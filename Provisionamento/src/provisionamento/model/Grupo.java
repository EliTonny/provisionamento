package provisionamento.model;

import DaoArquivo.ModeloBase;

public abstract class Grupo  extends ModeloBase{
    private Categoria categoria;
    private String descricao;
    private int prazoValidade;
    private int quantidade;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrazoValidade() {
        return prazoValidade;
    }

    public void setPrazoValidade(int prazoValidade) {
        this.prazoValidade = prazoValidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public Grupo()
    {
        this.id = -1;
    }
}
