
package Funciones;

import Clases.Ciudad;
import Clases.Hormigas;
import Clases.ListaCaminos;
import Clases.ListaCiudad;
import Clases.ListaHormigas;
import Clases.NodoCiudad;
import java.io.File;
import javax.swing.JOptionPane;

public class Global {
    //valores estaticos para guardar los datos
    private static File file;
    private static ListaCaminos listacaminos;
    private static ListaCiudad listaciudades;
    private static ListaHormigas listahormigas;
    private static Matriz matriz;
    private static Matriz matriz_feromonas;
    private static Matriz matrizoptimizacion;
    private int cantidadciclos;
    private int numerohormigas;
    private Ciudad ciudadInicial;
    private Ciudad ciudadFinal;
    //β
    private int visibilidad;
    //α
    private int imporfermonas;
    //ρ
    private float factordevaporicacion;
    private Grafo grafo;
    
    
    
    public Global(int cantidadciclos, int numerohormigas, Ciudad ciudadInicial, Ciudad ciudadFinal, int visibilidad, int imporfermonas, float factordevaporicacion ) {
        this.cantidadciclos = cantidadciclos;
        this.numerohormigas = numerohormigas;
        this.ciudadInicial = ciudadInicial;
        this.ciudadFinal = ciudadFinal;
        this.visibilidad = visibilidad;
        this.imporfermonas = imporfermonas;
        this.factordevaporicacion = factordevaporicacion;
        this.grafo = new Grafo();
    }

    public static File getFile() {
        return file;
    }
    // definir el archivo txt a usar
    public static void setFile(File file) {
        Global.file = file;
    }

    public static ListaHormigas getListahormigas() {
        return listahormigas;
    }

    public static void setListahormigas(ListaHormigas listahormigas) {
        Global.listahormigas = listahormigas;
    }

    public static ListaCaminos getListacaminos() {
        return listacaminos;
    }

    public static void setListacaminos(ListaCaminos listacaminos) {
        Global.listacaminos = listacaminos;
    }

    public static ListaCiudad getListaciudades() {
        return listaciudades;
    }

    public static void setListaciudades(ListaCiudad listaciudades) {
        Global.listaciudades = listaciudades;
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

    public static Matriz getMatriz() {
        return matriz;
    }

    public static void setMatriz(Matriz matriz) {
        Global.matriz = matriz;
    }

    public static Matriz getMatriz_feromonas() {
        return matriz_feromonas;
    }

    public static void setMatriz_feromonas(Matriz matriz_feromonas) {
        Global.matriz_feromonas = matriz_feromonas;
    }
    
    public void agregarciudad(Ciudad ciudad){
      getListaciudades().insertFinal(ciudad);
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public static Matriz getMatrizoptimizacion() {
        return matrizoptimizacion;
    }

    public static void setMatrizoptimizacion(Matriz matrizoptimizacion) {
        Global.matrizoptimizacion = matrizoptimizacion;
    }
     
    //define la cantidad de feromonas iniciales que tendrá cada ciudad
    public void agregarFeromonas(){
        float r =(float) 1/getListaciudades().getSize();
        for (int i = 0; i < getListacaminos().getSize(); i++) {
            getListacaminos().recorrer(i).setCantidadfermona(r);
        }
}
    
    
    //Metodo que permite realizar los ciclos de las hormigas por la cantidad dada por el usuario.
    public void iniciarCiclo(){
        int hormigas = this.numerohormigas;
        int ciclos = getCantidadciclos();
        int count_hormigas = 0;
        int count_ciclos = 0;
        ListaHormigas listahormiga = new ListaHormigas();
        NodoCiudad aux = getListaciudades().getHead();
            while (aux.getNext() != null){
                aux =aux.getNext();
            }
            int ultimaCiudad = aux.getElement().getName();
        Matriz matrix2 = new Matriz(ultimaCiudad);
        matrix2.crearmatrix();
        setMatrizoptimizacion(matrix2);
        agregarFeromonas();
        //creacion de hormigas y seteo de sus matrices de recorrido.
        while(count_hormigas < hormigas){
            Matriz matrix = new Matriz(getMatriz().getMaximo());
            matrix.crearmatrix();
            Matriz matrizhormigas = matrix.llenarmatriz(matrix);
            Hormigas hormiga = new Hormigas(getCiudadInicial(),getCiudadFinal(),matrizhormigas);
            hormiga.setGlobal(this);
            listahormiga.insertBegin(hormiga);
            count_hormigas++;
        }
        Global.setListahormigas(listahormiga);
        //Inicio de los ciclos
        while(count_ciclos < ciclos){
            for (int i = 0; i < listahormigas.getSize(); i++) {
                Hormigas hormiga  = listahormigas.recorrer(i);
                hormiga.setPrueba(false);
                // Se envian las hormigas a recorrer.
                while(hormiga.finalizar()== false && hormiga.ciega()){
                    hormiga.eleccioncamino();
                    
                }
            }
            for (int i = 0; i < getListacaminos().getSize(); i++) {
               getListacaminos().recorrer(i).evaporacion();
            }
         //Mostrar los resultados del ciclo.   
        getGrafo().addValuesToGrafo(getCiudadInicial().getName(),getCiudadFinal().getName());
        count_ciclos++;
        JOptionPane.showMessageDialog(null,"Ciclo "+count_ciclos+" realizado con exito, puede ver actualmente la conclusión del recorrido de dicho ciclo\nPor favor dele click en 'OK' para ejecutar el siguiente ciclo\n la cantidad de hormigas es: "+getNumerohormigas());
        }
        Matriz matrizferomonas = getMatriz_feromonas();
        matrizferomonas.feromonasIniciales();
        setMatriz_feromonas(matrizferomonas);

    }

}
