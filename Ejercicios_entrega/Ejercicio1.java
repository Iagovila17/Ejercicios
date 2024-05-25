package github.Ejercicios.Ejercicios_entrega;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar al usuario que introduzca una cadena de texto
        System.out.println("Por favor, introduce una cadena de texto: ");
        String textoUsuario = scanner.nextLine();
        
        // Declarar un objeto FileWriter
        FileWriter escritor = null;
        
        try {
            // Inicializar el FileWriter con el nombre del fichero
            escritor = new FileWriter("salida.txt");
            
            // Escribir la cadena de texto en el fichero
            escritor.write(textoUsuario);
            
            // Confirmar que la operación se ha realizado con éxito
            System.out.println("El texto ha sido escrito en salida.txt");
        } catch (IOException e) {
            // Manejar posibles excepciones de entrada/salida
            System.out.println("Ocurrió un error al escribir en el fichero.");
            e.printStackTrace();
        } finally {
            // Asegurarse de cerrar el FileWriter para liberar recursos
            if (escritor != null) {
                try {
                    escritor.close();
                } catch (IOException e) {
                    System.out.println("Ocurrió un error al cerrar el fichero.");
                    e.printStackTrace();
                }
            }
            // Cerrar el objeto Scanner
            scanner.close();
        }
    }
}