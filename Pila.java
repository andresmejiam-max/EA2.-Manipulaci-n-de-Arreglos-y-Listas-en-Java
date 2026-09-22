// Pila (Stack) implementada manualmente con una lista ligada de Nodos.
// No usa java.util.Stack: el "tope" es simplemente el puntero al primer Nodo de la lista.
public class Pila<T> {

    private Nodo<T> tope;

    public Pila() {
        this.tope = null;
    }

    // Inserta un dato en el tope: el nuevo nodo apunta al que antes era el tope,
    // y el tope pasa a ser el nuevo nodo. Así queda "encima" de todos los demás.
    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    // Retira el dato del tope: el tope avanza al nodo siguiente,
    // y el nodo retirado queda sin referencias (se descarta).
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T dato = tope.dato;
        tope = tope.siguiente;
        return dato;
    }

    // Devuelve el dato del tope sin modificar la pila.
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.dato;
    }

    public boolean isEmpty() {
        return tope == null;
    }
}
