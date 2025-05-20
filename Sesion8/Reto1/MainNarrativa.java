package Sesion8.Reto1;

import java.util.Scanner;

// --- Interfaces ---

interface TransicionHistoria {
    String siguienteEscena(String escenaActual, boolean decision);
}

interface GestorDialogo {
    void mostrarDialogo(String texto);
}

interface LogicaDecision {
    boolean obtenerDecision(String pregunta);
}

// --- Implementaciones concretas ---

class TransicionSimple implements TransicionHistoria {
    @Override
    public String siguienteEscena(String escenaActual, boolean decision) {
        switch (escenaActual) {
            case "inicio":
                return decision ? "batalla" : "huida";
            case "batalla":
                return decision ? "victoria" : "derrota";
            case "huida":
                return decision ? "refugio" : "perdido";
            default:
                return "fin";
        }
    }
}

class DialogoTexto implements GestorDialogo {
    @Override
    public void mostrarDialogo(String texto) {
        System.out.println("NPC dice: " + texto);
    }
}

class DecisionBinaria implements LogicaDecision {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public boolean obtenerDecision(String pregunta) {
        while (true) {
            System.out.print(pregunta + " (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí")) {
                return true;
            } else if (respuesta.equals("n") || respuesta.equals("no")) {
                return false;
            } else {
                System.out.println("Por favor, responde 's' o 'n'.");
            }
        }
    }
}

// --- Clase principal que usa solo interfaces ---

public class MainNarrativa {
    private TransicionHistoria transicion;
    private GestorDialogo dialogo;
    private LogicaDecision decision;

    public MainNarrativa(TransicionHistoria transicion, GestorDialogo dialogo, LogicaDecision decision) {
        this.transicion = transicion;
        this.dialogo = dialogo;
        this.decision = decision;
    }

    public void ejecutar() {
        String escena = "inicio";
        dialogo.mostrarDialogo("Comienza la historia...");

        while (!escena.equals("fin")) {
            boolean decisionJugador = false;

            switch (escena) {
                case "inicio":
                    dialogo.mostrarDialogo("¿Quieres enfrentar al enemigo?");
                    decisionJugador = decision.obtenerDecision("¿Lucharás?");
                    break;
                case "batalla":
                    dialogo.mostrarDialogo("¡La batalla ha comenzado! ¿Atacarás con fuerza?");
                    decisionJugador = decision.obtenerDecision("¿Atacar con fuerza?");
                    break;
                case "huida":
                    dialogo.mostrarDialogo("¿Quieres correr hacia el refugio o perderte en el bosque?");
                    decisionJugador = decision.obtenerDecision("¿Correr hacia refugio?");
                    break;
                case "victoria":
                    dialogo.mostrarDialogo("Has ganado la batalla, ¡felicidades!");
                    return;
                case "derrota":
                    dialogo.mostrarDialogo("Has sido derrotado... Fin de la historia.");
                    return;
                case "refugio":
                    dialogo.mostrarDialogo("Has encontrado un refugio seguro. Fin de la historia.");
                    return;
                case "perdido":
                    dialogo.mostrarDialogo("Te has perdido en el bosque, cuidado... Fin de la historia.");
                    return;
                default:
                    dialogo.mostrarDialogo("Escena desconocida. Fin de la historia.");
                    return;
            }

            escena = transicion.siguienteEscena(escena, decisionJugador);
        }
    }

    // --- Método main para ejecutar la simulación ---
    public static void main(String[] args) {
        TransicionHistoria transicion = new TransicionSimple();
        GestorDialogo dialogo = new DialogoTexto();
        LogicaDecision decision = new DecisionBinaria();

        MainNarrativa juego = new MainNarrativa(transicion, dialogo, decision);
        juego.ejecutar();
    }
}
