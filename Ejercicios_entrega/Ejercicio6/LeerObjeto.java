package github.Ejercicios.Ejercicios_entrega.Ejercicio6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerObjeto {
    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream("persona.bin");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            persona persona = (persona) in.readObject();
            System.out.println("Objeto leído desde persona.bin:");
            System.out.println(persona);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}