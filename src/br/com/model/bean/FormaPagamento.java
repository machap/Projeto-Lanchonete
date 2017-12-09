package br.com.model.bean;

/**
 *
 * @author paulo
 */
public class FormaPagamento {
    
    private int id;
    private String formaPagamento;

    public FormaPagamento() {
    }

    public FormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    
    
    
    
}
