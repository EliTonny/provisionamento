package provisionamento.DaoArquivo;

import MyExceptions.CarregaDadosException;
import MyExceptions.DaoException;
import MyExceptions.DeletaDadosException;
import MyExceptions.GravaDadosException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;

public abstract class DaoArquivo<T extends ModeloBase> implements Serializable{

    protected HashMap<Integer, T> dados;
    protected int proximoId;
    private File arquivo;

    public DaoArquivo(String caminho) throws CarregaDadosException {
        this.arquivo = new File(caminho);
        dados = new HashMap<>();
        this.Carrega();
    }

    private void Carrega() throws CarregaDadosException {
        try {
            if (arquivo.exists()) {
                FileInputStream fileInputStream = new FileInputStream(arquivo);
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream); //abre
                    ObjectInputStream objetos = new ObjectInputStream(bufferedInputStream);
                    DaoArquivo<T> aux;
                    aux = (DaoArquivo<T>) objetos.readObject();

                    this.dados = aux.dados;
                    this.proximoId = aux.proximoId;
                } finally {
                    fileInputStream.close();
                }
            }

        } catch (Exception ex) {
            throw new CarregaDadosException(ex);
        }
    }

    public void Persiste() throws DaoException {
        try {
            FileOutputStream fileOutput = new FileOutputStream(arquivo);
            try {
                BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
                ObjectOutputStream objectOutput = new ObjectOutputStream(bufferedOutput);
                objectOutput.writeObject(this);
                objectOutput.flush();
            } finally {
                fileOutput.close();
            }

        } catch (Exception ex) {
            throw new GravaDadosException(ex);
        }
    }

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
    
    public void grava(T object) throws DaoException {
        try {
            if (object.getId() == -1) {
                this.insereId(object);
            }
            this.dados.put(object.getId(), object);
            this.Persiste();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
    
    public void deleta(T object) throws DaoException {
        if (object.getId() == -1) {
            throw new DeletaDadosException("Grupo não cadastrado.");
        }
        T objectRemovido = this.dados.remove(object.getId());
        if (objectRemovido == null) {
            throw new DeletaDadosException("Grupo não encontrado.");
        }
    }
    
   public T busca(int id) {
        return this.dados.get(id);
    }
}
