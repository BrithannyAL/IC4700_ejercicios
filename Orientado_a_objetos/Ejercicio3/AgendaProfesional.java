public class AgendaProfesional extends Agenda {
    public ContactoT1 creaContactoPersonal(Persona persona, int telefono, String email, String relacion, String cumple) {
        throw new UnsupportedOperationException("No es posible crear un contacto personal en una agenda profesional");
    }

    public ContactoT2 crearPersonaProfesional(Persona persona, int telefono, String email, String empresa, String cargo) {
        return new ContactoT2(persona, telefono, email, empresa, cargo);
    }
}
