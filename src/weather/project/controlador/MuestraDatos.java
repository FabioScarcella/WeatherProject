/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.project.controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import weather.project.vistas.PanelCiudades;

/**
 *
 * @author fabio
 */
public class MuestraDatos {
    
    private PanelCiudades panel;
    
    public MuestraDatos(PanelCiudades panel){
        this.panel = panel;
    }
    
    public void MuestraCiudades(){
        
        List<String> ciudades = getTodasCiudades();
        BuscadorCiudad buscadorCiudad = new BuscadorCiudad();
        ApiConnector apiConnector = new ApiConnector();
        DefaultTableModel tabla =  panel.getTabla();
        
        for(String ciudad: ciudades){
            Map<String, Double> coordinates = buscadorCiudad.getCoordinates(ciudad);
            List<String> excludes = new ArrayList<String>();
            excludes.add("hourly");
            excludes.add("minuetly");
            List<String> datos = apiConnector.getTemperatura(coordinates.get("lat").toString(), coordinates.get("lon").toString(), excludes);
            Vector vector = new Vector();
            
            vector.add(ciudad);
            vector.add(datos.get(0));
            vector.add(datos.get(1));
            vector.add(datos.get(2));
            vector.add(datos.get(4));
            vector.add(datos.get(3));
            
            tabla.addRow(vector);
        }
        
    }
    
    private List<String> getTodasCiudades(){
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
            
        }catch(FileNotFoundException fne){
            fne.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally{
            return ciudades;
        }
    }
    
    
}
