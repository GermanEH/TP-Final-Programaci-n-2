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
        if (v == null){
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

    public static boolean buscarPersona(int numero) {
        for (Votante votante : votantes) {
            if (votante.getNumero() == numero) {
                return true;
            }
        }

        return false;
    }

    public static boolean buscarPersona(String dni) {
        for (Votante votante : votantes) {
            if (votante.getDni().equals(dni)) {
                return true;
            }
        }

        return false;
    }


}
