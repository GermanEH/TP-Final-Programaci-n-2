package Clases;

import Interfaces.Registro;

import java.util.ArrayList;
import java.util.HashMap;

public final class Padron implements Registro<Votante> {

    private static ArrayList<Votante> Votantes = new ArrayList<>();


    @Override
    public void agregar(Votante votante) {

    }

    @Override
    public void eliminar(Votante votante) {

    }

    @Override
    public void mostrar() {

    }

    public static boolean buscarPersona(int numero) {
        for (Votante votante : Votantes) {
            if (votante.getNumero() == numero) {
                return true;
            }
        }

        return false;
    }

    public static boolean buscarPersona(String dni) {
        for (Votante votante : Votantes) {
            if (votante.getDni().equals(dni)) {
                return true;
            }
        }
        ;
        return false;
    }


}
