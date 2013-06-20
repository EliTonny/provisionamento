package provisionamento.DaoArquivo;

import MyExceptions.CarregaDadosException;
import MyExceptions.DaoException;
import MyExceptions.DeletaDadosException;
import MyExceptions.GravaDadosException;
import Resources.Resources;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class DaoArquivo<T extends ModeloBase> implements Serializable {

    protected HashMap<Integer, T> dados;
    private File arquivo;

    public DaoArquivo(String nomeArquivo) throws DaoException {
        this.arquivo = new File(Resources.CAMINHO_ARQUIVOS + "\\" + nomeArquivo);
        dados = new HashMap<>();
        this.Carrega();
        this.AtualizaReferencias();
    }

    protected abstract void AtualizaReferencias() throws DaoException;

    private void Carrega() throws CarregaDadosException {
        try {
            if (arquivo.exists()) {
                try (FileInputStream fileInputStream = new FileInputStream(arquivo)) {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream); //abre
                    ObjectInputStream objetos = new ObjectInputStream(bufferedInputStream);
                    this.dados = (HashMap<Integer, T>) objetos.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new CarregaDadosException(ex);
        }
    }

    public void Persiste() throws DaoException {
        try {
            try (FileOutputStream fileOutput = new FileOutputStream(arquivo)) {
                BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
                ObjectOutputStream objectOutput = new ObjectOutputStream(bufferedOutput);
                objectOutput.writeObject(this.dados);
                objectOutput.flush();
            }
        } catch (Exception ex) {
            throw new GravaDadosException(ex);
        }
    }

    public void grava(T object) throws DaoException {
        try {
            T lol = this.dados.put(object.getId(), object);
            if(lol!=null)
                throw new Exception("Erro aki lol != null");
            this.Persiste();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public T deleta(T object) throws DaoException {
        try {
            return this.dados.remove(object.getId());
        } catch (Exception ex) {
            throw new DaoException("Erro ao deletar " + object.getClass().getSimpleName(), ex);
        }
    }

    public T busca(int id) {
        return this.dados.get(id);
    }

    public ArrayList<T> busca() {
        return new ArrayList<>(this.dados.values());
    }

    /*private void AtualizaReferencias()
     {
     if(this.dados.isEmpty())
     return;
        
     Class classe = this.dados.values().iterator().next().getClass();
     Field[] fields = classe.getDeclaredFields();
     for(int i = 0; i< fields.length; i++)
     {
     if(fields[i].getGenericType().getClass().equals(ModeloBase.class))
     {
                
     }
     }
     }*/
    /* private void AtualizaReferencias(Class classe)
     {
     if(classe == null)
     return;
        
     Dao.class.getConstructor(parameterTypes)
        
     Dao<?> dao =  
        
     Field[] fields = classe.getDeclaredFields();
     for(int i = 0; i< fields.length; i++)
     {
     if(fields[i].getGenericType().getClass().equals(ModeloBase.class))
     {
                
     }
     }
     }*/
    /*
     protected Field procuraCampoId(Class classe) throws DaoException {
     try {

     Class aux = classe.getSuperclass();
     while(aux != null)
     {
     if(aux.equals(ModeloBase.class))
     break;
     aux = aux.getSuperclass();
     }
     if(aux == null)
     return null;
            
     return aux.getDeclaredField("id");

     } catch (NoSuchFieldException | SecurityException ex) {
     throw new DaoException(ex);
     }
     }

     protected void insereId(T object) throws DaoException {
     try {
     Field fileId = procuraCampoId(object.getClass());
     if (fileId == null) {
     throw new DaoException(object.getClass().getSimpleName() + " não possui campo id");
     }
     fileId.setInt(object, proximoId++);
     } catch (Exception ex) {
     throw new DaoException("Erro ao acessar id de " + object.getClass().getSimpleName(), ex);
     }
     }
     */
}
