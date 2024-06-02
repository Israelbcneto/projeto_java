package com.example.Repository;

import java.sql.*;
import java.util.ArrayList;

public class QueryExecutions {

    private DatabaseManager dbManager;

    public QueryExecutions() throws SQLException {
        dbManager = new DatabaseManager("jdbc:mysql://localhost/bank_system", "root", "");
    }

    public void realizeConsult() {
        try {
            ResultSet dados = dbManager.executeQuery("SELECT * FROM clients_datas");

            ArrayList<Datas> user_datas_list = new ArrayList<>();

            while (dados.next()) {
                String document_number = dados.getString("document_number");
                String name = dados.getString("name");
                String email = dados.getString("email");
                int account = dados.getInt("account");
                String password = dados.getString("password");
                float balance = dados.getFloat("balance");

                Datas user_datas = new Datas(document_number, name, email, account, password, balance);
                user_datas_list.add(user_datas);
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar a DB: " + ex.getMessage());
        }
    }

    public void insertCliente(Datas cliente) {
        try {
            String query = "INSERT INTO clients_datas (document_number, name, email, account, password, balance) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = dbManager.getConnection().prepareStatement(query);
            stmt.setString(1, cliente.getDocument_number());
            stmt.setString(2, cliente.getName());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getAccount());
            stmt.setString(5, cliente.getPassword());
            stmt.setFloat(6, cliente.getBalance());
            stmt.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao inserir o cliente: " + ex.getMessage());
        }
    }

    public void updateCliente(Datas cliente) {
        try {
            String query = "UPDATE clients_datas SET name = ?, email = ?, account = ?, password = ?, balance = ? WHERE document_number = ?";
            PreparedStatement stmt = dbManager.getConnection().prepareStatement(query);
            stmt.setString(1, cliente.getName());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getAccount());
            stmt.setString(4, cliente.getPassword());
            stmt.setFloat(5, cliente.getBalance());
            stmt.setString(6, cliente.getDocument_number());
            stmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao atualizar o cliente: " + ex.getMessage());
        }
    }

    public void deleteCliente(String documentNumber) {
        try {
            String query = "DELETE FROM clients_datas WHERE document_number = ?";
            PreparedStatement stmt = dbManager.getConnection().prepareStatement(query);
            stmt.setString(1, documentNumber);
            stmt.executeUpdate();
            System.out.println("Cliente deletado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao deletar o cliente: " + ex.getMessage());
        }
    }

    public Datas getClienteById(String documentNumber) {
        try {
            String query = "SELECT * FROM clients_datas WHERE document_number = ?";
            PreparedStatement stmt = dbManager.getConnection().prepareStatement(query);
            stmt.setString(1, documentNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Datas(
                    rs.getString("document_number"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getInt("account"),
                    rs.getString("password"),
                    rs.getFloat("balance")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao buscar o cliente: " + ex.getMessage());
        }
        return null;
    }
}
