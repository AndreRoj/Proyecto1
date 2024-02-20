
package Clases;


public class NodoHormiga {
    private Hormigas element;
    private NodoHormiga next;
    
    public NodoHormiga(Hormigas element) {
        this.element = element;
        this.next = null;
    }

    public Hormigas getElement() {
        return element;
    }

    public void setElement(Hormigas element) {
        this.element = element;
    }

    public NodoHormiga getNext() {
        return next;
    }

    public void setNext(NodoHormiga next) {
        this.next = next;
    }
    
}
