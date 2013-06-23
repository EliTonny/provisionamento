package provisionamento.model;

public class GrupoUnitario extends Grupo{
    
    private Usuario criador;

    public Usuario getCriador() {
        return criador;
    }   

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }
}
