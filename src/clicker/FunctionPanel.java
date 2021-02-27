/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author JESUS
 */
public class FunctionPanel extends JPanel {

   private JLabel clickingSpeedLabel, clickingModeLabel, initialKeyLabel;
   private JButton triggerKeyChanger;
   private JComboBox speedCombobox;
   private JComboBox clickingModes;
   private JLabel triggerKey;
   
   ClickerManager manager;
    
    public FunctionPanel() {
        //setBorder(new LineBorder(Color.BLACK,2));
        setBorder(new EmptyBorder(10,10,10,10));
        setSize(200, 300);
        setLayout(new GridLayout(4, 1));
        
        setFocusable(false);
        
        //clickingSpeedLabel = new JLabel("Clicks per second:");
        //clickingSpeedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //clickingModeLabel = new JLabel("Clicking mode:");
        //initialKeyLabel = new JLabel("Activating key:");
        //initialKeyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clickingModes = new JComboBox(new String[]{"Left-click","Right-click"});
        clickingModes.setBorder(new EmptyBorder(10,10,10,10));
        clickingModes.setEditable(false);
        clickingModes.setFocusable(false);
        speedCombobox = new JComboBox(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20});
        speedCombobox.setBorder(new EmptyBorder(10,10,10,10));
        speedCombobox.setFocusable(false);
        //add(clickingSpeedLabel);
        add(speedCombobox);
        //add(clickingModeLabel);
        add(clickingModes);
        
        triggerKey = new JLabel("N");
        triggerKey.setBorder(new EmptyBorder(10,10,20,10));
        triggerKeyChanger = new JButton("Change trigger key");
        triggerKeyChanger.addActionListener(new changeTriggerKeyEvent());
        triggerKeyChanger.setFocusable(false);
        triggerKey.setHorizontalAlignment(SwingConstants.CENTER);
        //initialKeyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //add(initialKeyLabel);
        add(triggerKey);
        add(triggerKeyChanger);
        
        setVisible(true);
    }
    
    public void setManager(ClickerManager passedManager){
        manager = passedManager;
    }
    
    public void disableInput(){
        speedCombobox.setEnabled(false);
        clickingModes.setEnabled(false);
        triggerKeyChanger.setEnabled(false);
    }
    
    public void enableInput(){
        speedCombobox.setEnabled(true);
        clickingModes.setEnabled(true);
        triggerKeyChanger.setEnabled(true);
    }
    
    public void updateTriggerKeyLabel(String newTriggerKey){
        triggerKey.setText(newTriggerKey);
    }
    
    public void callChangerWindow(){
        new ChangeKeyWindow(this.manager);
    }
    
    public String getClickMode(){
        return clickingModes.getSelectedItem().toString();
    }
    
    public int getClickDelay(){
        return Integer.parseInt(speedCombobox.getSelectedItem().toString());
    }

    public class changeTriggerKeyEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            callChangerWindow();
        }

    }
    
}
