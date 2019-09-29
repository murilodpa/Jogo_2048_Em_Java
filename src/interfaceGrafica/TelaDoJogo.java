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

    private Color cor1;
    private Color cor2;
    private JPanel painelLogo;
    private JPanel painelPontuacao;
    private JPanel painelReiniciar;
    private final JLabel nomeDoJogo, pontuacao;
    private JLabel autor;
    private JLabel reiniciar;
    private Integer valor;

    public TelaDoJogo() {
        cor1 = new Color(102, 178, 255);
        cor2 = new Color(0, 128, 255);

        painelLogo = new JPanel();
        painelPontuacao = new JPanel();
        painelReiniciar = new JPanel();

        valor = 2048;

        nomeDoJogo = new JLabel("2048", JLabel.CENTER);
        autor = new JLabel();
        pontuacao = new JLabel("",JLabel.CENTER);
        reiniciar = new JLabel("",JLabel.CENTER);

        autor.setText("<html><center>MURILO ARAUJO<br></html>");
        pontuacao.setText("<html><center>PONTUAÇÃO<br>" + getValor() + "</html>");
        reiniciar.setText("<html><center>NOVO JOGO"+"</html>");

        painelLogo.setLayout(new BorderLayout());
        painelLogo.add(nomeDoJogo);
        painelLogo.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 3));

        painelPontuacao.setLayout(new BorderLayout());
        painelPontuacao.add(pontuacao);
        painelPontuacao.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 3));

        painelReiniciar.setLayout(new BorderLayout());
        painelReiniciar.add(reiniciar);
        painelReiniciar.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 3));
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
    
     /**
     * @return the painelPontuacao
     */
    public JPanel getPainelPontuacao() {
        return painelPontuacao;
    }

    /**
     * @param cor1 the cor1 to set
     */
    public void setCor1(Color cor1) {
        this.cor1 = cor1;
    }

    /**
     * @param cor2 the cor2 to set
     */
    public void setCor2(Color cor2) {
        this.cor2 = cor2;
    }

    /**
     * @param painelLogo the painelLogo to set
     */
    public void setPainelLogo(JPanel painelLogo) {
        this.painelLogo = painelLogo;
    }

    /**
     * @param painelPontuacao the painelPontuacao to set
     */
    public void setPainelPontuacao(JPanel painelPontuacao) {
        this.painelPontuacao = painelPontuacao;
    }

    /**
     * @return the painelReiniciar
     */
    public JPanel getPainelReiniciar() {
        return painelReiniciar;
    }

    /**
     * @param painelReiniciar the painelReiniciar to set
     */
    public void setPainelReiniciar(JPanel painelReiniciar) {
        this.painelReiniciar = painelReiniciar;
    }

    /**
     * @return the autor
     */
    public JLabel getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(JLabel autor) {
        this.autor = autor;
    }

    /**
     * @return the reiniciar
     */
    public JLabel getReiniciar() {
        return reiniciar;
    }

    /**
     * @param reiniciar the reiniciar to set
     */
    public void setReiniciar(JLabel reiniciar) {
        this.reiniciar = reiniciar;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Integer valor) {
        this.valor = valor;
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

        getPainelLogo().setBounds(265, 10, 130, 130);
        getPainelLogo().setBackground(Color.red);
        getPainelLogo().setVisible(true);

        getNomeDoJogo().setForeground(Color.BLACK);
        getNomeDoJogo().setBackground(Color.BLACK);
        getNomeDoJogo().setFont(new Font("Arial", Font.BOLD, 53));
        getNomeDoJogo().setVisible(true);

        getPainelPontuacao().setBounds(82, 40, 170, 100);
        getPainelPontuacao().setBackground(Color.red);
        getPainelPontuacao().setVisible(true);
        
        getPainelReiniciar().setBounds(408, 40, 170, 100);
        getPainelReiniciar().setBackground(Color.red);
        getPainelReiniciar().setVisible(true);

        getPontuacao().setForeground(Color.BLACK);
        getPontuacao().setBackground(Color.BLACK);
        getPontuacao().setFont(new Font("Arial", Font.BOLD, 25));
        getPontuacao().setVisible(true);

        getAutor().setForeground(Color.BLACK);
        getAutor().setBackground(Color.BLACK);
        getAutor().setFont(new Font("Arial", Font.BOLD, 25));
        getAutor().setBounds(200, 300, 100, 100);
        getAutor().setVisible(true);
        
        getReiniciar().setForeground(Color.BLACK);
        getReiniciar().setBackground(Color.BLACK);
        getReiniciar().setFont(new Font("Arial", Font.BOLD, 25));
        getReiniciar().setVisible(true);
    }
}
