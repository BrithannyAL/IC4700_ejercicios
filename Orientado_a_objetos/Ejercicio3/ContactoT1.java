public class ContactoT1 extends Contacto{

    protected String tipo = "Personal";
    protected String relacion;
    protected String cumple;

    public ContactoT1(Persona persona, int telefono, String email, String relacion, String cumple) {
        super(persona, telefono, email);
        this.relacion = relacion;
        this.cumple = cumple;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getRelacion() {
        return this.relacion;
    }

    public void setCumple(String cumple) {
        this.cumple = cumple;
    }

    public String getCumple() {
        return this.cumple;
    }
    
}
