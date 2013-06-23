package provisionamento.model;

import java.util.ArrayList;
import java.util.List;

public class GrupoComunitario extends GrupoUnitario{
        
    private List<Participante> participantes;
    private int comprador;
    private double valorCompra;

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }
    
    public GrupoComunitario(){
        super();
        participantes = new ArrayList<>();
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
}
