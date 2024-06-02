package com.example.Model;

public class ContaCorrente extends Cliente {

    public ContaCorrente(String cpf, String cnpj, String nome, String senha, String email, int tipoDeConta, double saldo) {
        super(cpf, cnpj, nome, senha, email, tipoDeConta, saldo);
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
