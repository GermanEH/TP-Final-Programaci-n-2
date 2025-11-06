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
        if (this == o) return true;
        if (!(o instanceof Boleta)) return false;
        Boleta boleta = (Boleta) o;
        return lista == boleta.lista;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lista);
    }

    @Override
    public String toString() {
        return "| BOLETA | :  " + nombre + " =" + sigla + "=" + "LISTA " + lista;
    }

    public boolean agregarCandidato(Candidato c) {
        if (candidatos.size() >= 5 || c == null) {
            return false; // si se pasa de 5 candidatos no lo agrego
        } else {
            for (Candidato candidato : candidatos) {
                if(candidato.getDni().equalsIgnoreCase(c.getDni())){
                    return false; // si existe no lo agrego
                }
            }
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
