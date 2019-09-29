package jogo2048;

import controleDoJogo.TelaGraficaEDeControle;
import java.util.Random;
import javax.swing.SwingUtilities;

/**
 *
 * @author Murilo Araujo
 */
public class Jogo2048 {

    

    public static void main(String[] args) {
        /*  imprimirMatriz(matriz);
        gerarAleatorio(matriz);
        System.out.println("");
        imprimirMatriz(matriz);
        baixo(matriz);
        System.out.println("");
        imprimirMatriz(matriz);

        System.out.println("\n\n Pontuacao: " + pontuacao);
         */
        SwingUtilities.invokeLater(() -> {
            TelaGraficaEDeControle telaGraficaEDeControle = new TelaGraficaEDeControle();
        });
    }

}
