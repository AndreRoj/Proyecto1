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
    
    public void print() {
        NodoHormiga pointer = getHead();
        while (pointer != null) {
            System.out.println("[ "+pointer.getElement() + " ]");
            pointer = pointer.getNext();
        }
    }
    public boolean isEmpty() {
        return getHead() == null;
    }
    
    public Object GetElementIndex(int index){
        int count = 0;
        {
            NodoHormiga pointer = getHead();
            while (pointer != null) {
                System.out.println("[ "+pointer.getElement() + " ]");
                pointer = pointer.getNext();
                if(count == index){

                return pointer.getElement();


                }
                count = count + 1;
            }
        }
     return null;

    }
    
}
