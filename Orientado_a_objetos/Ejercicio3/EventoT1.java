import java.util.ArrayList;

public class EventoT1 extends Evento {

    private ArrayList<String> invitados;
    private String organizador;

    public EventoT1(String tipo, String fecha, String hora, String lugar, String notas, ArrayList<String> invitados, String organizador) {
        super(tipo, fecha, hora, lugar, notas);
        this.invitados = invitados;
        this.organizador = organizador;
    }

    public ArrayList<String> getInvitados() {
        return invitados;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setInvitados(ArrayList<String> invitados) {
        this.invitados = invitados;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public void agregarInvitado(String invitado) {
        this.invitados.add(invitado);
    }
}
