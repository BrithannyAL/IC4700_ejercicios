/**
 * La clase Cuadro representa un objeto cuadrado con una longitud y un área de lado determinadas.
 */
public class Cuadro extends Objeto {
    private int lado;
    private int area;

    public Cuadro(int lado) {
        this.lado = lado;
        this.area = lado * lado;
    }

    public int getLado() {
        return lado;
    }

    public int getArea() {
        return area;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
