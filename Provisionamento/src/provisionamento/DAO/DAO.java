package provisionamento.DAO;

public interface DAO<T> {
    void grava(T objeto);
    void busca(String nome);
    void deleta(T objeto);
}
