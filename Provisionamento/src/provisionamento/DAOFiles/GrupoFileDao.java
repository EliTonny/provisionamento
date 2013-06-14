package provisionamento.DAOFiles;

import provisionamento.DAO.DAO;
import provisionamento.model.Grupo;

public class GrupoFileDao implements DAO<Grupo>{
    
    private static GrupoFileDao instancia;
    Dados<Grupo> dados;
    
    private GrupoFileDao(String caminho)
    {
        dados = new Dados<>(caminho+"\\"+Grupo.class.getSimpleName());
    }
    
    public static GrupoFileDao getInstancia(String caminho)
    {
        if(instancia == null)
            instancia = new GrupoFileDao(caminho);
        return instancia;
    }
    
    @Override
    public void grava(Grupo grupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void busca(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleta(Grupo grupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
