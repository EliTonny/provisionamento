package provisionamento.model;

import java.util.ArrayList;
import java.util.List;

public class GrupoComunitario extends Grupo{
    
    private Usuario criador;
    private List<Participante> participantes;
    private int comprador;
    
    public GrupoComunitario(){
        participantes = new ArrayList<>();
    }

    public Usuario getCriador() {
        return criador;
    }   

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }
    
    public void addParticipante(Participante participante){
        //Usando arrayList para controlar a fila com o indice comprador
        if(!participantes.contains(participante))
            participantes.add(participante);
    }
    
    public void removeParticipante(Participante participante){
        participantes.remove(participante);
    }
}
