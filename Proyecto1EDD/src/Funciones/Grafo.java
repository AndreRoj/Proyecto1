
package Funciones;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Camera;

public class Grafo {
    //Agregar los valores al grafo
    public void addValuesToGrafo(int cinicio, int cfinal){
        System.setProperty("org.graphstream.ui", "swing");
        Matriz matriz = Global.getMatriz();
        Matriz matrizOpt = Global.getMatrizoptimizacion();
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
                    a.setAttribute("ui.style", "size: 30px, 30px; fill-color: rgb(76,60,76);");
                    b.setAttribute("ui.style", "size: 30px, 30px; fill-color: rgb(76,60,76);");
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
        // marcar el camino recorrido por las hormigas
        for (int i = 0; i < Global.getMatriz().getMaximo(); i++) {
            for (int j = 0; j < Global.getMatriz().getMaximo(); j++) {
                graph.setStrict(false);
                graph.setAutoCreate( true );
                if(matrizOpt.getMatrix() [i][j] != 0){
                    String origen =  Integer.toString(i+1);
                    String end =  Integer.toString(j+1);
                    Node nodoEspecifico = graph.getNode(origen);
                    Node nodoEspecifico2 = graph.getNode(end); 
                    for (Node node : graph) {
                        if(node.getId().equals(nodoEspecifico.getId())|| node.getId().equals(nodoEspecifico2.getId())){
                            node.setAttribute("ui.style", "size: 30px, 30px; fill-color: rgb(45,87,44);");
                            try{
                                graph.getEdge(origen+end).setAttribute("ui.style", "size: 5px, 5px ;fill-color: rgb(45,87,44);");
                            }catch(Exception e){
                                continue;
                            }
                            try{
                                graph.getEdge(end+origen).setAttribute("ui.style", "size: 5px, 5px ;fill-color: rgb(45,87,44);");
                            }catch(Exception e){
                                continue;
                            }
                        }
                    }
                }   
            }
        }
        
        
        for (Node node : graph) {
        node.setAttribute("ui.label", node.getId());
        //Se setean lso colores de la ciudad inicial y final escogidas por el usuario.
            if(node.getId().equals(Integer.toString(cinicio)) || node.getId().equals(Integer.toString(cfinal))){
                node.setAttribute("ui.style", "size: 30px, 30px; fill-color: rgb(0,255,0);");
                node.setAttribute("ui.style", "size: 30px, 30px; fill-color: rgb(0,255,0);");
            }   
        }  
        graph.addAttribute("ui.stylesheet", "edge { text-size: 100; }");
        graph.addAttribute("ui.stylesheet", "node { text-size: 15; }");
        graph.display();
    }
}
    