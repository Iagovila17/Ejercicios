package github.Ejercicios.Ejercicios_entrega.Ejercicio8;

import java.io.*;
import java.util.Scanner;

public class DividirFichero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Aqui pondremos el nombre del fichero con  su extension
        System.out.println("Introduce el nombre del fichero (incluye la extensión .txt o la que sea):");
        String nombreFicheroGrande = scanner.nextLine();

        // número de líneas por fichero maximo
        System.out.println("Introduce el número de líneas por cada fichero:");
        int lineasPorFichero = scanner.nextInt();
        scanner.nextLine(); //salto de línea

        dividirFichero(nombreFicheroGrande, lineasPorFichero);
    }

    private static void dividirFichero(String nombreFicheroGrande, int lineasPorFichero) {
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreFicheroGrande))) {
            String linea;
            int numeroFichero = 1; // maximo de fichero 1 
            int contadorLineas = 0; // minimo de lineas 0
            BufferedWriter escritor = null;

            while ((linea = lector.readLine()) != null) {
                if (contadorLineas % lineasPorFichero == 0) {
                    if (escritor != null) {
                        escritor.close();
                    }
                    String nombreFicheroPequeno = "parte" + numeroFichero + ".txt";
                    escritor = new BufferedWriter(new FileWriter(nombreFicheroPequeno));
                    numeroFichero++;
                }

                escritor.write(linea); // para leer el fichero original
                escritor.newLine(); // esacribe los nuevos ficheros
                contadorLineas++; // cuenta el maximo de lineas de cada fichero
            }

            if (escritor != null) {// una vez termina de formar los ficheros cerramos la marca
                escritor.close();
            } 

            System.out.println("El fichero ha sido dividido en " + (numeroFichero - 1) + " partes."); // mostrara en cuantas partes se va a dividir el el fichero dadas las lineas maximas

        } catch (IOException e) {
            System.out.println("Ocurrió un error al dividir el fichero."); // caso de error
            e.printStackTrace();
        }
    }
}

