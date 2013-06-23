package provisionamento.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GrupoComunitario extends GrupoUnitario{
        
    private List<Participante> participantes;
    private Date dataCriacao;

    public List<Participante> getParticipantes() {
        return participantes;
    }
    private int comprador;
    
    public GrupoComunitario(){
        participantes = new ArrayList<>();
        dataCriacao = new Date();
    }
    
    public void addParticipante(Participante participante){
        //Usando arrayList para controlar a fila com o indice comprador
        if(!participantes.contains(participante))
            participantes.add(participante);
    }
    
    public void removeParticipante(Participante participante){
        participantes.remove(participante);
    }
    
    public void addComprador(){
        this.comprador++;
        if(this.comprador == participantes.size())
            this.comprador = 0;
    }
    
    public void setComprador(int comprador){
        this.comprador = comprador;
    }
    
    public Participante getComprador(){
        return this.participantes.get(comprador);
    }
    
    @Override
    public String toString()
    {
        return this.getCategoria().getDescricao() + this.dataCriacao.toString();
    }
}
