package JSONUtiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONUtiles {

    /// METODO GENERICO PARA GRABAR JSONARRAY
    public static void grabar(String archivo, JSONArray array) {
        try (FileWriter file = new FileWriter(archivo)) {
            file.write(array.toString(4)); // formato mas lindo con 4, agrego catch

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) { // para capturar error del formato
            throw new RuntimeException(e);
        }
    }

    /// METODO GENERICO PARA GRABAR JSONOBJECT
    public static void grabar(String archivo, JSONObject obj) {
        try (FileWriter file = new FileWriter(archivo)) {
            file.write(obj.toString(4));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /// METODO PARA LEER JSON
    public static JSONTokener leer(String archivo) {
        try {
            return new JSONTokener(new FileReader(archivo));

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: ARCHIVO NO ENCONTRADO");
            return null;
        }
    }

}