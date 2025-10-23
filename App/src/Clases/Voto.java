package Clases;

public class Voto {
    private Boleta boleta;
    private boolean validez;

    public Voto() {
    }

    public Voto(Boleta boleta, boolean validez) {
        this.boleta = boleta;
        this.validez = validez;
    }

    public Boleta getBoleta() {
        return boleta;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }

    public boolean isValidez() {
        return validez;
    }

    public void setValidez(boolean validez) {
        this.validez = validez;
    }

    @Override
    public String toString() {
        return "Voto{" +
                "boleta=" + boleta +
                ", validez=" + validez +
                '}';
    }
}
