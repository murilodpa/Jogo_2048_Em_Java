package jogo2048;

import controleDoJogo.TelaGraficaEDeControle;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Murilo Araujo
 */
public class Jogo2048 {

    public static void main(String[] args) {
        /*  imprimirMatriz(matriz);
        gerarAleatorio(matriz);
        System.out.println("");
        imprimirMatriz(matriz);
        baixo(matriz);
        System.out.println("");
        imprimirMatriz(matriz);

        System.out.println("\n\n Pontuacao: " + pontuacao);
         */
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            //try {
            //  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException exception) {
            //  JOptionPane.showMessageDialog(null, "Erro ao criar o L&F do sistema! " + exception.getMessage());
            //}

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("JOGO 2048");
            //frame.setSize(676, 699);
            //frame.setLayout(null);
            frame.setResizable(true);
            frame.add(new TelaGraficaEDeControle(), BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            //frame.setLayout(null);
            frame.setBackground(new Color(102, 178, 255));
            frame.setVisible(true);
        });
    }

}
