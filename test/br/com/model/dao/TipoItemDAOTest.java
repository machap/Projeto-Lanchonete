package br.com.model.dao;

import br.com.model.bean.TipoItem;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author paulo
 */
public class TipoItemDAOTest {

    public TipoItemDAOTest() {
    }

    @Test
    @Ignore
    public void testSave() {

        TipoItem tipoItem = new TipoItem();
        TipoItemDAO dao = new TipoItemDAO();

        tipoItem.setTipo("Massa");

        if (dao.save(tipoItem)) {

            System.out.println("Salvo com Sucesso");
        } else {

            fail("Erro ao Salvar");
        }

    }

    @Test
    @Ignore
    public void testListAll() {

        TipoItemDAO dao = new TipoItemDAO();

        for (TipoItem tI : dao.findAll()) {

            System.out.println("Tipo: " + tI.getTipo());
        }

    }

    @Test
    @Ignore
    public void testUpdate() {

        TipoItem tipoItem = new TipoItem();
        TipoItemDAO dao = new TipoItemDAO();

        tipoItem.setTipo("Bebida");
        tipoItem.setId(1);

        if (dao.update(tipoItem)) {

            System.out.println("Atualizado com Sucesso");
        } else {

            fail("Erro ao Atualizado");
        }

    }

    @Test
    @Ignore
    public void testDelete() {

        TipoItem tipoItem = new TipoItem();
        TipoItemDAO dao = new TipoItemDAO();

        tipoItem.setId(4);

        if (dao.delete(tipoItem)) {

            System.out.println("Excluido com Sucesso");
        } else {

            fail("Erro ao Excluir");
        }

    }

}
