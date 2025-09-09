package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;

public class ClienteDao {

    private static final String IP = "localhost";
    private static final String PORT = "5432";
    private static final String DB = "trbalhoprog3";
    private static final String URL = "jdbc:postgresql://" + IP + ":" + PORT + "/" + DB;
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";

    private Connection conexao;

    public ClienteDao() {
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println(" Conectado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }

    public void adicionarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, cpf, endereco, telefone, email, dataNascimento) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getEndereco());
            comando.setString(4, cliente.getTelefone());
            comando.setString(5, cliente.getEmail());
            comando.setString(6, cliente.getDataNascimento()); 

            comando.executeUpdate();
            System.out.println(" Cliente adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println(" Erro ao adicionar cliente: " + e.getMessage());
        }
    }
    public void deletarCliente(String cpf) {
        String sql = "DELETE FROM cliente WHERE cpf = ?";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, cpf);
            int linhasAfetadas = comando.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println(" Cliente deletado com sucesso!");
            } else {
                System.out.println(" Nenhum cliente encontrado com o CPF fornecido.");
            }
        } catch (SQLException e) {
            System.out.println(" Erro ao deletar cliente: " + e.getMessage());
        }
    }
    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, endereco = ?, telefone = ?, email = ?, dataNascimento = ? "
                   + "WHERE cpf = ?";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getEndereco());
            comando.setString(4, cliente.getTelefone());
            comando.setString(5, cliente.getEmail());
            comando.setString(6, cliente.getDataNascimento());
            comando.setString(7, cliente.getCpf());

            int linhasAfetadas = comando.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println(" Cliente atualizado com sucesso!");
            } else {
                System.out.println(" Nenhum cliente encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.out.println(" Erro ao atualizar cliente: " + e.getMessage());
        }
    }
    public Cliente buscarClientePorCpf(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf = ?";
        Cliente cliente = null;

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, cpf);
            var resultado = comando.executeQuery();

            if (resultado.next()) {
                cliente = new Cliente(
                    resultado.getString("nome"),
                    resultado.getString("cpf"),
                    resultado.getString("endereco"),
                    resultado.getString("telefone"),
                    resultado.getString("email"),
                    resultado.getString("dataNascimento")
                );
                System.out.println(" Cliente encontrado: " + cliente.getNome());
            } else {
                System.out.println(" Nenhum cliente encontrado com o CPF fornecido.");
            }
        } catch (SQLException e) {
            System.out.println(" Erro ao buscar cliente: " + e.getMessage());
        }
        return cliente;
    }
    public ArrayList<Cliente> listarClientes() {
        String sql = "SELECT * FROM cliente";
        ArrayList<Cliente> clientes = new ArrayList<>();

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            var resultado = comando.executeQuery();

            while (resultado.next()) {
                Cliente cliente = new Cliente(
                    resultado.getString("nome"),
                    resultado.getString("cpf"),
                    resultado.getString("endereco"),
                    resultado.getString("telefone"),
                    resultado.getString("email"),
                    resultado.getString("dataNascimento")
                );
                clientes.add(cliente);
            }
            System.out.println(" Lista de clientes obtida com sucesso!");
        } catch (SQLException e) {
            System.out.println(" Erro ao listar clientes: " + e.getMessage());
        }
        return clientes;
    }

    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println(" Conexão fechada.");
            }
        } catch (SQLException e) {
            System.out.println(" Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
