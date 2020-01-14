package CapaGrafica;

import UtilitarioVentana.UtilitarioVentana;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class jFrmMenuPrincipal extends JFrame {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu();
    private JMenuItem menuFileExit = new JMenuItem();
    private JMenu jMenu1 = new JMenu();
    private JMenuItem jMenuItem1 = new JMenuItem();
    private JMenuItem jMenuItem2 = new JMenuItem();
JDesktopPane oEcritorioPane =new JDesktopPane();
    public jFrmMenuPrincipal() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.add(oEcritorioPane);
        this.setJMenuBar( menuBar );
       // this.getContentPane().setLayout( null );
        this.setSize( new Dimension(400, 300) );
        menuFile.setText("Archivador");
        menuFileExit.setText( "Exit" );
        menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { fileExit_ActionPerformed( ae ); } } );
        jMenu1.setText("Recetario");
        jMenuItem1.setText("Registrar Ingrediente");
        jMenuItem1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jMenuItem1_actionPerformed(e);
                }
            });
        jMenuItem2.setText("Registrar Receta");
        jMenuItem2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jMenuItem2_actionPerformed(e);
                }
            });
        menuFile.add( menuFileExit );
        menuBar.add( menuFile );
        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);
        menuBar.add(jMenu1);
    }

    void fileExit_ActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void jMenuItem1_actionPerformed(ActionEvent e) {
        jPanIngredientes jPanel=new jPanIngredientes();
        UtilitarioVentana.centrarVentanaJPanel(this, "Registro de ingredientes", jPanel, oEcritorioPane);
    }

    private void jMenuItem2_actionPerformed(ActionEvent e) {
        jPanReceta jPanel=new jPanReceta();
        UtilitarioVentana.centrarVentanaJPanel(this, "Registro de receta", jPanel, oEcritorioPane);
    }
}
