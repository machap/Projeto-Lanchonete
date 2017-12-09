package br.com.model.dao;

import br.com.model.bean.Item;
import br.com.model.bean.TipoItem;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author paulo
 */
public class ItemDAOTest {

    public ItemDAOTest() {
    }

    @Test
    @Ignore
    public void testSave() {

        TipoItem tipoItem = new TipoItem();
        tipoItem.setId(3);

        Item item = new Item();
        ItemDAO dao = new ItemDAO();

        item.setDescricao("Pizza p Portuguesa");
        item.setTipo(tipoItem);
        item.setPreco(27.00);

        if (dao.save(item)) {
            System.out.println("Salvo com Sucesso");
        } else {
            fail("Erro ao Salvar");
        }

    }

    @Test
    @Ignore
    public void testListAll() {

        ItemDAO dao = new ItemDAO();

        for (Item i : dao.findAll()) {

            System.out.println("Descrição: " + i.getDescricao());
            System.out.println("Tipo: " + i.getTipo().getTipo());
            System.out.println("Preço: " + i.getPreco());

            System.out.println("------------------------");
        }
    }

    @Test
    @Ignore
    public void testUpdate() {

        TipoItem tipoItem = new TipoItem();
        tipoItem.setId(3);

        Item item = new Item();
        ItemDAO dao = new ItemDAO();

        item.setDescricao("Pizza Carne do sol");
        item.setTipo(tipoItem);
        item.setPreco(30.00);
        item.setId(6);

        if (dao.update(item)) {

            System.out.println("Salvo com Sucesso");
        } else {

            fail("Erro ao Salvar");
        }

    }

    @Test
    @Ignore
    public void testDelete() {

        Item item = new Item();
        ItemDAO dao = new ItemDAO();

        item.setId(5);

        if (dao.delete(item)) {

            System.out.println("Excluido com Sucesso");
        } else {

            fail("Erro ao Salvar");
        }

    }

}
