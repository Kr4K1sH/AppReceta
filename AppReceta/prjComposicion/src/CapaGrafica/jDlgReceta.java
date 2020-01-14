package CapaGrafica;

import Archivador.Archivador;

import CapaLogica.Ingrediente;
import CapaLogica.PorcionReceta;

import CapaLogica.Receta;
import CapaLogica.UnidadMedida;

import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class jDlgReceta extends JDialog {
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JButton jBtnRegistrar = new JButton();
    private JComboBox jCmbIngredientes = new JComboBox();
    private JComboBox jCmbUnidadMedida = new JComboBox();
    private JTextField jTxtCantidad = new JTextField();
    private JTextField jTxtPrecio = new JTextField();
    private jPanReceta jPanel;
    private Receta receta;
  
    public jDlgReceta() {
        this(null, "", false);
    }

    public jDlgReceta(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(521, 358));
        this.getContentPane().setLayout(null);
        jLabel1.setText("Ingredientes");
        jLabel1.setBounds(new Rectangle(10, 35, 105, 30));
        jLabel2.setText("Unidad Medida");
        jLabel2.setBounds(new Rectangle(10, 95, 135, 40));
        jLabel3.setText("Cantidad");
        jLabel3.setBounds(new Rectangle(10, 155, 100, 30));
        jLabel4.setText("Precio");
        jLabel4.setBounds(new Rectangle(15, 200, 100, 30));
        jBtnRegistrar.setText("Registrar");
        jBtnRegistrar.setBounds(new Rectangle(175, 270, 150, 35));
        jBtnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBtnRegistrar_actionPerformed(e);
            }
        });
        jCmbIngredientes.setBounds(new Rectangle(100, 40, 190, 35));
        jCmbUnidadMedida.setBounds(new Rectangle(100, 100, 190, 35));
        jTxtCantidad.setBounds(new Rectangle(95, 155, 145, 35));
        jTxtPrecio.setBounds(new Rectangle(95, 205, 145, 30));
        this.getContentPane().add(jTxtPrecio, null);
        this.getContentPane().add(jTxtCantidad, null);
        this.getContentPane().add(jCmbUnidadMedida, null);
        this.getContentPane().add(jCmbIngredientes, null);
        this.getContentPane().add(jBtnRegistrar, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
        this.llenarComboIngredientes();
        this.llenarComboMedida();
    }

    public void llenarComboIngredientes() {
        this.jCmbIngredientes.removeAllItems();
        for (Ingrediente ingre : Archivador.getArrayIngrediente()) {
            this.jCmbIngredientes.addItem(ingre);
            this.jCmbIngredientes.setSelectedIndex(-1);
        }

    }

    public void llenarComboMedida() {
        this.jCmbUnidadMedida.removeAllItems();
        this.jCmbUnidadMedida.setModel(new DefaultComboBoxModel(UnidadMedida.values()));
        this.jCmbIngredientes.setSelectedIndex(-1);
    }

    private void jBtnRegistrar_actionPerformed(ActionEvent e) {
        receta.agregarPocionIngrediente((Ingrediente)this.jCmbIngredientes.getSelectedItem(),
                                        Double.parseDouble(this.jTxtCantidad.getText()),
                                        Double.parseDouble(this.jTxtPrecio.getText()),
                                        (UnidadMedida)this.jCmbUnidadMedida.getSelectedItem());
        JOptionPane.showMessageDialog(this, "Porción agregada");
       
        this.dispose();
       

    }


    public void setJPanel(jPanReceta jPanel) {
        this.jPanel = jPanel;
    }

    public jPanReceta getJPanel() {
        return jPanel;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Receta getReceta() {
        return receta;
    }

}
