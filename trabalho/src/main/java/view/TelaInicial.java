<<<<<<< HEAD:trabalho/src/main/java/com/example/TelaInicial.java
package com.example;
=======
package view;
>>>>>>> 6a8a55305b8e1f582d191ca580a3c0938a76fff3:trabalho/src/main/java/view/TelaInicial.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame implements ActionListener {

    private JTextArea nome = new JTextArea("Humberto");
    private JButton botaoCadastar = new JButton("Tela Cadastrar");
    private JButton botaoAlterar = new JButton("Tela Alterar");
    private JButton botaoExcluir = new JButton("Tela Excluir");
    private JButton botaoPesquisar = new JButton("Tela Pesquisar");
    private JButton botaoSair = new JButton("Sair");
    private JLabel fundo = new JLabel(new ImageIcon("imagens/fundoMenu.gif"));
    public TelaInicial() {


        setContentPane(fundo);
        getContentPane().add(nome);
        getContentPane().add(botaoCadastar);
        getContentPane().add(botaoAlterar);
        getContentPane().add(botaoExcluir);
        getContentPane().add(botaoPesquisar);
        getContentPane().add(botaoSair);

        fundo.setLayout(null);
        setTitle("Menu - nomeDeAlgo");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        botaoCadastar.setBounds(0, 80, 150, 60);
        botaoAlterar.setBounds(0, 160, 150, 60);
        botaoExcluir.setBounds(0, 240, 150, 60);
        botaoPesquisar.setBounds(0, 320, 150, 60);
        botaoSair.setBounds(0, 400, 150, 60);
        nome.setBounds(550, 120,150, 30);

        botaoCadastar.addActionListener(this);
        botaoAlterar.addActionListener(this);
        botaoExcluir.addActionListener(this);
        botaoPesquisar.addActionListener(this);

        nome.setFont( new Font("Georgia", Font.BOLD, 25));
        nome.setEditable(false);
        nome.setOpaque(false);
        nome.setFocusable(false);

        botaoCadastar.setVisible(true);
        botaoAlterar.setVisible(true);
        botaoExcluir.setVisible(true);
        botaoPesquisar.setVisible(true);
        botaoSair.setVisible(true);
        nome.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == botaoCadastar) {

        }
        if(e.getSource() == botaoAlterar) {

        }
        if(e.getSource() == botaoExcluir) {

        }
        if(e.getSource() == botaoPesquisar) {

        }
        if(e.getSource() == botaoSair) {
            System.exit(0);
        }
    }
}
