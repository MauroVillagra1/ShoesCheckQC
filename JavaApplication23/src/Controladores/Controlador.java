/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import View.Login;
import View.Principal;
import View.*;
import Datos.*;
import Objetos.*;
import Objetos.Empleado;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.DTD;

/**
 *
 * @author Mauro
 */
public class Controlador {

    static Color[] VectorColores = new Color[100];
    static Color[][] VectorColores2 = new Color[100][100];
    Datos dt = new Datos();
    static String AUX = "";
    static String AUX2 = "";
    static String AUX3 = "";
    static Login lg = new Login();
    static Principal pr = new Principal();
    static GestionColores gt = new GestionColores();
    static GestionModelos gm = new GestionModelos();
    static CrearOP cop = new CrearOP();
    static Empleado[] ListaEmpleado = new Empleado[100];
    static Color[] ListaColor = new Color[100];
    static Linea[] ListaLinea = new Linea[100];
    static Modelo[] ListaModelo = new Modelo[100];
    static Object[] fila = new Object[10];
    public static Modelo[][] ListaModeloOP = new Modelo[100][];
    public static Linea[][] ListaLineaOP = new Linea[100][];
    public static Empleado[][] ListaEmpleadoOP = new Empleado[100][];
    public static int a;
    public static int EmpleadoSistema;

    public static void VisualLogin() {
        lg.setVisible(true);
    }

    public static void Salir() {
        lg.getjTextField2().setText(null);
        lg.getjPasswordField1().setText(null);
        lg.setVisible(true);
    }

    public static void VisualCrearOP() {
        cop.setVisible(true);
        pr.setVisible(false);
    }

    public static void VisualGestionModelos() {
        pr.setVisible(false);
        gm.setVisible(true);
    }

    public static void ReiniciarColoresGestionModelo() {
        DefaultTableModel modelo = (DefaultTableModel) gm.getjTable1().getModel();
        modelo.setRowCount(0);
        LlenarTablaColoresGestionModelo();
        AUX2 = "";
    }

    public static void ReiniciarColores() {
/*        DefaultTableModel modelo = (DefaultTableModel) cop.getjTable1().getModel();*/
 /*       modelo.setRowCount(0);*/
        CargarLista();
        AUX = "";

    }

    public static void EliminarOP() {

        int valor2 = 0;
        String Var = cop.getjTextField1().getText();
        DefaultTableModel modelo = (DefaultTableModel) cop.getjTable2().getModel();

// Obtener el índice de la columna que deseas recorrer
        for (int fila = 0; fila < modelo.getRowCount(); fila++) {
            Object valor = modelo.getValueAt(fila, 0);
            valor2 = Integer.parseInt(String.valueOf(modelo.getValueAt(fila, 1)));
            System.out.println(String.valueOf(valor));
            System.out.println(String.valueOf(valor2));

            if (Var.equals(String.valueOf(valor))) {
                modelo.removeRow(fila);
            }

        }
        for (Linea linea : ListaLinea) {
            if (linea != null) {
                System.out.println("Pera");
                if (linea.getNumeroLinea() == (valor2)) {
                    linea.setDisponibilidadLinea(true);

                }
            }
        }
        for (Empleado empleado : ListaEmpleado) {
            if (empleado != null) {
                if (empleado.getDocumento() == Integer.parseInt(Var)) {
                    empleado.setDisponibilidadEmpleado(true);
                    System.out.println("Manzana");
                }
            }
        }

    }

    public static void AgregarOP2() {
        DefaultTableModel modelo = (DefaultTableModel) cop.getjTable2().getModel();
        modelo.setRowCount(0);
        String LineaSeleccionada = (String) cop.getjComboBox3().getSelectedItem();
        String ModeloSeleccionado = (String) cop.getjComboBox1().getSelectedItem();
        String ColorSeleccionado = (String) cop.getjComboBox2().getSelectedItem();
        int x = 0;
        int bandera1 = 0, bandera2 = 0;
        for (Empleado empleado : Datos.ListaEmpleado) {
            if (empleado != null) {
                if (String.valueOf(EmpleadoSistema).equals(String.valueOf(empleado.getDocumento())) && empleado.getDisponibilidadEmpleado() == true) {
                    empleado.setDisponibilidadEmpleado(false);
                    bandera1 = 1;
                    for (Linea linea : Datos.ListaLinea) {
                        if (linea != null) {
                            if (String.valueOf(LineaSeleccionada).equals(String.valueOf(linea.getNumeroLinea())) && linea.getDisponibilidadLinea() == true) {
                                linea.setDisponibilidadLinea(false);
                                bandera2 = 1;
                            }
                        }
                    }
                }
            }
        }

        for (OP op : Datos.ListaOP) {
            if (op != null) {
                x++;
            }
        }

        if (bandera1 == 1 && bandera2 == 1) {

            Datos.ListaOP[x + 1] = new OP((String.valueOf(EmpleadoSistema)), (String.valueOf(LineaSeleccionada)), (String.valueOf(ModeloSeleccionado)), (String.valueOf(ColorSeleccionado)), true);
        } else {
            JOptionPane.showMessageDialog(null, "La linea o el Usuario ya tienen asignado un OP");
        }
        System.out.println(Datos.ListaOP[x + 1]);
        ActualizarListaOP();

    }

