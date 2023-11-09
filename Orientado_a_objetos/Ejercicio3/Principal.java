public class Principal {

    /*
     * En Eager Singleton, la instancia de la clase se crea de inmediato cuando la clase es cargada
     * por el cargador de clases, lo que garantiza que la instancia esté disponible en todo momento
     * durante la ejecución del programa. Esto significa que la instancia se inicializa de manera temprana
     * incluso antes de que se necesite, lo que puede consumir recursos del sistema,
     * especialmente si la creación de la instancia es costosa en términos de memoria o tiempo de
     * procesamiento.
     * 
     * En Lazy Singleton, la instancia de la clase se crea solo cuando se solicita por primera vez,
     * posponiendo la creación hasta el momento en que sea necesaria durante la ejecución del programa.
     * Este enfoque puede ahorrar recursos del sistema, ya que la instancia solo se crea cuando se requiere,
     * lo que puede ser beneficioso en situaciones donde la creación de la instancia es costosa en términos
     * de recursos como memoria o tiempo de procesamiento.
     */

    /*
     * Es más factible utilizar Eager Singleton, ya que la agenda es un componente central
     * que se utiliza de manera constante durante la ejecución del programa,
     * y tener una instancia lista y disponible desde el inicio garantiza un acceso rápido y consistente,
     * evitando la sobrecarga de crear la instancia cada vez que sea necesaria.
    */

    private Agenda contactosPersonales;
    private Agenda contactosProfesionales;
    private static Principal InstanciaPrincipal;

    private Principal() {
        FabricaDeAgendas fabricaDeAgendas = new FabricaDeAgendas();
        this.contactosPersonales = fabricaDeAgendas.crearAgendaPersonal();
        this.contactosProfesionales = fabricaDeAgendas.crearAgendaProfesional();
    }

    public static Principal obtenePrincipal() {
        if (InstanciaPrincipal == null) {
            InstanciaPrincipal = new Principal();
        }
        return InstanciaPrincipal;
    }

    public void agregarContactoPersonal(ContactoT1 contacto) {
        this.contactosPersonales.agregarContacto(contacto);
    }

    public void agregarContactoProfesional(ContactoT2 contacto) {
        this.contactosProfesionales.agregarContacto(contacto);
    }

    public void verContactosPersonales() {
        System.out.println("\tCONTACTOS PERSONALES\n");
        for (Contacto contacto : this.contactosPersonales.getContactos()) {
            System.out.println("Nombre: " + contacto.getPersona().getNombre() + " " + contacto.getPersona().getApellido());
            System.out.println("Teléfono: " + contacto.getTelefono());
            System.out.println("Email: " + contacto.getEmail());
            System.out.println("Relación: " + ((ContactoT1) contacto).getRelacion());
            System.out.println("Cumpleaños: " + ((ContactoT1) contacto).getCumple());
            System.out.println("Tipo: " + ((ContactoT1) contacto).getTipo());
            System.out.println("--------------------------------------------------");
        }
    }

    public void verContactosProfesionales() {
        System.out.println("\tCONTACTOS PROFESIONALES\n");
        for (Contacto contacto : this.contactosProfesionales.getContactos()) {
            System.out.println("Nombre: " + contacto.getPersona().getNombre() + " " + contacto.getPersona().getApellido());
            System.out.println("Teléfono: " + contacto.getTelefono());
            System.out.println("Email: " + contacto.getEmail());
            System.out.println("Empresa: " + ((ContactoT2) contacto).getEmpresa());
            System.out.println("Cargo: " + ((ContactoT2) contacto).getCargo());
            System.out.println("Tipo: " + ((ContactoT2) contacto).getTipo());
            System.out.println("--------------------------------------------------");
        }
    }

    //Ver los eventos de la agenda contactosPersonales los cuales pertenecen al tipo EventoT1
    public void verEventosPersonales() {
        System.out.println("\tEVENTOS PERSONALES\n");
        for (Evento evento : this.contactosPersonales.getEventos()) {
            System.out.println("Tipo: " + evento.getTipo());
            System.out.println("Fecha: " + evento.getFecha());
            System.out.println("Hora: " + evento.getHora());
            System.out.println("Lugar: " + evento.getLugar());
            System.out.println("Notas: " + evento.getNotas());
            System.out.println("Invitados: " + ((EventoT1) evento).getInvitados());
            System.out.println("Organizador: " + ((EventoT1) evento).getOrganizador());
            System.out.println("--------------------------------------------------");
        }
    }
}
