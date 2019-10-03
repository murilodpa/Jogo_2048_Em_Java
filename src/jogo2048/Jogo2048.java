package jogo2048;

import TelasComplementares.CriarTelasDoJogo;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Murilo Araujo
 */
public abstract class Jogo2048 {

    static JFrame telaDoJogo = new JFrame();
    static JFrame telaInicial = new JFrame();
    static JFrame telaFinal = new JFrame();
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException exception) {
                JOptionPane.showMessageDialog(null, "Erro ao criar a frame! " + exception.getMessage());
            }

            CriarTelasDoJogo telasDoJogo = new CriarTelasDoJogo();
           // editarJanelaInicial();
           //editarJanelaFinal(); 
        });
    }
}
