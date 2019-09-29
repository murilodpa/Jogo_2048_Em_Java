package controleDoJogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Murilo Araujo
 */
public class OrganizandoPaineisELabels extends JPanel{
    
    JPanel[] pPos;
    Integer x, y;
    Color corInicial;
    
    public OrganizandoPaineisELabels(){
        pPos = new JPanel[16];
        
        for(int i=0; i<16; i++){
        pPos[i] = new JPanel();
        pPos[i].setLayout(new BorderLayout());
        }
        
        x=97;
        y=167;
        
        corInicial= Color.red;
    }
    
    public void paintComponent(Graphics grafico) {
//private static Integer p0x=97, p1x=217, p2x=337, p3x=457, p4x=97, p5x=217, p6x=337, p7x=457, p8x=97, p9x=217, p10x=337, p11x=457, p12x=97, p13x=217, p14x=337, p15x=457;
//	private static Integer p0y=167, p1y=167, p2y=167, p3y=167, p4y=287, p5y=287, p6y=287, p7y=287, p8y=407, p9y=407, p10y=407, p11y=407, p12y=527, p13y=527, p14y=527, p15y=527;	

        //grafico.setFont(minhaFonte);
        for(int i=0; i<16; i++){
        pPos[i].setBounds(x, y, 106, 106);
        pPos[i].setBackground(corInicial);
        pPos[i].setVisible(true);
        x+=120;
        if(x==577){
            x=97;
            y+=120;
        }
        }
    }
}
