package Clases;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

public class JSONBoletas {
    private static final String JBOLETAS = "boletas.json";

    /// MÉTODO PARA DESERIALIZAR BOLETAS
    public static List<Boleta> leerBoletas() {
        List<Boleta> boletas = new ArrayList<>();

        try {
            JSONTokener tokener = JSONUtiles.leer(JBOLETAS);
            if (tokener == null) {
                System.out.println("ERROR: NO SE PUDO LEER LAS BOLETAS.");
                return boletas;
            }

            JSONObject obj = new JSONObject(tokener);
            if (!obj.has("boletas")) {
                return boletas;
            }

            JSONArray jBoletas = obj.getJSONArray("boletas");
            for (int i = 0; i < jBoletas.length(); i++) {
                JSONObject jB = jBoletas.getJSONObject(i);

                String nombre = jB.getString("nombre");
                String sigla = jB.getString("sigla");
                int lista = jB.getInt("lista");
                int votos = jB.getInt("votos");

                Boleta b = new Boleta(nombre, sigla, lista);
                b.setVotos(votos);

                if (jB.has("candidatos")) {
                    JSONArray jCandidatos = jB.getJSONArray("candidatos");
                    for (int j = 0; j < jCandidatos.length(); j++) {
                        JSONObject jC = jCandidatos.getJSONObject(j);

                        Candidato c = new Candidato(
                                jC.getString("nombre"),
                                jC.getString("apellido"),
                                jC.getInt("edad"),
                                jC.getString("dni"),
                                jC.getString("partido"),
                                jC.getString("cargo"),
                                jC.getString("profesion")
                        );
                        b.agregarCandidato(c);
                    }
                }
                boletas.add(b);
            }
        } catch (JSONException e) {
            System.out.println("ERROR al leer boletas: " + e.getMessage());
        }
        return boletas;
    }


}
