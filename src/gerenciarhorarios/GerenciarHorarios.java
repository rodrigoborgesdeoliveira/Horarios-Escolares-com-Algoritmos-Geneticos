/*
 * Sistema computacional para alocar horários escolares utilizando inteligência
 * artificial (algoritmos genéticos).
 */
package gerenciarhorarios;

import interfaces.Login;
import interfaces.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Rodrigo Borges de Oliveira
 */
public class GerenciarHorarios {
    public static void main(String[] args) {
        //Utilizar a aparência do sistema.
        String laf = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(laf);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException 
                | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new Login().setVisible(true);
    }
}
