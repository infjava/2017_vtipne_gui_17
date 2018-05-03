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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    
    // Otazka           _OX
    // ====================
    // Spravis Informatiku?
    // Ano              Nie

    public VtipneOkno() {
        this.okno = new JFrame("Otazka");
        this.okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
                tlacice.add(nie);
                tlacice.add(ano);
                VtipneOkno.this.okno.revalidate();
            }
        });
        
        tlacice.add(ano);
        tlacice.add(nie);
        
        this.okno.add(tlacice, BorderLayout.SOUTH);
        
        this.okno.pack();
    }

    void zobraz() {
        this.okno.setVisible(true);
    }
}
