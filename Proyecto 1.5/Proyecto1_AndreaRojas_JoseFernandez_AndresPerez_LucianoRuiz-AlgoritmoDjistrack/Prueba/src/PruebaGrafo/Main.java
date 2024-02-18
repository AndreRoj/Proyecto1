
package PruebaGrafo;
import java.awt.Color;
import java.util.Random;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Main {

    public static void main(String[] args) {
       Graph graph = new SingleGraph("tutorial1");
       String stylesheet = "node { z-index: 1; text-mode: normal; text-alignment: center; text-background-mode: none; text-size: 15; size: 60px; fill-mode: dyn-plain; text-color: white; } edge { z-index: 0; arrow-shape: arrow; fill-mode: dyn-plain; }";
        graph.setAttribute("ui.stylesheet", stylesheet);
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        Color randomColor = new Color(red,green,blue);
        String rgbColor = String.format("rgb(%d,%d,%d)", randomColor.getRed(), randomColor.getGreen(), randomColor.getBlue());
        
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
        node.setAttribute("ui.label","fill-color: " + rgbColor + ";");
    }
     for (Edge e : graph.getEachEdge()) {
        e.addAttribute("ui.label", 50);
    }
    graph.display();      
    }
    
    

    
}
