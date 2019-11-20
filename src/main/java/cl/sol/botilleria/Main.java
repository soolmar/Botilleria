/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sol.botilleria;

import cl.sol.botilleria.models.Alcoholica;
import cl.sol.botilleria.models.Fantasia;
import java.util.Scanner;

/**
 *
 * @author Sol
 */
public class Main {

    public static void main(String[] args) {
        // prueba manual
        // Botilleria.main();
        // System.exit(0);

        Scanner input = new Scanner(System.in);

        // Inicializar la aplicación
        Botilleria b = new Botilleria();
        b.cargarDesdeArchivo();

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
            System.out.println("Ingrese una opción: ");
            String opcionTexto = input.nextLine();
            Integer opcion;
            try {
                opcion = Integer.parseInt(opcionTexto);
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida.");
                continue;
            }
            
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
                System.out.println("Código: ");
                codigo = input.nextLine();

                System.out.println("Nombre: ");
                nombre = input.nextLine();

                System.out.println("Fabricante: ");
                fabricante = input.nextLine();

                System.out.println("Cantidad: ");
                cantidad = input.nextInt();
                input.nextLine();

                System.out.println("Precio Neto: ");
                precioNeto = input.nextInt();
                input.nextLine();

                System.out.println("Capacidad: ");
                capacidad = input.nextInt();
                input.nextLine();

                System.out.println("Grado Alcohólico: ");
                gradoAlcoholico = input.nextInt();
                input.nextLine();

                System.out.println("Tipo: ");
                tipo = input.nextLine();

                // mostrar los datos que ingresó
                System.out.println("El código ingresado es: " + codigo);
                System.out.println("El nombre ingresado es: " + nombre);
                System.out.println("El fabricante ingresado es: " + fabricante);
                System.out.println("La cantidad ingresada es: " + cantidad);
                System.out.println("El precio neto ingresado es: " + precioNeto);
                System.out.println("La capacidad ingresada es: " + capacidad);
                System.out.println("El grado alcoholico ingresado es: " + gradoAlcoholico);
                System.out.println("El tipo ingresado es: " + tipo);

                // se ingresa a la botilleria
                System.out.println("Ingresando al sistema...");
                Alcoholica bebida = new Alcoholica(codigo, nombre, fabricante, cantidad, precioNeto, capacidad, gradoAlcoholico, tipo);
                b.ingresarBebidaAlcoholica(bebida);

                // mostrar mensaje de OK!
                System.out.println("OK!");
            }
            
            // si eligió la opción 2 (crear bebida de fantasía)
            if (opcion == 2) {
                String codigo;
                String nombre;
                String fabricante;
                Integer cantidad;
                Integer precioNeto;
                Integer capacidad;
                String sabor;

                // mostrar un mensaje indicando lo que hay que hacer
                System.out.println("Por favor, ingrese los datos de la bebida de fantasía");
                // preguntar cada dato
                System.out.println("Código: ");
                codigo = input.nextLine();

                System.out.println("Nombre: ");
                nombre = input.nextLine();

                System.out.println("Fabricante: ");
                fabricante = input.nextLine();

                System.out.println("Cantidad: ");
                cantidad = input.nextInt();
                input.nextLine();

                System.out.println("Precio Neto: ");
                precioNeto = input.nextInt();
                input.nextLine();

                System.out.println("Capacidad: ");
                capacidad = input.nextInt();
                input.nextLine();
                
                System.out.println("Sabor: ");
                sabor = input.nextLine();

                // mostrar los datos que ingresó
                System.out.println("El código ingresado es: " + codigo);
                System.out.println("El nombre ingresado es: " + nombre);
                System.out.println("El fabricante ingresado es: " + fabricante);
                System.out.println("La cantidad ingresada es: " + cantidad);
                System.out.println("El precio neto ingresado es: " + precioNeto);
                System.out.println("La capacidad ingresada es: " + capacidad);
                System.out.println("El sabor ingresado es: " + sabor);

                // se ingresa a la botilleria
                System.out.println("Ingresando al sistema...");
                Fantasia bebida = new Fantasia(codigo, nombre, fabricante, cantidad, precioNeto, capacidad, sabor);
                b.ingresarBebidaFantasia(bebida);

                // mostrar mensaje de OK!
                System.out.println("OK!");
            }            

            // mostrar todas las bebidas alcoholicas
            if (opcion == 3) {
                b.mostrarBebidasAlcoholicas();
            }
            
            // mostrar todas las bebidas de fantasía
            if (opcion == 4) {
                b.mostrarBebidasFantasias();
            }
            
            // buscar una bebida alcohólica por código
            if (opcion == 5) {
                String codigo;
                Alcoholica resultado;

                System.out.println("Ingrese código a buscar: ");
                codigo = input.nextLine();
                resultado = b.buscarBebidaAlcoholica(codigo);
                if (resultado != null) {
                    System.out.println("Se encontró: " + resultado.getCodigo());
                } else {
                    System.out.println("No se encontró un resultado.");
                }
            }
            
            // buscar una bebida de fantasía por código
            if (opcion == 6) {
                String codigo;
                Fantasia resultado;

                System.out.println("Ingrese código a buscar: ");
                codigo = input.nextLine();
                resultado = b.buscarBebidaFantasia(codigo);
                if (resultado != null) {
                    System.out.println("Se encontró: " + resultado.getCodigo());
                } else {
                    System.out.println("No se encontró un resultado.");
                }
            }            

            // calcular el precio de venta de una bebida alcohólica
            if (opcion == 7) {
                String codigo;
                Double resultado;

                System.out.println("Ingrese código a buscar: ");
                codigo = input.nextLine();
                resultado = b.calcularPrecioVentaAlcoholica(codigo);
                if (resultado != null) {
                    System.out.println("Precio de venta: " + resultado);
                } else {
                    System.out.println("No se encontró un resultado.");
                }
            }
            
            // calcular el precio de venta de una bebida de fantasía
            if (opcion == 8) {
                String codigo;
                Double resultado;

                System.out.println("Ingrese código a buscar: ");
                codigo = input.nextLine();
                resultado = b.calcularPrecioVentaFantasia(codigo);
                if (resultado != null) {
                    System.out.println("Precio de venta: " + resultado);
                } else {
                    System.out.println("No se encontró un resultado.");
                }
            }            

            // eliminar una bebida alcohólica por código
            if (opcion == 9) {
                String codigo;
                boolean resultado;

                System.out.println("Ingrese código a buscar: ");
                codigo = input.nextLine();
                resultado = b.eliminarBebidaAlcoholica(codigo);
                if (resultado) {
                    System.out.println("Se eliminó correctamente.");
                } else {
                    System.out.println("Bebida no encontrada.");
                }
            }
            
            // eliminar una bebida de fantasía por código
            if (opcion == 10) {
                String codigo;
                boolean resultado;

                System.out.println("Ingrese código a buscar: ");
                codigo = input.nextLine();
                resultado = b.eliminarBebidaFantasia(codigo);
                if (resultado) {
                    System.out.println("Se eliminó correctamente.");
                } else {
                    System.out.println("Bebida no encontrada.");
                }
            }            

            //
            //
            //
            // si eligió la opción 0
            if (opcion == 0) {
                
                // guardar cambios antes de salir
                b.guardarEnArchivo();
                
                break;
            }
        }

        System.out.println("Gracias.");
    }
}
