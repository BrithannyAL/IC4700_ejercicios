/**
 * La clase Rectángulo representa un objeto rectangular con base y altura.
 */
public class Rectangulo extends Objeto {
    private int base;
    private int altura;
    private int area;

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
        this.area = base * altura;
    }

    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }

    public int getArea() {
        return area;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
