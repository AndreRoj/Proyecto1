
package Clases;

import Funciones.Matriz;
import Funciones.Global;

public class Hormigas {
    private Ciudad ciudadinicial;
    private Ciudad ciudadactual;
    private Ciudad ciudadfinal;
    private Camino camino;
    private Global global;
    private Matriz matriz_feromonas;
    private Matriz matriz;

    public Hormigas(Ciudad ciudadinicial, Ciudad ciudadfinal) {
        this.ciudadinicial = ciudadinicial;
        this.ciudadactual = ciudadinicial;
        this.ciudadfinal = ciudadfinal;
        this.camino = null;
        this.matriz = global.getMatriz();
        this.matriz_feromonas = global.getMatriz_feromonas();
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

    public Matriz getMatriz() {
        return matriz;
    }

    public void setMatriz(Matriz matriz) {
        this.matriz = matriz;
    }
    
    //sumatoria que se pide en el calculo de posibilidades de eleccion de camino
    public int sumatoria(){
        float[] distancia = getMatriz().buscar(getCiudadactual().getName());
        int a = 0;
        int r = 1/getCiudadinicial().getCiudadmax();
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
    
    //calculo de todos los caminos para ser elegidos guardados en un array 
    public void eleccioncamino(){
        double random = Math.random();
        float[] distancia = getMatriz().buscar(getCiudadactual().getName());
        int a = this.sumatoria();
        float [] resultados = new float [distancia.length];
        int r = 1/getCiudadinicial().getCiudadmax();
        ListaCaminos lista = new ListaCaminos();
        for (int i = 0; i < global.getListacaminos().getSize(); i++) {
            global.getListacaminos().recorrer(i).setCantidadfermona(r);
            lista.buscarCiudadName(getCiudadactual().getName()); 
        }
        for (int i = 0; i < distancia.length; i++){
            float parte = this.potencia(lista.recorrer(i).getCantidadfermona(), global.getImporfermonas());
            float n = 1/distancia[i];
            float parte2 = this.potencia(n, global.getVisibilidad());
            float guardar = parte*parte2/a;
            resultados[i] = guardar;
        }
        for (int i = 0; i < distancia.length; i++) {
            if(random < resultados[i] && random > resultados[i+1]){
                setCamino(lista.buscarDistancia(resultados[i]));
                setCiudadactual(getCamino().getCiudadfinal());
                break;
            } 
        }
       
    }  
}
