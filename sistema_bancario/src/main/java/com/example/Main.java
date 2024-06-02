package com.example;

import com.example.Model.Administrador;
import com.example.Model.Cliente;
import com.example.Repository.QueryExecutions;
import com.example.Repository.Datas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static QueryExecutions executor;

    public static void main(String[] args) throws IOException, SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        try {
            executor = new QueryExecutions();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return;
        }

        while (continuar) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Login");
            System.out.println("2. Cadastro com CPF (Pessoa Física)");
            System.out.println("3. Cadastro com CNPJ (Pessoa Jurídica)");
            System.out.println("4. Login como Admin");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            clearConsole();

            switch (opcao) {
                case 1:
                    Cliente usuarioLogado = login(scanner);
                    if (usuarioLogado != null) {
                        menuFinanceiro(scanner, usuarioLogado);
                    }
                    break;
                case 2:
                    cadastroPessoaFisica(scanner);
                    break;
                case 3:
                    cadastroPessoaJuridica(scanner);
                    break;
                case 4:
                    Administrador adm = loginAdmin(scanner);
                    if (adm != null) {
                        menuAdmin(scanner, adm);
                    }
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static Cliente login(Scanner scanner) {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        Datas dadosCliente = executor.getClienteByEmailAndPassword(email, password);
        if (dadosCliente != null) {
            System.out.println("Login bem-sucedido!");
            if(dadosCliente.getDocument_number().length() == 10){
                return new Cliente(dadosCliente.getDocument_number(), "", dadosCliente.getName(), dadosCliente.getPassword(), dadosCliente.getEmail(), dadosCliente.getAccount(), dadosCliente.getBalance());

            } else{
                return new Cliente("", dadosCliente.getDocument_number(), dadosCliente.getName(), dadosCliente.getPassword(), dadosCliente.getEmail(), dadosCliente.getAccount(), dadosCliente.getBalance());

            }
        } else {
            System.out.println("Login falhou. Email ou senha incorretos.");
            return null;
        }
    }

    private static Administrador loginAdmin(Scanner scanner) {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        Datas dadosAdmin = executor.getAdminByEmailAndPassword(email, password);
        if (dadosAdmin != null) {
            System.out.println("Login de Admin bem-sucedido!");
            return new Administrador(dadosAdmin.getDocument_number(), "", dadosAdmin.getName(), dadosAdmin.getPassword(), dadosAdmin.getEmail(), dadosAdmin.getAccount(), dadosAdmin.getBalance());
        } else {
            System.out.println("Login falhou. Email ou senha incorretos.");
            return null;
        }
    }

    private static void menuFinanceiro(Scanner scanner, Cliente usuario) throws SQLException {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menu Financeiro ---");
            System.out.println("1. Sacar");
            System.out.println("2. Depositar");
            System.out.println("3. Empréstimo e consulta de débito");
            System.out.println("4. Ver Saldo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            clearConsole();

            switch (opcao) {
                case 1:
                    System.out.print("Quantia para saque: ");
                    double saque = scanner.nextDouble();
                    usuario.sacar(saque);
                    break;
                case 2:
                    System.out.print("Quantia para depósito: ");
                    double deposito = scanner.nextDouble();
                    usuario.depositar(deposito);
                    break;
                case 3:
                    System.out.print("Quantia para empréstimo(caso deseje apenas ver seu débito digite um valor 0): ");
                    double emprestimo = scanner.nextDouble();
                    usuario.emprestimo(emprestimo);
                    break;
                case 4:
                    System.out.println("Saldo: " + usuario.getSaldo());
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Saindo do menu financeiro...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void menuAdmin(Scanner scanner, Administrador adm) {
        Administrador admin = adm;
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menu do Admin ---");
            System.out.println("1. Listar todos os CPFs");
            System.out.println("2. Listar todos os CNPJs");
            System.out.println("3. Excluir uma conta");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            clearConsole();

            switch (opcao) {
                case 1:
                    admin.listarCpfs(executor);
                    break;
                case 2:
                    admin.listarCnpjs(executor);
                    break;
                case 3:
                    System.out.print("Digite o CPF ou CNPJ para excluir: ");
                    String id = scanner.nextLine();
                    admin.excluirConta(executor, id);
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saindo do menu do admin...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void cadastroPessoaFisica(Scanner scanner) {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();
        System.out.print("Saldo: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();

        Datas novaPessoa = new Datas(cpf, name, email, 1, password, saldo);
        executor.insertCliente(novaPessoa);
        System.out.println("Pessoa física cadastrada com sucesso.");
    }

    private static void cadastroPessoaJuridica(Scanner scanner) {
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();
        System.out.print("Saldo: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();

        Datas novaPessoa = new Datas(cnpj, name, email, 2, password, saldo);
        executor.insertCliente(novaPessoa);
        System.out.println("Pessoa jurídica cadastrada com sucesso.");
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
