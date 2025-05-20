import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer datos desde la consola
        Scanner scanner = new Scanner(System.in);

        // Crear un objeto Paciente
        Paciente paciente = new Paciente();

        // Solicitar y asignar datos al objeto paciente
        System.out.print("Ingrese el nombre del paciente: ");
        paciente.nombre = scanner.nextLine();

        System.out.print("Ingrese la edad del paciente: ");
        paciente.edad = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea pendiente

        System.out.print("Ingrese el número de expediente: ");
        paciente.numeroExpediente = scanner.nextLine();

        // Mostrar la información del paciente
        System.out.println();
        paciente.mostrarInformacion();

        scanner.close();
    }
}
