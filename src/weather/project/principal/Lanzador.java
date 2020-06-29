/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.project.principal;

import weather.project.controlador.ApiConnector;

/**
 * URL DE LA API A UTILIZAR: https://openweathermap.org
 * @author fabio
 */
public class Lanzador {
    
    public static void main(String[] args){
        //Latitud: 41.7516, Longitud: 1.90326 de navarcles para testear
        ApiConnector apiCon = new ApiConnector();
        String temp = apiCon.getTemperatura("41.7516", "1.90326");
        
        System.out.println(temp);
    }
    
}
