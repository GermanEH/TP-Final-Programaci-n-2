package Clases;

import java.util.List;

public class Votante extends Persona{
    private int numero;
    private boolean voto = false;

    public Votante() {
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

    public boolean getVoto() {
        return voto;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }

    public Voto votar (BoletaUnica boletaUnica, int numeroLista){
       Boleta boletaElegida = boletaUnica.buscarPorLista(numeroLista);
       Voto votoRealizado = new Voto (boletaElegida, true);
       return votoRealizado;
    }
}
