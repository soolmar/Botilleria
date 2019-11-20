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
public class Fantasia extends Liquido{
    private String sabor;
    
    Fantasia() {}
    
    Fantasia(String codigo, String nombre, String fabricante, int cantidad, int precioNeto, int capacidad, String sabor) {
        super(codigo, nombre, fabricante, cantidad, precioNeto, capacidad);
        this.sabor = sabor;
    }
    
    public String getSabor() {
        return this.sabor;
    }
    
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
}
