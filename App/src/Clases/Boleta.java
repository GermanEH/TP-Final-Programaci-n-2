package Clases;

import java.util.ArrayList;

public class Boleta {
    private Boleta nombre;
    private String sigla;
    private int lista;
    private int votos;
    ArrayList<Candidato> Candidatos = new ArrayList<>();

    public Boleta(Boleta nombre, String sigla, int lista, int votos) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.lista = lista;
        this.votos = votos;
    }

    public Boleta getNombre() {
        return nombre;
    }

    public void setNombre(Boleta nombre) {
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
}
