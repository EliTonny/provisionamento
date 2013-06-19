package provisionamento.DaoArquivo;

import java.io.Serializable;

public abstract class ModeloBase implements Serializable {

    public ModeloBase() {
        id = super.hashCode();
    }
    protected int id;

    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        return (((ModeloBase) o).getId() == this.getId());
    }
}
