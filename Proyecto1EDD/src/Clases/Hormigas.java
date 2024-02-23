
package Clases;

import Funciones.Matriz;
import Funciones.Global;

public class Hormigas {
    private Ciudad ciudadinicial;
    private Ciudad ciudadactual;
    private Ciudad ciudadfinal;
    private Matriz matriz;
    private Camino camino;
    private Global global;

    public Hormigas(Ciudad ciudadinicial, Ciudad ciudadfinal) {
        this.ciudadinicial = ciudadinicial;
        this.ciudadactual = ciudadinicial;
        this.ciudadfinal = ciudadfinal;
        this.camino = null;
        this.global = global;
        this.matriz = Global.getMatriz();
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

    public Matriz getMatriz() {
        return matriz;
    }

    public void setMatriz(Matriz matriz) {
        this.matriz = matriz;
    }
    
    //sumatoria que se pide en el calculo de posibilidades de eleccion de camino
    public float sumatoria(){
        float[] distancia = Global.getMatriz().buscar(getCiudadactual().getName());
        float a = 0;
        float r = (float)1/(Global.getListaciudades().getSize());
        //System.out.println(r);
        System.out.println(distancia.length);
        for (int i = 0; i < distancia.length; i++) {
            float parte = potencia(r, getGlobal().getImporfermonas());
            float n = 1/distancia[i];
            float parte2 = potencia(n, getGlobal().getVisibilidad());
            a += parte*parte2;
        }
        return a;  
    }
    
    //metodo para elevar, no podemos usar Math pow, por eso se creo
    public float potencia(float numero, int elevado){
        int a = 1;
        float b = numero;
        //System.out.println("antes");
        //System.out.println(b);
        while(a<elevado){
            b *= numero;   
            a++;
        }
        //System.out.println("despues");
       // System.out.println(b);
        return b; 
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
            if(random < resultados[i] || random > resultados[i+1]){
                b =i;
              break;
           } 
        }
        setCamino(lista.recorrer(b));
        int d = getCiudadactual().getName();
        setCiudadactual(getCamino().getCiudadfinal());
        getCamino().aumentofermonas(getGlobal().getNumerohormigas());
        Matriz mcambio = getMatriz();
        mcambio.cambiarvaloresespecifico(0,getCiudadactual().getName(),d);
        setMatriz(mcambio);
        System.out.println(getCiudadactual().getName());
    }
    
    public boolean finalizar(){
      return getCiudadactual() == getCiudadfinal();  
    }
    
}