    public static void EliminarListaOP() {
        String EliminarOP = String.valueOf(cop.getjTextField1().getText());
        
        for (OP op : Datos.ListaOP) {
            if (op != null) {
                if (op.getEmpleadoOP().equals(EliminarOP) && op.isEstadoOP() == true) {
                    op.setEstadoOP(false);
                    for (Empleado empleado : Datos.ListaEmpleado) {
                        if (empleado != null) {
                            if (String.valueOf(empleado.getDocumento()).equals(op.getEmpleadoOP())) {
                                empleado.setDisponibilidadEmpleado(true);
                            }
                        }
                    }
                    for (Linea linea : Datos.ListaLinea) {
                        if (linea != null) {
                            if (String.valueOf(linea.getNumeroLinea()).equals(op.getLineaOP())) {
                                linea.setDisponibilidadLinea(true);
                            }
                        }

                    }
                }
                else{
                JOptionPane.showMessageDialog(null, "La OP No existe");}
            }

        }
ActualizarListaOP();

    }

    public static void ActualizarListaOP() {
        DefaultTableModel modelox = (DefaultTableModel) cop.getjTable2().getModel();
                modelox.setRowCount(0);

        int x = 0;

        for (OP op : Datos.ListaOP) {
            if (op != null) {
                if (op.isEstadoOP() == true) {

                    fila[0] = String.valueOf(op.getEmpleadoOP());
                    fila[1] = String.valueOf(op.getLineaOP());
                    fila[2] = String.valueOf(op.getModeloOP());
                    fila[3] = String.valueOf(op.getColorOP());
                    modelox.addRow(fila);
                }
            }

        }
        CargarLista();
    }

    /*  public static void AgregarOP() {

        DefaultTableModel modelo = (DefaultTableModel) cop.getjTable1().getModel();
        modelo.setRowCount(0);
        String LineaSeleccionada = (String) cop.getjComboBox3().getSelectedItem();
        String ModeloSeleccionado = (String) cop.getjComboBox1().getSelectedItem();
        int i = 0;
        int x = 0;

        DefaultTableModel datosFila = (DefaultTableModel) cop.getjTable2().getModel();
        for (i = 0; i < 1; i++) {

            for (Empleado empleado : Datos.ListaEmpleado) {
                {
                    for (Linea linea : Datos.ListaLinea) {
                        if (empleado != null && linea != null) {
                            if (empleado.getDocumento() == (EmpleadoSistema) && empleado.getDisponibilidadEmpleado() == true && Integer.parseInt(LineaSeleccionada) == linea.getNumeroLinea() && linea.getDisponibilidadLinea() == true) {
                                empleado.setDisponibilidadEmpleado(false);
                                linea.setDisponibilidadLinea(false);

                                fila[0] = String.valueOf(EmpleadoSistema);
                                fila[1] = String.valueOf(LineaSeleccionada);
                                fila[2] = String.valueOf(ModeloSeleccionado);
                                fila[3] = String.valueOf(AUX);
                                datosFila.addRow(fila);
                                return;
                            } else if ((empleado.getDocumento() == (EmpleadoSistema) && empleado.getDisponibilidadEmpleado() == false) || (Integer.parseInt(LineaSeleccionada) == linea.getNumeroLinea() && linea.getDisponibilidadLinea() == false)) {
                                if (x == 0) {
                                    JOptionPane.showMessageDialog(null, "Este Usuario Ya ingreso una OP o la linea ya tiene asignada una OP");
                                    x = 1;
                                }
                            }

                        }
                    }
                }
            }

        }
        CargarLista();

    }
     */
    public static void VisualPrincipal() {
        pr.setVisible(true);
        cop.setVisible(false);
        lg.setVisible(false);
        gt.setVisible(false);
        gm.setVisible(false);
    }

