/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sol.botilleria.models;

/**
 *
 * @author puje
 */
public class Liquido {
    private String codigo;
    private String nombre;
    private String fabricante;
    private int cantidad;
    private int precioNeto;
    private int capacidad;
    
    Liquido() {}
    
    Liquido(String codigo, String nombre, String fabricante, int cantidad, int precioNeto, int capacidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.cantidad = cantidad;
        this.precioNeto = precioNeto;
        this.capacidad = capacidad;
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public String getnombre() {
        return this.nombre;
    }
    
    public String getFabricante() {
        return this.fabricante;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }
    
    public int getPrecioNeto() {
        return this.precioNeto;
    }
    
    public int getCapacidad() {
        return this.capacidad;
    }
    
    public void getCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void getnombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void getFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
    public void getCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void getPrecioNeto(int precio) {
        this.precioNeto = precio;
    }
    
    public void getCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
