package github.Ejercicios.Ejercicios_entrega.Ejercicio7;

import java.io.Serializable;

public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}