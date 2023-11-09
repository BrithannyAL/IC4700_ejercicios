public class FabricaDeAgendas {
    public Agenda crearAgendaPersonal() {
        return new AgendaPersonal();
    }

    public Agenda crearAgendaProfesional() {
        return new AgendaProfesional();
    }
}