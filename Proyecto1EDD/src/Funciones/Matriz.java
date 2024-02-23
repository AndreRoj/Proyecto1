
package Funciones;

import Clases.Camino;

public class Matriz {
    private int maximo;
    private float matrix[][];
    private float buscados[];
    private int value;

    public Matriz(int maximo) {
        this.maximo = maximo;
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

    //crea una matriz con puros valores de cero, para que luego sean modificados
    public float[][] crearmatrix(){
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
        for (int i = 0; i < getMaximo(); i++) {
            for (int j = 0; j < getMaximo(); j++) {
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
          borrar[numero][i] = 0;
          borrar[i][numero]= 0;
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

    public void cambiarvalorescolumna(float valor, int columna){
        for (int i = 0; i < getMaximo(); i++) {
            getMatrix()[i][columna-1] = valor;   
        }  
    }


    public void cambiarvaloresfilas(float valor, int filas){
        for (int i = 0; i < getMaximo(); i++) {
            getMatrix()[filas-1][i] = valor;   
        }  
    }
    
    //se usa principalmente para cambiar un valor especifico en la matriz, tanto fila x columna como columna x fila
    public void cambiarvaloresespecifico(float valor, int columna, int fila){
        getMatrix()[fila-1][columna-1] = valor;   
        getMatrix()[columna-1][fila-1] = valor;   
    }
    
    //para definir las distancias de los caminos que luego será utilizado para la representación del grafo
    public void llenarmattriz(){
        Matriz matriz = Global.getMatriz();
        for (int i = 0; i < Global.getListacaminos().getSize(); i++) {
            Camino camino = Global.getListacaminos().recorrer(i);
            matriz.cambiarvaloresespecifico(camino.getDistancia(), camino.getCiudadfinal().getName(), camino.getCiudadinicial().getName());
        }
        Global.setMatriz(matriz);
    }
    
    //para definir las ferromanas de los caminos que luego será utilizado para el recorrido y busqueda del camino más corto
    public void feromonasIniciales(){
        Matriz matriz_f = Global.getMatriz_feromonas();
        for (int i = 0; i < Global.getListacaminos().getSize(); i++) {
            Camino camino = Global.getListacaminos().recorrer(i);
            matriz_f.cambiarvaloresespecifico(camino.getCantidadfermona(), camino.getCiudadfinal().getName(), camino.getCiudadinicial().getName());
        }
        Global.setMatriz_feromonas(matriz_f);
    }
    

}
