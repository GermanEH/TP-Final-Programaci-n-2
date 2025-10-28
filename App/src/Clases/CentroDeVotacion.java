package Clases;

import Excepciones.VotanteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CentroDeVotacion {

    private boolean esVotacionAbierta = false;
    private List<Votante> Fila;
    private int turno = 0;
    private Urna urna;
    private HashMap<String,Boleta> resultado;

    public CentroDeVotacion(){
        this.Fila = new ArrayList<Votante>();
        this.urna = new Urna();
        this.resultado = new HashMap<>();
        //this.resultado.entrySet("En blanco",new Boleta("En blanco","","en blanco",0));
    }
    public void abrirVotacion(){
        esVotacionAbierta = true;
    }

    public int asignarTurno(Votante votante) throws VotanteException{
        if(esVotacionAbierta && Padron.buscarPersona(votante.getNumero()) && !votante.getVoto()) {
            return ++turno;
        }
        else if(!esVotacionAbierta){
            throw new VotanteException("La votación no está abierta.");
        } else if(!Padron.buscarPersona(votante.getDni())){
            throw new VotanteException("No se encontró el dni en el padrón de votantes.");
        } else if(!votante.getVoto()){
            throw new VotanteException("Usted ya ha votado.");
        }
        return 0;
    }

    public int asignarTurno(String votanteDni){
        if(Padron.buscarPersona(votanteDni)) {
            return ++turno;
        }
        return 0;
    }

    public void procesarVoto(Votante votante, Voto voto) {
        this.urna.agregar(voto);
        votante.setVoto(true);
    }

    public void cerrarVotacion(){
        esVotacionAbierta=false;
    }

    public Boleta contarVotos() throws VotanteException{
        if(!esVotacionAbierta) {
            throw new VotanteException("La votación todavía no fue cerrada.");
        }
        Boleta ganador = null;
        for(Voto voto:urna.getUrnaVotos()){
            if(!voto.getValidez()) {
                //this.resultado.get("En blanco").aumentarVotos();
            } else {
                this.resultado.get(voto.getBoleta().getNombre()).aumentarVotos();
            }
        }
        return ganador;
    }

}
