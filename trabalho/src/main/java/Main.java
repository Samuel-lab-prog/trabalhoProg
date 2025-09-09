import java.util.Scanner;
import dao.ClienteDao;
import model.Cliente;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("""
                    ----------------------------------------------
                    Menu - Sistema de Gerenciamento de Clientes
                    ----------------------------------------------
                    Escolha uma opção:
                    1 - Adicionar cliente
                    2 - Buscar cliente
                    3 - Atualizar cliente
                    4 - Deletar cliente
                    5 - Listar clientes
                    0 - Sair
                    ----------------------------------------------""");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar cliente selecionado.");
                    ClienteDao clienteDao = new ClienteDao();
                    Cliente cliente = new Cliente();
                    System.out.print("Nome: ");
                    cliente.setNome(scanner.nextLine());
                    System.out.print("CPF: ");
                    cliente.setCpf(scanner.nextLine());
                    System.out.print("Endereço: ");
                    cliente.setEndereco(scanner.nextLine());
                    System.out.print("Telefone: ");
                    cliente.setTelefone(scanner.nextLine());
                    System.out.print("Email: ");
                    cliente.setEmail(scanner.nextLine());
                    System.out.print("Data de Nascimento (YYYY-MM-DD): ");
                    cliente.setDataNascimento(scanner.nextLine());
                    clienteDao.adicionarCliente(cliente);
                    break;
                case 2:
                    clienteDao = new ClienteDao();
                    System.out.println("Buscar cliente selecionado.");
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    Cliente clienteBuscado = clienteDao.buscarClientePorCpf(cpf);
                    if (clienteBuscado != null) {
                        System.out.println("Cliente encontrado:");
                        System.out.println(clienteBuscado);
                    }
                    break;
                case 3:
                    clienteDao = new ClienteDao();
                    System.out.println("Atualizar cliente selecionado.");
                    System.out.print("Digite o CPF do cliente a ser atualizado: ");
                    String cpfAtualizar = scanner.nextLine();
                    Cliente clienteAtualizar = clienteDao.buscarClientePorCpf(cpfAtualizar);
                    if (clienteAtualizar != null) {
                        System.out.print("Novo Nome (atual: " + clienteAtualizar.getNome() + "): ");
                        clienteAtualizar.setNome(scanner.nextLine());
                        System.out.print("Novo Endereço (atual: " + clienteAtualizar.getEndereco() + "): ");
                        clienteAtualizar.setEndereco(scanner.nextLine());
                        System.out.print("Novo Telefone (atual: " + clienteAtualizar.getTelefone() + "): ");
                        clienteAtualizar.setTelefone(scanner.nextLine());
                        System.out.print("Novo Email (atual: " + clienteAtualizar.getEmail() + "): ");
                        clienteAtualizar.setEmail(scanner.nextLine());
                        System.out.print(
                                "Nova Data de Nascimento (atual: " + clienteAtualizar.getDataNascimento() + "): ");
                        clienteAtualizar.setDataNascimento(scanner.nextLine());
                        clienteDao.atualizarCliente(clienteAtualizar);
                    }
                    break;
                case 4:
                    clienteDao = new ClienteDao();
                    System.out.println("Deletar cliente selecionado.");
                    System.out.print("Digite o CPF do cliente a ser deletado: ");
                    String cpfDeletar = scanner.nextLine();
                    clienteDao.deletarCliente(cpfDeletar);
                    break;
                case 5:
                    System.out.println("Listar clientes selecionado.");
                    clienteDao = new ClienteDao();
                    ArrayList<Cliente> clientes = clienteDao.listarClientes();
                    for (Cliente c : clientes) {
                        System.out.println(c);
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

    }

}