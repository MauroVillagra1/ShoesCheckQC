/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Mauro
 */
public class Color {
    private int CodigoColor;
    private String Color;
    boolean Visible;

    public Color(int CodigoColor, String Color, boolean Visible) {
        this.CodigoColor = CodigoColor;
        this.Color = Color;
        this.Visible = Visible;
    }

    public Color() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCodigoColor() {
        return CodigoColor;
    }

    public void setCodigoColor(int CodigoColor) {
        this.CodigoColor = CodigoColor;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public boolean getVisible() {
        return Visible;
    }

    public void setVisible(boolean Visible) {
        this.Visible = Visible;
    }

    public int setCodigoColor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
