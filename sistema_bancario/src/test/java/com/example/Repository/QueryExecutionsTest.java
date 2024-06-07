package com.example.Repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.sql.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import com.example.Repository.DatabaseManager;
import com.example.Repository.Datas;
import com.example.Repository.QueryExecutions;

import java.util.ArrayList;
import java.util.List;

public class QueryExecutionsTest {

    @Mock
    private DatabaseManager dbManagerMock;

    @InjectMocks
    private QueryExecutions queryExecutions;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        queryExecutions = new QueryExecutions();
        queryExecutions.dbManager = dbManagerMock;
    }

    @Test
    public void testGetClienteByEmailAndPassword() throws SQLException {
        String email = "test@example.com";
        String password = "password";

        Datas expected = new Datas("123456", "Test User", email, 1, password, 100.0f);

        Connection conn = mock(Connection.class);
        PreparedStatement stmt = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        when(dbManagerMock.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(stmt);
        when(stmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getString("document_number")).thenReturn(expected.getDocument_number());
        when(rs.getString("name")).thenReturn(expected.getName());
        when(rs.getString("email")).thenReturn(expected.getEmail());
        when(rs.getInt("account")).thenReturn(expected.getAccount());
        when(rs.getString("password")).thenReturn(expected.getPassword());
        when(rs.getFloat("balance")).thenReturn(expected.getBalance());

        Datas result = queryExecutions.getClienteByEmailAndPassword(email, password);
        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    public void testGetClienteByEmailAndPassword_NotFound() throws SQLException {
        String email = "test@example.com";
        String password = "password";

        Connection conn = mock(Connection.class);
        PreparedStatement stmt = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        when(dbManagerMock.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(stmt);
        when(stmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(false);

        Datas result = queryExecutions.getClienteByEmailAndPassword(email, password);
        assertNull(result);
    }

    @Test
    public void testGetAdminByEmailAndPassword() throws SQLException {
        String email = "admin@example.com";
        String password = "admin";

        Datas expected = new Datas("654321", "Admin User", email, 2, password, 0.0f);

        Connection conn = mock(Connection.class);
        PreparedStatement stmt = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        when(dbManagerMock.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(stmt);
        when(stmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getString("document_number")).thenReturn(expected.getDocument_number());
        when(rs.getString("name")).thenReturn(expected.getName());
        when(rs.getString("email")).thenReturn(expected.getEmail());
        when(rs.getInt("account")).thenReturn(expected.getAccount());
        when(rs.getString("password")).thenReturn(expected.getPassword());
        when(rs.getFloat("balance")).thenReturn(expected.getBalance());

        Datas result = queryExecutions.getAdminByEmailAndPassword(email, password);
        assertEquals(expected, result);
    }

    @Test
    public void testInsertCliente() throws SQLException {
        Datas cliente = new Datas("10545612387", "Test User", "test@example.com", 1, "password", 100.0f);

        Connection conn = mock(Connection.class);
        PreparedStatement stmt = mock(PreparedStatement.class);

        when(dbManagerMock.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(stmt);

        queryExecutions.insertCliente(cliente);

        verify(stmt).setString(1, cliente.getDocument_number());
        verify(stmt).setString(2, cliente.getName());
        verify(stmt).setString(3, cliente.getEmail());
        verify(stmt).setInt(4, cliente.getAccount());
        verify(stmt).setString(5, cliente.getPassword());
        verify(stmt).setFloat(6, cliente.getBalance());
        verify(stmt).executeUpdate();
    }

    @Test
    public void testGetClienteById() throws SQLException {
        String documentNumber = "10545612387";
        Datas expected = new Datas(documentNumber, "Test User", "test@example.com", 1, "password", 100.0f);

        Connection conn = mock(Connection.class);
        PreparedStatement stmt = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        when(dbManagerMock.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(stmt);
        when(stmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getString("document_number")).thenReturn(expected.getDocument_number());
        when(rs.getString("name")).thenReturn(expected.getName());
        when(rs.getString("email")).thenReturn(expected.getEmail());
        when(rs.getInt("account")).thenReturn(expected.getAccount());
        when(rs.getString("password")).thenReturn(expected.getPassword());
        when(rs.getFloat("balance")).thenReturn(expected.getBalance());

        Datas result = queryExecutions.getClienteById(documentNumber);
        assertEquals(expected, result);
    }

    @Test
    public void testDeleteCliente() throws SQLException {
        String documentNumber = "123456";

        Connection conn = mock(Connection.class);
        PreparedStatement stmt = mock(PreparedStatement.class);

        when(dbManagerMock.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(stmt);

        queryExecutions.deleteCliente(documentNumber);

        verify(stmt).setString(1, documentNumber);
        verify(stmt).executeUpdate();
    }

    @Test
    public void testGetAllClientes() throws SQLException {
        List<Datas> expectedClientes = new ArrayList<>();
        expectedClientes.add(new Datas("123456", "Test User", "test@example.com", 1, "password", 100.0f));
        expectedClientes.add(new Datas("654321", "Another User", "another@example.com", 2, "password", 200.0f));

        Connection conn = mock(Connection.class);
        Statement stmt = mock(Statement.class);
        ResultSet rs = mock(ResultSet.class);

        when(dbManagerMock.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true, true, false);
        when(rs.getString("document_number")).thenReturn("123456", "654321");
        when(rs.getString("name")).thenReturn("Test User", "Another User");
        when(rs.getString("email")).thenReturn("test@example.com", "another@example.com");
        when(rs.getInt("account")).thenReturn(1, 2);
        when(rs.getString("password")).thenReturn("password", "password");
        when(rs.getFloat("balance")).thenReturn(100.0f, 200.0f);

        List<Datas> result = queryExecutions.getAllClientes();
        assertEquals(expectedClientes, result);
    }


    @Test
    public void testUpdateBalance() throws SQLException {
        String documentNumber = "123456";
        double saldo = 200.0;
        float debt = 50.0f;

        Connection conn = mock(Connection.class);
        PreparedStatement stmtUpdate = mock(PreparedStatement.class);
        PreparedStatement stmtDebtView = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        when(dbManagerMock.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(stmtUpdate, stmtDebtView);
        when(stmtDebtView.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getFloat("debt")).thenReturn(debt);

        queryExecutions.updateBalance(saldo, documentNumber, debt);

        verify(stmtUpdate).setDouble(1, saldo);
        verify(stmtUpdate).setFloat(2, debt);
        verify(stmtUpdate).setString(3, documentNumber);
        verify(stmtUpdate).executeUpdate();

        verify(stmtDebtView).setString(1, documentNumber);
        verify(stmtDebtView).executeQuery();
    }
}
