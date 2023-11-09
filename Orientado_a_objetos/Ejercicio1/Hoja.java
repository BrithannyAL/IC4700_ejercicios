import java.util.ArrayList;

/**
 * La clase Hoja es un contenedor que contiene una lista de objetos Objeto y proporciona métodos para
 * agregar y eliminar objetos de la lista.
 */
public class Hoja {
    private ArrayList<Objeto> objetos;

    public Hoja() {
        objetos = new ArrayList<Objeto>();
    }

    public void add(Objeto objeto) {
        objetos.add(objeto);
    }

    public void remove(Objeto objeto) {
        objetos.remove(objeto);
    }

    public ArrayList<Objeto> getObjetos() {
        return objetos;
    }
}
