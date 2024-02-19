
package Funciones;

import Clases.Ciudad;
import Clases.ListaCaminos;
import Clases.ListaCiudad;
import Funciones.Matriz;

public class Global {
    private static ListaCaminos listacaminos;
    private static ListaCiudad listaciudades;
private int cantidadciclos;
private int numerohormigas;
//b
private int visibilidad;
//a
private int imporfermonas;
//p
private float factordevaporicacion;
private Matriz matriz;

    public Global(int cantidadciclos, int numerohormigas, Matriz matriz) {
        this.cantidadciclos = cantidadciclos;
        this.numerohormigas = numerohormigas;
        this.visibilidad = 2;
        this.imporfermonas = 1;
        this.factordevaporicacion = 05;
        this.listaciudades = new ListaCiudad();
        this.matriz = matriz;
    }

    public int getCantidadciclos() {
        return cantidadciclos;
    }

    public void setCantidadciclos(int cantidadciclos) {
        this.cantidadciclos = cantidadciclos;
    }

    public int getNumerohormigas() {
        return numerohormigas;
    }

    public void setNumerohormigas(int numerohormigas) {
        this.numerohormigas = numerohormigas;
    }

    public int getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(int visibilidad) {
        this.visibilidad = visibilidad;
    }

    public int getImporfermonas() {
        return imporfermonas;
    }

    public void setImporfermonas(int imporfermonas) {
        this.imporfermonas = imporfermonas;
    }

    public float getFactordevaporicacion() {
        return factordevaporicacion;
    }

    public void setFactordevaporicacion(float factordevaporicacion) {
        this.factordevaporicacion = factordevaporicacion;
    }

    public ListaCiudad getListaciudades() {
        return listaciudades;
    }

    public void setListaciudades(ListaCiudad listaciudades) {
        this.listaciudades = listaciudades;
    }

    public Matriz getMatriz() {
        return matriz;
    }

    public void setMatriz(Matriz matriz) {
        this.matriz = matriz;
    }

    public ListaCaminos getListacaminos() {
        return listacaminos;
    }

    public void setListacaminos(ListaCaminos listacaminos) {
        this.listacaminos = listacaminos;
    }
    

    
 public void agregarciudad(Ciudad ciudad){
   getListaciudades().insertFinal(ciudad);
 }
}
