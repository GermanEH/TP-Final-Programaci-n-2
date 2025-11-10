package JSONUtiles;

import Clases.Boleta;
import Clases.Voto;
import org.json.*;

import java.util.ArrayList;
import java.util.List;

public class JSONUrna {

    private static final String JVOTOS = "App/archivos/urna.json";

    public static void guardarVotos(List<Voto> votos) {
        JSONArray jVotos = new JSONArray();

        for (Voto voto : votos) {
            JSONObject jVoto = new JSONObject();
            try {
                jVoto.put("numeroLista", voto.getNumeroLista());
                jVoto.put("validez", voto.isValidez());
                jVotos.put(jVoto);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        JSONObject obj = new JSONObject();
        try {
            obj.put("votos", jVotos);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONUtiles.grabar(JVOTOS, obj);

    }

    public static List<Voto> leerVotos() throws JSONException {
        List votos = new ArrayList();

        JSONTokener tokener = JSONUtiles.leer(JVOTOS);
        if (tokener == null) {
            System.out.println("ERROR: NO SE PUDO LEER LAS BOLETAS.");
            return votos;
        }
        JSONObject json = new JSONObject(tokener);
        JSONArray jvotos = json.getJSONArray("votos");

        for (int i = 0; i < jvotos.length(); i++) {
            JSONObject jvoto = jvotos.getJSONObject(i);

            int numeroLista = jvoto.getInt("numeroLista");
            boolean validez = jvoto.getBoolean("validez");

            Voto voto = new Voto(numeroLista, validez);

            votos.add(voto);
        }
        return votos;
    }

}
