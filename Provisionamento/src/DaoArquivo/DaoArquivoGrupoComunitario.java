package DaoArquivo;

import Sistema.Dao;
import MyExceptions.DaoException;
import MyExceptions.GravaDadosException;
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
    public void grava(GrupoComunitario grupo) throws GravaDadosException {
        if (grupo.getCriador().getId() < 0) {
            throw new GravaDadosException("Tentativa de gravar um Grupo Comunitário que possui referência a outros objetos que não estão gravados");
        }
        super.grava(grupo);
    }

    @Override
    public GrupoComunitario busca(String descricao) {
        for (GrupoComunitario val : this.dados.buscaTodos()) {
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
            Dao<Usuario> DaoUsuario = DaoArquivoUsuario.getInstancia();
            for (GrupoComunitario g : this.dados.buscaTodos()) {
                u = DaoUsuario.busca(g.getCriador().getId());
                g.setCriador(u);
            }
        } catch (DaoException ex) {
            throw new DaoException("Erro ao atualizar as referencias.", ex);
        }
    }
}
