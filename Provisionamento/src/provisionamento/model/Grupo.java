package provisionamento.model;

import DaoArquivo.ModeloBase;
import java.util.Date;

public abstract class Grupo  extends ModeloBase{
    private Categoria categoria;
    private String descricao;
    private Date prazoValidade;
    private int quantidade;
    private int qtd_dias_notificacao;

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

    public Date getPrazoValidade() {
        return prazoValidade;
    }

    public void setPrazoValidade(Date prazoValidade) {
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

    public int getQtd_dias_notificacao() {
        return qtd_dias_notificacao;
    }

    public void setQtd_dias_notificacao(int qtd_dias_notificacao) {
        this.qtd_dias_notificacao = qtd_dias_notificacao;
    }
}
