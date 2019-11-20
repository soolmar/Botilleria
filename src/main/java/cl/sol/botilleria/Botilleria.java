/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sol.botilleria;

import cl.sol.botilleria.models.Alcoholica;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Sol
 */
public class Botilleria {

    ArrayList<Alcoholica> listaAlcoholicas;

    public static void main() {
        System.out.println("Inaugurando la boti...");
        Botilleria b = new Botilleria();

        // inicio
        b.cargarDesdeArchivo();

        // agregando el primer item
        Alcoholica vino = new Alcoholica("VINO1", "Chimbombo", "Puje", 10, 9000, 10, 30, "de la calle");
        b.ingresarBebidaAlcoholica(vino);

        // agregando el segundo item
        Alcoholica vino2 = new Alcoholica("VINO2", "Pipeño", "Jonathan", 10, 9000, 10, 30, "de la calle");
        b.ingresarBebidaAlcoholica(vino2);

        // mostrar lo que haya
        b.mostrarBebidasAlcoholicas();

        // buscar pipeño
        Alcoholica resultado = b.buscarBebidaAlcoholica("VINO2");
        if (resultado != null) {
            System.out.println("Bebida encontrada!");
        } else {
            System.out.println("No se encontró!!");
        }

        // calcular precio de venta
        Double precioVenta = b.calcularPrecioVenta("VINO2");
        System.out.println("Precio venta: " + precioVenta);

        // ELImINAR PIÑEÑO
        b.eliminarBebibaAlcoholica("VINO2");
        System.out.println("pipeño eliminado :(");

        // buscar pipeño
        Alcoholica resultado2 = b.buscarBebidaAlcoholica("VINO2");
        if (resultado2 != null) {
            System.out.println("Bebida encontrada!");
        } else {
            System.out.println("No se encontró!!");
        }

        b.guardarEnArchivo();
    }

    public Botilleria() {
        listaAlcoholicas = new ArrayList();
    }

    public void cargarDesdeArchivo() {
        // leer bebidas desde el archivo

        String path = System.getProperty("user.home") + File.separator + "solBotilleriaAlcoholicas.txt";
        File archivoAlcoholicas = new File(path);

        if (archivoAlcoholicas.exists()) {
            // leer
            try {
                BufferedReader csvReader = new BufferedReader(new FileReader(archivoAlcoholicas));
                String row;
                while ((row = csvReader.readLine()) != null) {
                    String[] data = row.split(",");

                    System.out.println("found: " + row);

                    // leer desde la línea del archivo
                    Alcoholica b = new Alcoholica();
                    b.setCodigo(data[0]);
                    b.setNombre(data[1]);
                    b.setFabricante(data[2]);
                    b.setCantidad(Integer.parseInt(data[3]));
                    b.setPrecioNeto(Integer.parseInt(data[4]));
                    b.setCapacidad(Integer.parseInt(data[5]));

                    // ingresar a la boti
                    this.ingresarBebidaAlcoholica(b);

                    // do something with the data
                }
                csvReader.close();
            } catch (Exception e) {
                System.out.println(" No se pudo trabajar este archivo ");
            }

        } else {
            //
            return;
        }
    }

    public void guardarEnArchivo() {
        String path = System.getProperty("user.home") + File.separator + "solBotilleriaAlcoholicas.txt";
        File archivoAlcoholicas = new File(path);

        // si existe uno ya, borrarlo
        if (archivoAlcoholicas.exists()) {
            // borrar
        }

        // crear el archivo donde guardaremos los datos que tiene la boti
        try (PrintWriter writer = new PrintWriter(archivoAlcoholicas)) {
            StringBuilder sb = new StringBuilder();

            for (Alcoholica bebida : listaAlcoholicas) {
                writer.append(bebida.getCodigo());
                writer.append(",");
                writer.append(bebida.getNombre());
                writer.append(",");
                writer.append(bebida.getFabricante());
                writer.append(",");
                writer.append("" + bebida.getCantidad());
                writer.append(",");
                writer.append("" + bebida.getPrecioNeto());
                writer.append(",");
                writer.append("" + bebida.getCapacidad());
                writer.append(",");
                writer.append("" + bebida.getGradoAlcoholico());
                writer.append(",");
                writer.append(bebida.getTipo());
                writer.append('\n');
            }

            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ingresarBebidaAlcoholica(Alcoholica bebida) {
        listaAlcoholicas.add(bebida);
    }

    public void mostrarBebidasAlcoholicas() {
        for (Alcoholica bebida : listaAlcoholicas) {
            System.out.println(bebida.getCodigo());
        }
    }

    public Alcoholica buscarBebidaAlcoholica(String codigo) {
        for (Alcoholica bebida : listaAlcoholicas) {
            if (bebida.getCodigo().equals(codigo)) {
                return bebida;
            }
        }

        return null;
    }

    public Double calcularPrecioVenta(String codigo) {
        Alcoholica resultado = this.buscarBebidaAlcoholica(codigo);
        if (resultado != null) {
            return resultado.calcularPrecioVenta(0);
        } else {
            return null;
        }
    }

    public boolean eliminarBebibaAlcoholica(String codigo) {
        Alcoholica resultado = this.buscarBebidaAlcoholica(codigo);
        if (resultado != null) {
            listaAlcoholicas.remove(resultado);
            return true;
        } else {
            return false;
        }
    }
}
