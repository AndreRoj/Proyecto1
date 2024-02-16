/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import PruebaGrafo.Matriz;

/**
 *
 * @author pjroj
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matriz matrix = new Matriz();
        Matriz copia = new Matriz();
        matrix.crearmatrix();
        //matrix.print();
        copia.setMatrix(copia.añadir(matrix));
        copia.setMaximo(matrix.getMaximo()+1);
        copia.eliminar(0);
        for (int i = 0; i < copia.getMaximo(); i++) {
            System.out.println(copia.buscar(1)[i]);
        }
    }
    
}
