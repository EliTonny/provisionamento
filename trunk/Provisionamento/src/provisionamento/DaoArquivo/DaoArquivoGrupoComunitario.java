package provisionamento.DaoArquivo;

import Dao.Dao;
import MyExceptions.DaoException;
import provisionamento.model.GrupoComunitario;
import provisionamento.model.Usuario;

public class DaoArquivoGrupoComunitario extends DaoArquivo<GrupoComunitario> implements Dao<GrupoComunitario> {

    private static DaoArquivoGrupoComunitario instancia;

    private DaoArquivoGrupoComunitario() throws DaoException {
        super(GrupoComunitario.class.getSimpleName());
    }

    public static DaoArquivoGrupoComunitario getInstancia() throws DaoException {
        if (instancia == null) {
            instancia = new DaoArquivoGrupoComunitario();
        }
        return instancia;
    }

    @Override
    public GrupoComunitario busca(String descricao) {
        for (GrupoComunitario val : this.dados.values()) {
            if (val.getDescricao().equals(descricao)) {
                return val;
            }
        }
        return null;
    }

    @Override
    protected void AtualizaReferencias() throws DaoException {
        try {
            Usuario u;
            Dao<Usuario> dao = DaoArquivoUsuario.getInstancia();
            for (GrupoComunitario g : this.dados.values()) {
                u = dao.busca(g.getCriador().getId());
                g.setCriador(u);
            }
        } catch (DaoException ex) {
            throw new DaoException("Erro ao atualizar as referencias.", ex);
        }
    }
}
