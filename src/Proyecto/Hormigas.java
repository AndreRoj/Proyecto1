
package Proyecto;

public class Hormigas {
 private Ciudad ciudadinicial;
 private Ciudad ciudadactual;
 private Ciudad ciudadfinal;
 private Caminos camino;

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

    public Caminos getCamino() {
        return camino;
    }

    public void setCamino(Caminos camino) {
        this.camino = camino;
    }
 
  public int eleccioncamino(Ciudad ciudad){
   return 0;  
 }
}
