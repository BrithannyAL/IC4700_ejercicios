public class EventoT2 extends Evento {
    
    private String orador;
    private int asistentes;
    private String patrocinador;

    public EventoT2(String tipo, String fecha, String hora, String lugar, String notas, String orador, int asistentes, String patrocinador) {
        super(tipo, fecha, hora, lugar, notas);
        this.orador = orador;
        this.asistentes = asistentes;
        this.patrocinador = patrocinador;
    }

    public String getOrador() {
        return orador;
    }

    public int getAsistentes() {
        return asistentes;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setOrador(String orador) {
        this.orador = orador;
    }

    public void setAsistentes(int asistentes) {
        this.asistentes = asistentes;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }
}
