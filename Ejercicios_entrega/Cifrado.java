package github.Ejercicios.Ejercicios_entrega;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cifrado {
    public static void main(String[] args) {
        String ficheroOriginal = "original.txt"; // fichero donde inicial 
        String ficheroCifrado = "cifrado.txt"; // fichero de forma cifrada
        String ficheroDescifrado = "descifrado.txt"; // fichero sin cifrar
        int desplazamiento = 3; // Desplazamiento en el cifrado César, consiste en mover la letra 3 posiciones
    
        cifrarFichero(ficheroOriginal, ficheroCifrado, desplazamiento);
        descifrarFichero(ficheroCifrado, ficheroDescifrado, desplazamiento);
    
    }
    private static void cifrarFichero(String ficheroOriginal, String ficheroCifrado, int desplazamiento) {
        try (BufferedReader lector = new BufferedReader(new FileReader(ficheroOriginal));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(ficheroCifrado))) {
            int caracter;
            while ((caracter = lector.read()) != -1) {
                if (Character.isLetter(caracter)) {
                    caracter = (caracter - 'a' + desplazamiento) % 26 + 'a';
                }
                escritor.write(caracter);
            }

            System.out.println("Contenido cifrado y guardado en " + ficheroCifrado);

        } catch (IOException e) {
            System.out.println("Error al cifrar el fichero.");
            e.printStackTrace();
        }
    }

    private static void descifrarFichero(String ficheroCifrado, String ficheroDescifrado, int desplazamiento) {
        try (BufferedReader lector = new BufferedReader(new FileReader(ficheroCifrado));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(ficheroDescifrado))) {

            int caracter;
            while ((caracter = lector.read()) != -1) {
                if (Character.isLetter(caracter)) {
                    caracter = (caracter - 'a' - desplazamiento + 26) % 26 + 'a';
                }
                escritor.write(caracter);
            }

            System.out.println("Contenido descifrado y guardado en " + ficheroDescifrado);

        } catch (IOException e) {
            System.out.println("Error al descifrar el fichero.");
            e.printStackTrace();
        }
    }
}
