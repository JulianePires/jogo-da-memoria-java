package regras;

import javax.swing.*;

public class ReferenciasBotoes {
    private JButton botao;
    private Boolean selecionado;

    public JButton getBotao() {
        return botao;
    }

    public void setBotao(JButton botao) {
        this.botao = botao;
    }

    public Boolean getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Boolean selecionado) {
        this.selecionado = selecionado;
    }
}
