/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.logging.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.Principal;

/**
 *
 * @author Arlindo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
//            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            new Principal().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
