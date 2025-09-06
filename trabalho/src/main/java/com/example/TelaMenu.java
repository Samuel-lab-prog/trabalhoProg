package trabalho.src.main.java.com.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenu extends JFrame implements ActionListener {

    ClienteDao clienteDAO;
    Cliente cliente;
    private JLabel textoDeAviso = new JLabel("Aviso");
    private JLabel titulo = new JLabel("Menu");
    private JLabel localSenha = new JLabel("Senha: ");
    private JLabel localNome = new JLabel("Nome: ");
    private JTextField senhaDig = new JTextField();
    private JTextField nomeDig = new JTextField();
    private JButton botaoEntar = new JButton("Entar");
    private JButton botaoSair = new JButton("Sair");
    private JButton botaoTrocarS = new JButton("Trocar S");
    private JLabel fundo = new JLabel(new ImageIcon("imagens/fundoMenu.gif"));

    private String usuario[] = {"william", "leonel", "samuel", "jose"};
    private String senhas[] = {"EuAmoProg", "MinhaSenha123", "123", "321"};

    public TelaMenu() {

        setContentPane(fundo);
        getContentPane().add(titulo);
        getContentPane().add(localSenha);
        getContentPane().add(localNome);
        getContentPane().add(senhaDig);
        getContentPane().add(nomeDig);
        getContentPane().add(botaoEntar);
        getContentPane().add(botaoSair);
        getContentPane().add(botaoTrocarS);
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
        botaoTrocarS.setBounds(350, 400, 100, 40);
        textoDeAviso.setBounds(255, 285, 250, 30);

        botaoEntar.addActionListener(this);
        botaoSair.addActionListener(this);
        botaoTrocarS.addActionListener(this);

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
            int verificarSituacao = 0, verificarSituacao2 = 0;

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

                    for (int i = 0; i < usuario.length; i++) {
                        if (nomeDig.getText().equals(usuario[i]) && senhaDig.getText().equals(senhas[i])) {
                            verificarEntrada = true;
                            verificarSituacao2 = 1;
                        } else {
                            System.out.println("System: > Procurando.. <");

                        }
                    }

                    if(verificarSituacao2 == 1){
                        System.out.println("System: > Encontramos voce em nosso sistema! <");
                    }
                    else{
                        textoDeAviso.setText("Usuario nao registrado no sistema!");
                        System.out.println("System: > Nao registrado no sistema, por favor fale com o administrador do sistema! <");
                    }

                    break;
                case 1:
                    System.out.println("System: > Nao rodar o sistemqa de verificacao de usuario! <");
                    break;
                }
            textoDeAviso.setVisible(true);

            if (verificarEntrada == true) {
                System.out.println("System > Bem vindo usuario " + nomeDig.getText() + " <");
                TelaInicial telaInicial = new TelaInicial();
                telaInicial.setVisible(true);
                dispose();
            } else {
                System.out.println("System: > Voce foi bloqueado de entrar! <");
            }
        }
        if(e.getSource() == botaoTrocarS){
            TelaReconectar telaReconectar = new TelaReconectar();
            telaReconectar.setVisible(true);
            setVisible(false);
        }
        if(e.getSource() == botaoSair) {
            System.exit(0);
        }
    }
}

