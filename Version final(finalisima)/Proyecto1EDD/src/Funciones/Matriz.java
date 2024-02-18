
package Funciones;

import Clases.ListaCaminos;
import Clases.ListaCiudad;
import Clases.Camino;

public class Matriz {
 private int maximo;
 private float matrix[][];
 private float buscados[];
 private int value;
 private Global global;

    public Matriz(int maximo) {
        this.maximo = maximo;
        //this.matrix = new int[maximo][maximo];
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

    public float[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(float[][] matrix) {
        this.matrix = matrix;
    }

    public float[] getBuscados() {
        return buscados;
    }

    public void setBuscados(float[] buscados) {
        this.buscados = buscados;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }
    
    
 //necesitara recibir los datos en ListaCiudad y ListaCaminos    
  public float[][] crearmatrix(){
      //ListaCiudad listaciudad = global.getListaciudades();
      //ListaCaminos listacaminos = global.getListacaminos();
      setMatrix(new float [getMaximo()][getMaximo()]);
      for (int i = 0; i < getMaximo(); i++) {
          for (int j = 0; j < getMaximo(); j++) {
           float llenador[][] = getMatrix();
           llenador [i][j] = 0;
           setMatrix(llenador);
          }
      }
     return getMatrix(); 
  }
 
 public void print(){
  float matriz[][] = getMatrix();
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

  public void Show(){
        System.out.println("");
        for (int i = 0; i < getMaximo(); i++) 
        {
            for (int j = 0; j < getMaximo(); j++) 
            {
                System.out.print("["+(getMatrix()[i][j])+"]" + "");
            }
            System.out.println("");
        }
    }
 public float[][] añadir(Matriz matriz){
   float copia[][] = new float [matriz.getMaximo()+1][matriz.getMaximo()+1];
     for (int i = 0; i < matriz.getMaximo() ; i++) {   
     for (int j = 0; j < matriz.getMaximo(); j++) {
         copia[i][j] = matriz.getMatrix()[i][j];
         }
     }
     for (int i = 0; i < matriz.getMaximo()+1; i++) {
        copia[matriz.getMaximo()][i] = 0;
        copia[i][matriz.getMaximo()] = 0;
     }
     if (getMaximo() > 20){
     return getMatrix();    
     }
     return copia;
 }
 
public void eliminar(int numero){
 float borrar[][] = getMatrix();
    for (int i = 0; i < getMaximo(); i++) {
      borrar[numero][i] = -1;
      borrar[i][numero]= -1;
    }
  setMaximo(getMaximo()-1);
}

public float[] buscar(int columnas){
    setBuscados(new float[getMaximo()]);
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

public void cambiarvaloresespecifico(float valor, int columna, int fila){
     getMatrix()[fila][columna] = valor;   
}

public void llenarmattriz(){
        Matriz matriz = getGlobal().getMatriz();
        for (int i = 0; i < getGlobal().getListacaminos().getSize(); i++) {
          Camino camino = getGlobal().getListacaminos().recorrer(i);
          matriz.cambiarvaloresespecifico(camino.getDistancia(), camino.getCiudadfinal().getName()-1, camino.getCiudadinicial().getName()-1);
          matriz.cambiarvaloresespecifico(camino.getDistancia(), camino.getCiudadinicial().getName()-1, camino.getCiudadfinal().getName()-1);
        }   
}

}
