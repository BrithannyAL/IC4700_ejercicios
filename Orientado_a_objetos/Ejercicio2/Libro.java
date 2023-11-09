package Ejercicio2;

public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private boolean disponible;
    private String localizacion;
    private Socio socio;

    public Libro(String codigo, String titulo, String autor, String localizacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
        this.localizacion = localizacion;
    }

    public void prestar(Socio socio) {
        this.socio = socio;
        this.disponible = false;
        this.localizacion = socio.getDireccion();
    }

    public void devolver() {
        this.socio = null;
        this.disponible = true;
        this.localizacion = "Biblioteca";
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public boolean getDisponible() {
        return this.disponible;
    }

    public String getLocalizacion() {
        return this.localizacion;
    }

    public Socio getSocio() {
        return this.socio;
    }

    public String escribir() {
        String txt = """
            -%s
                Código: %s
                Autor: %s
                Disponible: %s
                Localización: %s
            """;
        return String.format(txt, this.titulo, this.codigo, this.autor, this.disponible, this.localizacion);
    }
}
