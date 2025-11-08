package Clases;

import java.util.Objects;

public class Voto {
    private int numeroLista; // cambiar esto a n de lista
    private boolean validez;

    public Voto() {
    }

    public Voto(int numeroLista, boolean validez) {
        this.numeroLista = numeroLista;
        this.validez = validez;
    }

    public int getNumeroLista() {
        return numeroLista;
    }

    public void setNumeroLista(int numeroLista) {
        this.numeroLista = numeroLista;
    }

    public boolean isValidez() {
        return validez;
    }

    public void setValidez(boolean validez) {
        this.validez = validez;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Voto voto)) return false;
        return numeroLista == voto.numeroLista && validez == voto.validez;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroLista, validez);
    }

    @Override
    public String toString() {
        return "Voto{" +
                "numeroLista=" + numeroLista +
                ", validez=" + validez +
                '}';
    }
}
