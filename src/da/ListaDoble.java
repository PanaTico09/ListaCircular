package da;

public class ListaDoble {

    private Nodo cabeza;
    private int size;

    public ListaDoble() {
        this.cabeza = null;
        this.size = 0;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    public int size() {
        return size;
    }

    public boolean add(char dato) {
        Nodo nuevo = new Nodo(dato);

        if (null == cabeza) {
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
        }

        size++;
        return true;
    }

    public boolean addFirst(char dato) {
        Nodo nuevo = new Nodo(dato);

        if (isEmpty()) { //Si la lista esta vacía.
            cabeza = nuevo;
        } else { //Agrega el nuevo Nodo al inicio de la lista.
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
        }
        size++;
        return true;
    }

    public boolean add(char dato, int index) {
        Nodo nuevo = new Nodo(dato);

        if (index == 0) {
            addFirst(dato);
        } else if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("No se puede agregar un numero en esa posicion de la lista.");
        } else if (index == size) {
            add(dato);
        } else {
            Nodo aux = cabeza;

            for (int i = 0; i < index; i++) {
                aux = aux.getSiguiente();
            }
            Nodo aux2 = aux.getAnterior();
            aux2.setSiguiente(nuevo);
            nuevo.setAnterior(aux2);
            nuevo.setSiguiente(aux);
            aux.setAnterior(nuevo);
            size++;
        }
        return true;
    }

    public boolean remove(int index) {
        if (isEmpty()) {
            return false;
        } else if (0 > index || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Indice invalido");
        } else {
            if (0 == index) {
                cabeza = cabeza.getSiguiente();

            } else if (index == size - 1) {
                Nodo aux = cabeza;

                for (int i = 0; i < index - 1; i++) {
                    aux = aux.getSiguiente();
                }

                aux.setSiguiente(null);

            } else {
                Nodo aux = cabeza;

                for (int i = 0; i < index - 1; i++) {
                    aux = aux.getSiguiente();
                }

                aux.setSiguiente(aux.getSiguiente().getSiguiente());
            }

            --size;
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");

        Nodo aux = cabeza;
        int cont = 0;

        while (size > cont) {
            str.append(aux.getDato());
            str.append(" ");
            aux = aux.getSiguiente();
            ++cont;
        }
        str.append("]");

        return str.toString();
    }

    public void mostrarLista() {
        if (!isEmpty()) { //Si la lista no esta vacía.
            Nodo aux = cabeza;
            while (aux != null) {
                System.out.print("[ " + aux.getDato() + " ]" + "-");
                aux = aux.getSiguiente();
            }
        }
    }
}
