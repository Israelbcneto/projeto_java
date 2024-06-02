package com.example.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.Repository.Datas;
import com.example.Repository.QueryExecutions;

public class Administrador extends Usuario {

    private double totalSaques;
    private double totalDepositos;

    public Administrador(String cpf, String cnpj, String nome, String senha, String email, int tipoDeConta, double saldo) {
        super(cpf, cnpj, nome, senha, email, tipoDeConta);
        this.totalSaques = 0.0;
        this.totalDepositos = 0.0;
    }

    public void listarCpfs(QueryExecutions executor){
        try {
            String query = "SELECT * FROM clients_datas WHERE LENGTH(document_number) = 11";
            PreparedStatement stmt = executor.manager().getConnection().prepareStatement(query);
    
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("document_number"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("account"));
                System.out.println(rs.getString("balance"));
                System.out.println(rs.getString("debt"));
                System.out.println("----------------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao buscar o cliente: " + e.getMessage());
        }
    }
    
    public void listarCnpjs(QueryExecutions executor){

        try {
            String query = "SELECT * FROM clients_datas WHERE LENGTH(document_number) = 14";
            PreparedStatement stmt = executor.manager().getConnection().prepareStatement(query);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                System.out.println(rs.getString("document_number"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("account"));
                System.out.println(rs.getString("balance"));
                System.out.println(rs.getString("debt"));
                System.out.println("----------------------------------------------------");

            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao buscar o cliente: " + e.getMessage());
        }

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

    public void excluirConta(QueryExecutions executor, String id) {
        try {
            String query = "DELETE FROM clients_datas WHERE document_number = ?";
            PreparedStatement stmt = executor.manager().getConnection().prepareStatement(query);
            stmt.setString(1, id);
    
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário excluído com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com o documento fornecido.");
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao excluir o cliente: " + e.getMessage());
        }
    }
    
}
