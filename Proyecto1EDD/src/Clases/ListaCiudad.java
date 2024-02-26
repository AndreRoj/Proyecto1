
package Clases;

public class ListaCiudad {
    private NodoCiudad head;
    private int size;

    public ListaCiudad() {
        this.head = null;
        this.size = 0;
    }

    public NodoCiudad getHead() {
        return head;
    }

    public void setHead(NodoCiudad head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
        
    //insertar al final de la lista ciudad
    public void insertFinal(Ciudad element) {
        NodoCiudad nodo = new NodoCiudad(element);
        if (isEmpty()) {
            setHead(nodo);
        } else {
            NodoCiudad pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(nodo);
        }
        size++;
    }
    
    // eliminar el primer elemento de la lista
    public Object deleteBegin(){
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            NodoCiudad pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            size--;
            return pointer.getElement();
        }
        return null;
    }
    
    //elimina la ciudad, recibe el nombre de la ciudad.
    public void eliminarciudad(int numeroCiudad){
        NodoCiudad aux = getHead();
        if(aux.getElement().getName() == numeroCiudad){
            deleteBegin();
        }else{
          while (aux.getNext().getElement().getName() != numeroCiudad){
            aux = aux.getNext();
            }
          NodoCiudad aux2 = aux.getNext();
          aux.setNext(aux2.getNext());
          aux2.setNext(null);
          
        }
        size --;
        
        
    }
    
    //Eliminar el ultimo elemento de la lista
    public Object deleteFinal(){
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            NodoCiudad pointer = getHead();
            while (pointer.getNext().getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(null);
            size--;
            return pointer.getElement();
        }
        return null;
    }
    
    // visualizacion de la lista.
    public void print() {
        NodoCiudad pointer = getHead();
        while (pointer != null) {
            System.out.println("[ "+pointer.getElement().getName() + " ]");
            pointer = pointer.getNext();
        }
    }
    
    public boolean isEmpty() {
        return getHead() == null;
    }    
    // retorna el objeto ciudad segun su nombre.
    public Ciudad definirCiudad(int element){
        NodoCiudad pointer = getHead();
        while(pointer.getElement().getName() != element){
            pointer = pointer.getNext();
        }
         return pointer.getElement();
    }
 }

    
