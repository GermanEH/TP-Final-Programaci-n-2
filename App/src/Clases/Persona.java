package Clases;

import java.util.Objects;

public abstract class Persona<T> {
    private String nombre;
    private String apellido;
    private int edad;
    private String dni;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Persona<?> persona)) return false;
        return edad == persona.edad && Objects.equals(nombre, persona.nombre) && Objects.equals(apellido, persona.apellido) && Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, edad, dni);
    }

    @Override
    public String toString() {
        return nombre + " " +
                apellido +
                ", edad: " + edad +
                ", dni: " + dni ;
    }
}
