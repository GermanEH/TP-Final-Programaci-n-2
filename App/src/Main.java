import Clases.*;
import Excepciones.VotanteException;
import org.json.JSONTokener;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CentroDeVotacion centro = new CentroDeVotacion();
        Padron padron = new Padron();
        GestorDeArchivos gestor = new GestorDeArchivos();

        List<Votante> votantes = gestor.leerVotantes();
        List<Boleta> boletas = gestor.leerBoletas();
        centro.cargarBoletas(boletas);


        BoletaUnica boletaUnica = new BoletaUnica(new HashSet<>(boletas));

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

                        Votante votante = padron.buscarPorDniYNVoto(dni, numVoto);
                        if (votante == null) {
                            throw new VotanteException("ERROR: DNI o número de votación incorrectos.");
                        }

                        System.out.println("=========================================================================================================");
                        System.out.println("                           BIENVENIDO VOTANTE: " + votante.getNombre());
                        pausa(scan);

                        int turno = centro.asignarTurno(votante);
                        System.out.println("SU TURNO ES : " + turno);

                        System.out.println("BOLETAS DISPONIBLES PARA VOTAR:");
                        boletaUnica.mostrar();

                        System.out.print("INGRESE EL NÚMERO DE LISTA PARA VOTAR: ");
                        int nLista = scan.nextInt();
                        scan.nextLine();

                        try {
                            centro.procesarVoto(votante, boletaUnica, nLista);
                            System.out.println("VOTO REGISTRADO PARA LA LISTA N°: " + nLista);
                        } catch (VotanteException e) {
                            System.out.println("ERROR: Boleta inválida, voto no registrado.");
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
                    System.out.print("Ingrese su contraseña: ");
                    String contra = scan.nextLine();
                    Administrador a = new Administrador(nombre, contra);

                    if (admins.containsKey(nombre) && admins.get(nombre).equals(contra)) {
                        int menuAdmin;
                        do {
                            pausa(scan);
                            System.out.println("""
                                    |-----------------------------------------------| 
                                    |1. Ver boletas.                                | 
                                    |2. Agregar boleta.                             | 
                                    |3. Eliminar boleta.                            | 
                                    |4. Agregar candidato.                          |
                                    |5. Eliminar candidato.                         | 
                                    |6. Iniciar votacion.                           |
                                    |7. Cerrar votacion.                            | 
                                    |0. Cerrar sesion.                              | 
                                    |-----------------------------------------------| """);
                            System.out.print("OPCION: ");
                            menuAdmin = scan.nextInt();
                            scan.nextLine();
                            switch (menuAdmin) {
                                case 0 -> System.out.println("CERRANDO SESION DE ADMINISTRADOR...");
                                case 1 -> boletaUnica.mostrar();
                                case 2 -> {
                                    System.out.print("Ingrese el nombre de la boleta : ");
                                    String bNombre = scan.nextLine();
                                    System.out.print("Las siglas de la boleta : ");
                                    String bSiglas = scan.nextLine();
                                    System.out.print("Ingrese el numero de lista : ");
                                    int bLista = scan.nextInt();
                                    scan.nextLine();
                                    Boleta b = new Boleta(bNombre, bSiglas, bLista);
                                    boletaUnica.agregar(b);
                                }
                                case 3 -> {
                                    System.out.print("Ingrese el numero de lista de la boleta para eliminarla : ");
                                    int nLista = scan.nextInt();
                                    scan.nextLine();
                                    Boleta b = boletaUnica.buscarPorLista(nLista);
                                    if (b != null) {
                                        boletaUnica.eliminar(b);
                                        System.out.println("Boleta eliminada correctamente. ");
                                    } else {
                                        System.out.println("No se encontró la boleta. ");
                                    }
                                }
                                case 4 -> {
                                    System.out.print("Ingrese el número de lista de la boleta donde quiere agregar un candidato: ");
                                    int nLista = scan.nextInt();
                                    scan.nextLine();
                                    Boleta b = boletaUnica.buscarPorLista(nLista);
                                    if (b != null) {
                                        System.out.print("Ingrese el nombre del candidato : ");
                                        String cNombre = scan.nextLine();
                                        System.out.print("Ingrese el apellido del candidato : ");
                                        String cApellido = scan.nextLine();
                                        System.out.print("Ingrese la edad del candidato : ");
                                        int cEdad = scan.nextInt();
                                        scan.nextLine();
                                        System.out.print("Ingrese el DNI del candidato : ");
                                        String cDni = scan.nextLine();
                                        System.out.print("Ingrese el puesto del candidato : ");
                                        String cPuesto = scan.nextLine();
                                        System.out.print("Ingrese el trabajo del candidato : ");
                                        String cTrabajo = scan.nextLine();

                                        Candidato c = new Candidato(cNombre, cApellido, cEdad, cDni, b.getNombre(), cPuesto, cTrabajo);
                                        b.agregarCandidato(c);
                                        System.out.println("Candidato agregado a la boleta " + b.getNombre());
                                    } else {
                                        System.out.println("No se encontró la boleta con número de lista " + nLista);
                                    }
                                }
                                case 5 -> {
                                    System.out.print("Ingrese el número de lista de la boleta donde quiere eliminar un candidato: ");
                                    int nLista = scan.nextInt();
                                    scan.nextLine();
                                    Boleta b = boletaUnica.buscarPorLista(nLista);
                                    if (b != null) {
                                        System.out.println("Candidatos disponibles:");
                                        int i = 1;
                                        for (Candidato c : b.getCandidatos()) {
                                            System.out.println(i + ". " + c.getNombre() + " " + c.getApellido() + " - " + c.getPuesto());
                                            i++;
                                        }
                                        System.out.print("Ingrese el número del candidato a eliminar: ");
                                        int numCandidato = scan.nextInt();
                                        scan.nextLine();
                                        if (numCandidato > 0 && numCandidato <= b.getCandidatos().size()) {
                                            Candidato cEliminar = b.getCandidatos().get(numCandidato - 1);
                                            b.eliminarCandidato(cEliminar);
                                            System.out.println("Candidato eliminado de la boleta " + b.getNombre());
                                        } else {
                                            System.out.println("Número de candidato inválido.");
                                        }
                                    } else {
                                        System.out.println("No se encontró la boleta con número de lista " + nLista);
                                    }
                                }
                                case 6 -> {
                                    centro.abrirVotacion();
                                    System.out.println("Votación iniciada.");
                                }
                                case 7 -> {
                                    centro.cerrarVotacion();
                                    System.out.println("Votación cerrada.");
                                }
                                default -> System.out.println("ERROR: OPCION INVALIDA.");
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
                break;
            }
        } while (menu != 0);
    }

    public static void pausa(Scanner scan) {
        System.out.println("PRESIONE ENTER PARA CONTINUAR.");
        scan.nextLine();
    }
}