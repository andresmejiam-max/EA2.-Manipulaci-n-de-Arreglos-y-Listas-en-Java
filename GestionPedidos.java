// Cordina las dos pilas del sistema Undo/Redo de Pizza-Track.
public class GestionPedidos {

    private Pila<Pizza> pilaPrincipal;  // Pedidos activos (permite Undo)
    private Pila<Pizza> pilaSecundaria; // Pedidos deshechos (permite Redo)

    public GestionPedidos() {
        pilaPrincipal = new Pila<>();
        pilaSecundaria = new Pila<>();
    }

    // Registrar Pedido: push en la pila principal.
    public void registrarPedido(Pizza pizza) {
        pilaPrincipal.push(pizza);
    }

    // Deshacer: pop de la principal, push a la secundaria.
    public Pizza deshacer() {
        if (pilaPrincipal.isEmpty()) {
            return null;
        }
        Pizza pizza = pilaPrincipal.pop();
        pilaSecundaria.push(pizza);
        return pizza;
    }

    // Rehacer: pop de la secundaria, push a la principal.
    public Pizza rehacer() {
        if (pilaSecundaria.isEmpty()) {
            return null;
        }
        Pizza pizza = pilaSecundaria.pop();
        pilaPrincipal.push(pizza);
        return pizza;
    }

    // Mostrar Pedido Actual: peek de la principal.
    public Pizza pedidoActual() {
        return pilaPrincipal.peek();
    }
}
