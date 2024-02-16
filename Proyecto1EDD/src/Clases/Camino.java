/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author pjroj
 */
public class Camino {

    private float distancia;
    private Ciudad ciudad;
    private float cantidadfermona;
    private float factorvaporacion;

    public Camino(float distancia, Ciudad ciudad) {
        this.distancia = distancia;
        this.ciudad = ciudad;
        this.cantidadfermona = 0;
        this.factorvaporacion = 05;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public float getCantidadfermona() {
        return cantidadfermona;
    }

    public void setCantidadfermona(float cantidadfermona) {
        this.cantidadfermona = cantidadfermona;
    } 

    public float getFactorvaporacion() {
        return factorvaporacion;
    }

    public void setFactorvaporacion(float factorvaporacion) {
        this.factorvaporacion = factorvaporacion;
    }
    
    public void evaporacion(){
        float t = 1-getFactorvaporacion(); 
        if(getCantidadfermona() ==0){   
            float r = 1/getCiudad().getCiudadmax(); 
            setCantidadfermona(r*t);
        }else{
            setCantidadfermona(getCantidadfermona()*t);   
        }
    } 

    public void aumentofermonas(int cantidadhormigas){
        float t = 1/getDistancia() * cantidadhormigas; 
        if(getCantidadfermona() ==0){   
            float r = 1/getCiudad().getCiudadmax(); 
            setCantidadfermona(r+t);
        }else{
            setCantidadfermona(getCantidadfermona()+t);   
        }
    } 
}
