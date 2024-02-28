/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablosi.ejercicio1;
import java.util.HashMap;
import java.util.Map;

public class SuperheroesInfo {
    // HashMap para almacenar la información de los superhéroes
    private static final Map<String, Superhero> infoSuperheroes = new HashMap<>();

    // Clase interna para representar la información de un superhéroe
    static class Superhero {
        String nombreReal;
        String[] poderes;
        String equipo;

    //       constructor
        Superhero(String nombreReal, String[] poderes, String equipo) {
            this.nombreReal = nombreReal;
            this.poderes = poderes;
            this.equipo = equipo;
        }
    }

    // Método estático para inicializar la información de los superhéroes
    static {
        infoSuperheroes.put("Iron Man", new Superhero("Tony Stark", new String[]{"Tecnologia avanzada", "Movilidad aérea"}, "Los vengadores"));
        infoSuperheroes.put("Capitán América", new Superhero("Steve Rogers", new String[]{"Fuerza sobrehumana", "Agilidad y reflejos sobresalientes"}, "Los vengadores"));
        infoSuperheroes.put("Thor", new Superhero("Thor Odinson", new String[]{"Mjolnir", "Viento y trueno"}, "Los vengadores"));
        infoSuperheroes.put("Spider-Man", new Superhero("Peter Parker", new String[]{"Balanceo", "Telarañas pegajosas", "Sentido aracnido"}, "Los vengadores"));
        infoSuperheroes.put("Hulk", new Superhero("Bruce Banner", new String[]{"Fuerza sobrehumana", "Invulnerabilidad"}, "Los vengadores"));
    }

    // Método estático para mostrar la información de un superhéroe
    public static void mostrarInformacionSuperheroe(String nombre) {
        // Comprobamos si el superhéroe existe en el mapa
        if (infoSuperheroes.containsKey(nombre)) {
            Superhero informacion = infoSuperheroes.get(nombre);
            System.out.println("############ " + nombre + " ############");
            System.out.println("Nombre real: " + informacion.nombreReal);
            System.out.println("Poderes: " + String.join(" - ", informacion.poderes));
            System.out.println("Equipo: " + informacion.equipo + "\n");
        } else {
            System.out.println(nombre + " no existe en los datos que tengo");
        }
    }

    // Método estático para mostrar la información de varios superhéroes
    public static void mostrarInformacionSuperheroes(String[] nombres) {
//        iteramos con un foreach pasandole el metodo de que busque la info de un superheroe
        for (String nombre : nombres) {
            mostrarInformacionSuperheroe(nombre);
        }
    }

    // Método principal para probar la funcionalidad
    public static void main(String[] args) {
//        mostrarInformacionSuperheroe("Thor");
        mostrarInformacionSuperheroes(new String[]{"Iron Man", "Thor", "Joker"});
    }
}
