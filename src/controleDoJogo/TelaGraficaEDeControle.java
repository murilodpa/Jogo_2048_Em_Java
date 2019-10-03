package controleDoJogo;

import static controleDoJogo.MovimentacaoDosBlocos.colunaChoque;
import static controleDoJogo.MovimentacaoDosBlocos.colunaSoma;
import static controleDoJogo.MovimentacaoDosBlocos.linhaChoque;
import static controleDoJogo.MovimentacaoDosBlocos.linhaSoma;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Murilo Araujo
 */
public class TelaGraficaEDeControle extends JPanel implements MouseListener {

    /**
     *
     */
    protected static int[][] matrizDoJogo = new int[4][4];
    protected static int pontuacao = 0, pontuacaoAnterior = 0;
    private BufferedImage[][] imagemRaio = new BufferedImage[4][3];
    private BufferedImage[][] imagemBoloco4 = new BufferedImage[4][4];
    private BufferedImage[][] imagemBoloco8 = new BufferedImage[4][4];
    private BufferedImage[][] imagemBoloco16 = new BufferedImage[4][4];
    private BufferedImage[][] imagemBoloco32 = new BufferedImage[4][4];
    private BufferedImage[][] imagemBoloco64 = new BufferedImage[4][4];
    private BufferedImage[][] imagemBoloco128 = new BufferedImage[4][4];
    private BufferedImage[][] imagemBoloco256 = new BufferedImage[4][4];
    private BufferedImage[][] imagemBoloco512 = new BufferedImage[4][4];
    private BufferedImage[][] imagemBoloco1024 = new BufferedImage[4][4];
    private BufferedImage[][] imagemBoloco2048 = new BufferedImage[4][4];
    private BufferedImage imagemRetornar;
            

    static boolean inicio = true, flagPerdeu = false, flagReiniciar = false, flagRetornar = false, flagSePodeRetornar = false;
    int k = 0, x = 97, y = 167, direcao = 0;
    private Integer clickX, clickY, soltarX, soltarY;
    private Color corFundo;
    private Color corLinhas;
    private Color corBloco2;
    private Color corBloco4;
    private Color corBloco8;
    private Color corBloco16;
    private Color corBloco32;
    private Color corBloco64;
    private Color corBloco128;
    private Color corBloco256;
    private Color corBloco512;
    private Color corBloco1024;
    private Color corBloco2048;
    private String valorPontuacao;
    int flagCimaOuBaixo = 0;

    public TelaGraficaEDeControle() {
        setPreferredSize(new Dimension(660, 660));
        setFocusable(true);
        instanciarComponentes();
        new verificarChoqueOuSoma().start();
        movimentar();
        addMouseListener(this);
    }

