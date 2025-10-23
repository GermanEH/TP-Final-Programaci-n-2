package Clases;
import Enums.Boletas;
public class Candidato extends Persona{
    private Boletas boleta;
    private String puesto;
    private String trabajo;

    public Candidato() {
    }

    public Candidato(Boletas partido, String puesto, String trabajo) {
        this.boleta = partido;
        this.puesto = puesto;
        this.trabajo = trabajo;
    }

    public Boletas getPartido() {
        return boleta;
    }

    public void setPartido(Boletas partido) {
        this.boleta = partido;
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
    public String toString() {
        return "Candidato{" +
                "boleta=" + boleta +
                ", puesto='" + puesto + '\'' +
                ", trabajo='" + trabajo + '\'' +
                '}';
    }
}
