package interfaceGrafica;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaDoJogo extends JPanel {

	private final Color cor1;
	private final Color cor2;
	private final JPanel painelLogo;
	private final JLabel nomeDoJogo;

	public TelaDoJogo() {
		cor1 = new Color(102, 178, 255);
		cor2 = new Color(0, 128, 255);

		painelLogo = new JPanel();
		nomeDoJogo = new JLabel("2048", JLabel.CENTER);

		painelLogo.setLayout(new BorderLayout());
		painelLogo.add(nomeDoJogo);
		painelLogo.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 3));
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
	 * 
	 */
	private static final long serialVersionUID = 1L; // Estava com Warning

	@Override
	public void paintComponent(Graphics grafico2) {

		Graphics2D grafico = (Graphics2D) grafico2.create();

		grafico.setColor(cor1);
		grafico.fillRect(0, 0, 660, 660);

		// Linhas Horizontais
		grafico.setStroke(new BasicStroke(14));
		grafico.setColor(cor2);
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

		painelLogo.setBounds(260, 5, 140, 140);
		painelLogo.setBackground(Color.red);
		painelLogo.setVisible(true);

		nomeDoJogo.setForeground(Color.BLACK);
		nomeDoJogo.setBackground(Color.BLACK);
		nomeDoJogo.setFont(new Font("Arial", Font.BOLD, 60));
		nomeDoJogo.setVisible(true);
	}

}