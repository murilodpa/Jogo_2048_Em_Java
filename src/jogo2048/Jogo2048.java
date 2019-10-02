package jogo2048;

import TelasComplementares.TelaFinal;
import TelasComplementares.TelaInicial;
import controleDoJogo.TelaGraficaEDeControle;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Murilo Araujo
 */
public class Jogo2048 {

    static JFrame telaDoJogo = new JFrame();
    static JFrame telaInicial = new JFrame();
    static JFrame telaFinal = new JFrame();
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException exception) {
                JOptionPane.showMessageDialog(null, "Erro ao criar o L&F do sistema! " + exception.getMessage());
            }

            //editarJanelaDoJogo();
           // editarJanelaInicial();
           editarJanelaFinal(); 
        });
    }

    public static void editarJanelaInicial() {
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaInicial.setTitle("JOGO 2048");
        telaInicial.setResizable(true);
        telaInicial.add(new TelaInicial(), BorderLayout.CENTER);
        telaInicial.pack();
        telaInicial.setLocationRelativeTo(null);
        telaInicial.setBackground(new Color(102, 178, 255));
        telaInicial.setVisible(true);
    }

    public static void editarJanelaDoJogo() {
        telaDoJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaDoJogo.setTitle("JOGO 2048");
        telaDoJogo.setResizable(true);
        telaDoJogo.add(new TelaGraficaEDeControle(), BorderLayout.CENTER);
        telaDoJogo.pack();
        telaDoJogo.setLocationRelativeTo(null);
        telaDoJogo.setBackground(new Color(102, 178, 255));
        telaDoJogo.setVisible(true);
    }
    
     public static void editarJanelaFinal() {
        telaFinal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaFinal.setTitle("JOGO 2048");
        telaFinal.setResizable(true);
        telaFinal.add(new TelaFinal(), BorderLayout.CENTER);
        telaFinal.pack();
        telaFinal.setLocationRelativeTo(null);
        telaFinal.setBackground(new Color(102, 178, 255));
        telaFinal.setVisible(true);
    }
}
