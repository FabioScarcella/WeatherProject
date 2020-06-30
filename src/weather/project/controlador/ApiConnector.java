/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.project.controlador;

import java.net.*;
import com.google.gson.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Clase que se encara de comunicarse con la api: https://openweathermap.org
 * DOC: https://openweathermap.org/api/one-call-api
 * @author fabio
 */
public class ApiConnector {
    final String apikey;
    final static String apiKeyNombre = "apiConnectorKey";
    
    public ApiConnector(){
        LeerArchivos leerArchivos = new LeerArchivos();
        apikey = leerArchivos.getAValue(apiKeyNombre);
    }
    
    public List<String> getTemperatura(String latitud, String longitud){
        List<String> temperatura = new ArrayList<String>();
        
        try{
            temperatura = getJSONTemperatura(latitud, longitud);
        }catch(MalformedURLException me){
            me.printStackTrace();
        }catch(IOException ie){
            ie.printStackTrace();
        }finally{
            return temperatura;
        }
    }
    
    private List<String> getJSONTemperatura(String latitud, String longitud) throws MalformedURLException, IOException{
        String sUrl = "https://api.openweathermap.org/data/2.5/onecall?lat="+ 
                latitud + "&lon=" + longitud + "&units=metric&appid=" + apikey;
        
        //Conectamos con la url mediante las librerias nativas de Java
        URL url = new URL(sUrl);
        URLConnection request = url.openConnection();
        
        request.connect();
        
        //Convertimos el objeto retornado
        JsonParser jp = new JsonParser(); //de la libreria gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convertimos el objecto en un json
        
        JsonObject rootObj = root.getAsJsonObject();
        
        String valoresCurrent = rootObj.get("current").toString();
        
        String[] listaCurrent = valoresCurrent.split(",");
        
        HashMap<String, String> mapaCurrent = new HashMap<String, String>();
        
        for(String s:listaCurrent){
            String[] sSplit = s.split(":");
            //con el metodo substring() borramos las " " que estaban al principio
            mapaCurrent.put(sSplit[0].substring(1, sSplit[0].length() - 1), sSplit[1]);
        }
        
        List<String> datos = new ArrayList<String>();
        datos.add(mapaCurrent.get("temp"));
        datos.add(mapaCurrent.get("feels_like"));
        datos.add(mapaCurrent.get("main").substring(1, mapaCurrent.get("main").length() - 1));
        
        
        return datos;
    }
}
