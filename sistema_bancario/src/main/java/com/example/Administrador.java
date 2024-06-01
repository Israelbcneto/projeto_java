package com.example;

public class Administrador extends Usuario {
    private double totalSaques;
    private double totalDepositos;

    public Administrador(String cpf, String cnpj, String nome, String senha, String email, int tipoDeConta, double saldo) {
        super(cpf, cnpj, nome, senha, email, tipoDeConta);
        this.totalSaques = 0.0;
        this.totalDepositos = 0.0;
    }

    public void adicionarSaque(double valor) {
        totalSaques += valor;
    }

    public void adicionarDeposito(double valor) {
        totalDepositos += valor;
    }

    public double getTotalSaques() {
        return totalSaques;
    }

    public double getTotalDepositos() {
        return totalDepositos;
    }
}
