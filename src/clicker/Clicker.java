package clicker;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jnativehook.keyboard.*;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class Clicker extends JFrame{
    
    JMenuBar menubar;
    InfoPanel leftPanel;
    FunctionPanel centerPanel;
    StatusPanel rightPanel;
    AboutMenu menu;
    ClickerManager manager;
    
    
    public Clicker(){
        builder();
        centerPanel.setManager(manager);
    }
    
    public void builder(){
       setLayout(new GridLayout(1, 3));
       setSize(400,300);
       setTitle("Heisei's Simple Autoclicker");
       setResizable(false);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       //menu = new AboutMenu();
       //menubar = new JMenuBar();
       //setJMenuBar(menubar);
       //menubar.add(menu);
       //leftPanel = new InfoPanel();
       //add(leftPanel);
       centerPanel = new FunctionPanel();
       add(centerPanel);
       rightPanel = new StatusPanel();
       add(rightPanel);
       setVisible(true);
       manager = new ClickerManager(leftPanel, centerPanel, rightPanel);
       
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new Clicker();
            }});
        
    }
}
