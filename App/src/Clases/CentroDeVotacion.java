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
    private HashMap<Integer, Boleta> resultado;

    public CentroDeVotacion() {
        this.Fila = new ArrayList<>();
        this.urna = new Urna();
        this.resultado = new HashMap<>();
    }

    public void abrirVotacion() {
        esVotacionAbierta = true;
    }

    public void cerrarVotacion() {
        esVotacionAbierta = false;
    }

    public void cargarBoletas(List<Boleta> boletas) {
        for (Boleta b : boletas) {
            resultado.put(b.getLista(), b);
        }
    }

    public int asignarTurno(Votante votante) throws VotanteException {
        if (!esVotacionAbierta) {
            throw new VotanteException("La votación no está abierta.");
        }
        if (!Padron.buscarPersona(votante.getDni())) {
            throw new VotanteException("No se encontró el votante en el padrón.");
        }
        if (votante.getVoto()) {
            throw new VotanteException("Usted ya ha votado.");
        }
        return ++turno;
    }

    public void procesarVoto(Votante votante, Voto voto) throws VotanteException{
        if(!esVotacionAbierta){
            throw new VotanteException("ERROR: No se puede procesar el voto");
        }
        urna.agregar(voto);
        votante.setVoto(true);
    }

    public Boleta contarVotos() throws VotanteException {
        if (esVotacionAbierta) {
            throw new VotanteException("La votación todavía está abierta. Primero debe cerrarse.");
        }

        if(urna.getUrnaVotos().isEmpty()){
            throw new VotanteException("ERROR: NO HAY VOTOS EN LA URNA.");
        }

        Boleta ganador = null;
        for (Voto voto : urna.getUrnaVotos()) {
            if (voto.isValidez()) {
                Boleta b = resultado.get(voto.getNumeroLista());
                if (b != null) {
                    b.aumentarVotos();
                }
            } else {
                // resultado.get(0).aumentarVotos(); // si querés contar votos en blanco
            }
        }

        for (Boleta b : resultado.values()) {
            if (ganador == null || b.getVotos() > ganador.getVotos()) {
                ganador = b;
            }
        }

        System.out.println("GANADOR: "+ganador.getLista() +"("+ ganador.getNombre() + ")");
        return ganador;
    }
}

