/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author JESUS
 */
public class ClickerManager {

    
    InfoPanel leftPanel;
    FunctionPanel centerPanel;
    StatusPanel rightPanel;
    
    int[] delayArray = new int[]{1000,500,333,250,200,166,143,125,111,100,91,83,77,71,67,63,59,56,52,50};
    
    
    private int clickingDelay = delayArray[0];
    private boolean currentlyAutoclicking = false;
    private boolean hasStarted = false;
    private SwingWorker<Void, Void> clicker;
    private SwingWorker<Void, Void> checker = new SwingWorker() {
        @Override
        protected Object doInBackground() throws Exception {
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((currentlyAutoclicking) && (!hasStarted)) {
                        updateDelay();
                        clicker = new SwingWorker() {
                            @Override
                            protected Object doInBackground() throws Exception {
                                while (currentlyAutoclicking) {
                                    if (centerPanel.getClickMode().equals("Left-click")) {
                                        click();
                                    }
                                    else if ((centerPanel.getClickMode().equals("Right-click"))){
                                        rightClick();
                                    }
                                }
                                return null;
                            }
                        };
                        clicker.execute();
                        hasStarted = true;
                    }
                }
            });
            timer.start();
            return null;
        }
    };
    private int triggerKey = NativeKeyEvent.VC_N;

    public ClickerManager(InfoPanel passedLeftPanel, FunctionPanel passedCenterPanel, StatusPanel passedRightPanel) {
        leftPanel = passedLeftPanel;
        centerPanel = passedCenterPanel;
        rightPanel = passedRightPanel;
        
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            Logger.getLogger(Clicker.class.getName()).log(Level.SEVERE, null, ex);
        }
        GlobalScreen.addNativeKeyListener(new CustomClickingEvent());
        checker.execute();
    }

    public void changeAutoState() {
        int decider = 0;

        if (currentlyAutoclicking) {
            decider = 1;
        } else if (!currentlyAutoclicking) {
            decider = 2;
        }

        switch (decider) {
            case 1:
                currentlyAutoclicking = false;
                hasStarted = false;
                centerPanel.enableInput();
                rightPanel.updateLabel(0);
                break;
            case 2:
                currentlyAutoclicking = true;
                centerPanel.disableInput();
                rightPanel.updateLabel(1);
                break;
        }
    }
    public void click() throws AWTException {
        Robot rob = new Robot();
        rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        rob.delay(clickingDelay);
    }
    public void rightClick() throws AWTException {
        Robot rob = new Robot();
        rob.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        rob.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        rob.delay(clickingDelay);
    }
    public int getTriggerKey(){
        return triggerKey;
    }
    public void setTriggerKey(int newTriggerKey){
        triggerKey = newTriggerKey;
        centerPanel.updateTriggerKeyLabel(NativeKeyEvent.getKeyText(newTriggerKey));
    }
    
    public void updateDelay(){
            clickingDelay = delayArray[centerPanel.getClickDelay()-1];
        }
    
    
    public class CustomClickingEvent implements NativeKeyListener {

        @Override
        public void nativeKeyTyped(NativeKeyEvent nativeEvent) {

        }
        @Override
        public void nativeKeyPressed(NativeKeyEvent nativeEvent) {

        }
        @Override
        public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
            if (nativeEvent.getKeyCode() == triggerKey) {
                changeAutoState();
            }
        }

    }
    
    
}
