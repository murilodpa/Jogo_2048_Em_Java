package jogo2048;

import java.util.Random;

/**
 *
 * @author Murilo Araujo
 */
public class Jogo2048 {

    /**
     * @param args the command line arguments
     */
    static int[][] matriz = new int[4][4];
    static Random aleatorio = new Random();
    
    public static void main(String[] args) {
        imprimirMatriz(matriz);
        gerarAleatorio(matriz);
        imprimirMatriz(matriz);
        esquerda(matriz);
        System.out.println("");
        imprimirMatriz(matriz);
        
    }
    
    public static void gerarAleatorio(int[][] matriz) {        
        
        matriz[0][0]=32;
        matriz[0][1]=8;
        matriz[0][2]=2;
        matriz[0][3]=4;
        int BlocoVisivel = 0;
        int linha0a3 = 0, coluna0a3 = 0, valor0a4 = 0, i = 0;
        
        while (i < 12) {
            do {
                BlocoVisivel = 0;
                linha0a3 = aleatorio.nextInt(4);
                coluna0a3 = aleatorio.nextInt(4);
                valor0a4 = aleatorio.nextInt(5);
                
                if (matriz[linha0a3][coluna0a3] == 0 && valor0a4 == 2) {
                    matriz[linha0a3][coluna0a3] = 4;
                } else {                    
                    if (matriz[linha0a3][coluna0a3] == 0 && valor0a4 != 2) {
                        matriz[linha0a3][coluna0a3] = 2;
                    } else {
                        BlocoVisivel = 1;                        
                    }
                }                
            } while (BlocoVisivel == 1);
            i += 1;
        }
        
    }
    
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%6d", matriz[i][j]);
            }
            System.out.println("");
        }
    }
    
    public static void esquerda(int[][] matriz) {
        int flagSoma = 0, aux = 0, cont = 1;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                aux = cont;
                
                while (aux > flagSoma) {
                    if (matriz[i][aux - 1] == 0) {
                        matriz[i][aux - 1] = matriz[i][aux];
                        matriz[i][aux] = 0;
                    }
                    if (matriz[i][aux - 1] == matriz[i][aux]) {
                        matriz[i][aux - 1] += matriz[i][aux];
                        matriz[i][aux] = 0;
                        flagSoma += 1;
                    } else {
                        if (matriz[i][aux - 1] != 0 && matriz[i][aux] != 0) {
                            flagSoma += 1;
                        }
                    }
                    aux -= 1;
                }
                cont += 1;
            }
            cont = 1;
            flagSoma = 0;
        }
    }
}

