package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDao {

    final private String ip = "localhost";
    final private String port = "5432";
    final private String db = "trbalhoprog3";
    final private String url = "jdbc:postgresql://" + ip + ":" + port + "/" + db;
    final private String usuario = "postgres";
    final private String senha = "postgres";

    Connection conexao = null;

    public ClienteDao() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
    }

    public void adicionaCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, cpf, endereco, telefone, email, dataNascimento) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conexao = DriverManager.getConnection(url,usuario,senha);
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getEndereco());
            comando.setString(4, cliente.getTelefone());
            comando.setString(5, cliente.getEmail());
            comando.setString(6, cliente.getDataNascimento());

            comando.executeUpdate();
            System.out.println("Cliente adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
        }
    }

    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexão fechada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
