package com.example;

public class Main {
    public static void main(String[] args) {
        // Criando um cliente
        Cliente cliente = new Cliente("12312312310", "01123123000101", "Klaudio", "123456", "ProfKlaudio@professor.com", 1, 0.0);

        // Criando uma conta corrente e cobrando tarifas
        ContaCorrente contaCorrente = new ContaCorrente("12312312310", "01123123000101", "Klaudio", "123456", "ProfKlaudio@professor.com", 1, 10000.0);
        contaCorrente.cobrarTarifaBancaria(50.0);

        // Criando uma conta poupança e aplicando rendimento
        ContaPoupanca contaPoupanca = new ContaPoupanca("12312312310", "01123123000101", "Klaudio", "123456", "ProfKlaudio@professor.com", 1, 5000.0);
        contaPoupanca.aplicarRendimento();

        // Criando uma conta PJ e validando
        ContaPJ contaPJ = new ContaPJ("12312312310", "01123123000101", "Klaudio", "123456", "ProfKlaudio@professor.com", 1, 20000.0);
        boolean cnpjValido = contaPJ.validarCNPJ("01123123000101");
        
        if (cnpjValido) {
            System.out.println("CNPJ válido");
        } else {
            System.out.println("CNPJ inválido");
        }

        // Criando um administrador e adicionando dados das operações bancárias
        Administrador admin = new Administrador("11122233344", "", "Admin", "admin123", "admin@admin.com", 2, 0.0);
        admin.adicionarSaque(1000.0);
        admin.adicionarDeposito(1100.0);

        // Gerando relatórios pegando como base os dados do administrador
        Relatorios relatorios = new Relatorios();
        relatorios.gerarRelatorios(admin);
    }
}
