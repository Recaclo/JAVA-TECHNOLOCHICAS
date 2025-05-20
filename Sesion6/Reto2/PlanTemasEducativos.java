package Sesion6.Reto2;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Comparator;

// Clase Tema que implementa Comparable (orden natural por título)
class Tema implements Comparable<Tema> {
    private String titulo;
    private int prioridad;

    public Tema(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Tema otro) {
        return this.titulo.compareToIgnoreCase(otro.titulo);
    }

    @Override
    public String toString() {
        return " " + titulo + " (Prioridad: " + prioridad + ")";
    }
}

public class PlanTemasEducativos {
    public static void main(String[] args) {
        // Lista concurrente para gestionar temas activos
        CopyOnWriteArrayList<Tema> temas = new CopyOnWriteArrayList<>();

        // Agregar temas
        temas.add(new Tema("Lectura comprensiva", 2));
        temas.add(new Tema("Matemáticas básicas", 1));
        temas.add(new Tema("Cuidado del medio ambiente", 3));
        temas.add(new Tema("Expresión escrita", 2));

        // Repositorio concurrente de recursos por tema
        ConcurrentHashMap<String, String> recursos = new ConcurrentHashMap<>();
        recursos.put("Lectura comprensiva", "https://recursos.edu/lectura");
        recursos.put("Matemáticas básicas", "https://recursos.edu/mate");
        recursos.put("Cuidado del medio ambiente", "https://recursos.edu/medioambiente");
        recursos.put("Expresión escrita", "https://recursos.edu/expresion");

        // Mostrar lista ordenada alfabéticamente (orden natural)
        Collections.sort(temas);  // Usa compareTo()
        System.out.println(" Temas ordenados alfabéticamente:");
        for (Tema tema : temas) {
            System.out.println(tema);
        }

        // Ordenar por prioridad usando Comparator
        temas.sort(Comparator.comparingInt(Tema::getPrioridad));
        System.out.println("\n Temas ordenados por prioridad (1=Alta, 3=Baja):");
        for (Tema tema : temas) {
            System.out.println(tema);
        }

        // Mostrar recursos compartidos por tema
        System.out.println("\n Repositorio de recursos compartidos:");
        for (String titulo : recursos.keySet()) {
            System.out.println("- " + titulo + ": " + recursos.get(titulo));
        }
    }
}

