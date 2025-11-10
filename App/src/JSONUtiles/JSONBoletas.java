package JSONUtiles;

import Clases.Boleta;
import Clases.Candidato;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

public class JSONBoletas {
    private static final String JBOLETAS = "App/archivos/boletas.json";

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
                    List<Candidato> candidatos = deserializarCandidatos(jB.getJSONArray("candidatos"));
                    for (Candidato c : candidatos) {
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

    /// MÉTODO PARA SERIALIZAR BOLETAS
    public static void guardarBoletas(List<Boleta> boletas) {
        JSONArray jBoletas = new JSONArray();

        for (Boleta b : boletas) {
            JSONObject jB = new JSONObject();
            try {
                jB.put("nombre", b.getNombre());
                jB.put("sigla", b.getSigla());
                jB.put("lista", b.getLista());
                jB.put("votos", b.getVotos());

                jB.put("candidatos", serializarCandidatos(b.getCandidatos()));
                jBoletas.put(jB);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        JSONObject obj = new JSONObject();
        try {
            obj.put("boletas", jBoletas);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONUtiles.grabar(JBOLETAS, obj);
    }

    private static List<Candidato> deserializarCandidatos(JSONArray jCandidatos) throws JSONException {
        List<Candidato> candidatos = new ArrayList<>();

        for (int j = 0; j < jCandidatos.length(); j++) {
            JSONObject jC = jCandidatos.getJSONObject(j);

            Candidato c = new Candidato(
                    jC.getString("nombre"),
                    jC.getString("apellido"),
                    jC.getInt("edad"),
                    jC.getString("dni"),
                    jC.getString("boleta"),
                    jC.getString("puesto"),
                    jC.getString("trabajo")
            );

            candidatos.add(c);
        }

        return candidatos;
    }

    private static JSONArray serializarCandidatos(List<Candidato> candidatos) {
        JSONArray jCandidatos = new JSONArray();

        for (Candidato c : candidatos) {
            JSONObject jC = new JSONObject();
            try {
                jC.put("nombre", c.getNombre());
                jC.put("apellido", c.getApellido());
                jC.put("edad", c.getEdad());
                jC.put("dni", c.getDni());
                jC.put("boleta", c.getBoleta());
                jC.put("puesto", c.getPuesto());
                jC.put("trabajo", c.getTrabajo());
                jCandidatos.put(jC);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return jCandidatos;
    }
}
