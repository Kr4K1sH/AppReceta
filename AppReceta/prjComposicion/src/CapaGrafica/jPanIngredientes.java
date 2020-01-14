package CapaGrafica;

import Archivador.Archivador;

import CapaLogica.Ingrediente;

import UtilitarioVentana.UtilitarioVentana;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class jPanIngredientes extends JPanel {
    private JLabel jLabel1 = new JLabel();
    private JTextField jTxtDescripcion = new JTextField();
    private JSeparator jSeparator1 = new JSeparator();
    private JButton jBtnRegistrar = new JButton();
    private JButton jBtnSalir = new JButton();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextArea jTxAingrediente = new JTextArea();

    public jPanIngredientes() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(452, 315));

        jLabel1.setText("Descripción ");
        jLabel1.setBounds(new Rectangle(25, 35, 75, 25));
        jTxtDescripcion.setBounds(new Rectangle(105, 35, 185, 30));
        jSeparator1.setBounds(new Rectangle(5, 110, 445, 2));
        jBtnRegistrar.setText("Registar");
        jBtnRegistrar.setBounds(new Rectangle(25, 250, 140, 35));
        jBtnRegistrar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBtnRegistrar_actionPerformed(e);
                }
            });
        jBtnSalir.setText("Salir");
        jBtnSalir.setBounds(new Rectangle(265, 255, 140, 30));
        jBtnSalir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBtnSalir_actionPerformed(e);
                }
            });
        jScrollPane1.setBounds(new Rectangle(10, 125, 430, 115));
        jScrollPane1.getViewport().add(jTxAingrediente, null);
        this.add(jScrollPane1, null);
        this.add(jBtnSalir, null);
        this.add(jBtnRegistrar, null);
        this.add(jSeparator1, null);
        this.add(jTxtDescripcion, null);
        this.add(jLabel1, null);
        
    }

    private void jBtnRegistrar_actionPerformed(ActionEvent e) {
        Ingrediente miIngredi=new Ingrediente(this.jTxtDescripcion.getText());
        Archivador.getArrayIngrediente().add(miIngredi);
            this.jTxAingrediente.append(miIngredi+"\n");
    this.jTxtDescripcion.setText("");
    }

    private void jBtnSalir_actionPerformed(ActionEvent e) {
        UtilitarioVentana.CerrarPanel(this);
    }
}
