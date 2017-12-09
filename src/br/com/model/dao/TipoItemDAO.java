package br.com.model.dao;

import br.com.connection.ConnectionFactory;
import br.com.model.bean.TipoItem;
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
public class TipoItemDAO {

    private Connection con = null;

    public TipoItemDAO() {

        con = ConnectionFactory.getConnection();
    }

    public boolean save(TipoItem tipoItem) {

        String sql = "INSERT INTO tbTipo(tipo) VALUES (?)";

        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, tipoItem.getTipo());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.err.println("ERRO: " + ex);
            return false;

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<TipoItem> findAll() {

        String sql = "SELECT * FROM tbTipo";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<TipoItem> tipoItens = new ArrayList<>();

        try {

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                TipoItem tipoItem = new TipoItem();

                tipoItem.setTipo(rs.getString("tipo"));
                tipoItens.add(tipoItem);

            }

        } catch (SQLException ex) {

            System.err.println("Erro: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return tipoItens;

    }

    public boolean update(TipoItem tipoItem) {

        String sql = "UPDATE tbTipo SET tipo = ? WHERE id_tipo = ?";

        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, tipoItem.getTipo());
            stmt.setInt(2, tipoItem.getId());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {

            System.err.println("ERRO: " + ex);
            return false;

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(TipoItem tipoItem) {

        String sql = "DELETE FROM tbTipo WHERE id_tipo = ?";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, tipoItem.getId());
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
