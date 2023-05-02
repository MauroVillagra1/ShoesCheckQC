/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.lang.reflect.Array;
/**
 *
 * @author Mauro
 */
public class Modelo {
    private int SKU;
    private String Descripcion;
    private Color[] Colores;
    private boolean VisibleModelo;

    public Modelo(int SKU, String Descripcion, Color[] Colores, boolean VisibleModelo) {
        this.SKU = SKU;
        this.Descripcion = Descripcion;
        this.Colores = Colores;
        this.VisibleModelo = VisibleModelo;
    }

    public Modelo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getSKU() {
        return SKU;
    }

    public void setSKU(int SKU) {
        this.SKU = SKU;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Color[] getColores() {
        return Colores;
    }

    public void setColores(Color[] Colores) {
        this.Colores = Colores;
    }

    public boolean getVisibleModelo() {
        return VisibleModelo;
    }

    public void setVisibleModelo(boolean VisibleModelo) {
        this.VisibleModelo = VisibleModelo;
    }

   
}
