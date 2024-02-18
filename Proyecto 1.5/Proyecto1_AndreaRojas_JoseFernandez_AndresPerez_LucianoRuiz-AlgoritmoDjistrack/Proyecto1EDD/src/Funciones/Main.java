
package Funciones;

public class Main {

    public static void main(String[] args) {
        Matriz matrix = new Matriz(5);
        Matriz copia = new Matriz(5);
        matrix.crearmatrix();
        //matrix.print();
        copia.setMatrix(copia.añadir(matrix));
        copia.setMaximo(matrix.getMaximo()+1);
        copia.eliminar(0);
        for (int i = 0; i < copia.getMaximo(); i++) {
            System.out.println(copia.buscar(1)[i]);
        }
        matrix.Show();
    }
    
}
