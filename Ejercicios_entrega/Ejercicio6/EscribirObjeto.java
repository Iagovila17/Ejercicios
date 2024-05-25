package github.Ejercicios.Ejercicios_entrega.Ejercicio6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirObjeto {
    public static void main(String[] args) {
        persona persona = new persona("Iago", 20);

        try (FileOutputStream fileOut = new FileOutputStream("persona.bin");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(persona);
            System.out.println("El objeto ha sido guardado en persona.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}