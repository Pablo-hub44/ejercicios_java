/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablosi.ejercicio1;
import java.util.ArrayDeque;
import java.util.Deque;

public class SimplificarRuta {
    public static String simplificarRuta(String ruta) {
        // Creamos una pila para almacenar los componentes de la ruta simplificada
        Deque<String> pila = new ArrayDeque<>();////aca pondremos la ruta filtrada
        // ArrayDeque en Java es una implementación de la interfaz Deque que utiliza un arreglo como la estructura subyacente para almacenar los elementos. Es parte del paquete java.util y proporciona una implementación de cola de doble extremo (deque) sin capacidad fija. Esto significa que puede crecer dinámicamente según sea necesario y no tiene restricciones de capacidad máxima como algunas otras estructuras de datos.

        // Dividimos la ruta en partes utilizando el separador "/"
        String[] partes = ruta.split("/");

        // Recorremos cada parte de la ruta
        for (String parte : partes) {
            // Validamos si la parte es ".." y la pila no está vacía, eliminamos el último elemento de la pila
            if (parte.equals("..") && !pila.isEmpty()) {
                pila.pop();
            }
            // Si la parte es diferente de "." y ".." y no está vacía, la agregamos a la pila
            else if (!parte.equals(".") && !parte.isEmpty()) {
                pila.push(parte);
            }
        }

        // Construimos la ruta simplificada uniendo los elementos de la pila
        StringBuilder resultado = new StringBuilder("/");
        while (!pila.isEmpty()) {
            resultado.append(pila.removeLast());
            if (!pila.isEmpty()) {
                resultado.append("/");
            }
        }

        return resultado.toString();
    }

    // Método principal para probar la funcionalidad
    public static void main(String[] args) {
        System.out.println(simplificarRuta("/home/")); // salida: /home
        System.out.println(simplificarRuta("/x/./y/../../z/")); // salida: /z
        System.out.println(simplificarRuta("/../")); // salida: /
        System.out.println(simplificarRuta("/home//prueba/")); // salida: /home/prueba
    }
}

