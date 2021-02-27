package clicker;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
/**
 *
 * @author JESUS
 */
public class InfoPanel extends JPanel{
    JLabel image, tooltip;
    
    public InfoPanel(){
//        setLayout(new GridLayout(2,1));
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints order = new GridBagConstraints();
        order.insets = new Insets(1,1,1,1);
        
        
        setBorder(new LineBorder(Color.BLACK));
        setFocusable(false);
        setSize(200, 300);
        image = new JLabel();
        image.setIcon(new ImageIcon("C:/Users/JESUS/Desktop/Pixel Art/placeholder.png"));
        image.setHorizontalAlignment(SwingConstants.CENTER);
        tooltip = new JLabel("Heisei's Simple Autoclicker");
        tooltip.setHorizontalAlignment(SwingConstants.CENTER);
        
        order.gridx = 0;
        order.gridy = 0;
        order.insets = new Insets(0,0,50,0);
        add(image, order);
        
        order.gridx = 0;
        order.gridy = 1;
        order.insets = new Insets(0,0,0,0);
        tooltip.setBorder(new SoftBevelBorder(3));
        add(tooltip, order);
        
        setVisible(true);
    }
}
