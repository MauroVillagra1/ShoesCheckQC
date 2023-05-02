/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Mauro
 */
public class Linea {
    private int NumeroLinea;
    private String Descripcion;
    private boolean DisponibilidadLinea;

    public Linea(int NumeroLinea, String Descripcion, boolean DisponibilidadLinea) {
        this.NumeroLinea = NumeroLinea;
        this.Descripcion = Descripcion;
        this.DisponibilidadLinea = DisponibilidadLinea;
    }

    public int getNumeroLinea() {
        return NumeroLinea;
    }

    public void setNumeroLinea(int NumeroLinea) {
        this.NumeroLinea = NumeroLinea;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public boolean getDisponibilidadLinea() {
        return DisponibilidadLinea;
    }

    public void setDisponibilidadLinea(boolean DisponibilidadLinea) {
        this.DisponibilidadLinea = DisponibilidadLinea;
    }

    
    
    

}
