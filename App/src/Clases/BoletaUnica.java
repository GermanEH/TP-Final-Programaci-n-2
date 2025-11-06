package Clases;

import Interfaces.Registro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class BoletaUnica implements Registro<Boleta> {
    Set<Boleta> boletasUnicas;

    public BoletaUnica(Set<Boleta> boletaUnica) {
        this.boletasUnicas = boletaUnica;
    }

    public Set<Boleta> getBoletasUnicas() {
        return boletasUnicas;
    }

    public void setBoletaUnica(Set<Boleta> boletaUnica) {
        this.boletasUnicas = boletaUnica;
    }

    @Override
    public String toString() {
        return "Clases.BoletaUnica{" +
                "boletaUnica=" + boletasUnicas +
                '}';
    }

    @Override
    public void agregar(Boleta boleta) {
        boletasUnicas.add(boleta);
    }

    @Override
    public void eliminar(Boleta boleta) {
        boletasUnicas.remove(boleta);
    }

    @Override
    public void mostrar() {
        if (boletasUnicas.isEmpty()) {
            System.out.println("No hay boletas disponibles");
            return;
        }

        System.out.println("------------------------------BOLETAS DISPONIBLES------------------------------");
        List<Boleta> listaBoletas = new ArrayList<>(boletasUnicas);
        listaBoletas.sort(Comparator.comparingInt(Boleta::getLista));

        for (Boleta b : listaBoletas) {
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
        for (Boleta boleta : boletasUnicas) {
            if (boleta.getLista() == lista) {
                return boleta;
            }
        }
        return null;
    }
}
