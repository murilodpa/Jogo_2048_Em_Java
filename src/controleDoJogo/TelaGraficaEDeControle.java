package controleDoJogo;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Murilo Araujo
 */
public class TelaGraficaEDeControle extends JPanel implements MouseListener {

    protected static int[][] matrizTeste = new int[4][4];
    protected static int[][] matrizDoJogo = new int[4][4];
    protected static int pontuacao = 0;
    boolean inicio = true, flagPerdeu = false;
    int k = 0, x = 97, y = 167, direcao = 0;
    private Integer clickX, clickY, soltarX, soltarY;
    private final Color corFundo, corLinhas, corBloco2, corBloco4, corBloco8, corBloco16, corBloco32, corBloco64, corBloco128, corBloco256, corBloco512, corBloco1024, corBloco2048;
    private String valorPontuacao;

    public TelaGraficaEDeControle() {
        corFundo = new Color(102, 178, 255);
        corLinhas = new Color(0, 128, 255);
        corBloco2 = new Color(220, 220, 220);
        corBloco4 = new Color(192, 192, 192);
        corBloco8 = new Color(255, 180, 68);
        corBloco16 = new Color(255, 64, 64);
        corBloco32 = new Color(255, 29, 11);
        corBloco64 = new Color(255, 0, 0);
        corBloco128 = new Color(251, 236, 93);
        corBloco256 = new Color(253, 233, 16);
        corBloco512 = new Color(255, 215, 0);
        corBloco1024 = new Color(255, 255, 64);
        corBloco2048 = new Color(255, 255, 0);

        setPreferredSize(new Dimension(660, 660));
        setFocusable(true);
        //imprimirLayout();
        //   imprimirBlocos();
        // new Movimento1().start();
        movimentar();
        addMouseListener(this);
    }

