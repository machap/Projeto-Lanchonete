package br.com.model.dao;

import br.com.connection.ConnectionFactory;
import br.com.model.bean.Item;
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
public class ItemDAO {

    private Connection con = null;

    public ItemDAO() {

        con = ConnectionFactory.getConnection();
    }

    public boolean save(Item item) {

        String sql = "INSERT INTO tbItem(descricao, tipo_id, preco) VALUES (?,?,?)";

        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, item.getDescricao());
            stmt.setInt(2, item.getTipo().getId());
            stmt.setDouble(3, item.getPreco());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {

            System.err.println("Erro: " + ex);
            return false;

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Item> findAll() {

        String sql = "SELECT * FROM vwItem";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Item> itens = new ArrayList<>();

        try {

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Item item = new Item();

                item.setDescricao(rs.getString("descricao"));

                TipoItem tipoItem = new TipoItem();
                tipoItem.setTipo(rs.getString("tipo"));

                item.setTipo(tipoItem);
                item.setPreco(rs.getDouble("preco"));

                itens.add(item);

            }

        } catch (SQLException ex) {

            System.err.println("Erro: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return itens;

    }

    public boolean update(Item item) {

        String sql = "UPDATE tbItem SET descricao = ?, tipo_id = ?, preco = ? WHERE id_item = ?";

        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, item.getDescricao());
            stmt.setInt(2, item.getTipo().getId());
            stmt.setDouble(3, item.getPreco());
            stmt.setInt(4, item.getId());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {

            System.err.println("Erro: " + ex);
            return false;

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean delete(Item item) {

        String sql = "DELETE FROM tbItem WHERE id_item = ?";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, item.getId());
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
