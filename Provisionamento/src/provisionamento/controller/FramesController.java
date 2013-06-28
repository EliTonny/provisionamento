/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package provisionamento.controller;

import MyExceptions.DaoException;
import Sistema.ConcreteSubject;
import Sistema.Dao;
import Sistema.Factoring;
import java.util.List;
import provisionamento.model.Categoria;
import provisionamento.model.GrupoUnitario;
import provisionamento.model.Usuario;

/**
 *
 * @author Eli T. de Souza
 */
public class FramesController {
    public void grava(Usuario usu) throws DaoException{
        Dao<Usuario> dao = Factoring.getDaoUsuario();
        dao.grava(usu);
        ConcreteSubject.getInstancia().notifyObservers(usu);
    }
    
    public void grava(Categoria cat) throws DaoException{
        Dao<Categoria> dao = Factoring.getDaoCategoria();
        dao.grava(cat);
        ConcreteSubject.getInstancia().notifyObservers(cat);
    }
    
    public void grava(GrupoUnitario grupoUnitario) throws DaoException{
        Dao<GrupoUnitario> dao = Factoring.getDaoGrupoUnitario();
        dao.grava(grupoUnitario);
        ConcreteSubject.getInstancia().notifyObservers(grupoUnitario);
    }
    
    public Usuario buscaUsuario(String nome) throws DaoException{
        Dao<Usuario> dao = Factoring.getDaoUsuario();;
        return dao.busca(nome);
    }
    
    public List buscaCategoria() throws DaoException{
        Dao<Categoria> daoCat = Factoring.getDaoCategoria();
        return daoCat.busca();
    }
    
    public void notificar(){
        
    }
}
