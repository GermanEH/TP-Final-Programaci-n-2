package Clases;

import Enums.Boletas;

import java.util.ArrayList;

public class Boleta {
    private Boletas nombre;
    private String sigla;
    private int Lista;
    private int votos;
    ArrayList<Candidato> Candidatos = new ArrayList<>();

    public Boleta(Boletas nombre, String sigla, int Lista, int votos) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.Lista = Lista;
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
        return Lista;
    }

    public void setLista(int lista) {
        this.Lista = lista;
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
                ", Lista=" + Lista +
                ", votos=" + votos +
                ", Candidatos=" + Candidatos +
                '}';
    }
}
