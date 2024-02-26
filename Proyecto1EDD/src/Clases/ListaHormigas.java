/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


public class ListaHormigas {
    private NodoHormiga head;
    private int size;

    public ListaHormigas() {
        this.head = null;
        this.size = 0;
    }

    public NodoHormiga getHead() {
        return head;
    }

    public void setHead(NodoHormiga head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        
    }
    
    public void borrarLista(){
        setHead(null);
    }
    
    //Insertar una nueva hormiga en la primera posicion.
    public void insertBegin(Hormigas element) {
        NodoHormiga nodo = new NodoHormiga(element);
        if (isEmpty()) {
            setHead(nodo);
        } else {
           nodo.setNext(getHead());
           setHead(nodo);
        }
        size++;
    }
    
    //visualizacion de la hormiga
    public void print() {
        NodoHormiga pointer = getHead();
        int count = 1;
        while (pointer != null) {
            System.out.println("Hormiga"+count+":[ inicio:"+ pointer.getElement().getCiudadinicial().getName() +" ,actual:"+ pointer.getElement().getCiudadactual().getName()+" ,final:"+ pointer.getElement().getCiudadfinal().getName()+" ]");
            pointer = pointer.getNext();
            count++;
        }
    }
    public boolean isEmpty() {
        return getHead() == null;
    }
    
    
    
    //bucar elemento con base a la cantidad de repeticiones hechas para encotrarlo.
    public Hormigas recorrer(int numero){
        NodoHormiga pointer = getHead(); 
        int a = 0;
        while(pointer.getNext() != null && a<numero ){
            pointer = pointer.getNext();
            a++;
        }
        if(numero == 0){
            return getHead().getElement();
        }
        if (numero == getSize()){
           return pointer.getNext().getElement();
        }else{
            return pointer.getElement();
        }
    }   
    
}
