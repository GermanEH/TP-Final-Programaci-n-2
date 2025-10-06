package Clases;
import java.util.List;
import java.util.ArrayList;
public class Jugador extends Personaje {
   private int vida;
   private int puntaje;
   private List <Item> inventario;

    public Jugador() {
    }

    public Jugador(String nombre, int posX, int posY, int vida, int puntaje, List<Item> inventario) {
        super(nombre, posX, posY);
        this.vida = vida;
        this.puntaje = puntaje;
        this.inventario = ArrayList<Item>();
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public void setInventario(List<Item> inventario) {
        this.inventario = inventario;
    }

    public void mover (int pX, int pY){
        posX += pX;
        posY += pY;
    }
    public void recibirDanio (int danio){
        vida -= danio;
    }

    public void ganarPunto (){
        puntaje++;
    }

    public void agregarItem (Item item){
        inventario.add(item);
    }
     public void verItem (){
        for (Item item : inventario) {
            System.out.println(item.getNombre());
        }
     }

    @Override
    public void interactuar(Jugador jugador) {

    }
}
