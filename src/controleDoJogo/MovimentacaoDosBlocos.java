/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleDoJogo;

import java.util.Random;

/**
 *
 * @author Murilo Araujo
 */
public class MovimentacaoDosBlocos extends TelaGraficaEDeControle {

    /**
     * @param args the command line arguments
     */
    static int[][] matriz = new int[4][4];
    static Random aleatorio = new Random();

    public MovimentacaoDosBlocos() {
    }

    public static void gerarAleatorio(int[][] matriz) {
        int BlocoVisivel = 0;
        int linha0a3 = 0, coluna0a3 = 0, valor0a4 = 0;

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
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%6d", matriz[i][j]);
            }
            System.out.println("");
        }
    }

    public static void esquerda(int[][] matriz, int pontuacao) {
        int flagSoma = 0, aux = 0, cont = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                aux = cont;

                while (aux > flagSoma) {
                    if (matriz[i][aux - 1] == 0) {
                        matriz[i][aux - 1] = matriz[i][aux];
                        matriz[i][aux] = 0;
                    }
                    if (matriz[i][aux - 1] == matriz[i][aux] && matriz[i][aux] != 0) {
                        matriz[i][aux - 1] += matriz[i][aux];
                        pontuacao += matriz[i][aux - 1];
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

    public static void direita(int[][] matriz, int pontuacao) {
        int flagSoma = 3, aux = 0, cont = 2;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                aux = cont;

                while (aux < flagSoma) {

                    if (matriz[i][aux + 1] == 0) {
                        matriz[i][aux + 1] = matriz[i][aux];
                        matriz[i][aux] = 0;
                    }
                    if (matriz[i][aux + 1] == matriz[i][aux] && matriz[i][aux] != 0) {
                        matriz[i][aux + 1] += matriz[i][aux];
                        pontuacao += matriz[i][aux + 1];
                        matriz[i][aux] = 0;
                        flagSoma -= 1;
                    } else {
                        if (matriz[i][aux + 1] != 0 && matriz[i][aux] != 0) {
                            flagSoma -= 1;
                        }
                    }
                    aux += 1;
                }
                cont -= 1;
            }
            cont = 2;
            flagSoma = 3;
        }
    }

    public static void cima(int[][] matriz, int pontuacao) {
        int flagSoma = 0, aux = 0, cont = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                aux = cont;

                while (aux > flagSoma) {
                    if (matriz[aux - 1][i] == 0) {
                        matriz[aux - 1][i] = matriz[aux][i];
                        matriz[aux][i] = 0;
                    }
                    if (matriz[aux - 1][i] == matriz[aux][i] && matriz[aux][i] != 0) {
                        matriz[aux - 1][i] += matriz[aux][i];
                        pontuacao += matriz[aux - 1][i];
                        matriz[aux][i] = 0;
                        flagSoma += 1;
                    } else {
                        if (matriz[aux - 1][i] != 0 && matriz[aux][i] != 0) {
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

    public static void baixo(int[][] matriz, int pontuacao) {
        int flagSoma = 3, aux = 0, cont = 2;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                aux = cont;

                while (aux < flagSoma) {

                    if (matriz[aux + 1][i] == 0) {
                        matriz[aux + 1][i] = matriz[aux][i];
                        matriz[aux][i] = 0;
                    }
                    if (matriz[aux + 1][i] == matriz[aux][i] && matriz[aux][i] != 0) {
                        matriz[aux + 1][i] += matriz[aux][i];
                        pontuacao += matriz[aux + 1][i];
                        matriz[aux][i] = 0;
                        flagSoma -= 1;
                    } else {
                        if (matriz[aux + 1][i] != 0 && matriz[aux][i] != 0) {
                            flagSoma -= 1;
                        }
                    }
                    aux += 1;
                }
                cont -= 1;
            }
            cont = 2;
            flagSoma = 3;
        }
    }

    public int Perdeu(int[][] matriz, int pontuacao) {
        int flagNaoPerdeu = 0, flagPerdeu = 1, pontos = 0;
        int[][] matrizTeste = new int[4][4];

        pontos = pontuacao;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matriz[i][j] == 0) {
                    return flagNaoPerdeu;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matriz[i][j] == 0) {
                    return flagNaoPerdeu;
                }
                matrizTeste[i][j] = matriz[i][j];
            }
        }

        esquerda(matrizTeste, pontos);
        
        if(pontos==pontuacao){
        direita(matrizTeste, pontos);
        } else {
            return flagNaoPerdeu;
        }
        
        if(pontos==pontuacao){
        cima(matrizTeste, pontos);
        } else {
            return flagNaoPerdeu;
        }
        
        if(pontos==pontuacao){
        baixo(matrizTeste, pontos);
        } else {
            return flagNaoPerdeu;
        }
     
        if(pontos==pontuacao){
            return flagPerdeu;
        }
        return flagNaoPerdeu;
    }
}
