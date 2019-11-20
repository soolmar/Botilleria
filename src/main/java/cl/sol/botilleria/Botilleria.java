/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sol.botilleria;

import cl.sol.botilleria.models.Alcoholica;
import cl.sol.botilleria.models.Fantasia;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Sol
 */
public class Botilleria {

    ArrayList<Alcoholica> listaAlcoholicas;
    ArrayList<Fantasia> listaFantasias;

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
        Double precioVenta = b.calcularPrecioVentaAlcoholica("VINO2");
        System.out.println("Precio venta: " + precioVenta);

        // ELImINAR PIÑEÑO
        b.eliminarBebidaAlcoholica("VINO2");
        System.out.println("pipeño eliminado :(");

        // buscar pipeño
        Alcoholica resultado2 = b.buscarBebidaAlcoholica("VINO2");
        if (resultado2 != null) {
            System.out.println("Bebida encontrada!");
        } else {
            System.out.println("No se encontró!!");
        }

        System.out.println("PROBAnDO COn LAS DE FANTASIA AHORA");

        // agregando el primer item
        Fantasia sprite = new Fantasia("FANT1", "Sprite", "Sol", 10, 9000, 10, "blanca");
        b.ingresarBebidaFantasia(sprite);

        // agregando el segundo item
        Fantasia quatro = new Fantasia("FANT2", "Quatro", "CCU", 10, 9000, 10, "pomelo");
        b.ingresarBebidaFantasia(quatro);

        // mostrar lo que haya
        b.mostrarBebidasFantasias();

        // buscar sprite
        Fantasia resultado3 = b.buscarBebidaFantasia("FANT1");
        if (resultado3 != null) {
            System.out.println("Bebida encontrada!");
        } else {
            System.out.println("No se encontró!!");
        }

        // calcular precio de venta
        Double precioVenta2 = b.calcularPrecioVentaFantasia("FANT1");
        System.out.println("Precio venta: " + precioVenta2);

        // ELImINAR SPRITE
        b.eliminarBebidaFantasia("FANT1");
        System.out.println("sprite eliminada :D");

        // buscar sprite
        Fantasia resultado4 = b.buscarBebidaFantasia("FANT1");
        if (resultado4 != null) {
            System.out.println("Bebida encontrada!");
        } else {
            System.out.println("No se encontró!!");
        }

        b.guardarEnArchivo();
    }

    public Botilleria() {
        listaAlcoholicas = new ArrayList();
        listaFantasias = new ArrayList();
    }

    public void cargarDesdeArchivo() {
        // leer bebidas desde el archivo

        // CARGAR ALCOHOLICAS
        String path = System.getProperty("user.home") + File.separator + "solBotilleriaAlcoholicas.txt";
        File archivoAlcoholicas = new File(path);

        if (archivoAlcoholicas.exists()) {
            // leer
            try {
                BufferedReader csvReader = new BufferedReader(new FileReader(archivoAlcoholicas));
                String row;
                while ((row = csvReader.readLine()) != null) {
                    String[] data = row.split(",");

                    // leer desde la línea del archivo
                    Alcoholica b = new Alcoholica();
                    b.setCodigo(data[0]);
                    b.setNombre(data[1]);
                    b.setFabricante(data[2]);
                    b.setCantidad(Integer.parseInt(data[3]));
                    b.setPrecioNeto(Integer.parseInt(data[4]));
                    b.setCapacidad(Integer.parseInt(data[5]));
                    b.setGradoAlcoholico(Integer.parseInt(data[6]));
                    b.setTipo(data[7]);

                    // ingresar a la boti
                    this.ingresarBebidaAlcoholica(b);

                    // do something with the data
                }
                csvReader.close();
            } catch (Exception e) {
                System.out.println(" No se pudo trabajar este archivo ");
            }
        }

        // CARGAR FANTASIAS
        String path2 = System.getProperty("user.home") + File.separator + "solBotilleriaFantasias.txt";
        File archivoFantasias = new File(path2);

        if (archivoFantasias.exists()) {
            // leer
            try {
                BufferedReader csvReader = new BufferedReader(new FileReader(archivoFantasias));
                String row;
                while ((row = csvReader.readLine()) != null) {
                    String[] data = row.split(",");

                    // leer desde la línea del archivo
                    Fantasia b = new Fantasia();
                    b.setCodigo(data[0]);
                    b.setNombre(data[1]);
                    b.setFabricante(data[2]);
                    b.setCantidad(Integer.parseInt(data[3]));
                    b.setPrecioNeto(Integer.parseInt(data[4]));
                    b.setCapacidad(Integer.parseInt(data[5]));
                    b.setSabor(data[6]);

                    // ingresar a la boti
                    this.ingresarBebidaFantasia(b);

                    // do something with the data
                }
                csvReader.close();
            } catch (Exception e) {
                System.out.println(" No se pudo trabajar este archivo ");
            }
        }
    }

    public void guardarEnArchivo() {
        // GUARDAR ALCOHOLICAS

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

        // GUARDAR ALCOHOLICAS
        String path2 = System.getProperty("user.home") + File.separator + "solBotilleriaFantasias.txt";
        File archivoFantasias = new File(path2);

        // si existe uno ya, borrarlo
        if (archivoFantasias.exists()) {
            // borrar
        }

        // crear el archivo donde guardaremos los datos que tiene la boti
        try (PrintWriter writer = new PrintWriter(archivoFantasias)) {
            StringBuilder sb = new StringBuilder();

            for (Fantasia bebida : listaFantasias) {
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
                writer.append("" + bebida.getSabor());
                writer.append('\n');
            }

            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ingresarBebidaAlcoholica(Alcoholica bebida) {
        Alcoholica existente = this.buscarBebidaAlcoholica(bebida.getCodigo());
        if (existente != null) {
            // ya tenemos esa bebida
        } else {
            listaAlcoholicas.add(bebida);
        }
    }

    public void ingresarBebidaFantasia(Fantasia bebida) {
        Fantasia existente = this.buscarBebidaFantasia(bebida.getCodigo());
        if (existente != null) {
            // ya tenemos esa bebida
        } else {
            listaFantasias.add(bebida);
        }
        
    }

    public void mostrarBebidasAlcoholicas() {
        for (Alcoholica bebida : listaAlcoholicas) {
            System.out.println(bebida.getCodigo());
        }
    }

    public void mostrarBebidasFantasias() {
        for (Fantasia bebida : listaFantasias) {
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

    public Fantasia buscarBebidaFantasia(String codigo) {
        for (Fantasia bebida : listaFantasias) {
            if (bebida.getCodigo().equals(codigo)) {
                return bebida;
            }
        }

        return null;
    }

    public Double calcularPrecioVentaAlcoholica(String codigo) {
        Alcoholica resultado = this.buscarBebidaAlcoholica(codigo);
        if (resultado != null) {
            return resultado.calcularPrecioVenta(0);
        } else {
            return null;
        }
    }

    public Double calcularPrecioVentaFantasia(String codigo) {
        Fantasia resultado = this.buscarBebidaFantasia(codigo);
        if (resultado != null) {
            return resultado.calcularPrecioVenta(0);
        } else {
            return null;
        }
    }

    public boolean eliminarBebidaAlcoholica(String codigo) {
        Alcoholica resultado = this.buscarBebidaAlcoholica(codigo);
        if (resultado != null) {
            listaAlcoholicas.remove(resultado);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarBebidaFantasia(String codigo) {
        Fantasia resultado = this.buscarBebidaFantasia(codigo);
        if (resultado != null) {
            listaFantasias.remove(resultado);
            return true;
        } else {
            return false;
        }
    }
}
