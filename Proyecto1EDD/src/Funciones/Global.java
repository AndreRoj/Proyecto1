
package Funciones;

import Clases.Ciudad;
import Clases.Hormigas;
import Clases.ListaCaminos;
import Clases.ListaCiudad;
import Clases.ListaHormigas;

public class Global {
    private static ListaCaminos listacaminos;
    private static ListaCiudad listaciudades;
    private static ListaHormigas listahormigas;
    private Hormigas hormiga;
    private int cantidadciclos;
    private int numerohormigas;
    private Ciudad ciudadInicial;
    private Ciudad ciudadFinal;
    private Matriz matriz;
    private Matriz matriz_feromonas;
    //β
    private int visibilidad;
    //α
    private int imporfermonas;
    //ρ
    private float factordevaporicacion;
    
    //faltaria recibir Ciudad ciudadInicial, Ciudad ciudadFinal
    public Global(int cantidadciclos, int numerohormigas) {
        this.cantidadciclos = cantidadciclos;
        this.numerohormigas = numerohormigas;
        this.visibilidad = 2;
        this.imporfermonas = 1;
        this.factordevaporicacion = 05;
        //this.matriz = matriz;
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

    public Ciudad getCiudadInicial() {
        return ciudadInicial;
    }

    public Ciudad getCiudadFinal() {
        return ciudadFinal;
    }

    public void setCiudadInicial(Ciudad ciudadInicial) {
        this.ciudadInicial = ciudadInicial;
    }

    public void setCiudadFinal(Ciudad ciudadFinal) {
        this.ciudadFinal = ciudadFinal;
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

    public ListaCaminos getListacaminos() {
        return listacaminos;
    }

    public void setListacaminos(ListaCaminos listacaminos) {
        this.listacaminos = listacaminos;
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

    public Matriz getMatriz_feromonas() {
        return matriz_feromonas;
    }

    public void setMatriz_feromonas(Matriz matriz_feromonas) {
        this.matriz_feromonas = matriz_feromonas;
    }
    
    public void agregarciudad(Ciudad ciudad){
      getListaciudades().insertFinal(ciudad);
    }
    
    public void iniciarCiclo(){
        int hormigas = this.numerohormigas;
        int ciclos = getCantidadciclos();
        int count_hormigas = 0;
        while(count_hormigas < hormigas){
            Hormigas hormiga = new Hormigas(getCiudadInicial(),getCiudadFinal());
            hormiga.eleccioncamino();
            listahormigas.insertBegin(hormiga);
            count_hormigas++;
        }
        listahormigas.print();
    }
}
