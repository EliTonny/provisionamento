package provisionamento.DaoArquivo;

import Dao.Dao;
import MyExceptions.CarregaDadosException;
import MyExceptions.DaoException;
import java.util.ArrayList;
import java.util.List;
import provisionamento.model.Usuario;

public class DaoArquivoUsuario extends DaoArquivo<Usuario> implements Dao<Usuario> {

    private static DaoArquivoUsuario instancia;

    private DaoArquivoUsuario(String caminho) throws CarregaDadosException {
        super(caminho + "\\" + Usuario.class.getSimpleName());
    }

    public static DaoArquivoUsuario getInstancia(String caminho) throws CarregaDadosException {
        if (instancia == null) {
            instancia = new DaoArquivoUsuario(caminho);
        }
        return instancia;
    }

    public void grava(Usuario usuario) throws DaoException {
        super.grava(usuario);
    }
    
    public Usuario busca(int id) {
        return super.busca(id);
    }
    
    public void deleta(Usuario usuario) throws DaoException {
        super.deleta(usuario);
    }

    public Usuario busca(String nome) {
        for (Usuario val : this.dados.values()) {
            if (val.getNome().equals(nome)) {
                return val;
            }
        }
        return null;
    }

    public ArrayList<Usuario> busca() {
        return super.busca();
    }
}
