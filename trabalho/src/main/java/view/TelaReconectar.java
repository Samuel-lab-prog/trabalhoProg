<<<<<<< HEAD:trabalho/src/main/java/com/example/TelaReconectar.java
package com.example;
=======
package view;
>>>>>>> 6a8a55305b8e1f582d191ca580a3c0938a76fff3:trabalho/src/main/java/view/TelaReconectar.java

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
