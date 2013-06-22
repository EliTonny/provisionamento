package DaoArquivo;

import Sistema.Dao;
import MyExceptions.DaoException;
import provisionamento.model.Participante;
import provisionamento.model.Usuario;

public class DaoArquivoParticipante extends DaoArquivo<Participante> implements Dao<Participante> {

    private static DaoArquivoParticipante instancia;

    private DaoArquivoParticipante() throws DaoException {
        super(Participante.class.getSimpleName());
    }

    public static DaoArquivoParticipante getInstancia() throws DaoException {
        if (instancia == null) {
            instancia = new DaoArquivoParticipante();
        }
        return instancia;
    }

    @Override
    public Participante busca(String descricao) {
        for (Participante val : this.dados.buscaTodos()) {
            if (val.getUsuario().getNome().equals(descricao)) {
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
            for (Participante g : this.dados.buscaTodos()) {
                u = dao.busca(g.getUsuario().getId());
                g.setUsuario(u);
            }
        } catch (DaoException ex) {
            throw new DaoException("Erro ao atualizar as referencias.", ex);
        }
    }
}
