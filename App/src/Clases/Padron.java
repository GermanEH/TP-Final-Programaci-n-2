package Clases;

import Excepciones.VotanteException;
import Interfaces.Registro;

import java.util.ArrayList;

public final class Padron implements Registro<Votante> {

    private static ArrayList<Votante> votantes = new ArrayList<>();

    public Padron() {
    }

    @Override
    public void agregar(Votante v) throws VotanteException {
        if (v == null || v.getDni().isEmpty()){
            throw new VotanteException("ERROR: NO SE PERMITE AGREGAR VOTANTE NULO.");
        }
        votantes.add(v);
    }

    @Override
    public void eliminar(Votante votante) {
    votantes.remove(votante);
    }

    @Override
    public void mostrar() {
      for (Votante votante : votantes) {
        System.out.println(votante);
      }
    }

    @Override
    public Votante buscar(Votante votante) {
        for (Votante v : votantes){
            if (v.getNumero() == votante.getNumero()){
                return v;
            }
        }
        System.out.println("No se encontro el votante en el padron");
        return null;
    }

    public Votante buscarPorDniYNVoto(String dni, int numeroVoto) {
        for (Votante v : votantes) {
            if (v.getDni().equals(dni) && v.getNumero() == numeroVoto) {
                return v;
            }
        }
        return null;
    }

    public static boolean buscarPersona(String dni) {
        for (Votante v : votantes) {
            if (v.getDni().equals(dni)) return true;
        }
        return false;
    }

    public static boolean buscarPersona(int numeroVoto) {
        for (Votante v : votantes) {
            if (v.getNumero() == numeroVoto) return true;
        }
        return false;
    }

}
