package da;

/**
 *
 * @author Johan Herrera
 */
public class Nodo {
    
    private Nodo siguiente;
    private Nodo anterior;
    private char dato;
    
    public Nodo(char dato){
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
    
    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    } 
}
