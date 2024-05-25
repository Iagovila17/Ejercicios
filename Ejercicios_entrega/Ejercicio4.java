package github.Ejercicios.Ejercicios_entrega;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio4 {
    
 public static void main(String[] args) {
        BufferedReader lector = null; // nos permite leer el archivo de entrada 

        try {
            // selecionaremos que fichero vamos a coger en este caso "entrada.txt"
            lector = new BufferedReader(new FileReader("entrada.txt"));

            // Esta variable permite contar las palabras
            int contadorPalabras = 0;

            // Leeremos el contenido del fichero línea por línea
            String linea;
            while ((linea = lector.readLine()) != null) {
                // Dividiremos cada línea en palabras utilizando un espacio como delimitador
                String[] palabras = linea.split("\\s+");
                // incrementamos el numero de palabras
                contadorPalabras += palabras.length;
            }

            // lo mostraremos por consola
            System.out.println("El número de palabras en el fichero es: " + contadorPalabras);
        } catch (IOException e) {
            // y el mismo mensaje de siemore si ocurre algo inesperado
            System.out.println("Ocurrió un error al leer el fichero.");
            e.printStackTrace();
        } finally {
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    System.out.println("Ocurrió un error al cerrar el fichero.");
                    e.printStackTrace();
                }
            }
        }
    }
}
