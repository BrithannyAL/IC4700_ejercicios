import java.util.ArrayList;

/**
 * La clase `Grupo` representa un grupo de objetos y proporciona métodos para agregar y eliminar
 * objetos del grupo.
 */
public class Grupo extends Objeto {
    
    private ArrayList<Objeto> objetos;

    public Grupo() {
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
