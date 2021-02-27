/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
/**
 *
 * @author JESUS
 */
public class AboutMenu extends JMenu{
    JMenuItem about;
    
   public AboutMenu(){
       setText("Options");
       about = new JMenuItem("About");
       about.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               new AboutPopup();
           }
       
       });
       
       add(about);
       
   };
   
   
   
}
