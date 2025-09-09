package com.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Lembrar de trazer de volta!
        //TelaMenu telaMenu = new TelaMenu();
        //TelaInicial telaInicial = new TelaInicial(); // retirar depois

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();

        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();

        System.out.print("Digite a data de nascimento do cliente (dd/mm/aaaa): ");
        String dataNascimento = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, endereco, telefone, email, dataNascimento);
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.adicionaCliente(cliente);
        clienteDao.fecharConexao();
        scanner.close();

  

        
    }

}