    public void instanciarComponentes() {
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

        try {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    imagemRaio[i][j] = ImageIO.read(getClass().getResourceAsStream("RAIO.gif"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    imagemBoloco4[i][j] = ImageIO.read(getClass().getResourceAsStream("estrelas_4.gif"));
                    imagemBoloco8[i][j] = ImageIO.read(getClass().getResourceAsStream("brilhos_8.gif"));
                    imagemBoloco16[i][j] = ImageIO.read(getClass().getResourceAsStream("baloes_16.gif"));
                    imagemBoloco32[i][j] = ImageIO.read(getClass().getResourceAsStream("bobEsponja_32.gif"));
                    imagemBoloco64[i][j] = ImageIO.read(getClass().getResourceAsStream("abacates_64.gif"));
                    imagemBoloco128[i][j] = ImageIO.read(getClass().getResourceAsStream("tenor_128.gif"));
                    imagemBoloco256[i][j] = ImageIO.read(getClass().getResourceAsStream("giphy_256.gif"));
                    imagemBoloco512[i][j] = ImageIO.read(getClass().getResourceAsStream("tenor_512.gif"));
                    imagemBoloco1024[i][j] = ImageIO.read(getClass().getResourceAsStream("tenor_1024.gif"));
                    imagemBoloco2048[i][j] = ImageIO.read(getClass().getResourceAsStream("fogosDeArtificio_2048.gif"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
                try {
            imagemRetornar = ImageIO.read(getClass().getResourceAsStream("Retornar.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(TelaGraficaEDeControle.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        linhaChoque[k] = -1;
        colunaChoque[k] = -1;
        linhaSoma[k] = -1;
        colunaSoma[k] = -1;
    }

    public void telaDoJogo(Graphics2D g) {
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(3));

        g.setColor(Color.red); //Escolhendo Cor Vermelha 
        g.fillRoundRect(265, 14, 135, 135, 25, 25); //Desenhar o LOGO
        g.setColor(Color.BLACK); //Escolhendo Cor Preta 
        g.drawRoundRect(265, 14, 135, 135, 25, 25); //Desenhar a borda do LOGO
        g.setFont(new Font("Arial", Font.BOLD, 50)); //Escrever 2048
        g.drawString("2048", 275, 98); //Escrever 2048
        
        g.setColor(Color.red);
        g.fillRoundRect(100, 70, 153, 80, 25, 25);
        g.setColor(Color.BLACK);
        g.drawRoundRect(100, 70, 153, 80, 25, 25);
        g.setColor(corFundo);
        g.fillRoundRect(120, 105, 113, 40, 25, 25);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 22)); //PONTUACAO
        g.drawString("PONTUAÇÃO", 106, 95); //PONTUACAO

        g.setColor(Color.red);
        g.fillRoundRect(412, 80, 70, 70, 25, 25);
        g.setColor(Color.BLACK);
        g.drawRoundRect(412, 80, 70, 70, 25, 25);
        g.setFont(new Font("Arial", Font.BOLD, 22)); //NOVO JOGO
        g.drawString("NOVO", 415, 110); //NOVO
        g.drawString("JOGO", 415, 135); //JOGO

        g.setColor(Color.red);
        g.drawImage(imagemRetornar, 494, 80, 70, 70, this);
        //g.fillRoundRect(494, 80, 70, 70, 25, 25);
        g.setColor(Color.BLACK);
        g.drawRoundRect(494, 80, 70, 70, 1, 1);
        
        g.setFont(new Font("Arial", Font.BOLD, 22)); //NOVO JOGO

        if (flagReiniciar == true) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrizDoJogo[i][j] = 0;
                    inicio = true;
                    flagReiniciar = false;
                    pontuacao = 0;
                }
            }
        }

        if (flagRetornar == true && flagSePodeRetornar == true) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrizDoJogo[i][j] = MovimentacaoDosBlocos.matrizRetornar[i][j];
                    flagRetornar = false;
                    flagSePodeRetornar = false;
                    pontuacao = pontuacaoAnterior;
                }
            }
        }

        valorPontuacao = String.valueOf(pontuacao);
        g.setFont(new Font("Arial", Font.BOLD, 30)); //PONTUACAO

        pontuacaoAnterior = pontuacao;

        if (pontuacao < 10) {
            g.drawString(valorPontuacao, 170, 136); //PONTUACAO
        } else {
            if (pontuacao < 100) {
                g.drawString(valorPontuacao, 161, 136); //PONTUACAO  
            } else {
                if (pontuacao < 1000) {
                    g.drawString(valorPontuacao, 152, 136); //PONTUACAO
                } else {
                    if (pontuacao < 100000) {
                        g.drawString(valorPontuacao, 143, 136); //PONTUACAO
                    } else {
                        g.drawString(valorPontuacao, 134, 136); //PONTUACAO
                    }
                }
            }
        }

        g.setStroke(new BasicStroke(7));
        g.setColor(Color.BLACK);
        g.drawRoundRect(100, 160, 460, 475, 25, 25);
        g.setColor(corLinhas);
        g.fillRoundRect(100, 160, 460, 475, 25, 25);

         g.setColor(Color.BLACK);  
        g.setStroke(new BasicStroke(3));

