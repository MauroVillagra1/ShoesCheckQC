package Datos;

import Objetos.*;
import Sistema.*;
import Controladores.*;

public class Datos {

    public static Modelo[] ListaModelo = new Modelo[100]; // Variable movida al ámbito de la clase
    public static Empleado[] ListaEmpleado = new Empleado[100];
    public static Color[] ListaColor = new Color[100];
    public static Linea[] ListaLinea = new Linea[100];
    public static Color[][] coloresModelos = new Color[100][];
    public static OP[] ListaOP = new OP[100];
    public static Modelo[][] ListaModeloOP = new Modelo[100][];
    public static Linea[][] ListaLineaOP = new Linea[100][];
    public static Empleado[][] ListaEmpleadoOP = new Empleado[100][];
    public static Color[][] ListaColoresOP = new Color[100][];

    public static void LlenarArray() {

        ListaEmpleado[0] = new Empleado(43000000, "Juan Gomez", "JuanGomez@gmail.com", "123456", true);
        ListaEmpleado[1] = new Empleado(43000001, "Jose Lopez", "JoseLopez@gmail.com", "1234567", true);
        ListaEmpleado[2] = new Empleado(43000002, "Julian Garcia", "JulianGarcia@gmail.com", "12345678", true);
        
        
        
        ListaEmpleadoOP[0] = new Empleado[]{ListaEmpleado[0]};
        ListaLineaOP[0] = new Linea[]{ListaLinea[0]};
        ListaModeloOP[0] = new Modelo[]{ListaModelo[0]};
        
        ListaColor[0] = new Color(1, "Amarillo", true);
        ListaColor[1] = new Color(2, "Rojo", true);
        ListaColor[2] = new Color(3, "Azul", true);
        ListaColor[3] = new Color(4, "Verde", true);
        ListaColor[4] = new Color(5, "Morado", true);
        ListaColor[5] = new Color(6, "Negro", true);
        ListaColor[6] = new Color(7, "Blanco", true);
        ListaColor[7] = new Color(8, "Naranja", true);
        ListaColor[8] = new Color(9, "Celeste", true);
        ListaColor[9] = new Color(10, "Marron", true);

        ListaLinea[0] = new Linea(1, "Linea 1", true);
        ListaLinea[1] = new Linea(2, "Linea 1", true);
        ListaLinea[2] = new Linea(3, "Linea 1", true);
        ListaLinea[3] = new Linea(4, "Linea 1", true);
        ListaLinea[4] = new Linea(5, "Linea 1", true);
        ListaLinea[5] = new Linea(6, "Linea 1", true);
        ListaLinea[6] = new Linea(7, "Linea 1", true);
        ListaLinea[7] = new Linea(8, "Linea 1", true);
        ListaLinea[8] = new Linea(9, "Linea 1", true);
        ListaLinea[9] = new Linea(10, "Linea 1", true);

        coloresModelos[0] = new Color[]{ListaColor[4], ListaColor[1], ListaColor[2]};
        coloresModelos[1] = new Color[]{ListaColor[3], ListaColor[4], ListaColor[5]};
        coloresModelos[2] = new Color[]{ListaColor[6], ListaColor[7], ListaColor[8], ListaColor[9]};
        ListaModelo[0] = new Modelo(1, "Modelo 1", coloresModelos[0], true);
        ListaModelo[1] = new Modelo(2, "Modelo 2", coloresModelos[1], true);
        ListaModelo[2] = new Modelo(3, "Modelo 3", coloresModelos[2], true);

        
        
    }

    public static void MostrarModelos() {
        for (Modelo modelo : ListaModelo) {
            if (modelo != null) {
                System.out.println("ID: " + modelo.getSKU() + ", Nombre: " + modelo.getDescripcion() + ", Colores: ");
                for (Color color : modelo.getColores()) {
                    System.out.print(color.getColor() + " ");
                }
                System.out.println();
            }
        }
    }
}
