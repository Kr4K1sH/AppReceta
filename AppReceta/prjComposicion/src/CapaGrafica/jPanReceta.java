package CapaGrafica;

import CapaLogica.Ingrediente;
import CapaLogica.PorcionReceta;
import CapaLogica.Receta;
import CapaLogica.TipoReceta;

import UtilitarioVentana.UtilitarioVentana;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class jPanReceta extends JPanel {
    private JLabel jLabel1 = new JLabel();
    private JTextField jTxtNumReceta = new JTextField();
    private JLabel jLabel2 = new JLabel();
    private JTextField jTxtNombre = new JTextField();
    private JLabel jLabel3 = new JLabel();
    private JComboBox jCmbTipo = new JComboBox();
    private JLabel jLabel4 = new JLabel();
    private JTextField jTxtAutor = new JTextField();
    private JButton jBtnAgregarAutor = new JButton();
    private JLabel jLabel5 = new JLabel();
    private JTextField jTtxtFecha = new JTextField();
    private JLabel jLabel6 = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JButton jBtnAgregarReceta = new JButton();
    private JLabel jLabel7 = new JLabel();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JButton jBtnGuardarReceta = new JButton();
    private JButton jBtnSalir = new JButton();
    private JList jLstIngredientes = new JList();

    private JTextArea jTxApreparacion = new JTextArea();
    private DefaultListModel modeloLista = new DefaultListModel();
    Receta miReceta;

    public jPanReceta() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout(null);
        this.setSize(new Dimension(739, 739));
        this.addAncestorListener(new AncestorListener() {
            public void ancestorAdded(AncestorEvent e) {
                this_ancestorAdded(e);
            }

            public void ancestorRemoved(AncestorEvent e) {
            }

            public void ancestorMoved(AncestorEvent e) {
            }
        });
        jLabel1.setText("Num.Receta");
        jLabel1.setBounds(new Rectangle(20, 30, 80, 30));
        jTxtNumReceta.setBounds(new Rectangle(110, 30, 105, 30));
        jTxtNumReceta.setEditable(false);
        jLabel2.setText("Nombre");
        jLabel2.setBounds(new Rectangle(20, 85, 65, 25));
        jTxtNombre.setBounds(new Rectangle(110, 80, 170, 30));
        jLabel3.setText("Tipo");
        jLabel3.setBounds(new Rectangle(20, 135, 85, 25));
        jCmbTipo.setBounds(new Rectangle(105, 130, 225, 35));
        jLabel4.setText("Autor");
        jLabel4.setBounds(new Rectangle(20, 195, 65, 25));
        jTxtAutor.setBounds(new Rectangle(110, 195, 190, 30));
        jTxtAutor.setEditable(false);
        jBtnAgregarAutor.setText("Agregar Autor");
        jBtnAgregarAutor.setBounds(new Rectangle(360, 190, 150, 40));
        jBtnAgregarAutor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBtnAgregarAutor_actionPerformed(e);
            }
        });
        jLabel5.setText("Fecha");
        jLabel5.setBounds(new Rectangle(400, 35, 85, 30));
        jTtxtFecha.setBounds(new Rectangle(465, 30, 175, 35));
        jTtxtFecha.setEditable(false);
        jLabel6.setText("Ingredientes:");
        jLabel6.setBounds(new Rectangle(15, 340, 90, 20));
        jLabel6.setFont(new Font("Tahoma", 1, 12));
        jScrollPane1.setBounds(new Rectangle(125, 280, 410, 160));
        jBtnAgregarReceta.setText("Agregar Porción Receta");
        jBtnAgregarReceta.setBounds(new Rectangle(545, 330, 175, 45));
        jBtnAgregarReceta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBtnAgregarReceta_actionPerformed(e);
            }
        });
        jLabel7.setText("Preparación");
        jLabel7.setBounds(new Rectangle(20, 480, 125, 30));
        jLabel7.setFont(new Font("Tahoma", 1, 12));
        jScrollPane2.setBounds(new Rectangle(15, 520, 515, 210));
        jBtnGuardarReceta.setText("Guardar Receta");
        jBtnGuardarReceta.setBounds(new Rectangle(555, 570, 150, 35));
        jBtnGuardarReceta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBtnGuardarReceta_actionPerformed(e);
            }
        });
        jBtnSalir.setText("Salir");
        jBtnSalir.setBounds(new Rectangle(555, 635, 150, 35));
        jBtnSalir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBtnSalir_actionPerformed(e);
                }
            });
        this.add(jBtnSalir, null);
        this.add(jBtnGuardarReceta, null);
        jScrollPane2.getViewport().add(jTxApreparacion, null);
        this.add(jScrollPane2, null);
        this.add(jLabel7, null);
        this.add(jBtnAgregarReceta, null);
        jScrollPane1.getViewport().add(jLstIngredientes, null);
        this.add(jScrollPane1, null);
        this.add(jLabel6, null);
        this.add(jTtxtFecha, null);
        this.add(jLabel5, null);
        this.add(jBtnAgregarAutor, null);
        this.add(jTxtAutor, null);
        this.add(jLabel4, null);
        this.add(jCmbTipo, null);
        this.add(jLabel3, null);
        this.add(jTxtNombre, null);
        this.add(jLabel2, null);
        this.add(jTxtNumReceta, null);
        this.add(jLabel1, null);
    }

    public void llenarComboTipo() {
        this.jCmbTipo.removeAllItems();
        this.jCmbTipo.setModel(new DefaultComboBoxModel(TipoReceta.values()));
        this.jCmbTipo.setSelectedIndex(-1);

    }

    private void jBtnAgregarAutor_actionPerformed(ActionEvent e) {
        jDlgAutor jDlAutor = new jDlgAutor();
        jDlAutor.setJPanel(this);
        jDlAutor.setMiReceta(miReceta);
        UtilitarioVentana.centrarVentanaJDialog(jDlAutor);
        this.jTxtAutor.setText("" + miReceta.getObjAutor().getNombre());


    }

    private void this_ancestorAdded(AncestorEvent e) {
        miReceta = new Receta();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.jTxtNumReceta.setText("" + miReceta.getNumReceta());
        this.jTtxtFecha.setText("" + formato.format(this.miReceta.getFechaRegistro()));
        llenarComboTipo();

    }

    private void jBtnAgregarReceta_actionPerformed(ActionEvent e) {

        jDlgReceta jReceta = new jDlgReceta();
        jReceta.setReceta(miReceta);
        jReceta.setJPanel(this);
        UtilitarioVentana.centrarVentanaJDialog(jReceta);
        this.llenarLista();
    }

    public void llenarLista() {
        modeloLista.removeAllElements();
        for (PorcionReceta porcionReceta : miReceta.getArrayPorcIngrediente()) {
            modeloLista.addElement(porcionReceta);
        }
        this.jLstIngredientes.setModel(modeloLista);
    }

    private void jBtnGuardarReceta_actionPerformed(ActionEvent e) {
        if (this.jLstIngredientes.getSelectedIndex() != -1) {
            miReceta.setPreparacion(this.jTxApreparacion.getText());
            miReceta.setNombreReceta(this.jTxtNombre.getText());
            miReceta.setTipo((TipoReceta)this.jCmbTipo.getSelectedItem());
            JOptionPane.showMessageDialog(this, miReceta.toString());
        this.jTxApreparacion.setText(miReceta.toString());
       
        }
        
    }

    private void jBtnSalir_actionPerformed(ActionEvent e) {
        UtilitarioVentana.CerrarPanel(this);
    }
}
