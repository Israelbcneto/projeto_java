package com.example.Model;

public class ContaPJ extends Cliente {
    
    public ContaPJ(String cpf, String cnpj, String nome, String senha, String email, int tipoDeConta, double saldo) {
        super(cpf, cnpj, nome, senha, email, tipoDeConta, saldo);
    }

    // Método para validar CNPJ
    public boolean validarCNPJ(String cnpj) {
        // Lógica para validar o CNPJ
        return cnpj.equals(getCnpj());
    }
}
