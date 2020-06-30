/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.project.principal;

import java.util.Map;
import java.util.Scanner;
import weather.project.controlador.ApiConnector;
import weather.project.controlador.BuscadorCiudad;

/**
 * URL DE LA API A UTILIZAR: https://openweathermap.org
 * @author fabio
 */
public class Lanzador {
    
    public static void main(String[] args){
        String userInput;
        Scanner scanner = new Scanner(System.in);
        
        userInput = scanner.nextLine();
        
        BuscadorCiudad buscadorCiudad = new BuscadorCiudad();
        
        Map<String, Double> coordinates = buscadorCiudad.getCoordinates(userInput);
        
        
        ApiConnector apiCon = new ApiConnector();
        String temp = apiCon.getTemperatura(coordinates.get("lat").toString(), coordinates.get("lon").toString());
        
        System.out.println("Lat: " + coordinates.get("lat").toString() + " Lon: "
        + coordinates.get("lon").toString() + " temp: " + temp);
        
        
    }
    
}
