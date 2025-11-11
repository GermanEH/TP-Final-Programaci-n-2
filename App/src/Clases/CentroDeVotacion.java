package Clases;

import Excepciones.VotanteException;
import JSONUtiles.JSONBoletas;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CentroDeVotacion {

    private boolean esVotacionAbierta = false;
    private List<Votante> Fila;
    private int turno = 0;
    private Urna urna;
    private HashMap<Integer, Integer> resultado;

    public CentroDeVotacion() {
        this.Fila = new ArrayList<>();
        this.urna = new Urna();
        this.resultado = new HashMap<>();
        this.resultado.put(999, 0);
    }

    public boolean isEsVotacionAbierta() {
        return esVotacionAbierta;
    }

    public void setEsVotacionAbierta(boolean esVotacionAbierta) {
        this.esVotacionAbierta = esVotacionAbierta;
    }

    public List<Votante> getFila() {
        return Fila;
    }

    public void setFila(List<Votante> fila) {
        Fila = fila;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public Urna getUrna() {
        return urna;
    }

    public void setUrna(Urna urna) {
        this.urna = urna;
    }

    public HashMap<Integer, Integer> getResultado() {
        return resultado;
    }

    public void setResultado(HashMap<Integer, Integer> resultado) {
        this.resultado = resultado;
    }

    public void abrirVotacion() {
        esVotacionAbierta = true;
    }

    public void cerrarVotacion() {
        esVotacionAbierta = false;
    }

    public void cargarBoletas(List<Boleta> boletas) {
        for (Boleta b : boletas) {
            resultado.put(b.getLista(), 0);
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

    public void procesarVoto(Votante votante, BoletaUnica boletaUnica, int numeroLista) throws VotanteException {
        if (!esVotacionAbierta) {
            throw new VotanteException("ERROR: No se puede procesar el voto");
        }

        Voto voto = votante.votar(boletaUnica, numeroLista);

        if (voto.isValidez()) {
            urna.agregar(voto);
        }
    }

    public Integer contarVotos() throws VotanteException, JSONException {
        if (esVotacionAbierta) {
            throw new VotanteException("La votación todavía está abierta. Primero debe cerrarse.");
        }

        if (urna.getUrnaVotos().isEmpty()) {
            throw new VotanteException("ERROR: NO HAY VOTOS EN LA URNA.");
        }

        for (Voto voto : urna.getUrnaVotos()) {
            if (voto.isValidez()) {
                int numeroLista = voto.getNumeroLista();
                resultado.put(numeroLista, resultado.get(numeroLista) + 1);
            } else {
                resultado.put(999, resultado.get(999) + 1); // votos en blanco
            }
        }
        Integer votosGanador = 0;
        Integer ganador = 0;
        for (Integer lista : resultado.keySet()) {
            if (resultado.get(lista) > votosGanador) {
                votosGanador = resultado.get(lista);
                ganador = lista;
            }
        }

        for (Map.Entry<Integer, Integer> entry : resultado.entrySet()) {
            Integer key = entry.getKey();
            Integer valor = entry.getValue();

            System.out.println(key + " -> " + valor);
        }
        ;

        return ganador;
    }
}

