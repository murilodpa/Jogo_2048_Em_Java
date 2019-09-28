package controleDoJogo;

import javax.swing.JFrame;

/**
 *
 * @author Murilo Araujo
 */
public class TelaGraficaEDeControle extends JFrame {
  
    
    public TelaGraficaEDeControle(){
        editarJanela();
    }
    
     public final void editarJanela() {
        setTitle("JOGO 2048");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(676, 699);
        // frame.setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
}
