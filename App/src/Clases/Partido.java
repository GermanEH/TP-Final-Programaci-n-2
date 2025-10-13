package Clases;

import Enums.Partidos;

public class Partido {
    private Partido nombre;
    private String sigla;
    private int lista;
    private int votos;


    public Partido() {
    }

    public Partido(Partido nombre, String sigla, int lista, int votos) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.lista = lista;
        this.votos = votos;
    }

    public Partido getNombre() {
        return nombre;
    }

    public void setNombre(Partido nombre) {
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
