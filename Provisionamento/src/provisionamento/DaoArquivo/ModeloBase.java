package provisionamento.DaoArquivo;

import java.io.Serializable;

public abstract class ModeloBase implements Serializable{
    
    public ModeloBase()
    {
        id = -1;
    }
    
    protected int id;
    
    public int getId()
    {
        return this.id;
    }
}
