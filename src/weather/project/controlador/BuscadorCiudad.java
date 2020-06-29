/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.project.controlador;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.maps.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.apache.log4j.Logger;

/**
 *http://julien.gunnm.org/geek/programming/2015/09/13/how-to-get-geocoding-information-in-java-without-google-maps-api/
 * @author fabio
 */
public class BuscadorCiudad {
    final String apiKey = "AIzaSyAETXgZ4JVmr_qvNkqruDy9b7kQfA6E5Bc";
    String ciudad;
    
    public BuscadorCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    
    public void getCiudad() throws MalformedURLException, IOException{
        String sUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=" + ciudad + "&key=" + apiKey;
        
        URL url = new URL(sUrl);
        URLConnection request = url.openConnection();
        
        request.connect();
        
        //Convertimos el objeto retornado
        JsonParser jp = new JsonParser(); //de la libreria gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convertimos el objecto en un json
        
        JsonObject rootObj = root.getAsJsonObject();
        
    }
}
