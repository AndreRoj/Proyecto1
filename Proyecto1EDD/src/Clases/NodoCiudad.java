
package Clases;

public class NodoCiudad {
    private Ciudad element;
    private NodoCiudad next;

    public NodoCiudad(Ciudad element) {
        this.element = element;
        this.next = null;
    }

    public Ciudad getElement() {
        return element;
    }

    public void setElement(Ciudad element) {
        this.element = element;
    }

    public NodoCiudad getNext() {
        return next;
    }

    public void setNext(NodoCiudad next) {
        this.next = next;
    }   
}
