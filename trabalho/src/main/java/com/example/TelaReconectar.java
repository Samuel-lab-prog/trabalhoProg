package trabalho.src.main.java.com.example;

import javax.swing.*;

public class TelaReconectar extends JFrame {

    private JLabel fundo = new JLabel(new ImageIcon("imagens/fundoMenu.gif"));

    public TelaReconectar(){
        // isso é o basico para uma tela ok? *Autor: Will*
        fundo.setLayout(null);
        setTitle("Menu - nomeDeAlgo");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
