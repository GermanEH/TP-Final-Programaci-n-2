package Clases;

import Enums.Boletas;

import java.util.ArrayList;

public class Boleta {
    private Boletas nombre;
    private String sigla;
    private int numeroLista;
    private int votos;
    ArrayList<Candidato> Candidatos = new ArrayList<>();

    public Boleta(Boletas nombre, String sigla, int lista, int votos) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.numeroLista = lista;
        this.votos = votos;
    }

    public Boletas getNombre() {
        return nombre;
    }

    public void setNombre(Boletas nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getNumeroLista() {
        return numeroLista;
    }

    public void setNumeroLista(int numeroLista) {
        this.numeroLista = numeroLista;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return "Boleta{" +
                "nombre=" + nombre +
                ", sigla='" + sigla + '\'' +
                ", numeroLista=" + numeroLista +
                ", votos=" + votos +
                ", Candidatos=" + Candidatos +
                '}';
    }
}
