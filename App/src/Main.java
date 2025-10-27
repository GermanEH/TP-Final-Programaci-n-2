import Clases.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CentroDeVotacion centro = new CentroDeVotacion();
        Padron padron = new Padron();

        Votante v1 = new Votante("Mauricio","Tognocchi",21,"45923395",13);
        padron.agregar(v1);

        Boleta b1 = new Boleta("ALIANZA_LA_LIBERTAD_AVANZA", "ALLA", 503);
        Boleta b2 = new Boleta("PARTIDO_NUEVO_BUENOS_AIRES", "PNBA", 221);
        Boleta b3 = new Boleta("LIBER_AR", "LA", 318);
        Boleta b4 = new Boleta("FRENTE_DE_IZQUIERDA_UNIDAD", "FDIU", 506);
        Boleta b5 = new Boleta("FRENTE_PATRIOTA_FEDERAL", "FPF", 95);
        Boleta b6 = new Boleta("UNION_LIBERAL", "UL", 153);
        Boleta b7 = new Boleta("ALIANZA_FUERZA_PATRIA", "AFP", 507);
        Boleta b8 = new Boleta("COALICION_CIVICA", "CC", 47);
        Boleta b9 = new Boleta("MOVIMIENTO_POPULAR_SOCIAL_Y_CULTURAL_PROYECTO_SUR", "MPSYCPS", 305);
        Boleta b10 = new Boleta("PROPUESTA_FEDERAL_PARA_EL_CAMBIO", "PFPEC", 299);
        Boleta b11 = new Boleta("ALIANZA_PROVINCIAS_UNIDAS", "APU", 508);
        Boleta b12 = new Boleta("ALIANZA_POTENCIA", "AP", 504);
        Boleta b13 = new Boleta("ALIANZA_UNION_FEDERAL", "AUF", 501);
        Boleta b14 = new Boleta("ALIANZA_NUEVOS_AIRES", "ANA", 502);
        Boleta b15 = new Boleta("MOVIMIENTO_AVANZADA_SOCIALISTA", "MAS", 276);

        List<Boleta> boletas = new ArrayList<>();
        boletas.add(b1);
        boletas.add(b2);
        boletas.add(b3);
        boletas.add(b4);
        boletas.add(b5);
        boletas.add(b6);
        boletas.add(b7);
        boletas.add(b8);
        boletas.add(b9);
        boletas.add(b10);
        boletas.add(b11);
        boletas.add(b12);
        boletas.add(b13);
        boletas.add(b14);
        boletas.add(b15);


        Map<Long, Integer> votantes = new HashMap<>();
        votantes.put(12345678L, 1);
        votantes.put(23456789L, 2);
        votantes.put(34567890L, 3);
        votantes.put(34564340L, 4);
        votantes.put(35243890L, 5);
        votantes.put(34425890L, 6);
        votantes.put(34131890L, 7);

        Map<String, String> admins = new HashMap<>();
        admins.put("Mauri", "1234");
        admins.put("German", "4321");
        admins.put("Juan", "1212");

        int menu;
        do {
            pausa(scan);
            System.out.println("""
                    |-----------------------------------------------|
                    |1. Soy votante.                                |
                    |2. Soy Administrador.                          |
                    |0. Cerrar programa.                            |
                    |-----------------------------------------------|
                    """);
            System.out.print("OPCION: ");
            menu = scan.nextInt();
            scan.nextLine();
            switch (menu) {
                case 0: {
                    System.out.println("CERRANDO PROGRAMA...");
                    break;
                }
                case 1: {
                    System.out.print("Ingrese su dni: ");
                    String dni = scan.nextLine();

                    System.out.print("Ingrese su N de votacion: ");
                    int numVoto = scan.nextInt();
                    scan.nextLine();

                    if (Padron.buscarPersona(dni) && Padron.buscarPersona(numVoto)) {
                        System.out.println("Bienvenido votante.");
                        mostrarBoletas(boletas);
                    } else {
                        System.out.println("ERROR: Dni o N de votacion incorrecto");
                    }

                    break;
                }
                case 2: {
                    System.out.print("Ingrese su nombre: ");
                    String nombre = scan.nextLine();

                    System.out.print("Ingrese su constraseña: ");
                    String contra = scan.nextLine();

                    Administrador a = new Administrador(nombre, contra);

                    if (admins.containsKey(nombre) && admins.get(nombre).equals(contra)) {
                        int menuAdmin;

                        do {
                            pausa(scan);
                            System.out.println("""
                                    |-----------------------------------------------|
                                    |1. Agregar boleta.                             |
                                    |2. Eliminar boleta.                            |
                                    |3. Agregar candidato.                          |
                                    |4. Eliminar candidato.                         |
                                    |5. Iniciar votacion.                           |
                                    |6. Cerrar votacion.                            |
                                    |                                               |
                                    |0. Cerrar sesion.                              |
                                    |-----------------------------------------------|
                                    """);
                            System.out.print("OPCION: ");
                            menuAdmin = scan.nextInt();
                            scan.nextLine();
                            switch (menuAdmin) {
                                case 1: {
                                    System.out.println("Ingrese el nombre de la boleta : ");
                                    String bNombre = scan.nextLine();

                                    System.out.println("Las siglas de la boleta");
                                    String bSiglas = scan.nextLine();

                                    System.out.println("Ingrese el numero de lista.");
                                    int bLista = scan.nextInt();
                                    scan.nextLine();

                                    Boleta b = new Boleta(bNombre, bSiglas, bLista);

                                    for (int i = 0; i < 5; i++) {
                                        System.out.println("Ingrese el nombre del candidato: ");
                                        String cNombre = scan.nextLine();

                                        System.out.println("Ingrese el apellido del candidato: ");
                                        String cApellido = scan.nextLine();

                                        System.out.println("Ingrese la edad del candidato :");
                                        int cEdad = scan.nextInt();
                                        scan.nextLine();

                                        System.out.println("Ingrese el dni del candidato");
                                        String cDni = scan.nextLine();

                                        System.out.println("Ingrese el puesto del candidato: ");
                                        String cPuesto = scan.nextLine();

                                        System.out.println("Ingrese el trabajo del candidato: ");
                                        String cTrabajo = scan.nextLine();

                                        Candidato c = new Candidato(cNombre, cApellido, cEdad, cDni, bNombre, cPuesto, cTrabajo);
                                    }
                                    break;
                                }
                                case 2: {

                                    break;
                                }
                                case 3: {

                                    break;
                                }
                                case 4: {

                                    break;
                                }
                                case 5: {

                                    break;
                                }
                                case 6: {

                                    break;
                                }
                                case 7: {

                                    break;
                                }
                                default: {
                                    System.out.println("ERROR: OPCION INVALIDA");
                                }
                            }
                        } while (menuAdmin != 0);
                    } else {
                        System.out.println("ERROR: Nombre o contraseña incorrectas.");
                    }
                }
                default: {
                    System.out.println("ERROR: OPCION INVALIDA.");
                }
            }
        } while (menu != 0);

    }

    public static void pausa(Scanner scan) {
        System.out.println("PRESIONE ENTER PARA CONTINUAR.");
        scan.nextLine();
    }

    public static void mostrarBoletas(List<Boleta> boletas) {
        int i = 1;
        for (Boleta b : boletas) {
            System.out.println(b);
            for (Candidato c : b.getCandidatos()) {
                System.out.println(c);
            }
        }
    }
}
