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
import java.util.HashMap;
import java.util.List;

/**
 * Clase que se encara de comunicarse con la api: https://openweathermap.org
 * DOC: https://openweathermap.org/api/one-call-api
 * @author fabio
 */
public class ApiConnector {
    final String apikey = "e147808f8dac46f6d54ea065275b31df";
    
    public ApiConnector(){
        
    }
    
    public String getTemperatura(String latitud, String longitud){
        String temperatura = "Error";
        
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
    
    private String getJSONTemperatura(String latitud, String longitud) throws MalformedURLException, IOException{
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
        
        return mapaCurrent.get("temp");
    }
}
