package Clases;

import Interfaces.Registro;
import JSONUtiles.JSONBoletas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class BoletaUnica implements Registro<Boleta> {

    public BoletaUnica() {
    }

    @Override
    public void agregar(Boleta boleta) {
        List<Boleta> boletas = JSONBoletas.leerBoletas();
        boletas.add(boleta);
        JSONBoletas.guardarBoletas(boletas);
    }

    @Override
    public void eliminar(Boleta boleta) {
        List<Boleta> boletas = JSONBoletas.leerBoletas();
        boletas.removeIf(b -> b.getLista() == boleta.getLista());
        JSONBoletas.guardarBoletas(boletas);
    }

    @Override
    public void mostrar() {

        List<Boleta> boletas = JSONBoletas.leerBoletas();

        if (boletas.isEmpty()) {
            System.out.println("No hay boletas disponibles");
            return;
        }

        System.out.println("------------------------------BOLETAS DISPONIBLES------------------------------");

        boletas.sort(Comparator.comparingInt(Boleta::getLista));

        for (Boleta b : boletas) {
            System.out.println(b);
            int j = 1;
            for (Candidato c : b.getCandidatos()) {
                System.out.println("   " + j++ + " - " + c);
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    @Override
    public Boleta buscar(Boleta boleta) {
        return null;
    }

    public Boleta buscarPorLista(int lista) {

        List<Boleta> boletas = JSONBoletas.leerBoletas();

        for (Boleta boleta : boletas) {
            if (boleta.getLista() == lista) {
                return boleta;
            }
        }
        return null;
    }
}
