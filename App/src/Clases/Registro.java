package Clases;

import java.util.*;

public class Registro<T> {
    private List<T> registro;

    public Registro() {

        this.registro = new ArrayList<>();
    }

    public void agregar(T t) {

        registro.add(t);
    }
    public void eliminarRegistro(T t) {
        Iterator<T> it = registro.iterator();
        while (it.hasNext()) {
            if (it.next().equals(t)) {
                it.remove();
            }
        }

    }

    public T buscarRegistro(T t){
        for (T a : registro){
            if (a.equals(t)){
                return a;
            }
        }
        System.out.println("La busqueda no fue exitosa.");
        return null;
    }

    public void mostrarRegistro(T t){
        for (T a : registro){
            System.out.println(a);
        }
    }

    public void desordenarRandom() {

        Collections.shuffle(registro);
    }





}
