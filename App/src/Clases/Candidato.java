package Clases;

import java.util.Objects;

public class Candidato extends Persona {
    private String boleta;
    private String puesto;
    private String trabajo;

    public Candidato() {
    }

    public Candidato(String nombre, String apellido, int edad, String dni, String boleta, String puesto, String trabajo) {
        super(nombre, apellido, edad, dni);
        this.boleta = boleta;
        this.puesto = puesto;
        this.trabajo = trabajo;
    }

    public String getBoleta() {
        return boleta;
    }

    public void setBoleta(String boleta) {
        this.boleta = boleta;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Candidato candidato)) return false;
        return Objects.equals(boleta, candidato.boleta) && Objects.equals(puesto, candidato.puesto) && Objects.equals(trabajo, candidato.trabajo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boleta, puesto, trabajo);
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "boleta='" + boleta + '\'' +
                ", puesto='" + puesto + '\'' +
                ", trabajo='" + trabajo + '\'' +
                '}';
    }
}
