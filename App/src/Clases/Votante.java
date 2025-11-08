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

        if(this.voto){ // si ya tiene true porque voto antes devuelvo un Voto nulo.
            return new Voto(null, false);
        }

       Boleta b = boletaUnica.buscarPorLista(numeroLista); // Busco la boleta
       boolean validez = b != null; // Si existe
       Voto votoRealizado = new Voto (b, validez); // Creo un voto con boleta unica y Validez.

       if (validez){
           b.aumentarVotos(); // Si existe aumento el contador de la boleta unica
           this.voto = true; // Pongo el voto en true
       }

       return votoRealizado;
    }
}
