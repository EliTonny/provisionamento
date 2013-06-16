package provisionamento.DaoArquivo;

import MyExceptions.CarregaDadosException;
import MyExceptions.DaoException;
import MyExceptions.DeletaDadosException;
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
        try {
            if (grupo.getId() == -1) {
                this.insereId(grupo);
            }
            this.dados.put(grupo.getId(), grupo);
            this.Persiste();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }

    }

    public GrupoComunitario busca(String descricao) {
        for (GrupoComunitario val : this.dados.values()) {
            if (val.getDescricao().equals(descricao)) {
                return val;
            }
        }
        return null;
    }

    public GrupoComunitario busca(int id) {
        return this.dados.get(id);
    }

    public void deleta(GrupoComunitario grupo) throws DaoException {
        if (grupo.getId() == -1) {
            throw new DeletaDadosException("Grupo não cadastrado.");
        }
        Grupo grupoRemovido = this.dados.remove(grupo.getId());
        if (grupoRemovido == null) {
            throw new DeletaDadosException("Grupo não encontrado.");
        }
    }
}
