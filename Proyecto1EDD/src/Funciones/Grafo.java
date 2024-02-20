
package Funciones;

import java.awt.Color;
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
                    Node a = graph.addNode(origen);
                    Node b = graph.addNode(end);
                    float distancia = matriz.getMatrix()[i][j];
                    try{
                        graph.addEdge(origen+end, a, b ).setAttribute("ui.label",distancia);
                        graph.setAttribute("ui.quality");
                        graph.setAttribute("ui.antialias");
                    }catch(Exception e){
                        continue;
                    }
                }   
            }
        }
        for (Node node : graph) {
        node.setAttribute("ui.label", node.getId());
        //node.addAttribute("ui.size", 100);
        }
        graph.display();
        
    }
}
