package Clases;
import Interfaces.Registro;
import JSONUtiles.JSONBoletas;
import JSONUtiles.JSONUrna;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Urna implements Registro<Voto> {

    public Urna() {
    }

    public List<Voto> getUrnaVotos() throws JSONException {
        return JSONUrna.leerVotos();
    }

    public static void setUrnaVotos(List<Voto> urnaVotos) {
                JSONUrna.guardarVotos(urnaVotos);
    }

    @Override
    public void agregar(Voto voto) {
        try {
            List<Voto> votos = JSONUrna.leerVotos();
            votos.add(voto);
            JSONUrna.guardarVotos(votos);
        } catch (JSONException e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminar(Voto voto) {
        System.out.println("No se puede eliminar votos");
    }

    @Override
    public void mostrar() {
        try {
            List votos = JSONUrna.leerVotos();
            for (Object voto : votos) {
                System.out.println(voto);
            }
        }catch(JSONException e){
            System.out.println(e);
        }

    }

    @Override
    public Voto buscar(Voto voto) {
        return null;
    }
}
