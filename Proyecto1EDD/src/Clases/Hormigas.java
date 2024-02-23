
package Clases;

import Funciones.Matriz;
import Funciones.Global;

public class Hormigas {
    private Ciudad ciudadinicial;
    private Ciudad ciudadactual;
    private Ciudad ciudadfinal;
    private Camino camino;
    private Global global;

    public Hormigas(Ciudad ciudadinicial, Ciudad ciudadfinal) {
        this.ciudadinicial = ciudadinicial;
        this.ciudadactual = ciudadinicial;
        this.ciudadfinal = ciudadfinal;
        this.camino = null;
    }

    public Ciudad getCiudadinicial() {
        return ciudadinicial;
    }

    public void setCiudadinicial(Ciudad ciudadinicial) {
        this.ciudadinicial = ciudadinicial;
    }

    public Ciudad getCiudadactual() {
        return ciudadactual;
    }

    public void setCiudadactual(Ciudad ciudadactual) {
        this.ciudadactual = ciudadactual;
    }

    public Ciudad getCiudadfinal() {
        return ciudadfinal;
    }

    public void setCiudadfinal(Ciudad ciudadfinal) {
        this.ciudadfinal = ciudadfinal;
    }

    public Camino getCamino() {
        return camino;
    }

    public void setCamino(Camino camino) {
        this.camino = camino;
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    
    
    //sumatoria que se pide en el calculo de posibilidades de eleccion de camino
    public float sumatoria(){
        float[] distancia = Global.getMatriz().buscar(getCiudadactual().getName());
        float a = 0;
        float r = (float)1/getCiudadinicial().getCiudadmax();
        System.out.println(getCiudadinicial().getCiudadmax());
        for (int i = 0; i < distancia.length; i++) {
            float parte = this.potencia(r, global.getImporfermonas());
            float n = 1/distancia[i];
            float parte2 = this.potencia(n, global.getVisibilidad());
            a += parte*parte2;
        }
        return a;  
    }
    
    //metodo para elevar, no podemos usar Math pow, por eso se creo
    public float potencia(float numero, int elevado){
        int a = 1;
        float potencia = numero;
        while(a<elevado){
            potencia *= numero;   
            a++;
        }
        return potencia; 
    } 
    
    //calculo de la eleccion de camino tomando la formula dada, tambien ya aumenta la cantidad de fermonas de ese camino 
    public void eleccioncamino(){
        double random = Math.random();
        float[] distancia = Global.getMatriz().buscar(getCiudadactual().getName());
        float a = this.sumatoria();
        float [] resultados = new float [distancia.length];
        ListaCaminos lista = Global.getListacaminos().buscarCiudadName(getCiudadactual().getName());
        for (int i = 0; i < lista.getSize(); i++){
            float parte = this.potencia(lista.recorrer(i).getCantidadfermona(), getGlobal().getImporfermonas());
            float n =(float) 1/distancia[i];
            float parte2 = this.potencia(n, getGlobal().getVisibilidad());
            float guardar = (float)parte*parte2/a;
            resultados[i] = guardar;
        }
        int b = 0;
        for (int i = 0; i < resultados.length; i++) {
            if(random < resultados[i] && random > resultados[i+1]){
              b =i;
              break;
           } 
        }
        setCamino(lista.recorrer(b));
        setCiudadactual(getCamino().getCiudadfinal());
        getCamino().aumentofermonas(getGlobal().getNumerohormigas());
        getCamino().setFactorvaporacion(global.getFactordevaporicacion());
        getCamino().evaporacion();
    }  
}
