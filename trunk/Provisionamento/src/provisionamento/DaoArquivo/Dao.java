package provisionamento.DAO;

import MyExceptions.DaoException;

public interface Dao<T> {
    void grava(T objeto) throws DaoException;
    void deleta(T objeto) throws DaoException;
    T busca(String nome) throws DaoException;
    T busca(int id) throws DaoException;
}
