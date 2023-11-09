public class AgendaPersonal extends Agenda {

    public ContactoT1 creaContactoPersonal(Persona persona, int telefono, String email, String relacion, String cumple) {
        return new ContactoT1(persona, telefono, email, relacion, cumple);
    }

    public ContactoT2 crearPersonaProfesional(Persona persona, int telefono, String email, String empresa, String cargo) {
        throw new UnsupportedOperationException("No es posible crear un contacto profesional en una agenda personal");
    }
}