    public static void LoginUser() {
        String contraing = lg.getjPasswordField1().getText();
        String usuarioing = lg.getjTextField2().getText();

        boolean bandera = false;
        for (Empleado empleado : Datos.ListaEmpleado) {

            if (empleado != null) {
                if (empleado.getCorreo().equals(usuarioing) && empleado.getContra().equals(contraing)) {
                    VisualPrincipal();
                    EmpleadoSistema = empleado.getDocumento();
                    lg.setVisible(false);
                    bandera = true;

                }
            }
        }

        if (bandera == false) {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectos", "Error de Inicio de Sesion", JOptionPane.ERROR_MESSAGE);
            lg.getjTextField2().setText(null);
            lg.getjPasswordField1().setText(null);

        }

    }

    public static void CargarColoresJComboBox() {
        cop.getjComboBox2().removeAllItems();

        for (Modelo modelo : Datos.ListaModelo) {
            if (modelo != null && cop.getjComboBox1() != null) {
                if (String.valueOf(modelo.getDescripcion()).equals(cop.getjComboBox1().getSelectedItem())) {
                    for (Color color : modelo.getColores()) {
                        if (color != null) {
                            if (color.getVisible() == true) {
                                cop.getjComboBox2().addItem(String.valueOf(color.getColor()));
                            }
                        }
                    }
                }
            }
        }
      /*  DefaultTableModel modelo = (DefaultTableModel) cop.getjTable1().getModel();
        modelo.setRowCount(0);*/
    }

    public static void EliminarColor() {
        int x = 0;
        int CodigoEliminar = Integer.parseInt(gt.getjTextField8().getText());

        for (Color color : Datos.ListaColor) {
            if (color != null && CodigoEliminar == color.getCodigoColor()) {
                color.setVisible(false);
                x = 1;
            }

        }
        if (x == 0) {
            JOptionPane.showMessageDialog(null, "El Codigo de Color no Existe");
        }
        gt.getjTextField8().setText(null);
    }

    public static void VisualGestionarColor() {
        gt.setVisible(true);
        pr.setVisible(false);
    }

    public static void ActualizarTablaGestionModelo() {

        String ColorSeleccionado = (String) gm.getjComboBox2().getSelectedItem();
        gm.getjComboBox2().removeItem(gm.getjComboBox2().getSelectedItem());
        int i = 0;
        a = 0;
        DefaultTableModel datosFila = (DefaultTableModel) gm.getjTable1().getModel();
        for (Color color : Datos.ListaColor) {
            if (color != null && gm.getjComboBox2() != null) {
                if (color.getVisible() == true) {
                    fila[0] = String.valueOf(color.getCodigoColor());
                    if (ColorSeleccionado.equals(color.getColor())) {
                        AUX2 = AUX2.concat(String.valueOf(color.getColor()).concat("  "));
                        a++;

                        fila[0] = String.valueOf(color.getCodigoColor());
                        fila[1] = String.valueOf(color.getColor());

                        i++;
                        datosFila.addRow(fila);

                    }
                }
            }
        }
        System.out.println(AUX2);

    }

    public static void LlenarTablaColoresGestionModelo() {
        gm.getjComboBox2().removeAllItems();
        for (Color color : Datos.ListaColor) {
            if (color != null) {
                gm.getjComboBox2().addItem(String.valueOf(color.getColor()));
            }
        }

    }

    public static void EliminarDatosTablaModeloGestion() {
        int x = 0;
        int CodigoEliminar = Integer.parseInt(gm.getjTextField10().getText());

        for (Modelo modelo : Datos.ListaModelo) {
            if (modelo != null && CodigoEliminar == modelo.getSKU()) {
                modelo.setVisibleModelo(false);
                x = 1;
            }

        }
        gm.getjTextField10().setText(null);
        CargarTablaModelosGestion();
    }

    public static void CargarNuevosDatosTablaModeloGestion() {
        DefaultTableModel datosFila = (DefaultTableModel) gt.getjTable1().getModel();

        int x = 0;
        for (Modelo modelo : Datos.ListaModelo) {
            if (modelo != null) {
                for (Color color : modelo.getColores()) {

                }
                x++;
            }
        }

        for (Modelo modelo : Datos.ListaModelo) {
            if (modelo != null) {
                if (modelo.getVisibleModelo() == true) {
                    fila[0] = String.valueOf(modelo.getSKU());
                    fila[1] = String.valueOf(modelo.getDescripcion());
                    Color[] DatosAux = new Color[10];
                    fila[2] = AUX2;
                    x++;
                    datosFila.addRow(fila);

                }
            }
        }

    }

