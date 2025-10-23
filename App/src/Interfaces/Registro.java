package Interfaces;
public interface Registro<T> {
    public void agregar(T t);
    public void eliminar(T t);
    public void mostrar();
    public T buscar(T t);
}
