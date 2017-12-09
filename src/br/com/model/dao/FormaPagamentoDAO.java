package br.com.model.dao;

import br.com.connection.ConnectionFactory;
import br.com.model.bean.FormaPagamento;
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
public class FormaPagamentoDAO {

    private Connection con = null;

    public FormaPagamentoDAO() {
        
        con = ConnectionFactory.getConnection();
    }

    public boolean save(FormaPagamento formaPagemento) {

        String sql = "INSERT INTO tbFormaPagamento (tipo) VALUES (?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, formaPagemento.getFormaPagamento());
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            
            System.err.println("Erro: " + ex);
            return false;
            
        } finally {
            
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<FormaPagamento> findAll() {

        String sql = "SELECT * FROM tbFormaPagamento";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FormaPagamento> formaPagamentos = new ArrayList<>();

        try {

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                FormaPagamento formaPagamento = new FormaPagamento();

                formaPagamento.setFormaPagamento(rs.getString("tipo"));
                formaPagamentos.add(formaPagamento);

            }
        } catch (SQLException ex) {
            
            System.err.println("Erro: " + ex);
            
        } finally {
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }

        return formaPagamentos;

    }
    
    public boolean update(FormaPagamento formaPagemento) {

        String sql = "UPDATE tbFormaPagamento SET tipo = ? where id_formaPagamento = ?";

        PreparedStatement stmt = null;

        try {
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, formaPagemento.getFormaPagamento());
            stmt.setInt(2, formaPagemento.getId());
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            
            System.err.println("Erro: " + ex);
            return false;
            
        } finally {
            
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public boolean delete(FormaPagamento formaPagamento) {

        String sql = "DELETE FROM tbFormaPagamento WHERE id_formaPagamento = ?";
        PreparedStatement stmt = null;

        try {
            
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, formaPagamento.getId());
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
