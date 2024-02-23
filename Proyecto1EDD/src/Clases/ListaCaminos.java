
package Clases;

public class ListaCaminos {
    private NodoCamino head;
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
        } else {
           NodoCamino pointer = getHead();
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
            NodoCamino pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            size--;
            return -1;
        }
        return null;
    }
    
   //Está función de usa en los deletes de la ListaCaminos, para asi borrar los caminos
    public void deleteCamino(Ciudad ciudad){
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            NodoCamino pointer = getHead();
            int eliminate = ciudad.getName();
            while(pointer.getNext() != null){
                if(pointer.getElement().getCiudadinicial().getName() == eliminate || pointer.getElement().getCiudadfinal().getName() == eliminate){
                    NodoCamino pointer2 = pointer.getNext();   
                    if(pointer == getHead()){
                        setHead(pointer2);
                        pointer.setNext(null);
                    }else{
                        continue;
                    }
                    //faltan cosas
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
    //verificar
    public ListaCaminos buscarCiudadName(int numero){
        NodoCamino pointer = getHead();
        ListaCaminos lista = new ListaCaminos();
        while (pointer != null){
            if (pointer.getElement().getCiudadinicial().getName() == numero){
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
