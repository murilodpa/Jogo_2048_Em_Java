package TelasComplementares;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Murilo Araujo
 */
public class TelaFinal extends JPanel implements MouseListener{
    
    public TelaFinal(){
        setPreferredSize(new Dimension(660, 660));
        setFocusable(true);
    }
    
    public void telaDeFim(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRoundRect(265, 14, 135, 135, 25, 25);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 50)); //2048
        g.drawString("2048", 275, 98); //2048
    }
    
    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponents(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        telaDeFim(g);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}