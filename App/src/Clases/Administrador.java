package Clases;

import java.util.Objects;

public class Administrador {
    private String nombre;
    private String contra;

    public Administrador(String nombre, String contra) {
        this.nombre = nombre;
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Administrador that)) return false;
        return Objects.equals(nombre, that.nombre) && Objects.equals(contra, that.contra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, contra);
    }
}
