package Ejercicio2;

import java.util.ArrayList;

public class Socio {
    private int numero;
    private String nombre;
    private String direccion;
    private ArrayList<Libro> libros;

    public Socio(int numero, String nombre, String direccion) {
        this.numero = numero;
        this.nombre = nombre;
        this.direccion = direccion;
        this.libros = new ArrayList<Libro>();
    }

    public void prestar(Libro libro) {
        this.libros.add(libro);
        libro.prestar(this);
    }

    public void devolver(Libro libro) {
        this.libros.remove(libro);
        libro.devolver();
    }

    public int getNumeroLibros() {
        return this.libros.size();
    }

    public int getNumero() {
        return this.numero;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public ArrayList<Libro> getLibros() {
        return this.libros;
    }

    @Override
    public String toString() {
        String txt = """
            -%s
                Número de socio: %d
                Dirección: %s
                Número de libros prestados: %d
            """;
        return String.format(txt, this.nombre, this.numero, this.direccion, this.libros.size());
    }
}
