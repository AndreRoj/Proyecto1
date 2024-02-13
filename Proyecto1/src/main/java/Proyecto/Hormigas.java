
package Proyecto;

public class Hormigas {
 private Ciudad ciudadinicial;
 private Ciudad ciudadactual;
 private Ciudad ciudadfinal;
 private Caminos camino;
 private int visibilidad;
private int imporfermonas;
private int numerohormigas;
private Matriz matriz;

    public Hormigas(Ciudad ciudadinicial, Ciudad ciudadfinal, Matriz matriz, int numerohormigas) {
        this.ciudadinicial = ciudadinicial;
        this.ciudadactual = ciudadinicial;
        this.ciudadfinal = ciudadfinal;
        this.camino = null;
        this.visibilidad = 2;
        this.imporfermonas = 1;
        this.matriz = matriz;
        this.numerohormigas = numerohormigas;
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

    public Caminos getCamino() {
        return camino;
    }

    public void setCamino(Caminos camino) {
        this.camino = camino;
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

    public Matriz getMatriz() {
        return matriz;
    }

    public void setMatriz(Matriz matriz) {
        this.matriz = matriz;
    }

    public int getNumerohormigas() {
        return numerohormigas;
    }

    public void setNumerohormigas(int numerohormigas) {
        this.numerohormigas = numerohormigas;
    }
    
 //sumatoria que se pide en el calculo de posibilidades de eleccion de camino
  public int sumatoria(){
    int[] distancia = getMatriz().buscar(getCiudadactual().getName());
    int a = 0;
    int r = 1/getCiudadinicial().getCiudadmax();
      for (int i = 0; i < distancia.length; i++) {
      int parte = this.potencia(r, getImporfermonas());
      float n = 1/distancia[i];
      int parte2 = this.potencia(n, getVisibilidad());
      a = parte*parte2;
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
       int parte = this.potencia(r, getImporfermonas());
      float n = 1/distancia[i];
      int parte2 = this.potencia(n, getVisibilidad());
      int guardar = parte*parte2/a;
      resultados[i] = guardar;
      }
      return resultados;  
 }  
}
