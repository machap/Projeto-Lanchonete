package br.com.model.dao;

import br.com.connection.ConnectionFactory;
import br.com.model.bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulo
 */
public class ClienteDAO {

    private Connection con = null;

    public ClienteDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean save(Cliente cliente) {

        String sql = "INSERT INTO tbCliente(nome, cpf, telefone, rua, bairro, cidade, estado) VALUES (?,?,?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getRua());
            stmt.setString(5, cliente.getBairro());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getEstado());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Cliente> findAll() {

        String sql = "SELECT * FROM tbCliente";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setRua(rs.getString("rua"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));

                clientes.add(cliente);

            }
        } catch (SQLException ex) {

            System.err.println("Erro: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;
    }

    public boolean update(Cliente cliente) {

        String sql = "UPDATE tbCliente SET nome = ?, cpf = ?, telefone = ?, rua = ?,"
                + " bairro = ?, cidade = ?, estado = ? WHERE id_cliente = ?;";

        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getRua());
            stmt.setString(5, cliente.getBairro());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getEstado());
            stmt.setInt(8, cliente.getId());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {

            System.err.println("Erro: " + ex);
            return false;

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean delete(Cliente cliente) {

        String sql = "DELETE FROM tbCliente WHERE id_cliente = ?";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {

            System.err.println("ERRO: " + ex);
            return false;

        } finally {
            
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
