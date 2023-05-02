/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Mauro
 */
public class Empleado {
    private int Documento;
    private String ApellidoyNombre;
    private String Correo;
    private String Contra;
    private boolean DisponibilidadEmpleado;

    public Empleado(int Documento, String ApellidoyNombre, String Correo, String Contra, boolean DisponibilidadEmpleado) {
        this.Documento = Documento;
        this.ApellidoyNombre = ApellidoyNombre;
        this.Correo = Correo;
        this.Contra = Contra;
        this.DisponibilidadEmpleado = DisponibilidadEmpleado;
    }

    public int getDocumento() {
        return Documento;
    }

    public void setDocumento(int Documento) {
        this.Documento = Documento;
    }

    public String getApellidoyNombre() {
        return ApellidoyNombre;
    }

    public void setApellidoyNombre(String ApellidoyNombre) {
        this.ApellidoyNombre = ApellidoyNombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContra() {
        return Contra;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }

    public boolean getDisponibilidadEmpleado() {
        return DisponibilidadEmpleado;
    }

    public void setDisponibilidadEmpleado(boolean DisponibilidadEmpleado) {
        this.DisponibilidadEmpleado = DisponibilidadEmpleado;
    }

    
}