package Clases;
import Enums.Partidos;
public class Candidato extends Persona{
    private Partidos partido;
    private String puesto;
    private String trabajo;

    public Candidato() {
    }

    public Candidato(Partidos partido, String puesto, String trabajo) {
        this.partido = partido;
        this.puesto = puesto;
        this.trabajo = trabajo;
    }

    public Partidos getPartido() {
        return partido;
    }

    public void setPartido(Partidos partido) {
        this.partido = partido;
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
}
