
package Clases;

public class Main {

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
