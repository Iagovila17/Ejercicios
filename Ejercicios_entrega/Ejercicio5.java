package github.Ejercicios.Ejercicios_entrega;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {
    
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        //Solicitaremos la palabra a reemplazar
        System.out.println("Introduce la palabra que deseas reemplazar:");
        String palabraAReemplazar = scanner.nextLine();

        // Y aqui la nueva palabra 
        System.out.println("Introduce la nueva palabra:");
        String nuevaPalabra = scanner.nextLine();

        BufferedReader lector = null; // nos permite leer el archivo de entrada 
        FileWriter escritor = null;   // nos permite escribir en el archivo de salida

        try {
            // Inicializar el BufferedReader con el fichero "entrada.txt"
            lector = new BufferedReader(new FileReader("entrada.txt"));

            // Inicializar el FileWriter con el fichero "salida.txt"
            escritor = new FileWriter("salida.txt");

            // leera el contenido del fichero línea por línea y reemplazar las ocurrencias
            String linea;
            while ((linea = lector.readLine()) != null) {
                // Reemplazar todas las ocurrencias de la palabra especificada
                String lineaModificada = linea.replaceAll(palabraAReemplazar, nuevaPalabra);
                // Escribir la línea modificada en el nuevo fichero
                escritor.write(lineaModificada + "\n");
            }

            // Confirmar que la operación se ha realizado con éxito
            System.out.println("El contenido ha sido modificado y guardado en salida.txt");
        } catch (IOException e) {
            // posibles errores
            System.out.println("Ocurrió un error durante la modificación del fichero.");
            e.printStackTrace();
        } finally {
            // cierre  BufferedReader 
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    System.out.println("Ocurrió un error al cerrar el fichero de lectura.");
                    e.printStackTrace();
                }
            }
            if (escritor != null) {
                try {
                    escritor.close();
                } catch (IOException e) {
                    System.out.println("Ocurrió un error al cerrar el fichero de escritura.");
                    e.printStackTrace();
                }
            }
            scanner.close();
        }
    }
}