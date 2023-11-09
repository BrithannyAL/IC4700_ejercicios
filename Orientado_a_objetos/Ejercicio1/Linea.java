/**
 * La clase Linea es una subclase de ObjetoGeometrico y representa una línea con una longitud
 * especificada.
 */
public class Linea extends Objeto {
    private int longitud;

    public Linea(int longitud) {
        this.longitud = longitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
}