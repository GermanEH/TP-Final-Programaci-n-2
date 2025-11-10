package JSONUtiles;

import Clases.Voto;
import org.json.*;

import java.util.ArrayList;
import java.util.List;

public class JSONUrna {

    private static final String JVOTOS = "App/archivos/urna.json";

    public static void guardarVoto(Voto voto) throws JSONException{
        JSONObject jvoto = new JSONObject();
        jvoto.put("numeroLista", voto.getNumeroLista());
        jvoto.put("validez", voto.isValidez());
        JSONUtiles.grabar(JVOTOS, jvoto);
    }

    public static List<Voto> leerVotos() throws JSONException {
        JSONArray jvotos;
        List votos = new ArrayList();

        JSONTokener tokener = JSONUtiles.leer(JVOTOS);
        JSONObject json = new JSONObject(tokener);
        jvotos = new JSONArray(json.getJSONArray("votos"));

        for (int i = 0; i < jvotos.length(); i++) {
            JSONObject jvoto = new JSONObject(jvotos.getJSONObject(i));

            int numeroLista = jvoto.getInt("numeroLista");
            boolean validez = jvoto.getBoolean("validez");

            Voto voto = new Voto(numeroLista, validez);

            votos.add(voto);
        }
        return votos;
    }

}
