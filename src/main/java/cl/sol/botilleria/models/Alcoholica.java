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
public class Alcoholica extends Liquido {

    private int gradoAlcoholico;
    private String tipo;

    public Alcoholica() {
    }

    public Alcoholica(String codigo, String nombre, String fabricante, int cantidad, int precioNeto, int capacidad, int gradoAlcoholico, String tipo) {
        super(codigo, nombre, fabricante, cantidad, precioNeto, capacidad);
        this.gradoAlcoholico = gradoAlcoholico;
        this.tipo = tipo;
    }

    public int getGradoAlcoholico() {
        return this.gradoAlcoholico;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setGradoAlcoholico(int gradoAlcoholico) {
        this.gradoAlcoholico = gradoAlcoholico;
    }

    public void getTipo(String tipo) {
        this.tipo = tipo;
    }
}
