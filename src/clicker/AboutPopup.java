/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author JESUS
 */
public class AboutPopup extends JFrame {
       JLabel info1, info2;
       JLabel contact;
       public AboutPopup(){
           info1 = new JLabel("Made by Heisei, because sometimes you might just need a simple thing.");
           info2 = new JLabel("No matter how ugly or badly written.");
           contact = new JLabel("@jesuisheisei");
           setSize(500,100);
           setLayout(new GridLayout(3,1));
           setResizable(false);
           setTitle("About");
           setFocusable(false);
           setDefaultCloseOperation(DISPOSE_ON_CLOSE);
           add(info1);
           add(info2);
           add(contact);
           setLocationRelativeTo(null);
           setVisible(true);
       }
       
       public static void main(String[] args){
           new AboutPopup();
       }
   }
