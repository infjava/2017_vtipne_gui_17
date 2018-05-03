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
        
        ano.addActionListener(new AnoListener());
        
        tlacice.add(ano);
        tlacice.add(nie);
        
        this.okno.add(tlacice, BorderLayout.SOUTH);
        
        this.okno.pack();
    }

    void zobraz() {
        this.okno.setVisible(true);
    }
}
