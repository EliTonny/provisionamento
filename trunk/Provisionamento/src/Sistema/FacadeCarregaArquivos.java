
package Sistema;

import MyExceptions.DaoException;

public class FacadeCarregaArquivos {
    public void Carrega() throws DaoException
    {
        Factoring.getDaoUsuario().abre();
        Factoring.getDaoCategoria().abre();
        Factoring.getDaoParticipante().abre();
        Factoring.getDaoGrupoComunitario().abre();
    }
}
