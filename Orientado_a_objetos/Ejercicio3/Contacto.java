public class Contacto {
    protected Persona persona;
    protected int telefono;
    protected String email;

    public Contacto(Persona persona, int telefono, String email) {
        this.persona = persona;
        this.telefono = telefono;
        this.email = email;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}
