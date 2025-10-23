package Clases;

import Interfaces.Registro;

import java.util.ArrayList;
import java.util.HashMap;

public final class Padron implements Registro<Votante> {

    private static ArrayList<Votante> votantes = new ArrayList<>();


    @Override
    public void agregar(Votante votante) {
      votantes.add(votante);
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

    public static boolean buscarVotante(int numero) {
        for (Votante votante : votantes) {
            if (votante.getNumero() == numero) {
                return true;
            }
        }

        return false;
    }

    public static boolean buscarVotante(String dni) {
        for (Votante votante : votantes) {
            if (votante.getDni().equals(dni)) {
                return true;
            }
        }
        ;
        return false;
    }


}
