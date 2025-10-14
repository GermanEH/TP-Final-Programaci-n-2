import Clases.Boleta;
import Enums.Boletas;

public class Main {
    public static void main(String[] args) {
        double random = Math.random() *1 % 20;
        System.out.println(random);

        Boleta b1 = new Boleta(Boletas.ALIANZA_LA_LIBERTAD_AVANZA, "ALLA", 503, 0);
        Boleta b2 = new Boleta(Boletas.PARTIDO_NUEVO_BUENOS_AIRES, "PNBA", 221, 0);
        Boleta b3 = new Boleta(Boletas.LIBER_AR, "LA", 318, 0);
        Boleta b4 = new Boleta(Boletas.FRENTE_DE_IZQUIERDA_UNIDAD, "FDIU", 506, 0);
        Boleta b5 = new Boleta(Boletas.FRENTE_PATRIOTA_FEDERAL, "FPF", 95, 0);
        Boleta b6 = new Boleta(Boletas.UNION_LIBERAL, "UL", 153, 0);
        Boleta b7 = new Boleta(Boletas.ALIANZA_FUERZA_PATRIA, "AFP", 507, 0);
        Boleta b8 = new Boleta(Boletas.COALICION_CIVICA, "CC", 47, 0);
        Boleta b9 = new Boleta(Boletas.MOVIMIENTO_POPULAR_SOCIAL_Y_CULTURAL_PROYECTO_SUR, "MPSYCPS", 305, 0);
        Boleta b10 = new Boleta(Boletas.PROPUESTA_FEDERAL_PARA_EL_CAMBIO, "PFPEC", 299, 0);
        Boleta b11 = new Boleta(Boletas.ALIANZA_PROVINCIAS_UNIDAS, "APU", 508, 0);
        Boleta b12 = new Boleta(Boletas.ALIANZA_POTENCIA, "AP", 504, 0);
        Boleta b13 = new Boleta(Boletas.ALIANZA_UNION_FEDERAL, "AUF", 501, 0);
        Boleta b14 = new Boleta(Boletas.ALIANZA_NUEVOS_AIRES, "ANA", 502, 0);
        Boleta b15 = new Boleta(Boletas.MOVIMIENTO_AVANZADA_SOCIALISTA, "MAS", 276, 0);

    }
}