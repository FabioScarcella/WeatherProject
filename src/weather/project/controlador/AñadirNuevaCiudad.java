/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.project.controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import weather.project.vistas.PanelNuevaCiudad;

/**
 *
 * @author fabio
 */
public class AñadirNuevaCiudad {
    PanelNuevaCiudad panel;
    
    public AñadirNuevaCiudad(PanelNuevaCiudad panel){
        this.panel = panel;
    }
    
    public void añadirCiudad(){
        List<String> ciudades = new ArrayList<String>();
        
        BufferedReader reader;
        
        try{
            reader = new BufferedReader(new FileReader("cities.txt"));
            
            String line = reader.readLine();
            
            while(line != null){
                ciudades.add(line);
                line = reader.readLine();
            }
            
            reader.close();
            
            String ciudad = panel.getTxtCiudad().getText();
            ciudades.add(ciudad);
            
            guardarCiudades(ciudades);
            
        }catch(FileNotFoundException fne){
            fne.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    private void guardarCiudades(List<String> ciudades){
        try{
            FileWriter myWriter = new FileWriter("cities.txt");
            for(String s: ciudades){
                myWriter.write(s + "\n");
            }
            
            myWriter.close();
            
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally{
            panel.setTxtCiudad("");
        }
    }
    
}
