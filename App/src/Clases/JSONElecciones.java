package Clases;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

public class JSONElecciones {
    private static final String JVOTANTES = "votantes.json";
    private static final String CSVJSON = "csvjson.json";

    /// METODO PARA DESCERIALIZAR VOTANTES
    public static List<Votante> leerVotantes() {
        List<Votante> votantes = new ArrayList<>();

        try {
            JSONTokener tokener = JSONUtiles.leer(JVOTANTES);
            if (tokener == null) {
                return votantes;
            }

            JSONObject obj = new JSONObject(tokener);
            JSONArray jVotantes = obj.getJSONArray("votantes");

            for (int i = 0; i < jVotantes.length(); i++) {
                JSONObject jV = jVotantes.getJSONObject(i);

                Votante v = new Votante(
                        jV.getString("nombre"),
                        jV.getString("apellido"),
                        jV.getInt("edad"),
                        jV.getString("dni"),
                        jV.getInt("numero"),
                        jV.getBoolean("voto")
                );
                votantes.add(v);
            }

        } catch (JSONException e) {
            System.out.println("ERROR: NO SE PUDO LEER A LOS VOTANTES " + e.getMessage());
        }
        return votantes;
    }



    public static void guardarVotantes(List<Votante> votantes){
        JSONArray jVotantes = new JSONArray();

        for (Votante v : votantes){
            JSONObject jV = new JSONObject();
            try {
                jV.put("nombre", v.getNombre());
                jV.put("apellido", v.getApellido());
                jV.put("edad", v.getEdad());
                jV.put("dni", v.getDni());
                jV.put("numero", v.getNumero());
                jV.put("voto", v.getVoto());
                jVotantes.put(jV);

                JSONObject obj = new JSONObject();
                obj.put("votantes", jVotantes);

                JSONUtiles.grabar(JVOTANTES,jVotantes);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
