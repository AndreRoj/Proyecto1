/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

public class NodoCamino {
    private Camino element;
    private NodoCamino next;
    private NodoCamino previous;

    public NodoCamino(Camino element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    public Camino getElement() {
        return element;
    }

    public void setElement(Camino element) {
        this.element = element;
    }

    public NodoCamino getNext() {
        return next;
    }

    public void setNext(NodoCamino next) {
        this.next = next;
    }

    public NodoCamino getPrevious() {
        return previous;
    }

    public void setPrevious(NodoCamino previous) {
        this.previous = previous;
    }
    
    
    
}
