package Clases;

import Clases.JSONUtiles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static Clases.JSONUtiles.grabar;

public class GestorDeArchivos {

    public void agregarVotante(Votante votante) {
        List<Votante> votantes = JSONElecciones.leerVotantes();
        votantes.add(votante);
        JSONElecciones.guardarVotantes(votantes);
    }

    public List<Votante> leerVotantes() {
        return JSONElecciones.leerVotantes();
    }

//    public void removerVotante(Votante votante){
//        try{
//            FileWriter file = new FileWriter("votantes.json");
//            file.write(votante.toString());
//            file.flush();
//            file.close();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }

    public void agregarBoleta(Boleta boleta) {
        try {
            FileWriter file = new FileWriter("boletas.json");
            file.write(boleta.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerBoletas() {
        try {
            FileReader file = new FileReader("boletas.json");
            file.read();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void removerBoleta(Boleta boleta){
//        try{
//            FileWriter file = new FileWriter("boletas.json");
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }

}
