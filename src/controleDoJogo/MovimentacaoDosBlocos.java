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
    private static Random aleatorio = new Random();
    public static boolean flagMover = false, gerouAleatorio = false;
    static int[][] matrizRetornar = new int[4][4];
    static int[] linhaChoque = new int[12];
    static int[] colunaChoque = new int[12];
    static int[] linhaSoma = new int[16];
    static int[] colunaSoma = new int[16];
    int cont1 = 0, cont2 = 0;

    public MovimentacaoDosBlocos(int inicial) {
        int linha0a3 = 0, coluna0a3 = 0;

        linha0a3 = aleatorio.nextInt(4);
        coluna0a3 = aleatorio.nextInt(4);

        getMatrizDoJogo()[linha0a3][coluna0a3] = inicial;
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
    
     public static void gerarAleatorio(int n, int m) {
        int linha0a3 = 0, coluna0a3 = 0;
        matrizDoJogo[linha0a3][coluna0a3] = n;
        matrizDoJogo[linha0a3][coluna0a3+1] = m;
     }
    
    
      public static void zerarMatriz() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrizDoJogo[i][j]=0;
            }
        }
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
        int flagSoma = 0, aux = 0, cont = 1, cont1 = 0, cont2 = 0, k = 0, l=0;
        flagMover = false;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrizRetornar[i][j] = matrizDoJogo[i][j];
                if (k < 12) {
                    linhaChoque[k] = -1;
                    colunaChoque[k] = -1;
                }
                if (k < 16) {
                    linhaSoma[k] = -1;
                    colunaSoma[k] = -1;
                }
                k += 1;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                aux = cont;

                while (aux > flagSoma) {
                    if (matriz[i][aux - 1] == 0 && matriz[i][aux] != 0) {
                        matriz[i][aux - 1] = matriz[i][aux];
                        matriz[i][aux] = 0;
                        flagMover = true;
                    }
                    if (matriz[i][aux - 1] == matriz[i][aux] && matriz[i][aux] != 0) {
                        matriz[i][aux - 1] += matriz[i][aux];
                        linhaSoma[l]=i;
                        colunaSoma[l]=(aux-1);
                        l+=1;
                        setPontuacao(getPontuacao() + matriz[i][aux - 1]);
                        matriz[i][aux] = 0;
                        flagSoma += 1;
                        flagMover = true;
                    } else {
                        if (matriz[i][aux - 1] != 0 && matriz[i][aux] != 0) {
                            linhaChoque[cont1] = i;
                            colunaChoque[cont2] = (aux - 1);
                            cont1 += 1;
                            cont2 += 1;
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
        gerouAleatorio = false;

        if (flagMover == true) {
            gerarAleatorio();
            gerouAleatorio = true;
        }
        flagSePodeRetornar = true;
    }

    public static void direita(int[][] matriz) {
        int flagSoma = 3, aux = 0, cont = 2, cont1 = 0, cont2 = 0, k = 0, l=0;
        flagMover = false;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrizRetornar[i][j] = matrizDoJogo[i][j];
                if (k < 12) {
                    linhaChoque[k] = -1;
                    colunaChoque[k] = -1;
                }
                if (k < 16) {
                    linhaSoma[k] = -1;
                    colunaSoma[k] = -1;
                }
                k += 1;
            }
        }

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
                        linhaSoma[l]=i;
                        colunaSoma[l]=(aux+1);
                        l+=1;
                        pontuacao += matriz[i][aux + 1];
                        matriz[i][aux] = 0;
                        flagSoma -= 1;
                        flagMover = true;
                    } else {
                        if (matriz[i][aux + 1] != 0 && matriz[i][aux] != 0) {
                            linhaChoque[cont1] = i;
                            colunaChoque[cont2] = (aux);
                            cont1 += 1;
                            cont2 += 1;
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
        gerouAleatorio = false;

        if (flagMover == true) {
            gerarAleatorio();
            gerouAleatorio = true;
        }
        flagSePodeRetornar = true;
    }

    public static void cima(int[][] matriz) {
        int flagSoma = 0, aux = 0, cont = 1, cont1 = 0, cont2 = 0, k = 0, l=0;
        flagMover = false;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrizRetornar[i][j] = matrizDoJogo[i][j];
                if (k < 12) {
                    linhaChoque[k] = -1;
                    colunaChoque[k] = -1;
                }
                if (k < 16) {
                    linhaSoma[k] = -1;
                    colunaSoma[k] = -1;
                }
                k += 1;
            }
        }

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
                        linhaSoma[l]=(aux-1);
                        colunaSoma[l]=i;
                        l+=1;
                        pontuacao += matriz[aux - 1][i];
                        matriz[aux][i] = 0;
                        flagSoma += 1;
                        flagMover = true;
                    } else {
                        if (matriz[aux - 1][i] != 0 && matriz[aux][i] != 0) {
                            linhaChoque[cont1] = i;
                            colunaChoque[cont2] = (aux - 1);
                            cont1 += 1;
                            cont2 += 1;
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
        gerouAleatorio = false;

        if (flagMover == true) {
            gerarAleatorio();
            gerouAleatorio = true;
        }
        flagSePodeRetornar = true;
    }

    public static void baixo(int[][] matriz) {
        int flagSoma = 3, aux = 0, cont = 2, cont1 = 0, cont2 = 0, k = 0, l=0;
        flagMover = false;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrizRetornar[i][j] = matrizDoJogo[i][j];
                if (k < 12) {
                    linhaChoque[k] = -1;
                    colunaChoque[k] = -1;
                }
                if (k < 16) {
                    linhaSoma[k] = -1;
                    colunaSoma[k] = -1;
                }
                k += 1;
            }
        }

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
                        linhaSoma[l]=(aux+1);
                        colunaSoma[l]=i;
                        l+=1;
                        pontuacao += matriz[aux + 1][i];
                        matriz[aux][i] = 0;
                        flagSoma -= 1;
                        flagMover = true;
                    } else {
                        if (matriz[aux + 1][i] != 0 && matriz[aux][i] != 0) {
                            linhaChoque[cont1] = i;
                            colunaChoque[cont2] = aux;
                            cont1 += 1;
                            cont2 += 1;
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
        gerouAleatorio = false;

        if (flagMover == true) {
            gerarAleatorio();
            gerouAleatorio = true;
        }
        flagSePodeRetornar = true;
    }

    public static boolean verificarSePerdeu() {
        boolean flagPerder = false;
        int aux = 0;

        //    try{
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizDoJogo[i][j] == matrizDoJogo[i][j + 1] || matrizDoJogo[i][j] == 0 || matrizDoJogo[i][j + 1] == 0) {
                    return flagPerder;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizDoJogo[j][i] == matrizDoJogo[j + 1][i]) {
                    return flagPerder;
                }
            }
        }
        flagPerder = true;
        return flagPerder;
    }
}
