package trabalho.src.main.java.com.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame implements ActionListener {

    private JButton botaoCadastar = new JButton("Tela Cadastrar");
    private JButton botaoAlterar = new JButton("Tela Alterar");
    private JButton botaoExcluir = new JButton("Tela Excluir");
    private JButton botaoPesquisar = new JButton("Tela Pesquisar");
    private JButton botaoSair = new JButton("Sair");
    private JLabel fundo = new JLabel(new ImageIcon("imagens/fundoMenu.gif"));
    public TelaInicial() {

        setContentPane(fundo);
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

        botaoCadastar.setBounds(0, 0, 800, 60);
        botaoAlterar.setBounds(0, 0, 800, 60);
        botaoExcluir.setBounds(0, 0, 800, 60);
        botaoPesquisar.setBounds(0, 0, 800, 60);
        botaoSair.setBounds(0, 0, 800, 60);

        botaoCadastar.addActionListener(this);
        botaoAlterar.addActionListener(this);
        botaoExcluir.addActionListener(this);
        botaoPesquisar.addActionListener(this);

        botaoCadastar.setVisible(false);
        botaoAlterar.setVisible(false);
        botaoExcluir.setVisible(false);
        botaoPesquisar.setVisible(false);
        botaoSair.setVisible(false);
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
