
package Clases;

public class Global {
private int cantidadciclos;
private int numerohormigas;
private int visibilidad;
private int imporfermonas;
private float factordevaporicacion;
private Lista listaciudades;
private Matriz matriz;

    public Global(int cantidadciclos, int numerohormigas, Matriz matriz) {
        this.cantidadciclos = cantidadciclos;
        this.numerohormigas = numerohormigas;
        this.visibilidad = 2;
        this.imporfermonas = 1;
        this.factordevaporicacion = 05;
        this.listaciudades = new Lista();
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

    public Lista getListaciudades() {
        return listaciudades;
    }

    public void setListaciudades(Lista listaciudades) {
        this.listaciudades = listaciudades;
    }

    public Matriz getMatriz() {
        return matriz;
    }

    public void setMatriz(Matriz matriz) {
        this.matriz = matriz;
    }

 public void agregarciudad(Ciudad ciudad){
   getListaciudades().insertFinal(ciudad);
 }
}
