package trabalho.src.main.java.com.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenu extends JFrame implements ActionListener {

    private JLabel textoDeAviso = new JLabel("Aviso");
    private JLabel titulo = new JLabel("Menu");
    private JLabel localSenha = new JLabel("Senha: ");
    private JLabel localNome = new JLabel("Nome: ");
    private JTextField senhaDig = new JTextField();
    private JTextField nomeDig = new JTextField();
    private JButton botaoEntar = new JButton("Entar");
    private JButton botaoSair = new JButton("Sair");
    private JLabel fundo = new JLabel(new ImageIcon("imagens/fundoMenu.png"));

    private String usuario[] = {"william", "leonel", "samuel"};
    private String senhas[] = {"EuAmoProg", "MinhaSenha123", "123"};

    public TelaMenu() {
        setContentPane(fundo);
        getContentPane().add(titulo);
        getContentPane().add(localSenha);
        getContentPane().add(localNome);
        getContentPane().add(senhaDig);
        getContentPane().add(nomeDig);
        getContentPane().add(botaoEntar);
        getContentPane().add(botaoSair);
        getContentPane().add(textoDeAviso);

        fundo.setLayout(null);
        setTitle("Menu - nomeDeAlgo");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        localNome.setBounds(255, 175, 50, 20);
        localSenha.setBounds(255, 230, 50, 20);
        nomeDig.setBounds(255, 200, 300, 20);
        senhaDig.setBounds(255, 255, 300, 20);
        botaoEntar.setBounds(260, 340, 100, 40);
        botaoSair.setBounds(440, 340, 100, 40);
        textoDeAviso.setBounds(255, 285, 250, 30);

        botaoEntar.addActionListener(this);
        botaoSair.addActionListener(this);

        titulo.setVisible(false);
        localSenha.setVisible(true);
        localNome.setVisible(true);
        nomeDig.setVisible(true);
        senhaDig.setVisible(true);
        botaoEntar.setVisible(true);
        botaoSair.setVisible(true);
        textoDeAviso.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botaoEntar) {

            boolean verificarEntrada = false;
            int verificarSituacao = 0;

            if (nomeDig.getText().equals("") && senhaDig.getText().equals("")) {
                textoDeAviso.setText("Nao foi digitado nome e senha!");
                verificarSituacao = 1;
            } else if (senhaDig.getText().equals("")) {
                textoDeAviso.setText("Nao foi digitado senha!");
                verificarSituacao = 1;
            } else if (nomeDig.getText().equals("")) {
                textoDeAviso.setText("Nao foi digitado nome!");
                verificarSituacao = 1;
            }

            switch(verificarSituacao) {
                case 0:
                    if (nomeDig.getText().equals(usuario[0]) && senhaDig.getText().equals(senhas[0])) {
                        verificarEntrada = true;
                    } else if (nomeDig.getText().equals(usuario[1]) && senhaDig.getText().equals(senhas[1])) {
                        verificarEntrada = true;
                    } else if (nomeDig.getText().equals(usuario[2]) && senhaDig.getText().equals(senhas[2])) {
                        verificarEntrada = true;
                    } else {
                        System.out.println("System: > Policial nao registrado no sistema, por favor fale com o administrador do sistema! <");
                        textoDeAviso.setText("Usuario nao registrado no sistema!");
                    }
                    break;
                case 1:
                    System.out.println("System: > Nao rodar o sistemqa de verificacao de usuario! <");
                    break;
            }


            textoDeAviso.setVisible(true);

            if (verificarEntrada == true) {
                System.out.println("System > Bem vindo usuario " + nomeDig.getText() + " <");
            } else {
                System.out.println("System: > Voce foi bloqueado de entrar! <");
            }
        }
        if(e.getSource() == botaoSair) {
            System.exit(0);
        }
    }
}

