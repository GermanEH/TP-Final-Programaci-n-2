package Clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Boleta {
    private String nombre;
    private String sigla;
    private int lista;
    private int votos;
    private ArrayList<Candidato> candidatos;

    public Boleta(String nombre, String sigla, int lista) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.lista = lista;
        this.votos = 0;
        this.candidatos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
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

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Boleta boleta)) return false;
        return lista == boleta.lista && votos == boleta.votos && Objects.equals(nombre, boleta.nombre) && Objects.equals(sigla, boleta.sigla) && Objects.equals(candidatos, boleta.candidatos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, sigla, lista, votos, candidatos);
    }

    @Override
    public String toString() {
        return "Boleta{" +
                "nombre='" + nombre + '\'' +
                ", sigla='" + sigla + '\'' +
                ", lista=" + lista +
                ", votos=" + votos +
                ", Candidatos=" + candidatos +
                '}';
    }

    public boolean agregarCandidato(Candidato c) {
        if (candidatos.size() > 5 || c == null) {
            return false;
        } else {
            return candidatos.add(c);
        }
    }

    public boolean eliminarCandidato(Candidato c) {
        if (candidatos.isEmpty() || c == null) {
            return false;
        } else {
            Iterator it = candidatos.iterator();
            while (it.hasNext()) {
                Candidato iC = (Candidato) it.next();
                if (iC.equals(c)) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }

    public void aumentarVotos() {
        votos++;
    }
}
