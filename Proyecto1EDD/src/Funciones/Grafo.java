
package Funciones;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Grafo {
    private Global global;

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
                    String origen =  Integer.toString(i+1);
                    String end =  Integer.toString(j+1);
                    graph.addEdge( origen+end, origen, end );
                }   
            }
        }
        for (Node node : graph) {
        node.setAttribute("ui.label", node.getId());
        }
        for (Edge e : graph.getEachEdge()) {
        e.addAttribute("ui.label");
        }
        graph.display();
    }
}
