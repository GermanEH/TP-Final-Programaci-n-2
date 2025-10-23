import Clases.Boleta;
import Interfaces.Registro;

import java.util.Set;
public class BoletaUnica implements Registro<Boleta> {
    Set<Boleta> boletaUnica;

    public BoletaUnica(Set<Boleta> boletaUnica) {
        this.boletaUnica = boletaUnica;
    }

    public Set<Boleta> getBoletaUnica() {
        return boletaUnica;
    }

    public void setBoletaUnica(Set<Boleta> boletaUnica) {
        this.boletaUnica = boletaUnica;
    }

    @Override
    public String toString() {
        return "BoletaUnica{" +
                "boletaUnica=" + boletaUnica +
                '}';
    }

    @Override
    public void agregar(Boleta boleta) {

    }

    @Override
    public void eliminar(Boleta boleta) {

    }

    @Override
    public void mostrar() {

    }

}
