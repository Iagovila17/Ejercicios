package github.Ejercicios.Ejercicios_entrega;

import java.io.*;

public class Merge {

    public static void main(String[] args) {
        String fichero1 = "fichero1.txt"; //cogeremos el fichero con este nombre 
        String fichero2 = "fichero2.txt";//cogeremos el fichero con este nombre 
        String combinado = "combinado.txt";// combinacion de los dos 

        mergeFicheros(fichero1, fichero2, combinado);
    }

    private static void mergeFicheros(String fichero1, String fichero2, String combinado) {
        try (BufferedReader lector1 = new BufferedReader(new FileReader(fichero1)); // leera el fichero 1
             BufferedReader lector2 = new BufferedReader(new FileReader(fichero2)); //leera el fichero 1
             BufferedWriter escritor = new BufferedWriter(new FileWriter(combinado))) { // escribira en el fichero nuevo llamado combinacion

            String lineaFichero1 = lector1.readLine();
            String lineaFichero2 = lector2.readLine();

            while (lineaFichero1 != null || lineaFichero2 != null) { // indicaremos que las combinacion de el fichero final es intercalar lineas de cada uno de los 2
                if (lineaFichero1 != null) {
                    escritor.write(lineaFichero1);
                    escritor.newLine();
                    lineaFichero1 = lector1.readLine();
                }

                if (lineaFichero2 != null) {
                    escritor.write(lineaFichero2);
                    escritor.newLine();
                    lineaFichero2 = lector2.readLine();
                }
            }

            System.out.println("Ficheros combinados con éxito en " + combinado); // mostrara fichero creado

        } catch (IOException e) {
            System.out.println("Se produjo un error al combinar los ficheros.");
            e.printStackTrace();
        }
    }
} 