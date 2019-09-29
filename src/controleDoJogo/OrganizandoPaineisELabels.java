package controleDoJogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Murilo Araujo
 */
public class OrganizandoPaineisELabels extends JPanel {

    JPanel[] pPos;
    JLabel[] lPos;
    Integer x, y;
    Color corInicial;

    public OrganizandoPaineisELabels() {
        pPos = new JPanel[16];
        lPos = new JLabel[16];

        for (int i = 0; i < 16; i++) {
            pPos[i] = new JPanel();
            pPos[i].setLayout(new BorderLayout());
            
            lPos[i] = new JLabel("2", JLabel.CENTER);
            
            pPos[i].add(lPos[i]);
        }

        x = 97;
        y = 167;

        corInicial = Color.red;
    }

    public void paintComponent(Graphics grafico) {

        //grafico.setFont(minhaFonte);
        for (int i = 0; i < 16; i++) {
            pPos[i].setBounds(x, y, 106, 106);
            pPos[i].setBackground(corInicial);
            pPos[i].setVisible(true);
            x += 120;
            if (x == 577) {
                x = 97;
                y += 120;
            }

        lPos[i].setForeground(Color.BLACK);
        lPos[i].setFont(new Font("Arial", Font.BOLD, 60));
        lPos[i].setVisible(true);
        }
    }
}
