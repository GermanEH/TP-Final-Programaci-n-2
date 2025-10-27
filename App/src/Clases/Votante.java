package Clases;

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
}
