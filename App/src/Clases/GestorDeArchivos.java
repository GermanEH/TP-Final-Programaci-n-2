package Clases;
import JSONUtiles.JSONUtiles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static JSONUtiles.JSONUtiles.grabar;

public class GestorDeArchivos {

    public void agregarVotante(Votante votante){
        try {
            JSONObject JSONObjectvotantes = new JSONObject(JSONUtiles.leer("votantes.json"));
            JSONArray JSONArrayvotantes = JSONObjectvotantes.getJSONArray("votantes");
            ArrayList votantes = new ArrayList();
            votantes.add(JSONArrayvotantes.getString(1));
            JSONUtiles.grabar(JSONArrayvotantes);
        }catch(JSONException e) {
            e.printStackTrace();
        }
    }

    public void leerVotantes(){
        try {
            JSONArray votantes = new JSONArray(JSONUtiles.leer("votantes.json"));
        } catch(JSONException e){
            e.printStackTrace();
        }
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

    public void agregarBoleta(Boleta boleta){
        try{
            FileWriter file = new FileWriter("boletas.json");
            file.write(boleta.toString());
            file.flush();
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void leerBoletas(){
        try{
            FileReader file = new FileReader("boletas.json");
            file.read();
            file.close();
        }catch(IOException e){
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
