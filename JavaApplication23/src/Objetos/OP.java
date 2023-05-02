/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Mauro
 */
public class OP {
        private String EmpleadoOP, LineaOP, ColorOP, ModeloOP;
        private boolean EstadoOP;

    public OP(String EmpleadoOP, String LineaOP, String ColorOP, String ModeloOP, boolean EstadoOP) {
        this.EmpleadoOP = EmpleadoOP;
        this.LineaOP = LineaOP;
        this.ColorOP = ColorOP;
        this.ModeloOP = ModeloOP;
        this.EstadoOP = EstadoOP;
    }

    public String getEmpleadoOP() {
        return EmpleadoOP;
    }

    public void setEmpleadoOP(String EmpleadoOP) {
        this.EmpleadoOP = EmpleadoOP;
    }

    public String getLineaOP() {
        return LineaOP;
    }

    public void setLineaOP(String LineaOP) {
        this.LineaOP = LineaOP;
    }

    public String getColorOP() {
        return ColorOP;
    }

    public void setColorOP(String ColorOP) {
        this.ColorOP = ColorOP;
    }

    public String getModeloOP() {
        return ModeloOP;
    }

    public void setModeloOP(String ModeloOP) {
        this.ModeloOP = ModeloOP;
    }

    public boolean isEstadoOP() {
        return EstadoOP;
    }

    public void setEstadoOP(boolean EstadoOP) {
        this.EstadoOP = EstadoOP;
    }

    
    

    
   
}
