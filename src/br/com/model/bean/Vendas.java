package br.com.model.bean;

/**
 *
 * @author paulo
 */
public class Vendas {
    
    private int id;
    private Cliente cliente;
    private Item item;
    private FormaPagamento formaPagemento;
    private double valor;

    public Vendas() {
    }

    public Vendas(Cliente cliente, Item item, FormaPagamento formaPagemento, double valor) {
        this.cliente = cliente;
        this.item = item;
        this.formaPagemento = formaPagemento;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public FormaPagamento getFormaPagemento() {
        return formaPagemento;
    }

    public void setFormaPagemento(FormaPagamento formaPagemento) {
        this.formaPagemento = formaPagemento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}
