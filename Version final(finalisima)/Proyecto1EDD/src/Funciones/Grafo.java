
package Funciones;


import Funciones.Global;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.*;


public class Grafo {
    private int numvertices;
    private Global global;

    public int getNumvertices() {
        return numvertices;
    }

    public void setNumvertices(int numvertices) {
        this.numvertices = numvertices;
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }
    
    
    public void addValuesToGrafo(){
        Matriz matriz = getGlobal().getMatriz();
        Graph graph = new SingleGraph("tutorial1");
        for (int i = 0; i < getGlobal().getMatriz().getMaximo(); i++) {
        for (int j = 0; j < getGlobal().getMatriz().getMaximo(); j++) {
         graph.setStrict(false);
        graph.setAutoCreate( true );
        if(matriz.getMatrix() [i][j] != 0){
         String origen =  Integer.toString(i);
         String end =  Integer.toString(j);
        graph.addEdge( origen+end, origen, end );
        }   
        }
        }
         graph.display();
    }
}
