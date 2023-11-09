package Ejercicio2;

import java.time.LocalDate;

public class Prestamo {
    private String codigoLibro;
    private int numeroSocio;
    private LocalDate fechaPrestamo;

    public Prestamo(Socio socio, Libro libro) {
        this.codigoLibro = libro.getCodigo();
        this.numeroSocio = socio.getNumero();
        this.fechaPrestamo = LocalDate.now();

        socio.prestar(libro);
    }

    public String getCodigoLibro() {
        return this.codigoLibro;
    }

    public int getNumeroSocio() {
        return this.numeroSocio;
    }

    public LocalDate getFechaPrestamo() {
        return this.fechaPrestamo;
    }

    @Override
    public String toString() {
        String txt = """
            Pestamo: 
            ----------------------------------
                Código del libro: %s
                Número del socio: %d
                Fecha del préstamo: %s
            ----------------------------------
                """;
        return String.format(txt, this.codigoLibro, this.numeroSocio, this.fechaPrestamo);
    }
}
