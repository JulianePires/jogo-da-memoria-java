package regras;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ControleBotoesSelecionados {
    private String nomeBotao;
    private Map<JButton, Boolean> referenciasBotoes;

    public ControleBotoesSelecionados(){
        this.referenciasBotoes = new HashMap<>();
    }

    public String getNomeBotao() {
        return nomeBotao;
    }

    public void setNomeBotao(String nmBotao) {
        this.nomeBotao = nomeBotao;
    }

    public Map<JButton, Boolean> getReferenciasBotoes() {
        return referenciasBotoes;
    }

    public void setReferenciasBotoes(Map<JButton, Boolean> referenciasBotoes) {
        this.referenciasBotoes = referenciasBotoes;
    }

    public void adicionarBotao(JButton botao){
        this.referenciasBotoes.put(botao, Boolean.FALSE);
    }

    public void alterarSelecao(JButton botao, Boolean selecionado){
        Boolean b = this.referenciasBotoes.get(botao);
        b = selecionado;
    }

    public void botaoSelecionado(JButton botao){
        Boolean b = this.referenciasBotoes.get(botao);
        b = true;
    }

    public void zerarSelecoes(){
        this.referenciasBotoes.values().forEach((b) -> {
            b = false;
        });
    }

    public Boolean estaoTodasSelecionadas() {
        for (Boolean b : this.referenciasBotoes.values()) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
    
}
