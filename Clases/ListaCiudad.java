
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
    
    public Object deleteInIndex(int index) {
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            if (index < 0) {
                System.out.println("Index Error");
            } else if (index >= size) {
                System.out.println("Index Error");
            } else if (index == 0) {
                return deleteBegin();
            } else if (index == size-1) {
                return deleteFinal();
            } else {
                NodoCiudad pointer = getHead();
                int aux = 0; 
                while (pointer.getNext() != null && aux < index - 1) {
                    pointer = pointer.getNext();
                    aux++;
                }
                NodoCiudad pointer2 = pointer.getNext();
                pointer.setNext(pointer2.getNext());
                pointer2.setNext(null);
                size--;
                return pointer.getElement();
            }
        }
        return null;
    }
    
    public void print() {
        NodoCiudad pointer = getHead();
        while (pointer != null) {
            System.out.println("[ "+pointer.getElement() + " ]");
            pointer = pointer.getNext();
        }
    }
    
    public boolean isEmpty() {
        return getHead() == null;
    }    
}
