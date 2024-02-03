package telas;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import regras.ControleBotoesSelecionados;
import regras.EstadosBotoes;

public class TelaPrincipal extends JFrame {
    
    private static final int QUANTIDADE_JOGADAS = 2;
    private int jogadas = 0;
    
    private JPanel painel;
    
    private List<ControleBotoesSelecionados> listaControle;
    
    private List<ControleBotoesSelecionados> listaSelecionados;
    
    private ActionListener acaoBotoes;
    
    public TelaPrincipal() {
        super("Jogo da Memoria");
        
        listaControle = new ArrayList<>();
        listaSelecionados = new ArrayList<>();
        
        // Evento dos botões
        acaoBotoes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton botao = (JButton) e.getSource();
                for (ControleBotoesSelecionados cont : listaControle) {
                    if (cont.getReferenciaBotoes().get(botao) != null) {
                        jogadas++;
                        cont.executarAcaoBotoes((JButton) e.getSource(), EstadosBotoes.SELECIONADO);
                        // Controle de inclusão
                        if (!listaSelecionados.contains(cont)) {
                            listaSelecionados.add(cont);
                        }
                        System.out.println(listaSelecionados.size());
                        if (jogadas == QUANTIDADE_JOGADAS) {
                            // Acabaram as jogadas
                            if (listaSelecionados.size() > 1) {
                                // Deixar os botões com estado inicial
                                for (ControleBotoesSelecionados cbs : listaSelecionados) {
                                    cbs.zerarSelecoes();
                                }
                            } 
                            jogadas = 0;
                            listaSelecionados.clear();
                        }
                        break;
                    }
                }
            }
        };
        
        painel = new JPanel();
        this.add(painel);
        painel.setLayout(null);  
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        criarJogo(3);
        this.setBounds(250, 250, 800, 600);
        this.setVisible(true);
    }
    
    private void criarJogo(int qtPares) {
        // Quantidade de botões
        ControleBotoesSelecionados controle = null;
        
        List<Rectangle> posicionamentos = new ArrayList<>();
        int posX = 100;
        int posY = 200;
        
        Random rand = new Random();
        int j = 0;
        int i = 0;
        
        for (i = 0; i < (qtPares * 2); i++) {
            // Randomizar o posicionamento dos botões
            Rectangle rec = new Rectangle(posX, posY, 90, 100);
            posicionamentos.add(rec);
            if (i % 5 == 0 && i > 0) {
                posY += 90;
                posX = 40;
            } else {
                posX += 100;
            }
        }
        
        for (i = 0; i < (qtPares * 2); i++) {
            if (i % 2 == 0) {
                // Quantidade de controladores
                j++;
                controle = new ControleBotoesSelecionados();
                controle.setNmBotao("B " + j);
                this.listaControle.add(controle);
            }
            JButton botao = new JButton("Jogo");
            // Colocar os botões na tela
            this.painel.add(botao);
            botao.addActionListener(this.acaoBotoes);
            // Adicionar posição
            int pos = rand.nextInt(((posicionamentos.size() - 1) > 0) ? posicionamentos.size() - 1 : 1);
            System.out.println(pos);
            botao.setBounds(posicionamentos.get(pos));
            posicionamentos.remove(pos);
            
            
            controle.adicionarBotao(botao);
            
        }
        // Adaptar o tamanho da tela
        
        
    }
    
}

