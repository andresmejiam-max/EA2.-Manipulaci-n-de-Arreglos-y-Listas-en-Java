public class Pizza {

    private String nombre;
    private String[] ingredientes; // arreglo de tamaño fijo (3)

    public Pizza(String nombre, String[] ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(" (");
        for (int i = 0; i < ingredientes.length; i++) {
            sb.append(ingredientes[i]);
            if (i < ingredientes.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
