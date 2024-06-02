package com.example;

import com.example.Model.Administrador;
import com.example.Model.Cliente;
import com.example.Model.ContaCorrente;
import com.example.Model.ContaPJ;
import com.example.Model.ContaPoupanca;
import com.example.Model.Relatorios;
import com.example.Repository.QueryExecutions;
import com.example.Repository.Datas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = null;
        ContaCorrente contaCorrente = null;
        ContaPoupanca contaPoupanca = null;
        ContaPJ contaPJ = null;
        Administrador admin = null;
        Relatorios relatorios = new Relatorios();
        QueryExecutions executor = null;
        
        try {
            executor = new QueryExecutions();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.println("Bem-vindo ao sistema bancário!");
            System.out.println("Selecione a opção:");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Criar Conta Corrente");
            System.out.println("3. Criar Conta Poupança");
            System.out.println("4. Criar Conta PJ");
            System.out.println("5. Login Administrador");
            System.out.println("6. Realizar Saque");
            System.out.println("7. Realizar Depósito");
            System.out.println("8. Cobrar Tarifa Bancária");
            System.out.println("9. Aplicar Rendimento (Conta Poupança)");
            System.out.println("10. Validar CNPJ (Conta PJ)");
            System.out.println("11. Gerar Relatórios");
            System.out.println("12. Consultar Cliente");
            System.out.println("0. Sair");
            int option = scanner.nextInt();
            scanner.nextLine();

            clearConsole();

            switch (option) {
                case 1:
                    System.out.println("Criando um cliente...");
                    Datas novoCliente = new Datas("12312312310", "Klaudio", "ProfKlaudio@professor.com", 1, "123456", 0.0f);
                    executor.insertCliente(novoCliente);
                    System.out.println("Cliente criado com sucesso!");
                    break;
                case 2:
                    System.out.println("Criando uma conta corrente...");
                    contaCorrente = new ContaCorrente("12312312310", "01123123000101", "Klaudio", "123456", "ProfKlaudio@professor.com", 1, 10000.0);
                    System.out.println("Conta Corrente criada com sucesso!");
                    break;
                case 3:
                    System.out.println("Criando uma conta poupança...");
                    contaPoupanca = new ContaPoupanca("12312312310", "01123123000101", "Klaudio", "123456", "ProfKlaudio@professor.com", 1, 5000.0);
                    System.out.println("Conta Poupança criada com sucesso!");
                    break;
                case 4:
                    System.out.println("Criando uma conta PJ...");
                    contaPJ = new ContaPJ("12312312310", "01123123000101", "Klaudio", "123456", "ProfKlaudio@professor.com", 1, 20000.0);
                    System.out.println("Conta PJ criada com sucesso!");
                    break;
                case 5:
                    System.out.println("Fazendo login como administrador...");
                    admin = new Administrador("11122233344", "", "Admin", "admin123", "admin@admin.com", 2, 0.0);
                    System.out.println("Login de administrador bem-sucedido!");
                    break;
                case 6:
                    if (admin != null) {
                        System.out.println("Digite o valor do saque:");
                        double saque = scanner.nextDouble();
                        scanner.nextLine();
                        admin.adicionarSaque(saque);
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Por favor, faça login como administrador primeiro.");
                    }
                    break;
                case 7:
                    if (admin != null) {
                        System.out.println("Digite o valor do depósito:");
                        double deposito = scanner.nextDouble();
                        scanner.nextLine();
                        admin.adicionarDeposito(deposito);
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Por favor, faça login como administrador primeiro.");
                    }
                    break;
                case 8:
                    if (contaCorrente != null) {
                        System.out.println("Digite o valor da tarifa bancária:");
                        double tarifa = scanner.nextDouble();
                        scanner.nextLine();
                        contaCorrente.cobrarTarifaBancaria(tarifa);
                        System.out.println("Tarifa bancária cobrada com sucesso!");
                    } else {
                        System.out.println("Por favor, crie uma conta corrente primeiro.");
                    }
                    break;
                case 9:
                    if (contaPoupanca != null) {
                        contaPoupanca.aplicarRendimento();
                        System.out.println("Rendimento aplicado com sucesso!");
                    } else {
                        System.out.println("Por favor, crie uma conta poupança primeiro.");
                    }
                    break;
                case 10:
                    if (contaPJ != null) {
                        System.out.println("Validando CNPJ...");
                        boolean cnpjValido = contaPJ.validarCNPJ("01123123000101");
                        if (cnpjValido) {
                            System.out.println("CNPJ válido");
                        } else {
                            System.out.println("CNPJ inválido");
                        }
                    } else {
                        System.out.println("Por favor, crie uma conta PJ primeiro.");
                    }
                    break;
                case 11:
                    if (admin != null) {
                        System.out.println("Gerando relatórios...");
                        relatorios.gerarRelatorios(admin);
                        System.out.println("Relatórios gerados com sucesso!");
                    } else {
                        System.out.println("Por favor, faça login como administrador primeiro.");
                    }
                    break;
                case 12:
                    System.out.println("Digite o número do documento do cliente a ser consultado:");
                    String docNumber = scanner.nextLine();
                    Datas clienteConsultado = executor.getClienteById(docNumber);
                    if (clienteConsultado != null) {
                        System.out.println("Cliente encontrado: " + clienteConsultado.getName());
                        System.out.println("Email: " + clienteConsultado.getEmail());
                        System.out.println("Conta: " + clienteConsultado.getAccount());
                        System.out.println("Saldo: " + clienteConsultado.getBalance());
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
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
            // Handle any exceptions.
            e.printStackTrace();
        }
    }
}
