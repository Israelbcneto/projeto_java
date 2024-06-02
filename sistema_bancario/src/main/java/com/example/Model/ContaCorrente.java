package com.example.Model;

public class ContaCorrente extends Cliente {

    // Novo construtor que não exige CNPJ
    public ContaCorrente(String cpf, String nome, String senha, String email, int tipoDeConta, double saldo) {
        super(cpf, "", nome, senha, email, tipoDeConta, saldo); // Passando uma string vazia para CNPJ
    }

    // Tarifa bancária
    public void cobrarTarifaBancaria(double valorTarifa) {
        if (saldo >= valorTarifa) {
            saldo -= valorTarifa;
            System.out.println("Tarifa bancária cobrada com sucesso: " + valorTarifa);
        } else {
            System.out.println("Saldo insuficiente para cobrar tarifa bancária.");
        }
    }
}