    public static void CargarTablaModelosGestion() {
        DefaultTableModel datosFila = (DefaultTableModel) gm.getjTable2().getModel();
        datosFila.setRowCount(0);

        for (Modelo modelo : Datos.ListaModelo) {
            AUX3 = "";
            if (modelo != null && modelo.getVisibleModelo() == true) {

                for (Color color : modelo.getColores()) {
                    System.out.println(modelo.getColores());
                    if (color != null) {
                        if (color.getVisible() == true) {
                            AUX3 = AUX3.concat(String.valueOf(color.getColor()).concat("  "));
                        }
                    }

                }
                fila[0] = String.valueOf(modelo.getSKU());
                fila[1] = String.valueOf(modelo.getDescripcion());
                fila[2] = String.valueOf(AUX3);
                datosFila.addRow(fila);
            }
        }

    }

    public static void ModificarModelo() {
        int i = 0;
        a = 0;
        int t = 0;
        int x = 0, var = 0;
        int p = 0;
        int ModificarSkuModelo = Integer.parseInt(gm.getjTextField8().getText());
        DefaultTableModel datosFila = (DefaultTableModel) gm.getjTable1().getModel();
        String ModificarDescripcionModelo = String.valueOf(gm.getjTextField9().getText());

        for (Modelo modelo : Datos.ListaModelo) {
            if (modelo != null) {
                if (modelo.getDescripcion().equals(ModificarDescripcionModelo) && modelo.getVisibleModelo() == true) {
                    JOptionPane.showMessageDialog(null, "La Descripcion que ingresaste ya pertenece a otro modelo");
                    gm.getjTextField8().setText(null);
                    gm.getjTextField9().setText(null);
                    return;
                }
            }

        }

        for (i = 0; i < gm.getjTable1().getModel().getRowCount(); i++) {
            VectorColores[i] = new Color((Integer.parseInt(gm.getjTable1().getModel().getValueAt(i, 0).toString())), (String.valueOf(gm.getjTable1().getModel().getValueAt(i, 1).toString())), true);
            System.out.println(VectorColores[i]);
            t++;
        }
        for (Modelo modelo : Datos.ListaModelo) {
            if (modelo != null) {
                x++;
            }
        }
        for (p = 0; p < t; p++) {
            VectorColores2[t][p] = VectorColores[p];
        }
        x = 0;

        for (Modelo modelo : Datos.ListaModelo) {
            if (modelo != null) {
                x++;

                if (((modelo.getSKU() == ModificarSkuModelo) && ((modelo.getVisibleModelo()) == true))) {
                    modelo.setDescripcion(ModificarDescripcionModelo);

                    modelo.setColores(VectorColores2[t]);
                }
            }

        }

        gm.getjTextField8().setText(null);
        gm.getjTextField9().setText(null);
        CargarTablaModelosGestion();

    }

    public static void AgregarNuevoModelo() {
        int i = 0;
        a = 0;
        int t = 0;
        int x = 0, var = 0;
        int p = 0;
        int NuevoSKUModelo = Integer.parseInt(gm.getjTextField8().getText());
        String NuevoDescripcionModelo = String.valueOf(gm.getjTextField9().getText());

        DefaultTableModel datosFila = (DefaultTableModel) gm.getjTable1().getModel();
        for (i = 0; i < gm.getjTable1().getModel().getRowCount(); i++) {
            VectorColores[i] = new Color((Integer.parseInt(gm.getjTable1().getModel().getValueAt(i, 0).toString())), (String.valueOf(gm.getjTable1().getModel().getValueAt(i, 1).toString())), true);
            System.out.println(VectorColores[i]);
            System.out.println(Datos.coloresModelos);
            t++;
        }

        for (Modelo modelo : Datos.ListaModelo) {
            if (modelo != null) {
                x++;
            }
        }
        for (p = 0; p < t; p++) {
            VectorColores2[x + 1][p] = VectorColores[p];
        }
        x = 0;
        for (Modelo modelo : Datos.ListaModelo) {
            if (modelo != null) {
                x++;

                if (((modelo.getSKU() == NuevoSKUModelo) && ((modelo.getVisibleModelo()) == true)) || (((modelo.getVisibleModelo()) == true) && (NuevoDescripcionModelo.equals(modelo.getDescripcion())))) {
                    var = 1;
                }
            }

        }

        if (var == 1) {
            JOptionPane.showMessageDialog(null, "El Codigo del Color o el nombre Ya existe");
        } else {
            System.out.println(NuevoSKUModelo + "XD");
            System.out.println(NuevoDescripcionModelo + "XD2");
            System.out.println(VectorColores2[0] + "XD3");
            System.out.println(Datos.ListaModelo[x] + "XD4");

            Datos.ListaModelo[x + 1] = new Modelo(NuevoSKUModelo, NuevoDescripcionModelo, VectorColores2[x + 1], true);
            System.out.println(Datos.ListaModelo[x + 1] + "XD5");
        }

        gm.getjTextField8().setText(null);
        gm.getjTextField9().setText(null);

        CargarTablaModelosGestion();

    }

