/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Funciones.Global;
/**
 *
 * @author pjroj
 */
public class Camino {

    private float distancia;
    private Ciudad ciudadinicial;
    private Ciudad ciudadfinal;
    private float cantidadfermona;
    private float factorvaporacion;

    public Camino(Ciudad ciudadinicial, Ciudad ciudadfinal, float distancia) {
        this.distancia = distancia;
        this.ciudadinicial = ciudadinicial;
        this.cantidadfermona = 0;
        this.factorvaporacion = 05;
        this.ciudadfinal = ciudadfinal;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public Ciudad getCiudadinicial() {
        return ciudadinicial;
    }

    public void setCiudadinicial(Ciudad ciudadinicial) {
        this.ciudadinicial = ciudadinicial;
    }

    public Ciudad getCiudadfinal() {
        return ciudadfinal;
    }

    public void setCiudadfinal(Ciudad ciudadfinal) {
        this.ciudadfinal = ciudadfinal;
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
    
       //calculo de la evaporacion de cada camino al final de cada ciclo.
    public void evaporacion(){
        float t =(float) 1-getFactorvaporacion(); 
        if(getCantidadfermona() ==0){   
            float r = 1/(Global.getListaciudades().getSize()); 
            setCantidadfermona(r*t);
        }else{
            setCantidadfermona(getCantidadfermona()*t);   
        }
    } 
// aumento de fermonas que pasa cada vez que una hormiga pasa por un camino.
    public void aumentofermonas(int cantidadhormigas){
        float t =(float) 1/getDistancia() * cantidadhormigas; 
        if(getCantidadfermona() ==0){   
            float r = (float)1/(Global.getListaciudades().getSize()); 
            setCantidadfermona(r+t);
        }else{
            setCantidadfermona(getCantidadfermona()+t);   
        }
    } 
}
