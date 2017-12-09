package br.com.model.dao;

import br.com.model.bean.FormaPagamento;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author paulo
 */
public class FormaPagamentoDAOTest {

    public FormaPagamentoDAOTest() {
    }

    @Test
    @Ignore
    public void testSave() {

        FormaPagamento formaPagamento = new FormaPagamento();
        FormaPagamentoDAO dao = new FormaPagamentoDAO();

        formaPagamento.setFormaPagamento("C Debito");

        if (dao.save(formaPagamento)) {
            System.out.println("Salvo com Sucesso");
        } else {
            fail("Erro ao Salvar");
        }
    }

    @Test
    @Ignore
    public void testListAll() {

        FormaPagamentoDAO dao = new FormaPagamentoDAO();

        for (FormaPagamento fP : dao.findAll()) {
            System.out.println("Tipo: " + fP.getFormaPagamento());
        }
    }

    @Test
    @Ignore
    public void testUpdate() {

        FormaPagamento formaPagamento = new FormaPagamento();
        FormaPagamentoDAO dao = new FormaPagamentoDAO();

        formaPagamento.setFormaPagamento("Debito");
        formaPagamento.setId(3);

        if (dao.update(formaPagamento)) {
            System.out.println("Salvo com Sucesso");
        } else {
            fail("Erro ao Salvar");
        }
    }

    @Test
    @Ignore
    public void testDelete() {

        FormaPagamento fp = new FormaPagamento();
        FormaPagamentoDAO dao = new FormaPagamentoDAO();

        fp.setId(4);

        if (dao.delete(fp)) {
            System.out.println("Excluido com Sucesso");
        } else {
            fail("Erro ao Excluir");
        }

    }

}