    public void telaDoJogo(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRoundRect(265, 14, 135, 135, 25, 25);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 50)); //2048
        g.drawString("2048", 275, 98); //2048

        g.setColor(Color.red);
        g.fillRoundRect(100, 70, 150, 80, 25, 25);
        g.setColor(corFundo);
        g.fillRoundRect(120, 105, 110, 40, 25, 25);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 22)); //PONTUACAO
        g.drawString("PONTUAÇÃO", 105, 95); //PONTUACAO
        
        g.setColor(Color.red);
        g.fillRoundRect(415, 80, 70, 70, 25, 25);
        
         g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 22)); //NOVO JOGO
        g.drawString("NOVO", 418, 110); //PONTUACAO
        g.drawString("JOGO", 418, 135); //PONTUACAO

        valorPontuacao = String.valueOf(pontuacao);
        g.setFont(new Font("Arial", Font.BOLD, 30)); //PONTUACAO

        if (pontuacao < 10) {
            g.drawString(valorPontuacao, 169, 136); //PONTUACAO
        } else {
            if (pontuacao < 100) {
                g.drawString(valorPontuacao, 160, 136); //PONTUACAO  
            } else {
                if (pontuacao < 1000) {
                    g.drawString(valorPontuacao, 151, 136); //PONTUACAO
                } else {
                    if (pontuacao < 100000) {
                        g.drawString(valorPontuacao, 142, 136); //PONTUACAO
                    } else {
                        g.drawString(valorPontuacao, 133, 136); //PONTUACAO
                    }
                }
            }
        }

        g.setColor(corLinhas);
        g.fillRoundRect(100, 160, 460, 475, 25, 25);
        if (inicio == true) {
            MovimentacaoDosBlocos.gerarAleatorio(2);
        }
        inicio = false;
        MovimentacaoDosBlocos.imprimirMatriz();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrizDoJogo[i][j] == 0) {
                    g.setColor(corFundo);
                    g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                } else {
                    if (matrizDoJogo[i][j] == 2) {
                        g.setColor(corBloco2);
                        g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                        g.setColor(Color.BLACK);
                        g.setFont(new Font("Arial", Font.BOLD, 40)); //2
                        g.drawString("2", 153 + j * 111, 240 + i * 116); //2
                    } else {
                        if (matrizDoJogo[i][j] == 4) {
                            g.setColor(corBloco4);
                            g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                            g.setColor(Color.BLACK);
                            g.setFont(new Font("Arial", Font.BOLD, 40)); //4
                            g.drawString("4", 153 + j * 111, 240 + i * 116); //4
                        } else {
                            if (matrizDoJogo[i][j] == 8) {
                                g.setColor(corBloco8);
                                g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                g.setColor(Color.WHITE);
                                g.setFont(new Font("Arial", Font.BOLD, 40)); //8
                                g.drawString("8", 153 + j * 111, 240 + i * 116); //8
                            } else {
                                if (matrizDoJogo[i][j] == 16) {
                                    g.setColor(corBloco16);
                                    g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                    g.setColor(Color.WHITE);
                                    g.setFont(new Font("Arial", Font.BOLD, 40)); //16
                                    g.drawString("16", 140 + j * 111, 240 + i * 116); //16
                                } else {
                                    if (matrizDoJogo[i][j] == 32) {
                                        g.setColor(corBloco32);
                                        g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                        g.setColor(Color.WHITE);
                                        g.setFont(new Font("Arial", Font.BOLD, 40)); //32
                                        g.drawString("32", 140 + j * 110, 240 + i * 115); //32                                  
                                    } else {
                                        if (matrizDoJogo[i][j] == 64) {
                                            g.setColor(corBloco64);
                                            g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                            g.setColor(Color.WHITE);
                                            g.setFont(new Font("Arial", Font.BOLD, 40)); //64
                                            g.drawString("64", 140 + j * 110, 240 + i * 115); //64
                                        } else {
                                            if (matrizDoJogo[i][j] == 128) {
                                                g.setColor(corBloco128);
                                                g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                                g.setColor(Color.WHITE);
                                                g.setFont(new Font("Arial", Font.BOLD, 40)); //128
                                                g.drawString("128", 130 + j * 110, 240 + i * 115); //128
                                            } else {
                                                if (matrizDoJogo[i][j] == 256) {
                                                    g.setColor(corBloco256);
                                                    g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                                    g.setColor(Color.WHITE);
                                                    g.setFont(new Font("Arial", Font.BOLD, 40)); //128
                                                    g.drawString("256", 130 + j * 110, 240 + i * 115); //128
                                                } else {
                                                    if (matrizDoJogo[i][j] == 512) {
                                                        g.setColor(corBloco512);
                                                        g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                                        g.setColor(Color.WHITE);
                                                        g.setFont(new Font("Arial", Font.BOLD, 40)); //128
                                                        g.drawString("512", 130 + j * 110, 240 + i * 115); //128
                                                    } else {
                                                        if (matrizDoJogo[i][j] == 1024) {
                                                            g.setColor(corBloco1024);
                                                            g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                                            g.setColor(Color.WHITE);
                                                            g.setFont(new Font("Arial", Font.BOLD, 40)); //128
                                                            g.drawString("1024", 120 + j * 110, 240 + i * 115); //128
                                                        } else {
                                                            if (matrizDoJogo[i][j] == 2048) {
                                                                g.setColor(corBloco2048);
                                                                g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                                                g.setColor(Color.WHITE);
                                                                g.setFont(new Font("Arial", Font.BOLD, 40)); //128
                                                                g.drawString("2048", 120 + j * 110, 240 + i * 115); //128
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        
     /*   g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 70)); //PONTUACAO
        g.drawString("MURILO ARAUJO", 100, 300); //PONTUACAO */
    }

    public void movimentar() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == 37 || e.getKeyCode() == 65) {
                    MovimentacaoDosBlocos.esquerda(matrizDoJogo);
                }

                if (e.getKeyCode() == 38 || e.getKeyCode() == 87) {
                    MovimentacaoDosBlocos.cima(matrizDoJogo);
                }

                if (e.getKeyCode() == 39 || e.getKeyCode() == 68) {
                    MovimentacaoDosBlocos.direita(matrizDoJogo);
                }

                if (e.getKeyCode() == 40 || e.getKeyCode() == 83) {
                    MovimentacaoDosBlocos.baixo(matrizDoJogo);
                }
                repaint();
                flagPerdeu = MovimentacaoDosBlocos.verificarSePerdeu();
                if (flagPerdeu == true) {
                    System.out.println("Perdeuuuuuuuuuuuuu");
                }
                System.out.println("Pontuacaoo: " + getPontuacao());
            }
        });
    }

    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponents(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        telaDoJogo(g);
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
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        try {
            int deltaX = 0, deltaY = 0;
            soltarX = e.getX();
            soltarY = e.getY();
            deltaX = (soltarX - clickX);
            deltaY = (soltarY - clickY);
            //System.out.println("click x: " + clickX + " clickY: " + clickY + "\nsoltarX: " + soltarX + " soltarY: " + soltarY);

            if (deltaX < 0 && deltaY < 0) {
                deltaX = (deltaX * (-1));
                deltaY = (deltaY * (-1));
                if (deltaX > deltaY) {
                    MovimentacaoDosBlocos.esquerda(matrizDoJogo);
                    deltaX = (deltaX * (-1));
                    deltaY = (deltaY * (-1));
                } else {
                    MovimentacaoDosBlocos.cima(matrizDoJogo);
                    deltaX = (deltaX * (-1));
                    deltaY = (deltaY * (-1));
                }
            }

            if (deltaX > 0 && deltaY < 0) {
                deltaY = (deltaY * (-1));

                if (deltaX > deltaY) {
                    MovimentacaoDosBlocos.direita(matrizDoJogo);
                    deltaY = (deltaY * (-1));
                } else {
                    MovimentacaoDosBlocos.cima(matrizDoJogo);
                    deltaY = (deltaY * (-1));
                }
            }

            if (deltaX > 0 && deltaY > 0) {

                if (deltaX > deltaY) {
                    MovimentacaoDosBlocos.direita(matrizDoJogo);
                } else {
                    MovimentacaoDosBlocos.baixo(matrizDoJogo);
                }
            }

            if (deltaX < 0 && deltaY > 0) {
                deltaX = (deltaX * (-1));

                if (deltaX > deltaY) {
                    MovimentacaoDosBlocos.esquerda(matrizDoJogo);
                    deltaX = (deltaX * (-1));

                } else {
                    MovimentacaoDosBlocos.baixo(matrizDoJogo);
                    deltaX = (deltaX * (-1));
                }
            }
        } catch (java.lang.NullPointerException e1) {
        }
        repaint();
        if(MovimentacaoDosBlocos.gerouAleatorio==false){
        flagPerdeu = MovimentacaoDosBlocos.verificarSePerdeu();
        }
        if (flagPerdeu == true) {
            System.out.println("\nPerdeuuuuuuuuuuuuu");
        }
        System.out.println("\nPontuacaoo: " + getPontuacao());
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    public Integer getSoltarX() {
        return soltarX;
    }

    public void setSoltarX(Integer soltarX) {
        this.soltarX = soltarX;
    }

    public Integer getClickX() {
        return clickX;
    }

    public void setClickX(Integer clickX) {
        this.clickX = clickX;
    }

    public Integer getSoltarY() {
        return soltarY;
    }

    public void setSoltarY(Integer soltarY) {
        this.soltarY = soltarY;
    }

    public Integer getClickY() {
        return clickY;
    }

    public void setClickY(Integer clickY) {
        this.clickY = clickY;
    }

    /*
    public class Movimento1 extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    sleep(10);
                } catch (InterruptedException erro) {
                }
                boolean flagVer = false;

                for (int i = 0; i < 4 && flagVer == false; i++) {
                    for (int j = 0; j < 4 && flagVer == false; j++) {
                        if (matrizDoJogo[i][j] == 0) {
                            flagPerdeu = false;
                            flagVer = true;
                        }
                        matrizTeste[i][j] = matrizDoJogo[i][j];
                    }
                }

                if (flagVer != true) {
                    esquerda(matrizTeste);

                    if (flagMover == false) {
                        direita(matrizTeste);
                    } else {
                        flagPerdeu = false;
                        flagVer = true;
                    }
                }

                if (flagMover == false && flagVer != true) {
                    cima(matrizTeste);
                } else {
                    flagPerdeu = false;
                    flagVer = true;
                }

                if (flagMover == false && flagVer != true) {
                    baixo(matrizTeste);
                } else {
                    flagPerdeu = false;
                    flagVer = true;
                }

                if (flagMover == false && flagVer != true) {
                    flagPerdeu = true;
                }
            }
        }
    }*/
 
    public static int getPontuacao() {
        return pontuacao;
    }

    /**
     * @param aPontuacao the pontuacao to set
     */
    public static void setPontuacao(int aPontuacao) {
        pontuacao = aPontuacao;
    }

    /**
     * @return the matrizDoJogo
     */
    public static int[][] getMatrizDoJogo() {
        return matrizDoJogo;
    }

    /**
     * @param aMatrizDoJogo the matrizDoJogo to set
     */
    public static void setMatrizDoJogo(int[][] aMatrizDoJogo) {
        matrizDoJogo = aMatrizDoJogo;
    }
}
