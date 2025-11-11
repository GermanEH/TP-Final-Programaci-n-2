package Interfaces;

import Excepciones.VotanteException;

public interface Registro<T> {
    public void agregar(T t) throws VotanteException;
    public void eliminar(T t);
    public void mostrar();
    public T buscar(int t);
}
