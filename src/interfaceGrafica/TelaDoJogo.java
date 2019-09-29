package interfaceGrafica;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public final class TelaDoJogo extends JPanel {

    private final Color cor1;
    private final Color cor2;
    private final JPanel painelLogo, painelPontuacao;
    private final JLabel nomeDoJogo, pontuacao;
    private Integer valor;

    public TelaDoJogo() {
        cor1 = new Color(102, 178, 255);
        cor2 = new Color(0, 128, 255);

        painelLogo = new JPanel();
        painelPontuacao = new JPanel();
        valor = 2048;

        nomeDoJogo = new JLabel("2048", JLabel.CENTER);
        pontuacao = new JLabel("html>! html>" + getValor(), JLabel.CENTER);
        pontuacao.setText("<html><center>PONTUAÇÃO<br>" + getValor() + "</html>");

        painelLogo.setLayout(new BorderLayout());
        painelLogo.add(nomeDoJogo);
        painelLogo.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 3));

        painelPontuacao.setLayout(new BorderLayout());
        painelPontuacao.add(pontuacao);
        painelPontuacao.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 3));
    }

    public Color getCor1() {
        return cor1;
    }

    public Color getCor2() {
        return cor2;
    }

    public JPanel getPainelLogo() {
        return painelLogo;
    }

    public JLabel getNomeDoJogo() {
        return nomeDoJogo;
    }
    
    /**
     * @return the pontuacao
     */
    public JLabel getPontuacao() {
        return pontuacao;
    }

    /**
     * @return the valor
     */
    public Integer getValor() {
        return valor;
    }

    
    @Override
    public void paintComponent(Graphics grafico2) {

        Graphics2D grafico = (Graphics2D) grafico2.create();

        grafico.setColor(getCor1());
        grafico.fillRect(0, 0, 660, 660);

        // Linhas Horizontais
        grafico.setStroke(new BasicStroke(14));
        grafico.setColor(getCor2());
        grafico.drawLine(90, 160, 570, 160);
        grafico.drawLine(90, 280, 570, 280);
        grafico.drawLine(90, 400, 570, 400);
        grafico.drawLine(90, 520, 570, 520);
        grafico.drawLine(90, 640, 570, 640);

        // Linhas Verticais
        grafico.drawLine(90, 160, 90, 640);
        grafico.drawLine(210, 160, 210, 640);
        grafico.drawLine(330, 160, 330, 640);
        grafico.drawLine(450, 160, 450, 640);
        grafico.drawLine(570, 160, 570, 640);

        getPainelLogo().setBounds(260, 5, 140, 140);
        getPainelLogo().setBackground(Color.red);
        getPainelLogo().setVisible(true);

        getNomeDoJogo().setForeground(Color.BLACK);
        getNomeDoJogo().setBackground(Color.BLACK);
        getNomeDoJogo().setFont(new Font("Arial", Font.BOLD, 60));
        getNomeDoJogo().setVisible(true);

        getPainelPontuacao().setBounds(82, 35, 170, 110);
        getPainelPontuacao().setBackground(Color.red);
        getPainelPontuacao().setVisible(true);

        getPontuacao().setForeground(Color.BLACK);
        getPontuacao().setBackground(Color.BLACK);
        getPontuacao().setFont(new Font("Arial", Font.BOLD, 25));
        getPontuacao().setVisible(true);
    }

    /**
     * @return the painelPontuacao
     */
    public JPanel getPainelPontuacao() {
        return painelPontuacao;
    }
}
