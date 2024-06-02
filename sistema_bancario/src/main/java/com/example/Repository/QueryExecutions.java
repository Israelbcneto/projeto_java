package com.example.Repository;

import java.sql.*;
import java.util.ArrayList;

public class QueryExecutions {

    private DatabaseManager dbManager;

    public QueryExecutions() throws SQLException {
        dbManager = new DatabaseManager("jdbc:mysql://localhost/bank_system", "root", "");
    }

    public DatabaseManager manager(){
        return dbManager;
    }

    public Datas getClienteByEmailAndPassword(String email, String password) {

        try {
            String query = "SELECT * FROM clients_datas WHERE email = ? and password = ?";
            PreparedStatement stmt = dbManager.getConnection().prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
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
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao buscar o cliente: " + e.getMessage());
        }
        return null;
    }
    
    public Datas getAdminByEmailAndPassword(String email, String password) {

        try {
            String query = "SELECT * FROM administers WHERE email = ? and password = ?";
            PreparedStatement stmt = dbManager.getConnection().prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Datas(
                        rs.getString("document_number"),
                        rs.getString("name"),
                        rs.getString("email"),
                        2,
                        rs.getString("password"),
                        0.0f
                );
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao buscar o cliente: " + e.getMessage());
        }
        return null;
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
                        rs.getFloat("balance"));
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao buscar o cliente: " + ex.getMessage());
        }
        return null;
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

    public void insertAdministrador(Datas admin) {
        try {
            String query = "INSERT INTO administers (document_number, name, email, account, balance, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = dbManager.getConnection().prepareStatement(query);
            stmt.setString(1, admin.getDocument_number());
            stmt.setString(2, admin.getName());
            stmt.setString(3, admin.getEmail());
            stmt.setInt(4, admin.getAccount());
            stmt.setFloat(5, admin.getBalance());
            stmt.setString(6, admin.getPassword());
            stmt.executeUpdate();
            System.out.println("Administrador inserido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao inserir o administrador: " + ex.getMessage());
        }
    }

    public Datas getAdministradorById(String documentNumber) {
        try {
            String query = "SELECT * FROM administers WHERE document_number = ?";
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
                        rs.getFloat("balance"));
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao buscar o administrador: " + ex.getMessage());
        }
        return null;
    }

    public void deleteAdministrador(String documentNumber) {
        try {
            String query = "DELETE FROM administers WHERE document_number = ?";
            PreparedStatement stmt = dbManager.getConnection().prepareStatement(query);
            stmt.setString(1, documentNumber);
            stmt.executeUpdate();
            System.out.println("Administrador deletado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao deletar o administrador: " + ex.getMessage());
        }
    }

    public ArrayList<Datas> getAllClientes() {
        ArrayList<Datas> clientes = new ArrayList<>();
        try {
            String query = "SELECT * FROM clients_datas";
            ResultSet rs = dbManager.executeQuery(query);
            while (rs.next()) {
                Datas cliente = new Datas(
                        rs.getString("document_number"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("account"),
                        rs.getString("password"),
                        rs.getFloat("balance"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao buscar os clientes: " + ex.getMessage());
        }
        return clientes;
    }

    public ArrayList<Datas> getAllAdministradores() {
        ArrayList<Datas> admins = new ArrayList<>();
        try {
            String query = "SELECT * FROM administers";
            ResultSet rs = dbManager.executeQuery(query);
            while (rs.next()) {
                Datas admin = new Datas(
                        rs.getString("document_number"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("account"),
                        rs.getString("password"),
                        rs.getFloat("balance"));
                admins.add(admin);
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao buscar os administradores: " + ex.getMessage());
        }
        return admins;
    }

    public void updateBalance(double saldo, String document_number, float debt) {

        if (debt == 0.0f) {
            try {
                // Busca a dívida atual do cliente
                String queryDebtView = "SELECT debt FROM clients_datas WHERE document_number = ?";
                PreparedStatement stmt_debt = dbManager.getConnection().prepareStatement(queryDebtView);
                stmt_debt.setString(1, document_number);
                ResultSet rs = stmt_debt.executeQuery();
                
                if (rs.next()) {
                    System.out.println("Dívida atual: " + rs.getFloat("debt"));
                }
    
                // Atualiza o saldo e a dívida do cliente
                String query = "UPDATE clients_datas SET balance = ?, debt = ? WHERE document_number = ?";
                PreparedStatement stmt = dbManager.getConnection().prepareStatement(query);
                stmt.setFloat(1, (float) saldo);
                stmt.setFloat(2, debt);
                stmt.setString(3, document_number);
                stmt.executeUpdate();
    
            } catch (SQLException e) {
                System.out.println("Ocorreu um erro ao atualizar o saldo e a dívida: " + e.getMessage());
            }
    
        } else {
            try {
                // Atualiza apenas o saldo do cliente
                String query = "UPDATE clients_datas SET balance = ? WHERE document_number = ?";
                PreparedStatement stmt = dbManager.getConnection().prepareStatement(query);
                stmt.setFloat(1, (float) saldo);
                stmt.setString(2, document_number);
                stmt.executeUpdate();
    
            } catch (SQLException e) {
                System.out.println("Ocorreu um erro ao atualizar o saldo: " + e.getMessage());
            }
        }
    }
    
}
