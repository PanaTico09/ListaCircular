package da;

/**
 *
 * @author Johan Herrera
 */
public class ListaCircular {

    private Nodo cabeza;
    private int size;

    public ListaCircular() {
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

    public boolean addFirst(char dato) {

        Nodo nuevo = new Nodo(dato);

        if (isEmpty()) {
            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;

            while (aux.getSiguiente() != cabeza) {
                aux = aux.getSiguiente();
            }

            nuevo.setSiguiente(cabeza);
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
        }
        size++;
        return true;
    }

    public boolean add(char dato) {
        Nodo nuevo = new Nodo(dato);

        if (isEmpty()) {
            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;

            while (aux.getSiguiente() != cabeza) {
                aux = aux.getSiguiente();
            }

            nuevo.setSiguiente(cabeza);
            aux.setSiguiente(nuevo);
            cabeza.setAnterior(nuevo);
            nuevo.setAnterior(aux);
        }
        size++;
        return true;
    }

    public boolean addAll(ListaDoble ListaDoble) {

        Nodo aux = ListaDoble.getCabeza();
        Nodo aux2 = cabeza;

        aux.setSiguiente(cabeza);
        aux2.setSiguiente(ListaDoble.getCabeza());
        cabeza.setAnterior(aux);
        ListaDoble.getCabeza().setAnterior(aux2);

        while (aux.getSiguiente() != null || aux2.getSiguiente() != cabeza) {
            aux = aux.getSiguiente();
            aux2 = aux2.getSiguiente();
        }
        size++;
        return true;
    }

    public char get(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Indice invalido.");
        } else {
            Nodo aux = cabeza;
            int cont = 0;

            while (cont <= index) {
                aux = aux.getSiguiente();
                ++cont;
            }
            return aux.getDato();
        }
    }

    public int indexOf(char buscar) {
        Nodo aux = cabeza;
        int cont = 0;
        boolean bandera = false;

        while (cont < size && !bandera) {
            if (buscar == aux.getDato()) {
                bandera = true;
            } else {
                aux = aux.getSiguiente();
                cont++;
            }
        }
        if (bandera) {
            return cont;
        } else {
            return -1;
        }
    }

    public boolean remove(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Indice invalido");
        } else {
            if (0 == index) {
                cabeza.getSiguiente().setAnterior(cabeza.getAnterior());
                cabeza.getAnterior().setSiguiente(cabeza.getSiguiente());
                cabeza = cabeza.getSiguiente();
            } else {
                Nodo aux = cabeza;
                int cont = 0;
                while (cont < index - 1) {
                    aux = aux.getSiguiente();
                    cont++;
                }
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                aux.getSiguiente().setAnterior(aux);
            }
            size--;
        }
        return true;
    }

    public boolean removeBy(char dato) {
        if (dato == cabeza.getDato()) {
            cabeza.getSiguiente().setAnterior(cabeza.getAnterior());
            cabeza.getAnterior().setSiguiente(cabeza.getSiguiente());
            cabeza = cabeza.getSiguiente();
            size--;
        } else {
            Nodo aux = cabeza;
            boolean recorrer = false;
            while (aux.getSiguiente() != cabeza) {
                if (dato == aux.getDato()) {
                    aux = aux.getAnterior();
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                    aux.getSiguiente().setAnterior(aux);
                    size--;
                    break;
                }
                aux = aux.getSiguiente();
                if (aux.getSiguiente() == cabeza) {
                    recorrer = true;
                }
            }
            if (aux.getSiguiente() == cabeza && dato == aux.getDato()) {
                aux = aux.getAnterior();
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                aux.getSiguiente().setAnterior(aux);
                size--;
            } else if (!(dato == aux.getDato()) && recorrer) {
                System.err.println("El dato no se encuentra en la lista.");
            }
        }
        return true;
    }

    public boolean borraPrimos() {
        int index = 0;
        Nodo aux = cabeza;
        while (aux.getSiguiente() != cabeza) {
            if (esPrimo(index) == true) {
                remove(index);               
            }
            aux = aux.getSiguiente();
            index++;
        }
        return true;
    }

    public boolean esPrimo(int n) {
        int temp;
        boolean bandera = true;

        if (n == 0 || n == 1) {
            bandera = false;
        } else {
            for (int i = 2; i <= n / 2; i++) {
                temp = n % i;

                if (temp == 0) {
                    bandera = false;

                }
            }
        }
        //If isPrime is true then the number is prime else not
        if (bandera) {
            System.out.println(n + " is Prime Number");
        } else {
            System.out.println(n + " is not Prime Number");
        }
        return bandera;
    }

    public boolean cortarInvertirLista() {

        return true;
    }

    public boolean shake(int index) {

        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");

        Nodo aux = cabeza;
        int cont = 0;

        while (cont < size) {
            builder.append(aux.getDato());
            builder.append("-");
            ++cont;
            aux = aux.getSiguiente();
        }
        builder.append("}");

        return builder.toString();
    }

}
