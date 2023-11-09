import java.util.ArrayList;

public abstract class Agenda {

    protected ArrayList<Contacto> contactos = new ArrayList<>();
    protected ArrayList<Evento> eventos = new ArrayList<>();

    public abstract ContactoT1 creaContactoPersonal(
        Persona persona, int telefono, String email, String relacion, String cumple
    );

    public abstract ContactoT2 crearPersonaProfesional(
        Persona persona, int telefono, String email, String empresa, String cargo
    );

    public void agregarContacto(Contacto contacto) {
        this.contactos.add(contacto);
    }

    public void eliminarContacto(String apellido) {
        for (Contacto contacto : this.contactos) {
            if (contacto.getPersona().getApellido().equals(apellido)) {
                this.contactos.remove(contacto);
                break;
            }
        }
    }
    
    public ArrayList<Contacto> getContactos() {
        return this.contactos;
    }

    public Contacto getContacto(String apellido) {
        for (Contacto contacto : this.contactos) {
            if (contacto.getPersona().getApellido().equals(apellido)) {
                return contacto;
            }
        }
        return null;
    }

    public ArrayList<Evento> getEventos() {
        return this.eventos;
    }
    

    // MODIFICAR LA INFORMACIÓN GENERAL DE LOS CONTACTOS

    public void modificarContactoNumero(String apellido, int newNumero) {
        for (Contacto contacto : this.contactos) {
            if (contacto.getPersona().getApellido().equals(apellido)) {
                contacto.setTelefono(newNumero);
                break;
            }
        }
    }

    public void modificarContactoEmail(String apellido, String newEmail) {
        for (Contacto contacto : this.contactos) {
            if (contacto.getPersona().getApellido().equals(apellido)) {
                contacto.setEmail(newEmail);
                break;
            }
        }
    }

    public void modificarContactoNombreCompleto(String apellido, String newNombre, String newApellido) {
        for (Contacto contacto : this.contactos) {
            if (contacto.getPersona().getApellido().equals(apellido)) {
                contacto.getPersona().setNombre(newNombre);
                contacto.getPersona().setApellido(newApellido);
                break;
            }
        }
    }

    public void modificarContactoDireccion(String apellido, String newDireccion) {
        for (Contacto contacto : this.contactos) {
            if (contacto.getPersona().getApellido().equals(apellido)) {
                contacto.getPersona().setDireccion(newDireccion);
                break;
            }
        }
    }

    // MODIFICAR LA INFORMACIÓN ESPECÍFICA DE LOS CONTACTOS TIPO CONTACTOT1

    public void modificarContactoRelacion(String apellido, String newRelacion) {
        for (Contacto contacto : this.contactos) {
            if (contacto.getPersona().getApellido().equals(apellido) && contacto instanceof ContactoT1) {
                ((ContactoT1) contacto).setRelacion(newRelacion);
                break;
            }
        }
    }

    public void modificarContactoCumple(String apellido, String newCumple) {
        for (Contacto contacto : this.contactos) {
            if (contacto.getPersona().getApellido().equals(apellido) && contacto instanceof ContactoT1) {
                ((ContactoT1) contacto).setCumple(newCumple);
                break;
            }
        }
    }

    // MODIFICAR LA INFORMACIÓN ESPECÍFICA DE LOS CONTACTOS TIPO CONTACTOT2

    public void modificarContactoEmpresa(String apellido, String newEmpresa) {
        for (Contacto contacto : this.contactos) {
            if (contacto.getPersona().getApellido().equals(apellido) && contacto instanceof ContactoT2) {
                ((ContactoT2) contacto).setEmpresa(newEmpresa);
                break;
            }
        }
    }

    public void modificarContactoCargo(String apellido, String newCargo) {
        for (Contacto contacto : this.contactos) {
            if (contacto.getPersona().getApellido().equals(apellido) && contacto instanceof ContactoT2) {
                ((ContactoT2) contacto).setCargo(newCargo);
                break;
            }
        }
    }
}