/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

public class NodoCamino {
    private Camino element;
    private NodoCamino next;

    public NodoCamino(Camino element) {
        this.element = element;
        this.next = null;
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
    
    
    
}
