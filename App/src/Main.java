import Clases.*;
import Excepciones.VotanteException;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CentroDeVotacion centro = new CentroDeVotacion();
        Padron padron = new Padron();

        Votante v1 = new Votante("Mauricio", "Tognocchi", 21, "45923395", 13);

        try {
            padron.agregar(v1);
        } catch (VotanteException e) {
            throw new RuntimeException(e);
        }

        Boleta b1 = new Boleta("ALIANZA LA LIBERTAD AVANZA", "ALLA", 503);
        Boleta b2 = new Boleta("PARTIDO NUEVO BUENOS AIRES", "PNBA", 221);
        Boleta b3 = new Boleta("LIBER AR", "LA", 318);
        Boleta b4 = new Boleta("FRENTE DE IZQUIERDA UNIDAD", "FDIU", 506);
        Boleta b5 = new Boleta("FRENTE PATRIOTA FEDERAL", "FPF", 95);
        Boleta b6 = new Boleta("UNION LIBERAL", "UL", 153);
        Boleta b7 = new Boleta("ALIANZA FUERZA PATRIA", "AFP", 507);
        Boleta b8 = new Boleta("COALICION CIVICA", "CC", 47);
        Boleta b9 = new Boleta("MOVIMIENTO POPULAR SOCIAL Y CULTURAL PROYECTO SUR", "MPSYCPS", 305);
        Boleta b10 = new Boleta("PROPUESTA FEDERAL PARA EL CAMBIO", "PFPEC", 299);
        Boleta b11 = new Boleta("ALIANZA PROVINCIAS UNIDAS", "APU", 508);
        Boleta b12 = new Boleta("ALIANZA POTENCIA", "AP", 504);
        Boleta b13 = new Boleta("ALIANZA UNION FEDERAL", "AUF", 501);
        Boleta b14 = new Boleta("ALIANZA NUEVOS AIRES", "ANA", 502);
        Boleta b15 = new Boleta("MOVIMIENTO AVANZADA SOCIALISTA", "MAS", 276);

        b1.agregarCandidato(new Candidato("Javier", "Milei", 53, "20234567", "ALLA", "Presidente", "Economista"));
        b1.agregarCandidato(new Candidato("Victoria", "Villarruel", 48, "21234567", "ALLA", "Vicepresidente", "Abogada"));
        b1.agregarCandidato(new Candidato("Ramiro", "Marra", 41, "22234567", "ALLA", "Senador", "Financista"));
        b1.agregarCandidato(new Candidato("Carlos", "Kikuchi", 58, "23234567", "ALLA", "Diputado", "Periodista"));
        b1.agregarCandidato(new Candidato("Lilia", "Lemoine", 43, "24234567", "ALLA", "Concejal", "Actriz"));
        b2.agregarCandidato(new Candidato("Esteban", "Gómez", 50, "25234567", "PNBA", "Presidente", "Abogado"));
        b2.agregarCandidato(new Candidato("Juliana", "Morales", 42, "26234567", "PNBA", "Vicepresidente", "Economista"));
        b2.agregarCandidato(new Candidato("Rodrigo", "Pérez", 47, "27234567", "PNBA", "Senador", "Ingeniero"));
        b2.agregarCandidato(new Candidato("Martina", "López", 37, "28234567", "PNBA", "Diputada", "Docente"));
        b2.agregarCandidato(new Candidato("Lucas", "Fernández", 39, "29234567", "PNBA", "Concejal", "Arquitecto"));
        b3.agregarCandidato(new Candidato("Luciano", "Martínez", 45, "30234567", "LA", "Presidente", "Contador"));
        b3.agregarCandidato(new Candidato("Romina", "Suárez", 38, "31234567", "LA", "Vicepresidente", "Economista"));
        b3.agregarCandidato(new Candidato("Marcos", "Díaz", 52, "32234567", "LA", "Senador", "Abogado"));
        b3.agregarCandidato(new Candidato("Carla", "Mendoza", 40, "33234567", "LA", "Diputada", "Administradora"));
        b3.agregarCandidato(new Candidato("Gustavo", "Benítez", 48, "34234567", "LA", "Concejal", "Empresario"));
        b4.agregarCandidato(new Candidato("Myriam", "Bregman", 51, "35234567", "FDIU", "Presidente", "Abogada"));
        b4.agregarCandidato(new Candidato("Nicolás", "Del Caño", 44, "36234567", "FDIU", "Vicepresidente", "Sociólogo"));
        b4.agregarCandidato(new Candidato("Romina", "Del Plá", 50, "37234567", "FDIU", "Senadora", "Docente"));
        b4.agregarCandidato(new Candidato("Christian", "Castillo", 49, "38234567", "FDIU", "Diputado", "Profesor"));
        b4.agregarCandidato(new Candidato("Alejandro", "Bodart", 59, "39234567", "FDIU", "Concejal", "Politólogo"));
        b5.agregarCandidato(new Candidato("César", "Baeza", 62, "40234567", "FPF", "Presidente", "Abogado"));
        b5.agregarCandidato(new Candidato("Graciela", "Romero", 55, "41234567", "FPF", "Vicepresidente", "Contadora"));
        b5.agregarCandidato(new Candidato("Daniel", "Quiroga", 49, "42234567", "FPF", "Senador", "Comerciante"));
        b5.agregarCandidato(new Candidato("Silvia", "González", 46, "43234567", "FPF", "Diputada", "Docente"));
        b5.agregarCandidato(new Candidato("Oscar", "Luna", 58, "44234567", "FPF", "Concejal", "Abogado"));
        b6.agregarCandidato(new Candidato("Federico", "Romero", 45, "25234567", "UL", "Presidente", "Abogado"));
        b6.agregarCandidato(new Candidato("Claudia", "Santos", 39, "26234567", "UL", "Vicepresidente", "Economista"));
        b6.agregarCandidato(new Candidato("Ignacio", "Campos", 51, "27234567", "UL", "Senador", "Ingeniero"));
        b6.agregarCandidato(new Candidato("Verónica", "Paz", 36, "28234567", "UL", "Diputada", "Contadora"));
        b6.agregarCandidato(new Candidato("Ricardo", "Molina", 42, "29234567", "UL", "Concejal", "Docente"));
        b7.agregarCandidato(new Candidato("Eduardo", "Ramírez", 56, "30234567", "AFP", "Presidente", "Militar Retirado"));
        b7.agregarCandidato(new Candidato("Natalia", "Ibarra", 40, "31234567", "AFP", "Vicepresidente", "Abogada"));
        b7.agregarCandidato(new Candidato("Fernando", "Correa", 48, "32234567", "AFP", "Senador", "Administrador"));
        b7.agregarCandidato(new Candidato("Julieta", "Vega", 33, "33234567", "AFP", "Diputada", "Comunicadora"));
        b7.agregarCandidato(new Candidato("Marcelo", "Suárez", 46, "34234567", "AFP", "Concejal", "Empresario"));
        b8.agregarCandidato(new Candidato("Elisa", "Carrió", 67, "35234567", "CC", "Presidente", "Abogada"));
        b8.agregarCandidato(new Candidato("Maximiliano", "Ferraro", 43, "36234567", "CC", "Vicepresidente", "Politólogo"));
        b8.agregarCandidato(new Candidato("Mariana", "Zuvic", 47, "37234567", "CC", "Senadora", "Comunicadora"));
        b8.agregarCandidato(new Candidato("Juan", "López", 50, "38234567", "CC", "Diputado", "Abogado"));
        b8.agregarCandidato(new Candidato("Mónica", "Frade", 55, "39234567", "CC", "Diputada", "Contadora"));
        b9.agregarCandidato(new Candidato("Fernando", "Solanas", 84, "40234567", "MPSYCPS", "Presidente", "Cineasta"));
        b9.agregarCandidato(new Candidato("Gabriela", "Massuh", 60, "41234567", "MPSYCPS", "Vicepresidente", "Escritora"));
        b9.agregarCandidato(new Candidato("Eduardo", "Macaluse", 62, "42234567", "MPSYCPS", "Senador", "Profesor"));
        b9.agregarCandidato(new Candidato("Ana", "Zabaloy", 49, "43234567", "MPSYCPS", "Diputada", "Docente"));
        b9.agregarCandidato(new Candidato("Carlos", "Raimundi", 65, "44234567", "MPSYCPS", "Concejal", "Abogado"));
        b10.agregarCandidato(new Candidato("Mauricio", "Macri", 66, "45234567", "PFPEC", "Presidente", "Ingeniero"));
        b10.agregarCandidato(new Candidato("Patricia", "Bullrich", 68, "46234567", "PFPEC", "Vicepresidente", "Politóloga"));
        b10.agregarCandidato(new Candidato("Horacio", "Larreta", 59, "47234567", "PFPEC", "Senador", "Economista"));
        b10.agregarCandidato(new Candidato("María", "Vidal", 50, "48234567", "PFPEC", "Diputada", "Socióloga"));
        b10.agregarCandidato(new Candidato("Diego", "Santilli", 54, "49234567", "PFPEC", "Concejal", "Administrador"));
        b11.agregarCandidato(new Candidato("Gustavo", "Valdés", 55, "50234567", "APU", "Presidente", "Abogado"));
        b11.agregarCandidato(new Candidato("Rodolfo", "Suárez", 60, "51234567", "APU", "Vicepresidente", "Contador"));
        b11.agregarCandidato(new Candidato("Gerardo", "Morales", 64, "52234567", "APU", "Senador", "Abogado"));
        b11.agregarCandidato(new Candidato("Omar", "Perotti", 63, "53234567", "APU", "Diputado", "Administrador"));
        b11.agregarCandidato(new Candidato("Raúl", "Jalil", 58, "54234567", "APU", "Concejal", "Economista"));
        b12.agregarCandidato(new Candidato("Sergio", "Massa", 53, "55234567", "AP", "Presidente", "Abogado"));
        b12.agregarCandidato(new Candidato("Agustín", "Rossi", 64, "56234567", "AP", "Vicepresidente", "Ingeniero"));
        b12.agregarCandidato(new Candidato("Wado", "De Pedro", 51, "57234567", "AP", "Senador", "Abogado"));
        b12.agregarCandidato(new Candidato("Victoria", "Tolosa Paz", 46, "58234567", "AP", "Diputada", "Contadora"));
        b12.agregarCandidato(new Candidato("Daniel", "Scioli", 67, "59234567", "AP", "Concejal", "Empresario"));
        b13.agregarCandidato(new Candidato("Miguel", "Pichetto", 74, "60234567", "AUF", "Presidente", "Abogado"));
        b13.agregarCandidato(new Candidato("Florencia", "Arias", 45, "61234567", "AUF", "Vicepresidente", "Docente"));
        b13.agregarCandidato(new Candidato("Raúl", "Pérez", 58, "62234567", "AUF", "Senador", "Economista"));
        b13.agregarCandidato(new Candidato("Paula", "Giménez", 37, "63234567", "AUF", "Diputada", "Contadora"));
        b13.agregarCandidato(new Candidato("Jorge", "Cáceres", 41, "64234567", "AUF", "Concejal", "Ingeniero"));
        b14.agregarCandidato(new Candidato("Luis", "Caputo", 58, "65234567", "ANA", "Presidente", "Economista"));
        b14.agregarCandidato(new Candidato("Marta", "Ocampo", 49, "66234567", "ANA", "Vicepresidente", "Abogada"));
        b14.agregarCandidato(new Candidato("Sebastián", "Díaz", 38, "67234567", "ANA", "Senador", "Administrador"));
        b14.agregarCandidato(new Candidato("Laura", "Benítez", 44, "68234567", "ANA", "Diputada", "Docente"));
        b14.agregarCandidato(new Candidato("Tomás", "Aguilar", 35, "69234567", "ANA", "Concejal", "Arquitecto"));
        b15.agregarCandidato(new Candidato("Manuela", "Castañeira", 39, "70234567", "MAS", "Presidente", "Socióloga"));
        b15.agregarCandidato(new Candidato("Eduardo", "Mulhall", 55, "71234567", "MAS", "Vicepresidente", "Ingeniero"));
        b15.agregarCandidato(new Candidato("Mariana", "Martínez", 43, "72234567", "MAS", "Senadora", "Docente"));
        b15.agregarCandidato(new Candidato("Julián", "Gómez", 41, "73234567", "MAS", "Diputado", "Sindicalista"));
        b15.agregarCandidato(new Candidato("Camila", "Rojas", 34, "74234567", "MAS", "Concejal", "Periodista"));

        BoletaUnica boletaUnica = new BoletaUnica(new HashSet<>());
        boletaUnica.agregar(b1);
        boletaUnica.agregar(b2);
        boletaUnica.agregar(b3);
        boletaUnica.agregar(b4);
        boletaUnica.agregar(b5);
        boletaUnica.agregar(b6);
        boletaUnica.agregar(b7);
        boletaUnica.agregar(b8);
        boletaUnica.agregar(b9);
        boletaUnica.agregar(b10);
        boletaUnica.agregar(b11);
        boletaUnica.agregar(b12);
        boletaUnica.agregar(b13);
        boletaUnica.agregar(b14);
        boletaUnica.agregar(b15);

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
                    try {
                        System.out.print("Ingrese su DNI: ");
                        String dni = scan.nextLine();
                        System.out.print("Ingrese su número de votación: ");
                        int numVoto = scan.nextInt();
                        scan.nextLine();

                        Votante votante = padron.buscarPorDniYDniVoto(dni, numVoto);
                        if (votante == null) {
                            throw new VotanteException("ERROR: DNI o número de votación incorrectos.");
                        }

                        System.out.println("=========================================================================================================");
                        System.out.println("                           BIENVENIDO VOTANTE: " + votante.getNombre()) ;
                        pausa(scan);
                        System.out.println("BOLETAS DISPONIBLES PARA VOTAR:");
                        boletaUnica.mostrar();

                        System.out.print("INGRESE EL NÚMERO DE LISTA PARA VOTAR: ");
                        int nLista = scan.nextInt();
                        scan.nextLine();

                        Voto voto = votante.votar(boletaUnica, nLista);

                        if(voto.getValidez()){
                            centro.procesarVoto(votante, voto);
                            System.out.println("VOTO REGISTRADO PARA: " + voto.getBoleta().getNombre());

                        }else {
                         throw new VotanteException("ERROR: Boleta invalida, voto no registrado.");
                        }

                    } catch (VotanteException e) {
                        System.out.println("ERROR:" + e.getMessage());

                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Ingrese un número válido.");
                        scan.nextLine();

                    } catch (Exception e) {
                        System.out.println("ERROR DESCONOCIDO: " + e.getMessage());
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
                                    |0. Cerrar sesion.                              | 
                                    |-----------------------------------------------| """);
                            System.out.print("OPCION: ");
                            menuAdmin = scan.nextInt();
                            scan.nextLine();
                            switch (menuAdmin) {
                                case 0: {
                                    System.out.println("CERRANDO SESION DE ADMINISTRADOR...");
                                    break;
                                }
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
                                    System.out.println("Funcionalidad de eliminar boleta pendiente...");
                                    break;
                                }
                                case 3: {
                                    System.out.println("Funcionalidad de agregar candidato pendiente...");
                                    break;
                                }
                                case 4: {
                                    System.out.println("Funcionalidad de eliminar candidato pendiente...");
                                    break;
                                }
                                case 5: {
                                    centro.abrirVotacion();
                                    System.out.println("Votación iniciada.");
                                    break;
                                }
                                case 6: {
                                    centro.cerrarVotacion();
                                    System.out.println("Votación cerrada.");
                                    break;
                                }
                                default: {
                                    System.out.println("ERROR: OPCION INVALIDA.");
                                }
                            }
                        } while (menuAdmin != 0);
                    } else {
                        System.out.println("ERROR: Nombre o contraseña incorrectas.");
                    }
                    break;
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
}