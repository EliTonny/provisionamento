package provisionamento.DaoArquivo;

import Dao.Dao;
import MyExceptions.CarregaDadosException;
import MyExceptions.DaoException;
import java.util.ArrayList;
import java.util.List;
import provisionamento.model.Grupo;
import provisionamento.model.GrupoComunitario;

public class DaoArquivoGrupoComunitario extends DaoArquivo<GrupoComunitario> implements Dao<GrupoComunitario> {

    private static DaoArquivoGrupoComunitario instancia;

    private DaoArquivoGrupoComunitario(String caminho) throws CarregaDadosException {
        super(caminho + "\\" + Grupo.class.getSimpleName());
    }

    public static DaoArquivoGrupoComunitario getInstancia(String caminho) throws CarregaDadosException {
        if (instancia == null) {
            instancia = new DaoArquivoGrupoComunitario(caminho);
        }
        return instancia;
    }

    public void grava(GrupoComunitario grupo) throws DaoException {
        super.grava(grupo);
    }
    
    public GrupoComunitario busca(int id) {
        GrupoComunitario g = super.busca(id);
        
        return g;
    }
    
    public void deleta(GrupoComunitario grupo) throws DaoException {
        super.deleta(grupo);
    }

    public GrupoComunitario busca(String descricao) {
        for (GrupoComunitario val : this.dados.values()) {
            if (val.getDescricao().equals(descricao)) {
                return val;
            }
        }
        return null;
    }

    public ArrayList<GrupoComunitario> busca() {
        return super.busca();
    }
}