        if (inicio == true) {
            MovimentacaoDosBlocos.gerarAleatorio(2);
            inicio = false;
        }

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
                        g.drawRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                        g.setFont(new Font("Arial", Font.BOLD, 40)); //2
                        g.drawString("2", 153 + j * 111, 240 + i * 116); //2
                    } else {
                        if (matrizDoJogo[i][j] == 4) {
                            g.setColor(corBloco4);
                            g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                            g.setColor(Color.BLACK);
                            g.drawRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                            g.setFont(new Font("Arial", Font.BOLD, 40)); //4
                            g.drawString("4", 153 + j * 111, 240 + i * 116); //4
                        } else {
                            if (matrizDoJogo[i][j] == 8) {
                                g.setColor(corBloco8);
                                g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                g.setColor(Color.BLACK);
                                g.drawRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                g.setColor(Color.WHITE);
                                g.setFont(new Font("Arial", Font.BOLD, 40)); //8
                                g.drawString("8", 153 + j * 111, 240 + i * 116); //8
                            } else {
                                if (matrizDoJogo[i][j] == 16) {
                                    g.setColor(corBloco16);
                                    g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                    g.setColor(Color.BLACK);
                                    g.drawRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                    g.setColor(Color.WHITE);
                                    g.setFont(new Font("Arial", Font.BOLD, 40)); //16
                                    g.drawString("16", 140 + j * 111, 240 + i * 116); //16
                                } else {
                                    if (matrizDoJogo[i][j] == 32) {
                                        g.setColor(corBloco32);
                                        g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                        g.setColor(Color.BLACK);
                                        g.drawRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                        g.setColor(Color.WHITE);
                                        g.setFont(new Font("Arial", Font.BOLD, 40)); //32
                                        g.drawString("32", 140 + j * 110, 240 + i * 115); //32                                  
                                    } else {
                                        if (matrizDoJogo[i][j] == 64) {
                                            g.setColor(corBloco64);
                                            g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                            g.setColor(Color.BLACK);
                                            g.drawRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                            g.setColor(Color.WHITE);
                                            g.setFont(new Font("Arial", Font.BOLD, 40)); //64
                                            g.drawString("64", 140 + j * 110, 240 + i * 115); //64
                                        } else {
                                            if (matrizDoJogo[i][j] == 128) {
                                                g.setColor(corBloco128);
                                                g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                                g.setColor(Color.BLACK);
                                                g.drawRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                                g.setColor(Color.WHITE);
                                                g.setFont(new Font("Arial", Font.BOLD, 40)); //128
                                                g.drawString("128", 130 + j * 110, 240 + i * 115); //128
                                            } else {
                                                if (matrizDoJogo[i][j] == 256) {
                                                    g.setColor(corBloco256);
                                                    g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                                    g.setColor(Color.BLACK);
                                                    g.drawRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                                    g.setColor(Color.WHITE);
                                                    g.setFont(new Font("Arial", Font.BOLD, 40)); //128
                                                    g.drawString("256", 130 + j * 110, 240 + i * 115); //128
                                                } else {
                                                    if (matrizDoJogo[i][j] == 512) {
                                                        g.setColor(corBloco512);
                                                        g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                                        g.setColor(Color.BLACK);
                                                        g.drawRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                                        g.setColor(Color.WHITE);
                                                        g.setFont(new Font("Arial", Font.BOLD, 40)); //128
                                                        g.drawString("512", 130 + j * 110, 240 + i * 115); //128
                                                    } else {
                                                        if (matrizDoJogo[i][j] == 1024) {
                                                            g.setColor(corBloco1024);
                                                            g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                                            g.setColor(Color.BLACK);
                                                            g.drawRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                                            g.setColor(Color.WHITE);
                                                            g.setFont(new Font("Arial", Font.BOLD, 40)); //128
                                                            g.drawString("1024", 120 + j * 110, 240 + i * 115); //128
                                                        } else {
                                                            if (matrizDoJogo[i][j] == 2048) {
                                                                g.setColor(corBloco2048);
                                                                g.fillRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
                                                                g.setColor(Color.BLACK);
                                                                g.drawRoundRect(115 + j * 110, 175 + i * 115, 100, 100, 25, 25);
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
        
        /*   int x=0;
        if(x==0){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        MediaTracker tracker = new MediaTracker(this);
        Image image = toolkit.getImage("RAIO.gif");
        tracker.addImage(image, 0);
        try{tracker.waitForAll();}catch(InterruptedException e){System.exit(1);}
        g.drawImage(image,100,100,image.getWidth()*2,image.getHeight()*2, null);
        }  */

        int l = 0;
        while (linhaChoque[l] != -1 && flagCimaOuBaixo == 1) {
            for (int i = 0; i < 4 && linhaChoque[l] >= i; i++) { //for para horizontais
                for (int j = 0; j < 3; j++) {
                    if (linhaChoque[l] == i && colunaChoque[l] == j) {
                        g.drawImage(imagemRaio[i][j], 176 + j * 111, 178 + i * 116, 90, 90, this);
                    }
                }
            }
            l += 1;
        }

        l = 0;
        while (linhaChoque[l] != -1 && flagCimaOuBaixo == 2) {
            for (int i = 0; i < 4; i++) { //for para verticais
                for (int j = 0; j < 3; j++) {
                    if (linhaChoque[l] == i && colunaChoque[l] == j) {
                        g.drawImage(imagemRaio[i][j], 121 + i * 111, 237 + j * 116, 90, 90, this);
                    }
                }
            }
            l += 1;
        }

        l = 0;
        int i = 0, j = 0;
        while (linhaSoma[l] != -1) {

            if (matrizDoJogo[(linhaSoma[l])][(colunaSoma[l])] == 4) {
                g.drawImage(imagemBoloco4[i][j], 115 + colunaSoma[l] * 110, 175 + linhaSoma[l] * 115, 100, 100, this);
                j += 1;
                l += 1;
                if (j == 4) {
                    i += 1;
                }
                j = 0;
            } else {
                if (matrizDoJogo[(linhaSoma[l])][(colunaSoma[l])] == 8) {
                    g.drawImage(imagemBoloco8[i][j], 115 + colunaSoma[l] * 110, 175 + linhaSoma[l] * 115, 100, 100, this);
                    j += 1;
                    l += 1;
                    if (j == 4) {
                        i += 1;
                    }
                    j = 0;
                } else {
                    if (matrizDoJogo[(linhaSoma[l])][(colunaSoma[l])] == 16) {
                        g.drawImage(imagemBoloco8[i][j], 115 + colunaSoma[l] * 110, 175 + linhaSoma[l] * 115, 100, 100, this);
                        j += 1;
                        l += 1;
                        if (j == 4) {
                            i += 1;
                        }
                        j = 0;
                    } else {
                        if (matrizDoJogo[(linhaSoma[l])][(colunaSoma[l])] == 32) {
                            g.drawImage(imagemBoloco8[i][j], 115 + colunaSoma[l] * 110, 175 + linhaSoma[l] * 115, 100, 100, this);
                            j += 1;
                            l += 1;
                            if (j == 4) {
                                i += 1;
                            }
                            j = 0;
                        } else {
                            if (matrizDoJogo[(linhaSoma[l])][(colunaSoma[l])] == 64) {
                                g.drawImage(imagemBoloco8[i][j], 115 + colunaSoma[l] * 110, 175 + linhaSoma[l] * 115, 100, 100, this);
                                j += 1;
                                l += 1;
                                if (j == 4) {
                                    i += 1;
                                }
                                j = 0;
                            } else {
                                if (matrizDoJogo[(linhaSoma[l])][(colunaSoma[l])] == 128) {
                                    g.drawImage(imagemBoloco8[i][j], 115 + colunaSoma[l] * 110, 175 + linhaSoma[l] * 115, 100, 100, this);
                                    j += 1;
                                    l += 1;
                                    if (j == 4) {
                                        i += 1;
                                    }
                                    j = 0;
                                } else {
                                    if (matrizDoJogo[(linhaSoma[l])][(colunaSoma[l])] == 256) {
                                        g.drawImage(imagemBoloco8[i][j], 115 + colunaSoma[l] * 110, 175 + linhaSoma[l] * 115, 100, 100, this);
                                        j += 1;
                                        l += 1;
                                        if (j == 4) {
                                            i += 1;
                                        }
                                        j = 0;
                                    } else {
                                        if (matrizDoJogo[(linhaSoma[l])][(colunaSoma[l])] == 512) {
                                            g.drawImage(imagemBoloco8[i][j], 115 + colunaSoma[l] * 110, 175 + linhaSoma[l] * 115, 100, 100, this);
                                            j += 1;
                                            l += 1;
                                            if (j == 4) {
                                                i += 1;
                                            }
                                            j = 0;
                                        } else {
                                            if (matrizDoJogo[(linhaSoma[l])][(colunaSoma[l])] == 1024) {
                                                g.drawImage(imagemBoloco8[i][j], 115 + colunaSoma[l] * 110, 175 + linhaSoma[l] * 115, 100, 100, this);
                                                j += 1;
                                                l += 1;
                                                if (j == 4) {
                                                    i += 1;
                                                }
                                                j = 0;
                                            } else {
                                                if (matrizDoJogo[(linhaSoma[l])][(colunaSoma[l])] == 2048) {
                                                    g.drawImage(imagemBoloco8[i][j], 115 + colunaSoma[l] * 110, 175 + linhaSoma[l] * 115, 100, 100, this);
                                                    j += 1;
                                                    l += 1;
                                                    if (j == 4) {
                                                        i += 1;
                                                    }
                                                    j = 0;
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

    public void movimentar() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == 37 || e.getKeyCode() == 65) {
                    MovimentacaoDosBlocos.esquerda(matrizDoJogo);
                    flagCimaOuBaixo = 1;
                }

                if (e.getKeyCode() == 38 || e.getKeyCode() == 87) {
                    MovimentacaoDosBlocos.cima(matrizDoJogo);
                    flagCimaOuBaixo = 2;
                }

                if (e.getKeyCode() == 39 || e.getKeyCode() == 68) {
                    MovimentacaoDosBlocos.direita(matrizDoJogo);
                    flagCimaOuBaixo = 1;
                }

                if (e.getKeyCode() == 40 || e.getKeyCode() == 83) {
                    MovimentacaoDosBlocos.baixo(matrizDoJogo);
                    flagCimaOuBaixo = 2;
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

        System.out.println("click x: " + clickX + " clickY: " + clickY);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int deltaX = 0, deltaY = 0;

        try {
            soltarX = e.getX();
            soltarY = e.getY();
        } catch (java.lang.NullPointerException e1) {
        }

        if (clickX > 412 && clickX < 483 && clickY > 79 && clickY < 146) {
            flagReiniciar = true;
        }   else {
            if(clickX > 492 && clickX < 563 && clickY > 79 && clickY < 146){
              flagRetornar = true;  
            }
            try {
                deltaX = (soltarX - clickX);
                deltaY = (soltarY - clickY);
                //System.out.println("click x: " + clickX + " clickY: " + clickY + "\nsoltarX: " + soltarX + " soltarY: " + soltarY); 

                if (deltaX < 0 && deltaY < 0) {
                    deltaX = (deltaX * (-1));
                    deltaY = (deltaY * (-1));
                    if (deltaX > deltaY) {
                        MovimentacaoDosBlocos.esquerda(matrizDoJogo);
                        flagCimaOuBaixo = 1;
                        deltaX = (deltaX * (-1));
                        deltaY = (deltaY * (-1));
                    } else {
                        MovimentacaoDosBlocos.cima(matrizDoJogo);
                        flagCimaOuBaixo = 2;
                        deltaX = (deltaX * (-1));
                        deltaY = (deltaY * (-1));
                    }
                } else {
                    if (deltaX > 0 && deltaY < 0) {
                        deltaY = (deltaY * (-1));

                        if (deltaX > deltaY) {
                            MovimentacaoDosBlocos.direita(matrizDoJogo);
                            flagCimaOuBaixo = 1;
                            deltaY = (deltaY * (-1));
                        } else {
                            MovimentacaoDosBlocos.cima(matrizDoJogo);
                            flagCimaOuBaixo = 2;
                            deltaY = (deltaY * (-1));
                        }
                    } else {
                        if (deltaX > 0 && deltaY > 0) {

                            if (deltaX > deltaY) {
                                MovimentacaoDosBlocos.direita(matrizDoJogo);
                                flagCimaOuBaixo = 1;
                            } else {
                                MovimentacaoDosBlocos.baixo(matrizDoJogo);
                                flagCimaOuBaixo = 2;
                            }
                        } else {
                            if (deltaX < 0 && deltaY > 0) {
                                deltaX = (deltaX * (-1));

                                if (deltaX > deltaY) {
                                    MovimentacaoDosBlocos.esquerda(matrizDoJogo);
                                    flagCimaOuBaixo = 1;
                                    deltaX = (deltaX * (-1));

                                } else {
                                    MovimentacaoDosBlocos.baixo(matrizDoJogo);
                                    flagCimaOuBaixo = 2;
                                    deltaX = (deltaX * (-1));
                                }
                            }
                        }
                    }
                }
            } catch (java.lang.NullPointerException e1) {
            }
        } 

        repaint();
        if (MovimentacaoDosBlocos.gerouAleatorio == false) {
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

    public class verificarChoqueOuSoma extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    sleep(400);
                } catch (InterruptedException erro) {
                }
                if (linhaChoque[0] != -1 || linhaSoma[0] != -1) {
                    for (int i = 0; i < 16; i++) {
                        if (i < 12) {
                            linhaChoque[i] = -1;
                            colunaChoque[i] = -1;
                        }
                        linhaSoma[i] = -1;
                        colunaSoma[i] = -1;
                    }

                    try {
                        sleep(300);
                    } catch (InterruptedException erro) {
                    }
                    repaint();
                }
            }
        }
    }

    public class SelecionarComOMouse extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    sleep(10);
                } catch (InterruptedException erro) {
                }
                Point ponto = getMousePosition();

            }
        }
    }

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
