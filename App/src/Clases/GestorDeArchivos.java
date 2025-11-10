package Clases;

import java.util.List;

public class GestorDeArchivos {

    public void agregarVotante(Votante votante) {
        List<Votante> votantes = JSONElecciones.leerVotantes();
        votantes.add(votante);
        JSONElecciones.guardarVotantes(votantes);
    }

    public List<Votante> leerVotantes() {
        return JSONElecciones.leerVotantes();
    }

    public void eliminarVotante(Votante votante) {
        List<Votante> votantes = JSONElecciones.leerVotantes();
        votantes.removeIf(v -> v.getDni().equals(votante.getDni()));
        JSONElecciones.guardarVotantes(votantes);
    }

    public void agregarBoleta(Boleta boleta) {
        List<Boleta> boletas = JSONBoletas.leerBoletas();
        boletas.add(boleta);
        JSONBoletas.guardarBoletas(boletas);
    }

    public List<Boleta> leerBoletas() {
        return JSONBoletas.leerBoletas();
    }

    public void eliminarBoleta(Boleta boleta) {
        List<Boleta> boletas = JSONBoletas.leerBoletas();
        boletas.removeIf(b -> b.getLista() == boleta.getLista());
        JSONBoletas.guardarBoletas(boletas);
    }

}
