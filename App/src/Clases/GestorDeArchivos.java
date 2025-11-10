package Clases;

import JSONUtiles.JSONBoletas;
import JSONUtiles.JSONVotantes;

import java.util.List;

public class GestorDeArchivos {

    public void agregarVotante(Votante votante) {
        List<Votante> votantes = JSONVotantes.leerVotantes();
        votantes.add(votante);
        JSONVotantes.guardarVotantes(votantes);
    }

    public List<Votante> leerVotantes() {
        return JSONVotantes.leerVotantes();
    }

    public void eliminarVotante(Votante votante) {
        List<Votante> votantes = JSONVotantes.leerVotantes();
        votantes.removeIf(v -> v.getDni().equals(votante.getDni()));
        JSONVotantes.guardarVotantes(votantes);
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
