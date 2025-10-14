package Clases;

import java.util.ArrayList;
import java.util.HashMap;

public final class Padron {

    private static ArrayList<Votante> Votantes = new ArrayList<>();

    public static boolean buscarVotante(int numero) {
        for (Votante votante : Votantes) {
            if (votante.getNumero() == numero) {
                return true;
            }
        }

        return false;
    }

    public static boolean buscarVotante(String dni) {
        for (Votante votante : Votantes) {
            if (votante.getDni().equals(dni)) {
                return true;
            }
        }
        ;
        return false;
    }


}
