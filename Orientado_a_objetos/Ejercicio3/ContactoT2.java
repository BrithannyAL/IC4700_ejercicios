public class ContactoT2 extends Contacto {
    protected String tipo = "Profesional";
    protected String empresa;
    protected String cargo;

    public ContactoT2(Persona persona, int telefono, String email, String empresa, String cargo) {
        super(persona, telefono, email);
        this.empresa = empresa;
        this.cargo = cargo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return this.empresa;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }
}
