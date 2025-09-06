package trabalho.src.main.java.com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDao {

    final String ip = "localhost";
    final String port = "5432";
    final String db = "trabalhoprog3";
    final String url = "jdbc:postgresql://" + ip + ":" + port + "/" + db;
    final String usuario = "postgres";
    final String senha = "";

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
        String sql = "INSERT INTO clientes (nome, cpf, endereco, telefone, email, dataNascimento) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conexao = DriverManager.getConnection(url,usuario,senha);
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getEndereco());
            comando.setString(4, cliente.getTelefone());
            comando.setString(5, cliente.getEmail());
            comando.setString(6, cliente.toString());

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
