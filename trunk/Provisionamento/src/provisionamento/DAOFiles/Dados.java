package provisionamento.DAOFiles;

import MyExceptions.CarregaDadosException;
import MyExceptions.DaoException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dados<T> {

    private HashMap<Integer, T> dados;
    private int proximoId;
    private String caminho;

    public Dados(String caminho) throws DaoException {
        this.caminho = caminho;
        this.Carrega();
    }

    private void Carrega() throws DaoException {
        try {
            File file = new File(caminho);
            if (file.exists()) {
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream); //abre
                    ObjectInputStream objetos;
                    objetos = new ObjectInputStream(bufferedInputStream);
                    Dados<T> aux;
                    aux = (Dados<T>) objetos.readObject();

                    this.dados = aux.dados;
                    this.proximoId = aux.proximoId;
                }
            }
        } catch (Exception ex) {
            throw new CarregaDadosException();
        }
    }
    public void Grava() throws DaoException 
    {
        
    }
}
