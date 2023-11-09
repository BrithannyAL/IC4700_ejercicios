import java.util.ArrayList;

/**
 * La clase Documento representa un documento que contiene una colección de objetos Hoja.
 */
public class Documento {
    private ArrayList<Hoja> hojas;

    public Documento() {
        hojas = new ArrayList<Hoja>();
    }

    public void add(Hoja hoja) {
        hojas.add(hoja);
    }

    public void remove(Hoja hoja) {
        hojas.remove(hoja);
    }

    public ArrayList<Hoja> getHojas() {
        return hojas;
    }

    public void setHojas(ArrayList<Hoja> hojas) {
        this.hojas = hojas;
    }

    public int getNumeroHojas() {
        return hojas.size();
    }

    public Hoja getHoja(int index) {
        return hojas.get(index);
    }
}
