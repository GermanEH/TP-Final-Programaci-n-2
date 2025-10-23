package Clases;

import Enums.Boletas;

import java.util.ArrayList;

public class Boleta {
    private Boletas nombre;
    private String sigla;
    private int lista;
    private int votos;
    ArrayList<Candidato> Candidatos = new ArrayList<>();

    public Boleta(Boletas nombre, String sigla, int lista, int votos) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.lista = lista;
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

    public int getLista() {
        return lista;
    }

    public void setLista(int lista) {
        this.lista = lista;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public void aumentarVotos() {votos = votos++;}

    @Override
    public String toString() {
        return "Boleta{" +
                "nombre=" + nombre +
                ", sigla='" + sigla + '\'' +
                ", lista=" + lista +
                ", votos=" + votos +
                ", Candidatos=" + Candidatos +
                '}';
    }
}
