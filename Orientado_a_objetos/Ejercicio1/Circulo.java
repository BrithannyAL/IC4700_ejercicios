/**
 * La clase Circulo representa un objeto circular con propiedades como diámetro y radio.
 */
public class Circulo extends Objeto {
    private int diametro;
    private int radio;

    public Circulo(int diametro) {
        this.diametro = diametro;
        this.radio = diametro / 2;
    }

    public int getDiametro() {
        return diametro;
    }

    public int getRadio() {
        return radio;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
        this.radio = diametro / 2;
    }

    public void setRadio(int radio) {
        this.radio = radio;
        this.diametro = radio * 2;
    }
}
