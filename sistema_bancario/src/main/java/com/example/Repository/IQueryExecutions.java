package com.example.Repository;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IQueryExecutions {
    DatabaseManager manager();
    Datas getClienteByEmailAndPassword(String email, String password);
    Datas getAdminByEmailAndPassword(String email, String password);
    void insertCliente(Datas cliente);
    Datas getClienteById(String documentNumber);
    void deleteCliente(String documentNumber);
    void insertAdministrador(Datas admin);
    Datas getAdministradorById(String documentNumber);
    void deleteAdministrador(String documentNumber);
    ArrayList<Datas> getAllClientes();
    ArrayList<Datas> getAllAdministradores();
    void updateBalance(double saldo, String document_number, float debt);
}
