package CapaGrafica;

import CapaLogica.Autor;
import CapaLogica.Receta;

import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class jDlgAutor extends JDialog {
    private JLabel jLabel1 = new JLabel();
    private JTextField jTxtNombre = new JTextField();
    private JTextField jTxtTelefono = new JTextField();
    private JLabel jLabel2 = new JLabel();
    private JButton jBtnRegistrar = new JButton();
private jPanReceta jPanel;
private Receta miReceta;
    public jDlgAutor() {
        this(null, "", false);
    }

    public jDlgAutor(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(400, 282));
        this.getContentPane().setLayout( null );
        jLabel1.setText("Nombre");
        jLabel1.setBounds(new Rectangle(10, 40, 55, 40));
        jTxtNombre.setBounds(new Rectangle(70, 45, 150, 30));
        jTxtTelefono.setBounds(new Rectangle(70, 115, 150, 30));
        jLabel2.setText("Telefono");
        jLabel2.setBounds(new Rectangle(15, 120, 65, 25));
        jBtnRegistrar.setText("Registrar");
        jBtnRegistrar.setBounds(new Rectangle(250, 80, 115, 35));
        jBtnRegistrar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBtnRegistrar_actionPerformed(e);
                }
            });
        this.getContentPane().add(jBtnRegistrar, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jTxtTelefono, null);
        this.getContentPane().add(jTxtNombre, null);
        this.getContentPane().add(jLabel1, null);
    }

    private void jBtnRegistrar_actionPerformed(ActionEvent e) {
        
        Autor miAutor =new Autor(this.jTxtNombre.getText(),this.jTxtTelefono.getText());
        miReceta.setObjAutor(miAutor);
        this.jTxtNombre.setText("");
        this.jTxtTelefono.setText("");
        this.dispose();
    }

    public void setJPanel(jPanReceta jPanel) {
        this.jPanel = jPanel;
    }

    public jPanReceta getJPanel() {
        return jPanel;
    }

    public void setMiReceta(Receta miReceta) {
        this.miReceta = miReceta;
    }

    public Receta getMiReceta() {
        return miReceta;
    }
}
