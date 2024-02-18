
package PruebaGrafo;

    public class Aristas {
    private int valor;
    private Vertices vertice1;
    private Vertices vertice2;

    public Aristas(Vertices vertice1, Vertices vertice2) {
        this.valor = 0;
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Vertices getVertice1() {
        return vertice1;
    }

    public void setVertice1(Vertices vertice1) {
        this.vertice1 = vertice1;
    }

    public Vertices getVertice2() {
        return vertice2;
    }

    public void setVertice2(Vertices vertice2) {
        this.vertice2 = vertice2;
    }


}
