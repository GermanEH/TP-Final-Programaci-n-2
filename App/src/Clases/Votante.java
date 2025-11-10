package Clases;

import JSONUtiles.JSONVotantes;

import java.util.List;

public class Votante extends Persona {
    private int numero;
    private boolean voto;

    public Votante() {
        this.voto = false;
    }

    public Votante(String nombre, String apellido, int edad, String dni, int numero) {
        super(nombre, apellido, edad, dni);
        this.numero = numero;
        this.voto = false;
    }

    public Votante(String nombre, String apellido, int edad, String dni, int numero, boolean voto) {
        super(nombre, apellido, edad, dni);
        this.numero = numero;
        this.voto = voto;
    }

    public Votante(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void votar(Boleta boleta) {
        boleta.setVotos(boleta.getVotos() + 1);
        voto = true;
    }

    public boolean getVoto() {
        return voto;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }

    public Voto votar (BoletaUnica boletaUnica, int numeroLista){

        if (this.voto) { // si ya votó antes
            return new Voto(-1, false); // voto inválido
        }

        Boleta b = boletaUnica.buscarPorLista(numeroLista); // Busco la boleta
        boolean validez = b != null; // Si existe

        if (validez) {
            b.aumentarVotos();
            this.voto = true;


            List<Votante> votantes = JSONVotantes.leerVotantes();
            for (Votante v : votantes) {
                if (v.getDni().equals(this.dni)) {
                    v.setVoto(true);
                    break;
                }
            }
            JSONVotantes.guardarVotantes(votantes);
        }

        return new Voto(numeroLista, validez);
    }

}
