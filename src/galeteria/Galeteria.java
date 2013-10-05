/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package galeteria;

import java.util.logging.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.Principal;

/**
 *
 * @author Arlindo
 */
public class Galeteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            new Principal().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Galeteria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Galeteria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Galeteria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Galeteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
