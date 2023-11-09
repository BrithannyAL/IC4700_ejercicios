public class Main {
    public static void main(String[] args) {
        // Creando una instancia principal
        Principal principal = Principal.obtenePrincipal();

        // Agregando contectos a la agenda personal
        principal.agregarContactoPersonal(
                new ContactoT1(
                        new Persona("Julian", "Matute", "San Carlos"),
                        123456789, "email1@example.com",
                        "amigo", "01/01/2000"));

        principal.agregarContactoPersonal(
            new ContactoT1(
                    new Persona("Laura", "Gómez", "San Jose"),
                    987654321, "email2@example.com",
                    "familiar", "02/02/2000"));

        principal.agregarContactoPersonal(
                new ContactoT1(
                        new Persona("Carlos", "Sánchez", "Alajuela"),
                        111111111, "email3@example.com",
                        "compañero", "03/03/2000"));

        principal.agregarContactoPersonal(
                new ContactoT1(
                        new Persona("María", "Pérez", "Cartago"),
                        222222222, "email4@example.com",
                        "colega", "04/04/2000"));

        principal.agregarContactoPersonal(
                new ContactoT1(
                        new Persona("Andrés", "López", "Heredia"),
                        333333333, "email5@example.com",
                        "conocido", "05/05/2000"));

        // Agregando contectos a la agenda profesional

        principal.agregarContactoProfesional(
            new ContactoT2(
                    new Persona("Jorge", "González", "San Carlos"),
                    123456789, "email1@example.com", "CompanyA", "Manager"));

        principal.agregarContactoProfesional(
                new ContactoT2(
                        new Persona("Ana", "Hernández", "San Jose"),
                        987654321, "email2@example.com", "CompanyB", "Director"));

        principal.agregarContactoProfesional(
                new ContactoT2(
                        new Persona("Roberto", "Sánchez", "Alajuela"),
                        111111111, "email3@example.com", "CompanyC", "CEO"));

        principal.agregarContactoProfesional(
                new ContactoT2(
                        new Persona("Marcela", "Pérez", "Cartago"),
                        222222222, "email4@example.com", "CompanyD", "Supervisor"));

        principal.agregarContactoProfesional(
                new ContactoT2(
                        new Persona("Andrea", "López", "Heredia"),
                        333333333, "email5@example.com", "CompanyE", "Coordinator"));

        // Mostrando los contactos de ambas agendas
        principal.verContactosPersonales();
        principal.verContactosProfesionales();
    }
}