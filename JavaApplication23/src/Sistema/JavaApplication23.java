/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Sistema;
import Controladores.Controlador;
import Controladores.*;
import Datos.*;

/**
 *
 * @author Mauro
 */
public class JavaApplication23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controlador.VisualLogin();
        
        Datos.LlenarArray();
        
        Datos.MostrarModelos();
        Controlador.CargarLista();
        Controlador.CargarColoresJComboBox();

    }
    
}
