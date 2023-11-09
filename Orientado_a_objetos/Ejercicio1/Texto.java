/**
 * La clase `Texto` representa un objeto de texto con propiedades como el contenido, el alto y el ancho
 * del texto.
 */
public class Texto extends Objeto {
    private String texto;
    private int altura;
    private int anchura;

    public Texto(String texto, int altura, int anchura) {
        this.texto = texto;
        this.altura = altura;
        this.anchura = anchura;
    }

    public String getTexto() {
        return texto;
    }

    public int getAltura() {
        return altura;
    }

    public int getAnchura() {
        return anchura;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }
}
