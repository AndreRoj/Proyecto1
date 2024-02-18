
package Funciones;


import Funciones.Global;
import org.graphstream.graph.Graph;


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
        
    }
}
