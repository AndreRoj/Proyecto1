
package Clases;

public class Matriz {
 private int maximo;
 private int matrix[][];
 private int buscados[];
 private int value;

    public Matriz() {
        this.maximo = 5;
        this.matrix = null;
        this.buscados = null;
        this.value = 0;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[] getBuscados() {
        return buscados;
    }

    public void setBuscados(int[] buscados) {
        this.buscados = buscados;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
     
  public int[][] crearmatrix(){
   setMatrix(new int [getMaximo()][getMaximo()]);
      for (int i = 0; i < getMaximo(); i++) {
          for (int j = 0; j < getMaximo(); j++) {
           int llenador[][] = getMatrix();
           llenador [i][j] = 0;
           setMatrix(llenador);
          }
      }
     return getMatrix(); 
  }
 
 public void print(){
  int matriz[][] = getMatrix();
     for (int i = 0; i < getMaximo(); i++) {
     for (int j = 0; j < getMaximo(); j++) {
         System.out.println(i+" , "+ j);
         if (matriz[i][j]== -1){
             System.out.println("no hay nada");   
         }else{
         System.out.println(matriz[i][j]);
         }
     }
 } 
 }

 public int[][] añadir(Matriz matriz){
   int copia[][] = new int [matriz.getMaximo()+1][matriz.getMaximo()+1];
     for (int i = 0; i < matriz.getMaximo() ; i++) {   
     for (int j = 0; j < matriz.getMaximo(); j++) {
         copia[i][j] = matriz.getMatrix()[i][j];
         }
     }
     for (int i = 0; i < matriz.getMaximo()+1; i++) {
        copia[matriz.getMaximo()][i] =0;
        copia[i][matriz.getMaximo()] = 0;
     }
     if (getMaximo() > 20){
     return getMatrix();    
     }
     return copia;
 }
 
public void eliminar(int numero){
 int borrar[][] = getMatrix();
    for (int i = 0; i < getMaximo(); i++) {
      borrar[numero][i] = -1;
      borrar[i][numero]= -1;
    }
  setMaximo(getMaximo()-1);
}

public int[] buscar(int columnas){
    setBuscados(new int[getMaximo()]);
    for (int i = 0; i < getMaximo(); i++) {
      getBuscados()[i] = getMatrix()[columnas][i];  
    }
    return getBuscados();
}

public void cambiarvalorescolumna(int valor, int columna){
    for (int i = 0; i < getMaximo(); i++) {
     getMatrix()[i][columna] = valor;   
    }  
}


public void cambiarvaloresfilas(int valor, int filas){
    for (int i = 0; i < getMaximo(); i++) {
     getMatrix()[filas][i] = valor;   
    }  
}

public void cambiarvaloresespecifico(int valor, int columna, int fila){
     getMatrix()[fila][columna] = valor;   
}   
}
