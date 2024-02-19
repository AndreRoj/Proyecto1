
package Clases;

public class Nodo {
  private Ciudad element;
 private Nodo next;

    public Nodo(Ciudad element) {
        this.element = element;
        this.next = null;
    }

    public Ciudad getElement() {
        return element;
    }

    public void setElement(Ciudad element) {
        this.element = element;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }   
}
