package TelasComplementares;

import controleDoJogo.TelaGraficaEDeControle;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jogo2048.Jogo2048;

public class CriarTelasDoJogo extends Jogo2048 {

    JFrame telaDoJogo = new JFrame();
    JFrame telaInicial = new JFrame();
    JFrame telaFinal = new JFrame();
    static boolean flagIniciar = false;
    static boolean flagSair = false;

//    ImageIcon iconRaio = new ImageIcon(getClass().getResource("RAIO.gif"));
    //   JLabel labelRaio = new JLabel(iconRaio);
    public CriarTelasDoJogo() {
        SwingUtilities.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException exception) {
                JOptionPane.showMessageDialog(null, "Erro ao criar a frame! " + exception.getMessage());
            }

            //if(flagSair==false)
            //editarJanelaInicial();
            //if (flagSair == true) {
              //  telaInicial.dispose();
            //} else {
              //  if (flagIniciar == true) {
                    editarJanelaDoJogo();
                //    telaInicial.dispose();
               // }
            //}
            //editarJanelaFinal(); 
        });
    }

    public void editarJanelaInicial() {
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaInicial.setTitle("JOGO 2048");
        telaInicial.setResizable(true);
        telaInicial.add(new TelaInicial(), BorderLayout.CENTER);
        telaInicial.pack();
        telaInicial.setLocationRelativeTo(null);
        telaInicial.setBackground(new Color(102, 178, 255));
        telaInicial.setVisible(true);
    }

    public void editarComponente() {

    }

    public void editarJanelaDoJogo() {
        telaDoJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaDoJogo.setTitle("JOGO 2048");
        telaDoJogo.setResizable(false);
        telaDoJogo.add(new TelaGraficaEDeControle(), BorderLayout.CENTER);
        telaDoJogo.pack();
        telaDoJogo.setLocationRelativeTo(null);
        telaDoJogo.setBackground(new Color(102, 178, 255));
        telaDoJogo.setVisible(true);
    }

    public void editarJanelaFinal() {
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
