package com.example.Repository;

import java.util.Objects;

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

    public Datas(String cpf, String name2, String email2, int account2, String password2, double balance) {
        this.document_number = cpf;
        this.name = name2;
        this.email = email2;
        this.account = account2;
        this.password = password2;
        this.balance = (float) balance;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Datas datas = (Datas) o;
        return account == datas.account &&
                Float.compare(datas.balance, balance) == 0 &&
                Objects.equals(document_number, datas.document_number) &&
                Objects.equals(name, datas.name) &&
                Objects.equals(email, datas.email) &&
                Objects.equals(password, datas.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(document_number, name, email, account, password, balance);
    }

    @Override
    public String toString() {
        return "Datas{" +
                "document_number='" + document_number + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", account=" + account +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
