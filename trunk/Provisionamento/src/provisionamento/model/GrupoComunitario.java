package provisionamento.model;

import java.util.HashSet;
import java.util.Set;
import provisionamento.fila.Fila;

public class GrupoComunitario extends Grupo{
    
    private Usuario criador;
    private Set<Participante> participantes;
    private Fila fila;
    
    public GrupoComunitario(){
        participantes = new HashSet<>();
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }
    
    public void addParticipante(Participante participante){
        if(this.participantes.add(participante)){
          this.fila.insere(participante.getUsuario());  
        }
    }
    
    public void removeParticipante(Participante participante){
        this.participantes.remove(participante);
    }
}
