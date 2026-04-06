import java.util.Scanner;

public class RPGMenuSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;

        String nombre = "";
        String tipo = "";
        int vida = 0;
        int fuerza = 0;
        boolean personajeCreado = false;

        String[] inventario = {  // PARTE DEL INVENTARIO
            "❤️ Poción Curativa",
            "💧 Poción de Maná",
            "⛏️ Hierro",
            "📜 Pergamino",
            "🗝️ Llave Antigua"
        };

        do {
            System.out.println("\n=== RPG SIMULATOR ===");
            System.out.println("1. Crear personaje");
            System.out.println("2. Entrenar");
            System.out.println("3. Batalla");
            System.out.println("4. Inventario");
            System.out.println("5. Estado del personaje");
            System.out.println("6. Créditos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n=== CREAR PERSONAJE ===");

                    scanner.nextLine(); // limpiar buffer

                    System.out.print("Ingrese nombre del personaje: ");
                    nombre = scanner.nextLine();

                    System.out.println("Seleccione tipo de personaje:");
                    System.out.println("1. Mago");
                    System.out.println("2. Guerrero");
                    System.out.println("3. Arquero");
                    System.out.print("Opción: ");
                    int tipoOpcion = scanner.nextInt();

                    if (tipoOpcion == 1) {
                        tipo = "Mago";
                    } else if (tipoOpcion == 2) {
                        tipo = "Guerrero";
                    } else if (tipoOpcion == 3) {
                        tipo = "Arquero";
                    } else {
                        System.out.println("Opción inválida");
                        break;
                    }

                    System.out.print("Ingrese puntos de vida: ");
                    vida = scanner.nextInt();

                    if (vida < 0) {
                        System.out.println("La vida no puede ser negativa");
                        break;
                    }

                    System.out.print("Ingrese fuerza base: ");
                    fuerza = scanner.nextInt();

                    if (fuerza < 0) {
                        System.out.println("La fuerza no puede ser negativa");
                        break;
                    }

                    personajeCreado = true;

                    System.out.println("\n=== PERSONAJE CREADO ===");
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Clase: " + tipo);
                    System.out.println("Vida: " + vida);
                    System.out.println("Fuerza: " + fuerza);
                    break;

                case 2:
                    if (!personajeCreado) {
                        System.out.println("\nNo se ha creado un personaje aún...");
                        break;
                    }

                    System.out.println("\n=== ENTRENAMIENTO ===");
                    System.out.println("1. Entrenar Fuerza");
                    System.out.println("2. Entrenar Resistencia (Vida)");
                    System.out.println("3. Volver al menú principal");
                    System.out.print("Seleccione una opción: ");

                    int entrenamientoOpcion = scanner.nextInt();
                    switch (entrenamientoOpcion) {
                        case 1 -> {
                            int gananciaFuerza = (int)(Math.random() * 5) + 1;
                            fuerza += gananciaFuerza;

                            String nivelFuerza;
                            if (fuerza < 20) {
                                nivelFuerza = "Débil";
                            } else if (fuerza < 50) {
                                nivelFuerza = "Promedio";
                            } else if (fuerza <= 80) {
                                nivelFuerza = "Fuerte";
                            } else {
                                nivelFuerza = "¡Imparable!";
                            }

                            System.out.println("\n=== RESULTADO DEL ENTRENAMIENTO ===");
                            System.out.println("Tipo    : Fuerza");
                            System.out.println("─────────────────────────────");
                            System.out.println("Ganancia: +" + gananciaFuerza + " de Fuerza");
                            System.out.println("Fuerza  : " + fuerza + "  " + nivelFuerza);
                        }
                        case 2 -> {
                            int gananciaVida = (int)(Math.random() * 10) + 5;
                            vida = Math.min(vida + gananciaVida, 100);

                            int barraLlenaT = vida / 10;
                            String barraT = "[";
                            for (int i = 0; i < 10; i++) {
                                if (i < barraLlenaT) {
                                    barraT += "█";
                                } else {
                                    barraT += "░";
                                }
                            }
                            barraT += "]";

                            System.out.println("\n=== RESULTADO DEL ENTRENAMIENTO ===");
                            System.out.println("Tipo    : Resistencia");
                            System.out.println("─────────────────────────────");
                            System.out.println("Ganancia: +" + gananciaVida + " de Vida");
                            System.out.println("Vida    : " + barraT + "  " + vida + "/100");
                        }
                        case 3 -> System.out.println("Volviendo al menú principal...");
                        default -> System.out.println("Opción inválida");
                    }
                    break;
                case 3:
                    System.out.println("\nBatalla próximamente...");
                    break;

                case 4:
                        System.out.println("\n╔══════════════════════╗");
                        System.out.println("║     INVENTARIO       ║");
                        System.out.println("╠══════════════════════╣");

                    for (String item : inventario) {
                    System.out.println("║" + item);
                    }
                    
                        System.out.println("╠══════════════════════╣");
                        System.out.println("║  Total: " + inventario.length + " objetos      ║");
                        System.out.println("╚══════════════════════╝");

                    break;

                case 5:
                    if (!personajeCreado) {
                        System.out.println("\nNo se ha creado un personaje aún...");
                        break;
                    }

                    // Barra visual de vida (sobre 100)
                    int barraLlena = vida / 10;
                    String barra = "[";
                    for (int i = 0; i < 10; i++) {
                        if (i < barraLlena) {
                            barra += "█";
                        } else {
                            barra += "░";
                        }
                    }
                    barra += "]";

                    String estadoVida;
                    if (vida < 20) {
                        estadoVida = "¡PELIGRO! Vida crítica";
                    } else if (vida < 50) {
                        estadoVida = "Vida baja, ten cuidado";
                    } else if (vida <= 80) {
                        estadoVida = "Vida estable";
                    } else {
                        estadoVida = "¡Excelente forma!";
                    }

                    System.out.println("\n=== ESTADO DEL PERSONAJE ===");
                    System.out.println("Nombre  : " + nombre);
                    System.out.println("Clase   : " + tipo);
                    System.out.println("─────────────────────────────");
                    System.out.println("Vida    : " + barra + "  " + vida + "/100  " + estadoVida);
                    System.out.println("Fuerza  : " + fuerza);
                    break;
                    
                case 6:
                    System.out.println("\n=== CRÉDITOS ===");
                    System.out.println("Desarrollado por: JAVIERA GODOY - RENATO CAMPOS - DIEGO CASTILLO  - MATIAS CELIS -VICTOR ERAZO");
                    System.out.println("Inspirado en juegos RPG clásicos");
                    System.out.println("¡Gracias por jugar!");
                    break;
                case 7:
                    System.out.println("Saliendo del juego...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 7);

        scanner.close();
    }
}