package Clases;

public class Votante extends Persona{
    private int numero;

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
}
