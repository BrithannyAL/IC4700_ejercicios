public abstract class Evento {

    private String fecha;
    private String tipo;
    private String hora;
    private String lugar;
    private String notas;

    public Evento(String tipo, String fecha, String hora, String lugar, String notas) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.notas = notas;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getLugar() {
        return lugar;
    }

    public String getNotas() {
        return notas;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}