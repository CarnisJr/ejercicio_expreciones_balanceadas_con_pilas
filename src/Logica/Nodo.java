package Logica;

/**
 * Nodo es una clase que define a un elemento perteneciente a una pila.
 * @author Christopher Miranda
 */
public class Nodo {

    private char entrada;
    private Nodo proximo;

    /**
     * Para crear un Nodo se debe introducir su valor y reservar la memoria para el siguiente nodo
     * @param entrada valor del nodo
     * @param proximo reserva de memoria para el siguiente nodo, siempre se debe ser null
     */
    public Nodo(char entrada, Nodo proximo) {

        this.entrada = entrada;
        this.proximo = proximo;
    }

    public char getEntrada() {
        return entrada;
    }

    public void setEntrada(char entrada) {
        this.entrada = entrada;
    }

    public Nodo getProximo() {
        return proximo;
    }

    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }
}
