package github.Ejercicios.Ejercicios_entrega.Ejercicio7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionarListaPersonas {

    private static final String FICHERO_BINARIO = "personas.bin";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Persona> listaPersonas = new ArrayList<>();

        // Menu que vamos a mostrar 
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar persona");
            System.out.println("2. Guardar lista en fichero binario");
            System.out.println("3. Leer lista desde fichero binario");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // opcines del menu

            switch (opcion) {
                case 1:
                    agregarPersona(scanner, listaPersonas);
                    break;
                case 2:
                    guardarListaEnFichero(listaPersonas);
                    break;
                case 3:
                    listaPersonas = leerListaDesdeFichero();
                    mostrarLista(listaPersonas);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void agregarPersona(Scanner scanner, List<Persona> listaPersonas) { // si queremos agregar tendremos las opcines de nombre y edad
        System.out.println("Introduce el nombre de la persona:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce la edad de la persona:");
        int edad = scanner.nextInt();
        scanner.nextLine();  //  salto de línea

        Persona persona = new Persona(nombre, edad);
        listaPersonas.add(persona);
        System.out.println("Persona agregada."); // una vez agregada saltara este mensaje
    }

    private static void guardarListaEnFichero(List<Persona> listaPersonas) { // dewspues de agregar a las personas guardaremos el fichero bin 
        try (FileOutputStream fileOut = new FileOutputStream(FICHERO_BINARIO);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(listaPersonas);
            System.out.println("Lista guardada en " + FICHERO_BINARIO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Persona> leerListaDesdeFichero() { // desde aqui una vez guardemos el fichero lo leeremos y para mostrarlo se indica abajo 
        try (FileInputStream fileIn = new FileInputStream(FICHERO_BINARIO);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (List<Persona>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static void mostrarLista(List<Persona> listaPersonas) { // lo podremos mostrar por pantalla la lista que guardamos previamente
        if (listaPersonas.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("Lista de personas:");
            for (Persona persona : listaPersonas) {
                System.out.println(persona);
            }
        }
    }
}
