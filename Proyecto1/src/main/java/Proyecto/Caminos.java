/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

public class Caminos {

 private float distancia;
 private Ciudad ciudad;
 private int cantidadfermona;

    public Caminos(float distancia, Ciudad ciudad) {
        this.distancia = distancia;
        this.ciudad = ciudad;
        this.cantidadfermona = 0;
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

    public int getCantidadfermona() {
        return cantidadfermona;
    }

    public void setCantidadfermona(int cantidadfermona) {
        this.cantidadfermona = cantidadfermona;
    }    
    
 public int evaporacion(){
  return 0;   
 } 
 
}
