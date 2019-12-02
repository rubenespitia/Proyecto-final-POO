/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


//import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import Interfaces.Prueba;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


import clases.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CRUZLEIJA
 */
public class JFrameB extends JFrame {
 
 JTable tablaproductos = new javax.swing.JTable();

        
 Conectar con,con1,con2;
 Conectar con3 = new Conectar();
 Connection cn = con3.getConnection();
 String numero, clave;
 String producto, marca;
 
    public JFrameB() {
        inicializarComponentes();
        mostrarTabla();
    }
    
void mostrarTabla(){
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Clave");
    modelo.addColumn("Producto");
    modelo.addColumn("Cantidad");
    modelo.addColumn("Marca");
    
    tablaproductos.setModel(modelo);
    
    String sql = "SELECT * FROM productos";
    
    String datos [] = new String[4];
    Statement st;
    
     try {
         st = cn.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while(rs.next()){
             datos[0]=rs.getString(1);
             datos[1]=rs.getString(2);             
             datos[2]=rs.getString(3); 
             datos[3]=rs.getString(4); 
             modelo.addRow(datos);
         }
         tablaproductos.setModel(modelo);
         
     } catch (SQLException ex) {
         Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    }    
 

    private void inicializarComponentes() {
        // crear el componente para la parte central
        JPanel panelCentral = new JPanel(new GridLayout(5,2));
        // creamos los botones
        Dimension dim = new Dimension(10,10);
        JButtonB Conectar = new JButtonB("Conectar", dim, Color.yellow);
        JButtonB Guardar = new JButtonB("Guardar", dim, Color.yellow);
        JButtonB Borrar = new JButtonB("Borrar", dim, Color.yellow);
        JButtonB Modificar = new JButtonB("Modificar", dim, Color.blue);
        JButtonB Actualizar = new JButtonB("Actualizar", dim, Color.yellow);
        JButtonB AVISO = new JButtonB("Clave del Producto", dim, Color.green);
        JButtonB AVISO2 = new JButtonB("Nombre del Producto", dim, Color.green);
        JButtonB AVISO3 = new JButtonB("Numero de productos", dim, Color.green);
        JButtonB AVISO4 = new JButtonB("Marca", dim, Color.green);
        JButtonB AVISO5 = new JButtonB("Numero de Referencia", dim, Color.green);
        
        panelCentral.add(Conectar);
               panelCentral.add(AVISO);
        panelCentral.add(Guardar);
                panelCentral.add(AVISO2);
        panelCentral.add(Modificar);
                panelCentral.add(AVISO3);
        panelCentral.add(Borrar);
                panelCentral.add(AVISO4);
        panelCentral.add(Actualizar);
                 panelCentral.add(AVISO5);
        
        
        ////////////////////////////jtextfields
        JPanel panelText = new JPanel(new GridLayout(5,1));
        JTextField TextClave = new JTextField();
        JTextField TextProducto = new JTextField();
        JTextField TextNumero = new JTextField();
        JTextField TextMarca = new JTextField();
        JTextField TextNumref = new JTextField();
        panelText.add(TextClave);
        panelText.add(TextProducto);
        panelText.add(TextNumero);
        panelText.add(TextMarca);        
        panelText.add(TextNumref);    
        
        
        ////////////////Colocamos los elementos
        setLayout(new BorderLayout());
        add(panelCentral,BorderLayout.WEST);
        add(panelText,BorderLayout.CENTER);
        add(tablaproductos,BorderLayout.EAST);
        
        //////////////////////////Acciones
                Conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
                Guardar.setText("Guardar");
            Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt,TextClave.getText(),TextProducto.getText(),TextNumero.getText(),TextMarca.getText());
            }
        });
        
        

        Borrar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
         jButton3ActionPerformed(evt,TextClave.getText());
            }
        });
        
 
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt,TextClave.getText(),TextProducto.getText(),TextNumero.getText(),TextMarca.getText(),TextNumref.getText());
            }
        });
        
        
        
        //////////////5Especialito
        
        

        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt,TextClave,TextProducto,TextNumero,TextMarca,TextNumref);
            }
        });
        
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
    ///////////////////////////////////////////////////////////////////////Funciones de acciontes
        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        con = new Conectar();
        Connection reg = con.getConnection();
          
    } 
        
      private void jButton2ActionPerformed(java.awt.event.ActionEvent evt,String clave1,String producto1,String numero1, String marca1) {                                         
       con1= new Conectar();
       clave = clave1;
       producto = producto1;
       numero = numero1;
       marca =   marca1;
       
     try {
         Connection reg1 = con1.Subir(clave, producto, numero, marca);
         mostrarTabla();
     } catch (SQLException ex) {
         Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
     }
     
   
    }   
    
       private void jButton3ActionPerformed(java.awt.event.ActionEvent evt,String clave1) {                                         
       con2= new Conectar();
     try {
         Connection reg1 = con2.Borrar(clave1);
         mostrarTabla();
     } catch (SQLException ex) {
         Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
     }
    }    


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt,String clave1,String producto1,String numero1, String marca1, String numref) {                                         
     try {
         PreparedStatement pps = cn.prepareStatement("UPDATE productos Set Clave='"+clave1+"',Producto='"+producto1+"',Cantidad='"+numero1+"',Marca='"+marca1+"' WHERE Clave='"+numref+"'");
          pps.executeUpdate();
         JOptionPane.showMessageDialog(null, "Se actualizó sus datos");
         mostrarTabla();
     } catch (SQLException ex) {
         Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    
      private void jButton5ActionPerformed(java.awt.event.ActionEvent evt,JTextField clave1,JTextField producto1,JTextField numero1, JTextField marca1, JTextField buscar) {                                         
        int fila= tablaproductos.getSelectedRow();
        if(fila>=0)
        {
            buscar.setText(tablaproductos.getValueAt(fila, 0).toString());
            clave1.setText(tablaproductos.getValueAt(fila, 0).toString());
            producto1.setText(tablaproductos.getValueAt(fila, 1).toString());
            numero1.setText(tablaproductos.getValueAt(fila, 2).toString());
            marca1.setText(tablaproductos.getValueAt(fila, 3).toString());
        }
        else{
            JOptionPane.showMessageDialog(null, "No haz seleccionado fila");
        }
        
        
    }   
    
    
    
    
}