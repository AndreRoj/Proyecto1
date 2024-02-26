
package Clases;

public class ListaCaminos {
    private NodoCamino head;
    private NodoCamino tail;
    private int size;    

    public ListaCaminos() {
        this.head = null;
        this.size = 0;
    }

    public NodoCamino getHead() {
        return head;
    }

    public void setHead(NodoCamino head) {
        this.head = head;
    }

    public NodoCamino getTail() {
        return tail;
    }

    public void setTail(NodoCamino tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return getHead() == null;
    }
    
    public void insertFinal(Camino element) {
        NodoCamino nodo = new NodoCamino(element);
        if (isEmpty()) {
            setHead(nodo);
            setTail(nodo);
        } else {
            getTail().setNext(nodo);
            nodo.setPrevious(getTail());
            setTail(nodo);
        }
        size++;
    }
    
    public Object deleteBegin(){
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            if (getHead() == getTail()) {
                setHead(null);
                setTail(null);
                size--;
            } else {
                NodoCamino pointer = getHead();
                setHead(pointer.getNext());
                getHead().setPrevious(null);
                pointer.setNext(null);
                size--;
                return pointer;
            }
        }
        return null;
    }
    
    public Object deleteFinal(){
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            if (getTail() == getHead()) {
                setHead(null);
                setTail(null);
                size--;
            } else {
                NodoCamino pointer = getTail();
                setTail(pointer.getPrevious());
                getTail().setNext(null);
                pointer.setPrevious(null);
                size--;
                return pointer;
            }
        }
        return null;
    }
    
public void deleteCaminos(Ciudad ciudad){
    if (isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
        NodoCamino aux = getHead();
        int eliminate = ciudad.getName();
        while (aux!= null){
            if(aux.getElement().getCiudadinicial().getName() == eliminate){
                if(aux==getHead()){
                    NodoCamino auxNuevaCabeza = aux.getNext();
                    setHead(auxNuevaCabeza);
                    auxNuevaCabeza.setPrevious(null);
                    aux.setNext(null);
                    deleteCaminos(ciudad);
                    
                }
                if (aux.getNext() == null){
                    aux = aux.getPrevious();
                    NodoCamino auxdeleted = aux.getNext();
                    aux.setNext(null);
                    setTail(aux);
                    
                    auxdeleted.setPrevious(null);
                    auxdeleted.setNext(null);
                    deleteCaminos(ciudad);
                }
                else{
                    aux = aux.getPrevious();
                    NodoCamino auxb = aux.getNext();
                    NodoCamino auxn = aux.getNext().getNext();
                    
                    aux.setNext(auxn);
                    auxn.setPrevious(aux);
                            
                    auxb.setNext(null);
                    auxb.setPrevious(null);
                    
                }
            }
            if(aux.getElement().getCiudadfinal().getName() == eliminate){
                if(aux==getHead()){
                    NodoCamino auxNuevaCabeza = aux.getNext();
                    setHead(auxNuevaCabeza);
                    auxNuevaCabeza.setPrevious(null);
                    aux.setNext(null);
                    deleteCaminos(ciudad);
                }
                if (aux.getNext() == null){
                    aux = aux.getPrevious();
                    NodoCamino auxdeleted = aux.getNext();
                    aux.setNext(null);
                    setTail(aux);
                    
                    auxdeleted.setPrevious(null);
                    auxdeleted.setNext(null);
                    deleteCaminos(ciudad);
                }
                else{
                    aux = aux.getPrevious();
                    NodoCamino auxb = aux.getNext();
                    NodoCamino auxn = aux.getNext().getNext();
                    
                    aux.setNext(auxn);
                    auxn.setPrevious(aux);
                            
                    auxb.setNext(null);
                    auxb.setPrevious(null);
                    
                }
            }
            aux = aux.getNext();
        }
    }
}  

    
    public void deleteCaminoEspecifico(Camino camino){
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            NodoCamino pointer = getHead();
            boolean encontrado = false;
            if(camino == getHead().getElement()){
                deleteBegin();
                pointer = getHead();
            }
            if(camino == getTail().getElement()){
                deleteFinal();
                pointer = getTail();
            }
            while(pointer != null && encontrado == false){
                if(pointer.getElement() == camino){
                    NodoCamino temp = pointer.getPrevious();
                    NodoCamino temp2 = pointer.getNext();
                    temp.setNext(temp2);
                    temp2.setPrevious(temp);
                    pointer.setPrevious(null);
                    pointer.setNext(null);
                    size--;
                    encontrado = true;
                }else{
                    pointer = pointer.getNext();
                }
            }
        }
    }
    
    public void eliminar20(Ciudad ciudad){
        
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            NodoCamino pointer = getHead();
            int eliminate = ciudad.getName();
            //boolean encontrado = false;
            while(pointer != null){
                if(eliminate == getHead().getElement().getCiudadinicial().getName() || eliminate == getHead().getElement().getCiudadfinal().getName()){
                    deleteBegin();
                    pointer = getHead();
                }
                
                if(pointer.getElement().getCiudadinicial().getName() == eliminate || pointer.getElement().getCiudadfinal().getName() == eliminate ){
                    NodoCamino temp = pointer.getPrevious();
                    NodoCamino temp2 = pointer.getNext();
                    temp.setNext(temp2);
                    temp2.setPrevious(temp);
                    pointer.setPrevious(null);
                    pointer.setNext(null);
                    size--;
                }    
                if(eliminate == getTail().getElement().getCiudadinicial().getName() || eliminate == getTail().getElement().getCiudadfinal().getName()){
                    deleteFinal();
                    pointer = getTail();
                }
                
                else{
                    pointer = pointer.getNext();
                }
            }
    }
    }
     
  
    public Camino recorrer(int numero){
        NodoCamino pointer = getHead(); 
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
    
    public ListaCaminos buscarCiudadName(int numero){
        NodoCamino pointer = getHead();
        ListaCaminos lista = new ListaCaminos();
        while (pointer != null){
            if (pointer.getElement().getCiudadinicial().getName() == numero || pointer.getElement().getCiudadfinal().getName() == numero){
                lista.insertFinal(pointer.getElement());
            }
            pointer = pointer.getNext();
        }
        
        
        return lista;
    } 
    
    public Camino buscarDistancia (float numero){
        NodoCamino pointer = getHead();
        while (pointer != null){
            if (pointer.getElement().getDistancia() == numero){
                return pointer.getElement();
            }
            pointer = pointer.getNext();
        }
        return null;   
    }
    
    public void print() {
        NodoCamino pointer = getHead();
        while (pointer != null) {
            System.out.println("[ "+pointer.getElement().getCiudadinicial().getName()+","+pointer.getElement().getCiudadfinal().getName()+","+pointer.getElement().getDistancia()+ " ]");
            pointer = pointer.getNext();
        }
    }
    
}
