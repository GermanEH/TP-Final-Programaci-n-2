package Clases;
import Interfaces.Registro;
import java.util.List;
import java.util.Collections;
public class Urna implements Registro<Voto> {

    private List<Voto> urnaVotos;

    public Urna(List<Voto> urnaVotos) {
        this.urnaVotos = urnaVotos;
    }

    public List<Voto> getUrnaVotos() {
        return urnaVotos;
    }

    public void setUrnaVotos(List<Voto> urnaVotos) {
        this.urnaVotos = urnaVotos;
    }

    @Override
    public void agregar(Voto voto) {
        this.urnaVotos.add(voto);
    }

    @Override
    public void eliminar(Voto voto) {
        this.urnaVotos.remove(voto);
    }

    @Override
    public void mostrar() {
        for (Voto voto : this.urnaVotos) {
            System.out.println(voto);
        }
    }


}
