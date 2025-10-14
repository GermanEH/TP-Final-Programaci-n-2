package Clases;
import Enums.Boleta;
public class Candidato extends Persona{
    private Boleta boleta;
    private String puesto;
    private String trabajo;

    public Candidato() {
    }

    public Candidato(Boleta partido, String puesto, String trabajo) {
        this.boleta = partido;
        this.puesto = puesto;
        this.trabajo = trabajo;
    }

    public Boleta getPartido() {
        return boleta;
    }

    public void setPartido(Boleta partido) {
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
}
