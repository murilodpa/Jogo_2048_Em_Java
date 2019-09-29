package controleDoJogo;

import interfaceGrafica.TelaDoJogo;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Murilo Araujo
 */
public class TelaGraficaEDeControle extends JFrame {

    public TelaGraficaEDeControle() {
        editarJanela();
        imprimirLayout();
        imprimirBlocos();

    }

    public final void editarJanela() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException exception) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o L&F do sistema! " + exception.getMessage());
        }

        setTitle("JOGO 2048");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(676, 699);
        // frame.setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public final void imprimirLayout() {
        TelaDoJogo telaDoJogo = new TelaDoJogo();
        telaDoJogo.setBounds(0, 0, 660, 660);
        add(telaDoJogo.getPainelLogo());
        add(telaDoJogo.getPainelPontuacao());
        add(telaDoJogo);
    }

    public final void imprimirBlocos() {

        OrganizandoPaineisELabels paineisELabels = new OrganizandoPaineisELabels();
        //MovimentacaoDosBlocos movimentacao = new MovimentacaoDosBlocos();

        paineisELabels.setBounds(0, 0, 660, 660);
        //System.out.println(MovimentacaoDosBlocos.matriz[0][0]);
        int k=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (MovimentacaoDosBlocos.matriz[i][j] == 0) {
                    add(paineisELabels.pPos[k]);
                }
                //System.out.println(k);
                k+=1;
            }
        }
        //add(paineisELabels.pPos[5]);
        add(paineisELabels);
    }
}
