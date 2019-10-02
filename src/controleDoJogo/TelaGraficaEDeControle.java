package controleDoJogo;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Murilo Araujo
 */
public class TelaGraficaEDeControle extends JPanel implements MouseListener {

    protected static int[][] matrizDoJogo = new int[4][4];
    protected static int pontuacao = 0;
    boolean inicio = true, flagPerdeu=false;
    int k = 0, x = 97, y = 167, direcao = 0;
    private Integer clickX, clickY, soltarX, soltarY;
    private Color corFundo, corLinhas, corBloco2, corBloco4, corBloco8, corBloco16, corBloco32, corBloco64, corBloco128, corBloco256, corBloco512, corBloco1024, corBloco2048;

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

    public void teste(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRoundRect(265, 14, 135, 135, 25, 25);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 50)); //2
        g.drawString("2048", 275, 98); //2

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
                                                g.drawString("128", 140 + j * 110, 240 + i * 115); //128
                                            }

                                        }
                                    }
                                }
                            }

                        }
                    }
                }

                //g.setFont(new Font("Arial", Font.BOLD, 40));  //2048
                //g.drawString("2048", 121 + j*110, 240 + i*115); //2048
                // }
            }
        }
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
             /*   flagPerdeu = MovimentacaoDosBlocos.verificarSePerdeu();
                if(flagPerdeu==true){
                    System.out.println("Perdeu");
                } */
            }
        });
    }

    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponents(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        teste(g);
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

        
        /*
        @Override
        public void run() {
            while (true) {
                //    
                try {
                    sleep(10);
                } catch (InterruptedException erro) {
                }
                if (isAcao() == true) {
                    //OrganizandoPaineisELabels paineisELabels = new OrganizandoPaineisELabels();
                    //paineisELabels.setBounds(0, 0, 660, 660);

                    //  Integer k = 0, x = 97, y = 167;
                    // MovimentacaoDosBlocos.gerarAleatorio(matrizDoJogo);
                    //matrizDoJogo[0][0] = 0;
                    //OrganizandoPaineisELabels.pPos[0].setVisible(false);
                    //OrganizandoPaineisELabels.setP0x(97);
                    //MovimentacaoDosBlocos.imprimirMatriz(matrizDoJogo);
                    //for (int i = 0; i < 4; i++) {
                    //  for (int j = 0; j < 4; j++) {
                    //if(matrizDoJogo[i][j]==16){

                    /*          //System.out.println(matrizDoJogo[0][0]);
                            if (matrizDoJogo[0][0] == 0) {
                                OrganizandoPaineisELabels.getpPos()[k].setBounds(getX(), getY(), 106, 106);
                                OrganizandoPaineisELabels.getpPos()[k].setVisible(true);
                                //add(OrganizandoPaineisELabels.getpPos()[k]);
                                //k = k + 1;
                                x += 120;
                            } 
                            if (x == 577) {
                                x = 97;
                                y += 120;
                            }
                        //}
                    //} 
                    //add(OrganizandoPaineisELabels.getpPos()[k]);
                    //add(paineisELabels);
                    // MovimentacaoDosBlocos.imprimirMatriz(matrizDoJogo);
                }
                setAcao(false);
            }
        }
    } */
    /**
     * @return the acao
     */
    /**
     * @return the matrizDoJogo
     */
    /**
     * @return the pontuacao
     */
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
