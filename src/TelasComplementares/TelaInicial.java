package TelasComplementares;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Murilo Araujo
 */
public class TelaInicial extends JPanel implements MouseListener{
    
     private Color corFundo;
     private Color corLinhas;
     
     private Integer clickX, clickY;
     
    public TelaInicial(){
        corFundo = new Color(102, 178, 255);
        corLinhas = new Color(0, 128, 255);
        setPreferredSize(new Dimension(660, 660));
        setFocusable(true);
        addMouseListener(this);
    }
    
    public void TelaDeInicio(Graphics2D g) {
        
        g.setStroke(new BasicStroke(7));
        g.setColor(Color.BLACK);
        g.drawRoundRect(100, 160, 460, 475, 25, 25);
        g.setColor(corLinhas);
        g.fillRoundRect(100, 160, 460, 475, 25, 25);
        
        g.setStroke(new BasicStroke(7));
        g.setColor(Color.BLACK);
        g.drawRoundRect(130, 180, 400, 150, 25, 25);
        g.setColor(Color.red);
        g.fillRoundRect(130, 180, 400, 150, 25, 25);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 72)); //Escrever 2048
        g.drawString("JOGO 2048", 135, 280); //Escrever 2048
        
        g.setStroke(new BasicStroke(4));
        g.setColor(Color.BLACK);
        g.drawRoundRect(206, 360, 250, 70, 25, 25);
        g.setColor(Color.red);
        g.fillRoundRect(206, 360, 250, 70, 25, 25);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 40)); //Escrever 2048
        g.drawString("NOVO JOGO", 208, 408); //Escrever 2048
        
        g.setStroke(new BasicStroke(4));
        g.setColor(Color.BLACK);
        g.drawRoundRect(250, 510, 160, 70, 25, 25);
        g.setColor(Color.red);
        g.fillRoundRect(250, 510, 160, 70, 25, 25);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 40)); //Escrever 2048
        g.drawString("SAIR", 284, 560); //Escrever 2048
    }
    
    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponents(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        TelaDeInicio(g);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        try {
            clickX = e.getX();
            clickY = e.getY();
        } catch (java.lang.NullPointerException e1) {
        }

        System.out.println("click x: " + clickX + " clickY: " + clickY);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        if (clickX > 210 && clickX < 455 && clickY > 362 && clickY < 431) {
            CriarTelasDoJogo.flagIniciar = true;
        } else{
            
           new CriarTelasDoJogo();
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }
}
