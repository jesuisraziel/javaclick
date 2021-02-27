package clicker;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
/**
 *
 * @author JESUS
 */
public class ChangeKeyWindow extends JFrame {
    JLabel notice,currentTriggerNotice;
    ClickerManager manager;
    JButton bind, cancel;
    int currentTriggerKeyCopy;
    
    public ChangeKeyWindow(ClickerManager passedManager){
        manager = passedManager;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setFocusable(false);
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            Logger.getLogger(ChangeKeyWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        GlobalScreen.addNativeKeyListener(new KeyChangeEvent());
        currentTriggerKeyCopy = manager.getTriggerKey();
        setLayout(new GridLayout(4,1));
        setLocationRelativeTo(null);
        setResizable(false);
        notice = new JLabel("Press any key.");
        notice.setBorder(new EmptyBorder(10,10,10,10));
        notice.setHorizontalAlignment(0);
        currentTriggerNotice = new JLabel("Current trigger key: " + NativeKeyEvent.getKeyText(currentTriggerKeyCopy));
        currentTriggerNotice.setHorizontalAlignment(0);
        currentTriggerNotice.setBorder(new EmptyBorder(10,10,20,10));
        bind = new JButton("Bind");
        cancel = new JButton("Cancel");
        bind.setFocusable(false);
        cancel.setFocusable(false);
        bind.addActionListener(new ButtonEvents());
        cancel.addActionListener(new ButtonEvents());
        add(notice);
        add(currentTriggerNotice);
        add(bind);
        add(cancel);
        pack();
        setVisible(true);
    };

    
    public class KeyChangeEvent implements NativeKeyListener {

        @Override
        public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
            
        }

        @Override
        public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
            
        }

        @Override
        public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
            currentTriggerNotice.setText("New trigger key: " + NativeKeyEvent.getKeyText(nativeEvent.getKeyCode()));
            currentTriggerKeyCopy = nativeEvent.getKeyCode();
        }
    }
    public class ButtonEvents implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Cancel")){
                dispose();
            }
            
            if (e.getActionCommand().equals("Bind")){
                manager.setTriggerKey(currentTriggerKeyCopy);
                dispose();
            }
        }
    
    }
    
    public static void main(String[] args){
        
    }
}
