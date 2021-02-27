/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author JESUS
 */
public class StatusPanel extends JPanel {
    private JLabel statusLabel, status;
    
    public StatusPanel() {
        setSize(200, 300);
        setLayout(new GridLayout(2,1));;
        setBorder(new EmptyBorder(10,10,10,10));
        statusLabel = new JLabel("STATUS");
        statusLabel.setBorder(new LineBorder(Color.BLACK));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        status = new JLabel("OFF");
        status.setBorder(new LineBorder(Color.BLACK));
        status.setHorizontalAlignment(SwingConstants.CENTER);
        setFocusable(false);
        
        add(statusLabel);
        add(status);
        setVisible(true);
    }
    
    public void updateLabel(int opt){
        switch (opt){
            case 0:status.setText("OFF");
                break;
            case 1:status.setText("ON");
                break;
        }
    }
    
}
