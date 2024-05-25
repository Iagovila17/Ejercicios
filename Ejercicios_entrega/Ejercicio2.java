package github.Ejercicios.Ejercicios_entrega;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {

    public static void main(String[] args) {
        BufferedReader lector = null; // nos permite leer el archivo de entrada
    

        try {
            lector = new BufferedReader(new FileReader("entrada.txt"));// en esta zona se define el nombre de el fichero que vamos a querer abrir 

            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e){
            System.out.println("Se a produccido un error al leer el fichero");
            e.printStackTrace();
        } finally {
            if (lector != null){
                try {
                lector.close();
             } catch (IOException e) {
                System.out.println("Se produjo un error al cerrar el fichero");
             }
          }
      }
   } 
}

// previamente para que te lea el fichero llamado entrada.txt deberemos Crear dicho fichoreo si no nos saltara un error 