    public static void CargarLista() {
        cop.getjComboBox1().removeAllItems();
        cop.getjComboBox2().removeAllItems();
        cop.getjComboBox3().removeAllItems();

        String ModeloSelect = (String) cop.getjComboBox1().getSelectedItem();

        for (Modelo modelo : Datos.ListaModelo) {

            if (modelo != null) {
                if (modelo.getVisibleModelo() == true) {
                    cop.getjComboBox1().addItem(String.valueOf(modelo.getDescripcion()));
                }
            }
        }
        for (Linea linea : Datos.ListaLinea) {
            if (linea != null) {
                if (linea.getDisponibilidadLinea() == true) {
                    cop.getjComboBox3().addItem(String.valueOf(linea.getNumeroLinea()));
                }
            }
        }

    }

    public static void LlenarTablaGestionColores() {
        DefaultTableModel datosFila = (DefaultTableModel) gt.getjTable1().getModel();
        datosFila.setRowCount(0);
        for (Color color : Datos.ListaColor) {
            if (color != null) {
                if (color.getVisible() == true) {
                    fila[0] = String.valueOf(color.getCodigoColor());
                    fila[1] = String.valueOf(color.getColor());
                    datosFila.addRow(fila);
                }
            }
        }
    }

    public static void ModificacionColores() {
        int x = 0;
        int var = 0;
        int CodigoColor = Integer.parseInt(gt.getjTextField4().getText());
        String ColorModificar = String.valueOf(gt.getjTextField5().getText());
        for (Color color : Datos.ListaColor) {
            if (color != null) {
                if ((color.getColor().equals(ColorModificar)) && (color.getVisible() == true)) {
                    JOptionPane.showMessageDialog(null, "El Nombre del color ya existe");
                    gt.getjTextField4().setText(null);
                    gt.getjTextField5().setText(null);
                    return;
                }
            }

        }
        for (Color color : Datos.ListaColor) {
            if (color != null) {
                if ((color.getCodigoColor() == CodigoColor) && (color.getVisible() == true)) {
                    color.setColor(ColorModificar);
                }
            }
        }
        gt.getjTextField4().setText(null);
        gt.getjTextField5().setText(null);

        LlenarTablaGestionColores();
    }

    public static void AgregarColores() {
        int x = 0;
        int var = 0;
        int CodigoNuevo = Integer.parseInt(gt.getjTextField2().getText());
        String ColorNuevo = String.valueOf(gt.getjTextField3().getText());
        for (Color color : Datos.ListaColor) {
            if (color != null) {
                x++;
                if (((color.getCodigoColor() == CodigoNuevo) && ((color.getVisible()) == true)) || (((color.getVisible()) == true) && (ColorNuevo.equals(color.getColor())))) {
                    var = 1;
                }
            }

        }

        if (var == 1) {
            JOptionPane.showMessageDialog(null, "El Codigo del Color o el nombre Ya existe");
        } else {

            Datos.ListaColor[x + 1] = new Color(CodigoNuevo, ColorNuevo, true);
        }

        gt.getjTextField2().setText(null);
        gt.getjTextField3().setText(null);

        LlenarTablaGestionColores();
    }

    public static void AgregarColorAlModelo() {

        String ColorSeleccionado = (String) cop.getjComboBox2().getSelectedItem();
        cop.getjComboBox2().removeItem(cop.getjComboBox2().getSelectedItem());
        int i = 0;
        a = 0;
      /*  DefaultTableModel datosFila = (DefaultTableModel) cop.getjTable1().getModel();*/
        for (Color color : Datos.ListaColor) {
            if (color != null && cop.getjComboBox2() != null) {
                if (color.getVisible() == true) {
                    fila[0] = String.valueOf(color.getCodigoColor());
                    if (ColorSeleccionado.equals(color.getColor())) {
                        AUX = AUX.concat(String.valueOf(color.getColor()).concat("  "));
                        a++;
                        fila[0] = String.valueOf(color.getCodigoColor());
                        fila[1] = String.valueOf(color.getColor());

                        i++;
/*                        datosFila.addRow(fila);*/

                    }
                }
            }
        }

    }

}
