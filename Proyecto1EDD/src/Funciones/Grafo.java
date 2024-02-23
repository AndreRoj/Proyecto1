
package Funciones;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Grafo {
    
    public void addValuesToGrafo(){
        Matriz matriz = Global.getMatriz();
        Graph graph = new SingleGraph("tutorial1");
        for (int i = 0; i < Global.getMatriz().getMaximo(); i++) {
            for (int j = 0; j < Global.getMatriz().getMaximo(); j++) {
                graph.setStrict(false);
                graph.setAutoCreate( true );
                if(matriz.getMatrix() [i][j] != 0){
                    String origen =  Integer.toString(i+1);
                    String end =  Integer.toString(j+1);
                    Node a = graph.addNode(origen);
                    Node b = graph.addNode(end);
                    float distancia = matriz.getMatrix()[i][j];
                    a.setAttribute("ui.style", "size: 30px, 30px; fill-color: rgb(76,60,76);" );
                    b.setAttribute("ui.style", "size: 30px, 30px; fill-color: rgb(76,60,76);" );
                    
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
