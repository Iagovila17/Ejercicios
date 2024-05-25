package github.Ejercicios.Ejercicios_entrega;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio3 {
      public static void main(String[] args) {
        // Declarar objetos BufferedReader y FileWriter
        BufferedReader lector = null; // nos permite leer el archivo de entrada 
        FileWriter escritor = null;   // nos permite escribir en el archivo de salida

        try {
            // selecionaremos que fichero vamos a coger en este caso "entrada.txt"
            lector = new BufferedReader(new FileReader("entrada.txt"));

            // haremos una copia llamada "copia.txt"
            escritor = new FileWriter("copia.txt");

            // Leeremos y copiamos el contenido del fichero línea por línea
            String linea;
            while ((linea = lector.readLine()) != null) {
                escritor.write(linea + "\n");
            }

            // nos saltara un mensaje cuando haya terminado de copiar el contenido
            System.out.println("El contenido ha sido copiado a copia.txt");
        } catch (IOException e) {
            // este mensaje saltaria si nos diera algun fallo
            System.out.println("Ocurrió un error durante la copia del fichero.");
            e.printStackTrace();
        } finally {
            // cerraremos el BufferedReader para liberar recursos
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    System.out.println("Ocurrió un error al cerrar el fichero de lectura.");
                    e.printStackTrace();
                }
            }
            // cerraremos el FileWriter para liberar recursos 
                try {
                    escritor.close();
                } catch (IOException e) {
                    System.out.println("Ocurrió un error al cerrar el fichero de escritura.");
                    e.printStackTrace();
                }
            }
        }
    }

