/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PruebaGrafo;

public class Main {

    public static void main(String[] args) {
    Matriz matrix = new Matriz();
    Matriz copia = new Matriz();
    matrix.crearmatrix();
    //matrix.print();
    copia.setMatrix(copia.añadir(matrix));
    copia.setMaximo(matrix.getMaximo()+1);
        System.out.println("matriz");
    copia.print();
        System.out.println("matriz borrada");
        copia.eliminar(0);
        copia.print();
    }
    
}
