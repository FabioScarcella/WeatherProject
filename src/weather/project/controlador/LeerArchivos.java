/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.project.controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import weather.project.vistas.PanelEliminarCiudad;

/**
 *
 * @author fabio
 */
public class LeerArchivos {
    private Map<String, String> apikeys = new HashMap();
    private PanelEliminarCiudad frame;


    public LeerArchivos(){
        leerApiKeys();
    }
    
    public Map<String, String> leerApiKeys(){
        
        if(apikeys.size() > 0){
            return apikeys;
        }
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("apiKeys.json"));
            
            JSONObject jsonObject = (JSONObject) obj;
            
            jsonObject.keySet().forEach((s) -> {
                apikeys.put((String) s, (String) jsonObject.get(s));
            });
        }catch(IOException io){
            System.out.println("Error al leer");
        }finally{
            return apikeys;
        }
    }
    
    public String getAValue(String key){
        return apikeys.get(key);
    }
}
