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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

/**
 *http://julien.gunnm.org/geek/programming/2015/09/13/how-to-get-geocoding-information-in-java-without-google-maps-api/
 * @author fabio
 */
public class BuscadorCiudad {
    private JSONParser jsonParser;
    
    public BuscadorCiudad(){
        jsonParser = new JSONParser();
    }
    
    private String getRequest(String url) throws Exception{
        final URL obj = new URL(url);
        final HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        
        con.connect();
        
        if(con.getResponseCode() != 200){
            return null;
        }
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        
        while((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();
        
        return response.toString();
    }
    
    public Map<String, Double> getCoordinates(String adress){
        Map<String, Double> res;
        StringBuffer query;
        String[] split = adress.split(" ");
        String queryResult = null;
        
        query = new StringBuffer();
        res = new HashMap<String, Double>();
        
        query.append("https://nominatim.openstreetmap.org/search?q=");
        
        if(split.length == 0){
            return null;
        }
        
        for(int i = 0; i < split.length; ++i){
            query.append(split[i]);
            if(i < (split.length - 1)){
                query.append("+");
            }
        }
        
        query.append("&format=json&addressdetails=1");
        
        try{
            queryResult = getRequest(query.toString());
        }catch(Exception e){
            
        }
        
        if(queryResult == null){
            return null;
        }
        
        Object obj = JSONValue.parse(queryResult);
        
        if(obj instanceof JSONArray){
            JSONArray array = (JSONArray) obj;
            
            if(array.size() > 0){
                JSONObject jsonObject = (JSONObject) array.get(0);
                
                String lon = (String) jsonObject.get("lon");
                String lat = (String) jsonObject.get("lat");
                
                res.put("lon", Double.parseDouble(lon));
                res.put("lat", Double.parseDouble(lat));
            }
        }
        
        return res;
        
    }
}
