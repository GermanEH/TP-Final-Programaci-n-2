package Clases;

import Excepciones.VotanteException;

import java.util.ArrayList;

public class CentroDeVotacion {

    ArrayList<Boleta> boletas = new ArrayList<>();

    private boolean votacionIniciada = false;
    private boolean votacionCerrada = false;

    public void procesarVoto(Votante votante, Boleta boleta) throws VotanteException {

        if(votacionIniciada && Padron.buscarVotante(votante.getDni()) && !votante.getVoto()){
            votante.votar(boleta);
        } else if(!votacionIniciada){
            throw new VotanteException("La votación no fue iniciada todavía.");
        } else if(!Padron.buscarVotante(votante.getDni())){
            throw new VotanteException("No se encontró el dni en el padrón de votantes.");
        } else if(!votante.getVoto()){
            throw new VotanteException("Usted ya ha votado.");
        }

    }

    public Boleta determinarGanador() throws VotanteException{
        if(!votacionCerrada) {
            throw new Error("La votación todavía no fue cerrada.");
        }
        Boleta ganador = null;
        for(Boleta boleta:boletas){
            if(ganador == null) ganador = boleta;
            if(boleta.getVotos() > ganador.getVotos()){
                ganador = boleta;
            }
        }
        return ganador;
    }

    public void iniciarVotacion(){
        votacionIniciada = true;
    }

    public void cerrarVotacion(){
        votacionCerrada = true;
    }

    public ArrayList<Boleta> getBoletas() {
        return boletas;
    }

    public void setBoletas(ArrayList<Boleta> b) {
        boletas = b;
    }

}
