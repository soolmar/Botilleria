/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sol.botilleria;

import java.util.Scanner;

/**
 *
 * @author Sol
 */
public class Main {

    public static void main(String[] args) {     
        // prueba manual
        Botilleria.main();
        System.exit(0);

        Scanner input = new Scanner(System.in);

        while (true) {
            // mostrar menu
            System.out.println("[1] Ingresar una bebida alcohólica");
            System.out.println("[2] Ingresar una bebida de fantasía");
            System.out.println("[3] Mostrar todas las bebidas alcohólicas");
            System.out.println("[4] Mostrar todas las bebidas de fantasía");
            System.out.println("[5] Buscar una bebida alcohólica");
            System.out.println("[6] Buscar una bebida de fantasía");
            System.out.println("[7] Calcular el precio de venta de una bebida alcohólica");
            System.out.println("[8] Calcular el precio de venta de una bebida de fantasía");
            System.out.println("[9] Eliminar una bebida alcohólica");
            System.out.println("[10] Eliminar una bebida de fantasía");
            System.out.println("[0] Salir del sistema");

            // capturar opción
            Integer opcion = input.nextInt();
            System.out.println("Opcion elegida: " + opcion);

            // si eligió la opción 1
            if (opcion == 1) {
                String codigo;
                String nombre;
                String fabricante;
                Integer cantidad;
                Integer precioNeto;
                Integer capacidad;
                Integer gradoAlcoholico;
                String tipo;
                
                // mostrar un mensaje indicando lo que hay que hacer
                System.out.println("Por favor, ingrese los datos de la bebida alcohólica");
                // preguntar cada dato
                System.out.print("Código: ");
                codigo = input.next();
                
                System.out.print("Nombre: ");
                nombre = input.next();
                
                System.out.print("Fabricante: ");
                fabricante = input.next();

                System.out.print("Cantidad: ");
                cantidad = input.nextInt();
                
                System.out.print("Precio Neto: ");
                precioNeto = input.nextInt(); 
                
                System.out.print("Capacidad: ");
                capacidad = input.nextInt();                 
                
                System.out.print("Grado Alcohólico: ");
                gradoAlcoholico = input.nextInt();    
                
                System.out.print("Tipo: ");
                tipo = input.next();                
                
                // mostrar los datos que ingresó
                System.out.println("El código ingresado es: " + codigo);
                System.out.println("El nombre ingresado es: " + nombre);
                System.out.println("El fabricante ingresado es: " + fabricante);
                System.out.println("La cantidad ingresada es: " + cantidad);
                System.out.println("El precio neto ingresado es: " + precioNeto);
                System.out.println("La capacidad ingresada es: " + capacidad);
                System.out.println("El grado alcoholico ingresado es: " + gradoAlcoholico);
                System.out.println("El tipo ingresado es: " + tipo);
                                
                
                // ???? se ingresa
                System.out.println("Ingresando al sistema...");
                
                // mostrar mensaje de OK!
                System.out.println("OK!");
            }
            
            // si eligió la opción 0
            if (opcion == 0) {
                break;
            }
        }
        
        System.out.println("Chao.");
    }
}
