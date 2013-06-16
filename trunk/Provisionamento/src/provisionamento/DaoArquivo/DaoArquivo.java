package provisionamento.DaoArquivo;

import MyExceptions.CarregaDadosException;
import MyExceptions.DaoException;
import MyExceptions.GravaDadosException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import provisionamento.model.Grupo;

public abstract class DaoArquivo<T> {

    protected HashMap<Integer, T> dados;
    protected int proximoId;
    private File arquivo;

    public DaoArquivo(String caminho) throws CarregaDadosException {
        this.arquivo = new File(caminho);
        this.Carrega();
    }

    private void Carrega() throws CarregaDadosException {
        try {
            if (arquivo.exists()) {
                FileInputStream fileInputStream = new FileInputStream(arquivo);
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream); //abre
                    ObjectInputStream objetos;
                    objetos = new ObjectInputStream(bufferedInputStream);
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
                objectOutput.writeObject(dados);
            } finally {
                fileOutput.close();
            }

        } catch (Exception ex) {
            throw new GravaDadosException(ex);
        }
    }

    protected Field procuraCampoId(Class classe) {
        if (classe == null) {
            return null;
        }
        Field[] fields = classe.getFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals("id")) {
                return fields[i];
            }
        }
        return procuraCampoId(classe.getSuperclass());
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
}
