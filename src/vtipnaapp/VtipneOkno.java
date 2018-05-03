/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vtipnaapp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author janik
 */
class VtipneOkno {

    private final JFrame okno;
    private boolean prveAno;
    
    // Otazka           _OX
    // ====================
    // Spravis Informatiku?
    // Ano              Nie

    public VtipneOkno() {
        this.okno = new JFrame("Otazka");
        this.okno.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        this.okno.setLayout(new BorderLayout());
        
        this.okno.add(new JLabel("Spravis Informatiku?"), BorderLayout.CENTER);
        
        JPanel tlacice = new JPanel();
        tlacice.setLayout(new GridLayout(1, 2));
        
        final JButton ano = new JButton("Ano");
        final JButton nie = new JButton("Nie");
        
        ano.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Tak sa drz!");
            System.exit(0);
        });
        
        nie.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "To fakt?");
            System.exit(0);
        });
        
        nie.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                tlacice.removeAll();
                
                if (VtipneOkno.this.prveAno) {
                    tlacice.add(nie);
                    tlacice.add(ano);
                } else {
                    tlacice.add(ano);
                    tlacice.add(nie);
                }
                
                VtipneOkno.this.prveAno = !VtipneOkno.this.prveAno;
                
                VtipneOkno.this.okno.revalidate();
            }
        });
        
        nie.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                ano.requestFocus();
            }
            
        });
        
        this.prveAno = true;
        tlacice.add(ano);
        tlacice.add(nie);
        
        this.okno.add(tlacice, BorderLayout.SOUTH);
        
        this.okno.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Skutocne chces vzdat taku lahku otazku?");
            }
            
        });
        
        this.okno.pack();
    }

    void zobraz() {
        this.okno.setVisible(true);
    }
}
