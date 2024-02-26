
package Clases;

import Funciones.Matriz;
import Funciones.Global;

public class Hormigas {
    private Ciudad ciudadinicial;
    private Ciudad ciudadactual;
    private Ciudad ciudadfinal;
    private boolean prueba;
    private int intento;
    private Matriz matriz;
    private Camino camino;
    private Camino caminoanterior;
    private Global global;

    public Hormigas(Ciudad ciudadinicial, Ciudad ciudadfinal, Matriz matriz) {
        this.ciudadinicial = ciudadinicial;
        this.ciudadactual = ciudadinicial;
        this.ciudadfinal = ciudadfinal;
        this.camino = null;
        this.global = global;
        this.matriz = matriz;
        this.prueba = true;
        this.intento = 0;
        this.caminoanterior = camino;
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

    public boolean isPrueba() {
        return prueba;
    }

    public void setPrueba(boolean prueba) {
        this.prueba = prueba;
    }

    public int getIntento() {
        return intento;
    }

    public void setIntento(int intento) {
        this.intento = intento;
    }

    public Camino getCaminoanterior() {
        return caminoanterior;
    }

    public void setCaminoanterior(Camino caminoanterior) {
        this.caminoanterior = caminoanterior;
    }
    
    //sumatoria que se pide en el calculo de posibilidades de eleccion de camino
    public float sumatoria(){
        float[] distancia = getMatriz().buscar(getCiudadactual().getName()-1);
        float a = 0;
        float r = (float)1/(Global.getListaciudades().getSize());
        for (int i = 0; i < distancia.length; i++) {
            if(distancia[i] == 0){
                a+=0;
            }else{
                float parte = potencia(r, getGlobal().getImporfermonas());
                float n = (float) 1/distancia[i];
                float parte2 = potencia(n, getGlobal().getVisibilidad());
                a += parte*parte2;
            }
        }
        return a;  
    }
    
    //metodo para elevar, no podemos usar Math pow, por eso se creo
    public float potencia(float numero, int elevado){
        int a = 1;
        float b = numero;
        while(a<elevado){
            b *= numero;   
            a++;
        }
        return b; 
    } 
    
    //calculo de la eleccion de camino tomando la formula dada, tambien ya aumenta la cantidad de fermonas de ese camino 
    public void eleccioncamino(){
        int d = getCiudadactual().getName();
        double random = Math.random();
        float[] distancia = getMatriz().buscar(getCiudadactual().getName()-1);
        float a = this.sumatoria();
        ListaCaminos lista = global.getListacaminos().buscarCiudadName(getCiudadactual().getName());
        NodoCamino pointer = lista.getHead();
        while(pointer != null){
            float value = getMatriz().getMatrix()[(pointer.getElement().getCiudadinicial().getName())-1][(pointer.getElement().getCiudadfinal().getName())-1];
            float value2 = getMatriz().getMatrix() [pointer.getElement().getCiudadfinal().getName()-1][pointer.getElement().getCiudadinicial().getName()-1];
            if(lista.getSize() != 1){
                if(value == (float)0 || value2 == (float)0){
                    lista.deleteCaminoEspecifico(pointer.getElement());
                    pointer = lista.getHead();
                }else{
                    pointer = pointer.getNext();
                }
            }else{
                setPrueba(true);
                break;
            }
        }
        while(pointer != null){
            if(lista.getSize() != 1){
                if(pointer.getElement().getCiudadfinal().getName() == d){
                   lista.deleteCaminoEspecifico(pointer.getElement());
                   pointer = lista.getHead();
                }else{
                    pointer = pointer.getNext();
                }
            }else{
               break;       
            }
        }
        float [] resultados = new float [lista.getSize()];
        for (int i = 0; i < lista.getSize(); i++){
            if(distancia[i]!= 0){
            float parte = this.potencia(lista.recorrer(i).getCantidadfermona(), getGlobal().getImporfermonas());
            float n =(float) 1/distancia[i];
            float parte2 = this.potencia(n, getGlobal().getVisibilidad());
            float guardar = (float)parte*parte2/a;
            resultados[i] = guardar;
            }
          }
        int b = 0;
        int c = 0; 
        for (int i = 0; i < resultados.length; i++) {
            if(random < resultados[i]){
                b =i;
                break;
                }
             if(i == resultados.length-1 && resultados.length > 2){
                c++;
                random = Math.random();
                i = 0;
             }
             if(resultados.length == 2 && i == resultados.length -1){
                if(resultados[0] > resultados[1]){
                   b= 0;
                   break;
                }else{
                  b = 1;
                  break;
                }
             }
             if(resultados.length == 1 ){
                 b = 0;
                 break;
             }
             if(c>2){
                if(resultados[0] > resultados[1]){
                  b= 0;
                  break;
                }else{
                 b = 1;
                 break;
                }  
            }
        }
        Camino caminocorrecto = lista.recorrer(b);
        setCamino(caminocorrecto);
        if(caminocorrecto.getCiudadfinal() == getCiudadactual()){
          setCiudadactual(caminocorrecto.getCiudadinicial());
        }else{   
        setCiudadactual(caminocorrecto.getCiudadfinal());
        }
            if(getCiudadactual().getName()== d){
              setIntento(1);
            }
        int f = getCiudadactual().getName();
        getCamino().aumentofermonas(getGlobal().getNumerohormigas());
        Matriz m = getMatriz();
        m.cambiarvaloresespecifico(0,f,d);
        setMatriz(m);
        float e = Global.getMatrizoptimizacion().getMatrix()[f-1][d-1];
        Matriz matrizoptimizacion = Global.getMatrizoptimizacion();
        matrizoptimizacion.cambiarvaloresespecifico(e+1, f, d);
        Global.setMatrizoptimizacion(matrizoptimizacion);
     }
    //revision de ciudades para confirmar si se llega al destino
    public boolean finalizar(){
        return getCiudadactual() == getCiudadfinal();  
    }
    
    
    //Comprobacion de repeticion de camino
    public boolean ciega(){ 
        if(getIntento() == 1){
            return false;   
        }else{
            return true; 
        }
    }
    
}
