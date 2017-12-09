package br.com.model.dao;

import br.com.model.bean.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author paulo
 */
public class ClienteDAOTest {

    public ClienteDAOTest() {
    }

    @Test
    @Ignore
    public void testSave() {

        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();

        cliente.setNome("teste");
        cliente.setCpf("0");
        cliente.setTelefone("0");
        cliente.setRua("teste");
        cliente.setBairro("teste");
        cliente.setCidade("teste");
        cliente.setEstado("tt");

        if (dao.save(cliente)) {
            System.out.println("Salvo com Sucesso");
        } else {
            fail("Erro ao Salvar");
        }
    }

    @Test
    @Ignore
    public void testListAll() {

        ClienteDAO dao = new ClienteDAO();

        for (Cliente c : dao.findAll()) {

            System.out.println("Nome: " + c.getNome());
            System.out.println("CPF: " + c.getCpf());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Rua: " + c.getRua());
            System.out.println("Bairro: " + c.getBairro());
            System.out.println("Cidade: " + c.getCidade());
            System.out.println("Estado: " + c.getEstado());

            System.out.println("------------------------");
        }
    }

    @Test
    @Ignore
    public void testUpdate() {

        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();

        cliente.setNome("teste");
        cliente.setCpf("0");
        cliente.setTelefone("0");
        cliente.setRua("teste");
        cliente.setBairro("teste");
        cliente.setCidade("teste");
        cliente.setEstado("tt");
        cliente.setId(4);

        if (dao.update(cliente)) {
            System.out.println("Atualizado com Sucesso");
        } else {
            fail("Erro ao Atualizar");
        }
    }

    @Test
    @Ignore
    public void testDelete() {

        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();

        cliente.setId(5);

        if (dao.delete(cliente)) {
            System.out.println("Exluido com Sucesso");
        } else {
            fail("Erro ao Excluir");
        }

    }

}
