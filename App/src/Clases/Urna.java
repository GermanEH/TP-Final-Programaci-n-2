package Clases;
import Interfaces.Registro;
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
        try {
            for (Voto v : urnaVotos) {
                JSONUrna.guardarVoto(v);
            }
        } catch (JSONException e) {
            System.out.println(e);
        }

    }

    @Override
    public void agregar(Voto voto) {
        try {
            JSONUrna.guardarVoto(voto);
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
