
package Clases;

public class Hormigas {
    private Ciudad ciudadinicial;
    private Ciudad ciudadactual;
    private Ciudad ciudadfinal;
    private Camino camino;
    private Global global;
    private Matriz matriz;

    public Hormigas(Ciudad ciudadinicial, Ciudad ciudadfinal, Matriz matriz) {
        this.ciudadinicial = ciudadinicial;
        this.ciudadactual = ciudadinicial;
        this.ciudadfinal = ciudadfinal;
        this.camino = null;
        this.matriz = matriz;
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

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    
    //sumatoria que se pide en el calculo de posibilidades de eleccion de camino
    public int sumatoria(){
        int[] distancia = getMatriz().buscar(getCiudadactual().getName());
        int a = 0;
        int r = 1/getCiudadinicial().getCiudadmax();
        for (int i = 0; i < distancia.length; i++) {
            int parte = this.potencia(r, getGlobal().getImporfermonas());
            float n = 1/distancia[i];
            int parte2 = this.potencia(n, getGlobal().getVisibilidad());
            a += parte*parte2;
        }
        return a;  
    }
    
    //metodo para elevar, no podemos usar Math pow, por eso se creo
    public int potencia(float numero, int elevado){
        int a = 1;
        int potencia = 0;
        while(a<elevado){
            potencia *= potencia;   
        }
        return potencia; 
    } 
    
    //calculo de todos los caminos para ser elegidos guardados en un array 
    public int[] eleccioncamino(){
        int[] distancia = getMatriz().buscar(getCiudadactual().getName());
        int a = this.sumatoria();
        int [] resultados = new int [distancia.length];
        int r = 1/getCiudadinicial().getCiudadmax();
        for (int i = 0; i < distancia.length; i++){
            int parte = this.potencia(r, getGlobal().getImporfermonas());
            float n = 1/distancia[i];
            int parte2 = this.potencia(n, getGlobal().getVisibilidad());
            int guardar = parte*parte2/a;
            resultados[i] = guardar;
        }
      return resultados;  
 }  
}
