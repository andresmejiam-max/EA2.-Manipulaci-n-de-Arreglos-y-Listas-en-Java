// Nodo de una lista ligada: guarda un dato y una referencia (puntero) al siguiente nodo.
public class Nodo<T> {

    T dato;
    Nodo<T> siguiente;

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
