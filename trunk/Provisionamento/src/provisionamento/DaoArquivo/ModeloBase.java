package provisionamento.DaoArquivo;

import java.io.Serializable;

public abstract class ModeloBase implements Serializable {

    protected int id;

    public ModeloBase() {
        id = super.hashCode();
    }

    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        return (((ModeloBase) o).getId() == this.getId());
    }
}
