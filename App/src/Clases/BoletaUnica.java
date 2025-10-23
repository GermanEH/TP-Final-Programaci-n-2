package Clases;

import Interfaces.Registro;

import java.util.Set;
public class BoletaUnica implements Registro<Boleta> {
    Set<Boleta> boletaUnica;

    public BoletaUnica(Set<Boleta> boletaUnica) {
        this.boletaUnica = boletaUnica;
    }

    public Set<Boleta> getBoletaUnica() {
        return boletaUnica;
    }

    public void setBoletaUnica(Set<Boleta> boletaUnica) {
        this.boletaUnica = boletaUnica;
    }

    @Override
    public String toString() {
        return "Clases.BoletaUnica{" +
                "boletaUnica=" + boletaUnica +
                '}';
    }

    @Override
    public void agregar(Boleta boleta) {
        boletaUnica.add(boleta);
    }

    @Override
    public void eliminar(Boleta boleta) {
        boletaUnica.remove(boleta);
    }

    @Override
    public void mostrar() {
        if (boletaUnica.isEmpty()) {
            System.out.println("No hay boletas disponibles");
            return;
        } else {
            System.out.println("----------BOLETAS DISPONIBLES----------");

            int i = 1;

            for (Boleta boleta : boletaUnica) {
                System.out.println(i + ". " + boleta.toString());
                i++;
            }
            System.out.println("-----------------------------------");
        }

    }

    @Override
    public Boleta buscar(Boleta boleta) {
        return null;
    }

    public Boleta buscarPorLista(int lista) {
        for (Boleta boleta : boletaUnica) {
            if (boleta.getNumeroLista() == lista) {
                return boleta;
            }
        }
        return null;
    }
}
