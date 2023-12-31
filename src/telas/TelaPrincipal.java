package telas;

import javax.swing.*;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal(){
        super("Jogo da Memória");

        this.setBounds(250, 100, 600, 600);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
