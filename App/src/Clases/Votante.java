package Clases;

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

    public void votar (Boleta boleta){
        boleta.setVotos(boleta.getVotos()+1);
        voto = true;
    }

    public boolean getVoto() {
        return voto;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }
}
