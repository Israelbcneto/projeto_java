package com.example.Repository;

public class Datas {
    private String document_number;
    private String name;
    private String email;
    private int account;
    private String password;
    private float balance;

    public Datas(String document_number, String name, String email, int account, String password, float balance) {
        this.document_number = document_number;
        this.name = name;
        this.email = email;
        this.account = account;
        this.password = password;
        this.balance = balance;
    }

    public Datas(String cpf, String name2, String email2, int account2, String password2, double saldo) {
        this.document_number = cpf;
        this.name = name2;
        this.email = email2;
        this.account = account2;
        this.password = password2;
        this.balance = (float) saldo;
    }

    public String getDocument_number() {
        return document_number;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public float getBalance() {
        return balance;
    }
}
