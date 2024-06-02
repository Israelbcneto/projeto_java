package com.example.Model;

import java.sql.SQLException;

import com.example.Repository.Datas;
import com.example.Repository.QueryExecutions;

public class Cliente extends Usuario {
    // Atributo específico de Cliente
    protected double saldo;

    public Cliente(String cpf, String cnpj, String nome, String senha, String email, int tipoDeConta, double saldo) {
        super(cpf, cnpj, nome, senha, email, tipoDeConta);
        this.saldo = saldo;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void depositar(double valor) throws SQLException {
        saldo += valor;
        QueryExecutions executor = new QueryExecutions();
    
        if (this.getCfp() != "") {
            executor.updateBalance(saldo, this.getCfp(), 0);
        } else {
            executor.updateBalance(saldo, this.getCnpj(), 0);
        }
    
        System.out.println("Depósito realizado: " + valor);
    }
    
    public void sacar(double valor) throws SQLException {
        if (saldo >= valor) {
            saldo -= valor;

            QueryExecutions executor = new QueryExecutions();

            if(this.getCfp() != ""){
                executor.updateBalance(saldo, this.getCfp(), 0);
            } else{
                executor.updateBalance(saldo, this.getCnpj(), 0);
            }
            System.out.println("Saque realizado: " + valor);
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void emprestimo(double valor) throws SQLException {
        saldo += valor;
        QueryExecutions executor = new QueryExecutions();
    
        if (this.getCfp() != "") {
            executor.updateBalance(saldo, this.getCfp(), (float)valor);
        } else {
            executor.updateBalance(saldo, this.getCnpj(), (float)valor);
        }
    
        System.out.println("Depósito realizado: " + valor);
    }

    public float getSaldo(){
        return (float) this.saldo;
    }

}
