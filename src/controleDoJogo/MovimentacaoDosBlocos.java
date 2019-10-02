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
    static Random aleatorio = new Random();
    static boolean flagMover = false;

    public MovimentacaoDosBlocos(int inicial) {
        int linha0a3 = 0, coluna0a3 = 0;

        linha0a3 = aleatorio.nextInt(4);
        coluna0a3 = aleatorio.nextInt(4);

        getMatrizDoJogo()[linha0a3][coluna0a3] = inicial;
    }

    public MovimentacaoDosBlocos() {
    }

    public static void gerarAleatorio() {
        int BlocoVisivel = 0;
        int linha0a3 = 0, coluna0a3 = 0, valor0a4 = 0;

        do {
            BlocoVisivel = 0;
            linha0a3 = aleatorio.nextInt(4);
            coluna0a3 = aleatorio.nextInt(4);
            valor0a4 = aleatorio.nextInt(5);

            if (getMatrizDoJogo()[linha0a3][coluna0a3] == 0 && valor0a4 == 2) {
                getMatrizDoJogo()[linha0a3][coluna0a3] = 4;
            } else {
                if (getMatrizDoJogo()[linha0a3][coluna0a3] == 0 && valor0a4 != 2) {
                    getMatrizDoJogo()[linha0a3][coluna0a3] = 2;
                } else {
                    BlocoVisivel = 1;
                }
            }
        } while (BlocoVisivel == 1);
    }

    public static void gerarAleatorio(int n) {
        int linha0a3 = 0, coluna0a3 = 0;
        linha0a3 = aleatorio.nextInt(4);
        coluna0a3 = aleatorio.nextInt(4);
        matrizDoJogo[linha0a3][coluna0a3] = n;
    }

    public static void imprimirMatriz() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%6d", getMatrizDoJogo()[i][j]);
            }
            System.out.println("");
        }
    }

    public static void esquerda(int[][] matriz) {
        int flagSoma = 0, aux = 0, cont = 1;
        flagMover = false;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                aux = cont;

                while (aux > flagSoma) {
                    if (matriz[i][aux - 1] == 0 && matriz[i][aux] !=0) {
                        matriz[i][aux - 1] = matriz[i][aux];
                        matriz[i][aux] = 0;
                        flagMover = true;
                    }
                    if (matriz[i][aux - 1] == matriz[i][aux] && matriz[i][aux] != 0) {
                        matriz[i][aux - 1] += matriz[i][aux];
                        setPontuacao(getPontuacao() + matriz[i][aux - 1]);
                        matriz[i][aux] = 0;
                        flagSoma += 1;
                        flagMover = true;
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
        if (flagMover == true) {
            gerarAleatorio();
        }
        flagMover = false;
    }

    public static void direita(int[][] matriz) {
        int flagSoma = 3, aux = 0, cont = 2;
        flagMover = false;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                aux = cont;

                while (aux < flagSoma) {

                    if (matriz[i][aux + 1] == 0 && matriz[i][aux] != 0) {
                        matriz[i][aux + 1] = matriz[i][aux];
                        matriz[i][aux] = 0;
                        flagMover = true;
                    }
                    if (matriz[i][aux + 1] == matriz[i][aux] && matriz[i][aux] != 0) {
                        matriz[i][aux + 1] += matriz[i][aux];
                        pontuacao += matriz[i][aux + 1];
                        matriz[i][aux] = 0;
                        flagSoma -= 1;
                        flagMover = true;
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
        if (flagMover == true) {
            gerarAleatorio();
        }
        flagMover = false;
    }

    public static void cima(int[][] matriz) {
        int flagSoma = 0, aux = 0, cont = 1;
        flagMover = false;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                aux = cont;

                while (aux > flagSoma) {
                    if (matriz[aux - 1][i] == 0 && matriz[aux][i] != 0) {
                        matriz[aux - 1][i] = matriz[aux][i];
                        matriz[aux][i] = 0;
                        flagMover = true;
                    }
                    if (matriz[aux - 1][i] == matriz[aux][i] && matriz[aux][i] != 0) {
                        matriz[aux - 1][i] += matriz[aux][i];
                        pontuacao += matriz[aux - 1][i];
                        matriz[aux][i] = 0;
                        flagSoma += 1;
                        flagMover = true;
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

        if (flagMover == true) {
            gerarAleatorio();
        }
        flagMover = false;
    }

    public static void baixo(int[][] matriz) {
        int flagSoma = 3, aux = 0, cont = 2;
        flagMover = false;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                aux = cont;

                while (aux < flagSoma) {

                    if (matriz[aux + 1][i] == 0 && matriz[aux][i] != 0) {
                        matriz[aux + 1][i] = matriz[aux][i];
                        matriz[aux][i] = 0;
                        flagMover = true;
                    }
                    if (matriz[aux + 1][i] == matriz[aux][i] && matriz[aux][i] != 0) {
                        matriz[aux + 1][i] += matriz[aux][i];
                        pontuacao += matriz[aux + 1][i];
                        matriz[aux][i] = 0;
                        flagSoma -= 1;
                        flagMover = true;
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
        if (flagMover == true) {
            gerarAleatorio();
        }
        flagMover = false;
    }

    public static boolean verificarSePerdeu() {
        boolean flagPerdeu = false;
        int[][] matrizTeste = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrizDoJogo[i][j] == 0) {
                    return flagPerdeu;
                }
                matrizTeste[i][j] = matrizDoJogo[i][j];
            }
        }

        esquerda(matrizTeste);

        if (flagMover == false) {
            direita(matrizTeste);
        } else {
            flagPerdeu = false;
            return flagPerdeu;
        }

        if (flagMover == false) {
            cima(matrizTeste);
        } else {
            flagPerdeu = false;
            return flagPerdeu;
        }

        if (flagMover == false) {
            baixo(matrizTeste);
        } else {
            flagPerdeu = false;
            return flagPerdeu;
        }

        if (flagMover == false) {
            flagPerdeu = true;
            return flagPerdeu;
        }
        flagPerdeu = false;
        return flagPerdeu;
    }
}
