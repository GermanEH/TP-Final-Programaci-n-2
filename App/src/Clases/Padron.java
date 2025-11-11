package Clases;

import Excepciones.VotanteException;
import Interfaces.Registro;

import java.util.ArrayList;
import java.util.List;

public final class Padron implements Registro<Votante> {

    private static ArrayList<Votante> votantes = new ArrayList<>(); // votantes.json leido en main

    public Padron() {
    }

    public static List<Votante> getVotantes() {
        return new ArrayList<>(votantes);
    }

    @Override
    public void agregar(Votante v) throws VotanteException {
        if (v == null || v.getDni().isEmpty()) {
            throw new VotanteException("ERROR: NO SE PERMITE AGREGAR VOTANTE NULO.");
        }
        votantes.add(v);
    }

    @Override
    public void eliminar(Votante votante) {
        if (votante == null) {
            try {
                throw new VotanteException("ERROR: NO SE PUEDE ELIMINAR VOTANTE NULO.");
            } catch (VotanteException e) {
                throw new RuntimeException(e);
            }
        }
        if (votantes.isEmpty()) {
            try {
                throw new VotanteException("ERROR: LISTA DE VOTANTES VACIA..");
            } catch (VotanteException e) {
                throw new RuntimeException(e);
            }
        } else {
            votantes.remove(votante);
        }

    }

    @Override
    public void mostrar() {
        if (votantes.isEmpty()) {
            try {
                throw new VotanteException("ERROR: LISTA DE VOTANTES VACIA..");
            } catch (VotanteException e) {
                throw new RuntimeException(e);
            }
        } else {
            for (Votante votante : votantes) {
                System.out.println(votante);
            }
        }

    }

    @Override
    public Votante buscar(Votante votante) {

        if (votante == null) {
            try {
                throw new VotanteException("ERROR: NO SE PUEDE BUSCAR VOTANTE NULO.");
            } catch (VotanteException e) {
                throw new RuntimeException(e);
            }
        }
        if (votantes.isEmpty()) {
            try {
                throw new VotanteException("ERROR: LISTA DE VOTANTES VACIA..");
            } catch (VotanteException e) {
                throw new RuntimeException(e);
            }
        } else {
            votantes.remove(votante);
        }

        for (Votante v : votantes) {
            if (v.getNumero() == votante.getNumero()) {
                return v;
            }
        }
        System.out.println("No se encontro el votante en el padron");
        return null;
    }

    public Votante buscarPorDniYNVoto(String dni, int numeroVoto) {
        if (votantes.isEmpty()) {
            try {
                throw new VotanteException("ERROR: LISTA DE VOTANTES VACIA..");
            } catch (VotanteException e) {
                throw new RuntimeException(e);
            }
        } else {
            for (Votante v : votantes) {
                if (v.getDni().equals(dni) && v.getNumero() == numeroVoto) {
                    return v;
                }
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

}
