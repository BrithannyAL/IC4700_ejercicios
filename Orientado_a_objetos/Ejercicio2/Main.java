package Ejercicio2;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Agregando los socios
        Socio socio1 = new Socio(1, "Julio Pérez", "La Tigra");
        Socio socio2 = new Socio(2, "María López", "Santa Clara");
        Socio socio3 = new Socio(3, "Pedro Martínez", "Santa Rosa");
        Socio socio4 = new Socio(4, "Ana García", "Ciudad Quesada");

        //Agregando los libros
        Libro libro1 = new Libro("CD1427", "Todas las hadas del reino", "Laura Gallego", "Biblioteca");
        Libro libro2 = new Libro("AB3289", "Cien años de soledad", "Gabriel García Márquez", "Biblioteca");
        Libro libro3 = new Libro("EF4521", "El señor de los anillos", "J.R.R. Tolkien", "Biblioteca");
        Libro libro4 = new Libro("GH5963", "Orgullo y prejuicio", "Jane Austen", "Biblioteca");
        Libro libro5 = new Libro("IJ7412", "El retrato de Dorian Gray", "Oscar Wilde", "Biblioteca");
        Libro libro6 = new Libro("KL8524", "El nombre del viento", "Patrick Rothfuss", "Biblioteca");
        Libro libro7 = new Libro("YZ1234", "1984", "George Orwell", "Biblioteca");
        Libro libro8 = new Libro("KL7890", "El principito", "Antoine de Saint-Exupéry", "Biblioteca");
        Libro libro9 = new Libro("MN4567", "Don Quijote de la Mancha", "Miguel de Cervantes", "Biblioteca");
        Libro libro10 = new Libro("OP6789", "Harry Potter y la piedra filosofal", "J.K. Rowling", "Biblioteca");
        Libro libro11 = new Libro("WX3456", "El amor en los tiempos del cólera", "Gabriel García Márquez", "Biblioteca");
        Libro libro12 = new Libro("RS2345", "Crimen y castigo", "Fiódor Dostoyevski", "Biblioteca");
        Libro libro13 = new Libro("UV4567", "El retrato de Dorian Gray", "Oscar Wilde", "Biblioteca");
        Libro libro14 = new Libro("IJ5678", "Moby Dick", "Herman Melville", "Biblioteca");


        //Creando los prestamos de algunos libros
        Prestamo prestamo1 = new Prestamo(socio1, libro1);

        Prestamo prestamo2 = new Prestamo(socio2, libro2);
        Prestamo prestamo3 = new Prestamo(socio2, libro3);

        Prestamo prestamo4 = new Prestamo(socio3, libro4);
        Prestamo prestamo5 = new Prestamo(socio3, libro5);
        Prestamo prestamo6 = new Prestamo(socio3, libro6);
        Prestamo prestamo7 = new Prestamo(socio3, libro7);

        Prestamo prestamo8 = new Prestamo(socio4, libro8);
        Prestamo prestamo9 = new Prestamo(socio4, libro9);
        Prestamo prestamo10 = new Prestamo(socio4, libro10);
        Prestamo prestamo11 = new Prestamo(socio4, libro14);

        //Agregando todos los libros a una lista
        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);
        libros.add(libro5);
        libros.add(libro6);
        libros.add(libro7);
        libros.add(libro8);
        libros.add(libro9);
        libros.add(libro10);
        libros.add(libro11);
        libros.add(libro12);
        libros.add(libro13);
        libros.add(libro14);

        //Ver estado el estado de los libros
        VerEstadoLibros(libros);

        //Agregando todos los socios a una lista
        ArrayList<Socio> socios = new ArrayList<>();
        socios.add(socio1);
        socios.add(socio2);
        socios.add(socio3);
        socios.add(socio4);

        //Filtrando los socios que tienen más de tres libros prestados
        ArrayList<Socio> sociosFiltrados = filtrar(socios);
        VerSocios(sociosFiltrados);
        
        //Agregando los prestamos a una lista de prestamos
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        prestamos.add(prestamo1);
        prestamos.add(prestamo2);
        prestamos.add(prestamo3);
        prestamos.add(prestamo4);
        prestamos.add(prestamo5);
        prestamos.add(prestamo6);
        prestamos.add(prestamo7);
        prestamos.add(prestamo8);
        prestamos.add(prestamo9);
        prestamos.add(prestamo10);
        prestamos.add(prestamo11);

        //Ver lista de prestamos
        VerPrestamos(prestamos);

    }

    /**
     * La función filtra una lista de objetos "Socio" y devuelve una nueva lista que contiene sólo los
     * socios a los que les han prestado más de tres libros.
     * 
     * @return sociosFiltrados: ArrayList<Socio>
     */
    public static ArrayList<Socio> filtrar(ArrayList<Socio> socios) {
        ArrayList<Socio> sociosFiltrados = (ArrayList<Socio>) socios.stream()
                .filter(socio -> socio.getNumeroLibros() > 3)
                .collect(Collectors.toList());
        return sociosFiltrados;
    }

    /**
     * La función "VerEstadoLibros" imprime el estado de los libros en un ArrayList.
     * 
     * @param libros Un ArrayList de objetos de tipo Libro.
     */
    public static void VerEstadoLibros(ArrayList<Libro> libros) {
        System.out.println("\n\n>-ESTADO DE LIBROS-<");
        for (Libro libro : libros) {
            System.out.println(libro.escribir());
        }
    }

    /**
     * La función "VerSocios" imprime la información de todos los socios que tienen más de 3 libros,
     * incluyendo sus datos y el detalle de los libros que han tomado prestados.
     * 
     * @param socios Un ArrayList de objetos de tipo "Socio".
     */
    public static void VerSocios(ArrayList<Socio> socios) {
        System.out.println("\n\n>-SOCIOS CON MAS DE 3 LIBROS-<");
        for (Socio socio : socios) {
            System.out.println(socio.toString());
            ArrayList<Libro> libros = socio.getLibros();
            for (Libro libro : libros) {
                System.out.println("\t"+libro.getTitulo());
            }
            System.out.println("\n--------------------------------------------------------");
        }
    }

    //Ver lista de prestamos
    public static void VerPrestamos(ArrayList<Prestamo> prestamos) {
        System.out.println("\n\n>-PRESTAMOS-<");
        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo.toString());
        }
    }
}