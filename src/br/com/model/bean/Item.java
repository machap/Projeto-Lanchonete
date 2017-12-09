package br.com.model.bean;

/**
 *
 * @author paulo
 */
public class Item {
    
    private int id;
    private String descricao;
    private String tipo;
    private TipoItem tipoItem;
    private double preco; 
    

    public Item() {
    }

    public Item(String descricao, TipoItem tipoItem, double preco) {
        
        this.descricao = descricao;
        this.tipoItem = tipoItem;
        this.preco = preco;
        
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public TipoItem getTipo() {
        return tipoItem;
        
    }

    public void setTipo(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
        
    }
    
    
    
}
