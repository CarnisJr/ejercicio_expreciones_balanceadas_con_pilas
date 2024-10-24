package Logica;

import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;

/**
 * Pila es una clase que define una estructura de datos que sigue el principio LIFO. Para su implementacion se va
 * a hacer uso del concepto de listas enlazadas.
 * @author Christopher Miranda
 */
public class Pila {

    private int cantidad;
    private Nodo tope;
    private int auxCantidad;

    /**
     * Se crea una Pila sin recibir parámetros.
     */
    public Pila() {

        this.cantidad = 0;
        this.tope = null;
    }

    /**
     * Devuelve si la pila está vacía o no
     * @return devuelve el estado de la pila
     */
    public boolean isEmpty() {

        return this.tope == null;
    }

    /**
     * Agrega un elemento a la pila
     * @param entrada el valor del elemento
     * @param textArea area de texto de Swing UI
     */
    public void push(char entrada, JTextArea textArea){

        Nodo nuevoNodo = new Nodo(entrada, null);

        if(isEmpty()){

            this.tope = nuevoNodo;
        }else{

            nuevoNodo.setProximo(this.tope);
            this.tope = nuevoNodo;
        }

        refresh(textArea);
        cantidad++;
    }

    /**
     * Elimina la última entrada agregada de la pila
     */
    public void pop(){

        if(isEmpty()){

            JOptionPane.showMessageDialog(null, "ta vacio");
        }else{

            this.tope = tope.getProximo();
            cantidad--;
        }
    }

    /**
     * Agrega los elementos de una pila a otra al revés
     * @param pila pila donde se agregaran los elementos
     * @param textArea area de texto de Swing UI
     */
    public void revertStack(Pila pila, JTextArea textArea, JTextArea textArea2){

        Nodo aux = this.tope;
        this.auxCantidad = this.cantidad;

        while(aux != null){

            if(aux.getEntrada() == ')' || aux.getEntrada() == '}' || aux.getEntrada() == ']'){

                break;
            }else{

                pila.push(aux.getEntrada(), textArea2);
                pop();
                aux = aux.getProximo();
            }
        }
        pila.refresh(textArea2);
        refresh(textArea);
    }

    /**
     * Devuelve un valor booleano dependiendo si la pila esta balanceada
     * @param pila una pila vacia que sirve como variable auxiliar
     * @return regresa el estado de la pila (Balanceado = true o No balanceado = false)
     */
    public boolean isBalanced(Pila pila){

        boolean flag = false;
        Nodo aux = this.tope;

        if(this.auxCantidad % 2 == 0){

            while(aux != null && pila.getTope() != null){

                if(aux.getEntrada() + pila.getTope().getEntrada() == 81 || aux.getEntrada() + pila.getTope().getEntrada() == 184 || aux.getEntrada() + pila.getTope().getEntrada() == 248){

                    JOptionPane.showMessageDialog(null, aux.getEntrada() + pila.getTope().getEntrada());
                    flag = true;
                }else{

                    flag = false;
                    break;
                }
                aux = aux.getProximo();
                pila.setTope(pila.getTope().getProximo());
            }
        }

        return flag;
    }

    /**
     * Muestra los elementos de la pila
     * @return devuelve un string con la información de las entradas de la pila
     */
    public String showElements(){

        StringBuilder stringcito = new StringBuilder();

        if(!isEmpty()){

            Nodo aux = this.tope;
            while(aux != null){

                stringcito.append(aux.getEntrada()).append(" ");
                aux = aux.getProximo();
            }

            return stringcito.toString();
        }else{

            return stringcito.toString();
        }
    }

    /**
     * Refresca el area de texto de Swing UI
     * @param textArea area de texto de Swing UI
     */
    public void refresh(JTextArea textArea){

        textArea.setText(showElements());
    }

    public Nodo getTope() {
        return tope;
    }

    public void setTope(Nodo tope) {
        this.tope = tope;
    }

}
