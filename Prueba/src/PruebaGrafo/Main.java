
package PruebaGrafo;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Main {

    public static void main(String[] args) {
       Graph graph = new SingleGraph("tutorial1");
       //graph.addNode("A" );
       //graph.addNode("B" );
       //graph.addNode("C" );
       //graph.addEdge("AB", "A", "B");
       //graph.addEdge("BC", "B", "C");
       //graph.addEdge("CA", "C", "A");
     graph.setStrict(false);
     graph.setAutoCreate( true );
     graph.addEdge( "AB", "A", "B" );
     graph.addEdge( "BC", "B", "C" );
     for (Node node : graph) {
        node.setAttribute("ui.label", node.getId());
      }
     for (Edge e : graph.getEachEdge()) {
        e.addAttribute("ui.label", 1);
     }
     graph.display();
               
    }
    
}
