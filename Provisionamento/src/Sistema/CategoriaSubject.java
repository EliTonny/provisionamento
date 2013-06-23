/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eli T. de Souza
 */
public class CategoriaSubject implements Subject{
    
    private List<Observer> observadores;
    private static CategoriaSubject instancia;
    
    private CategoriaSubject(){
        observadores = new ArrayList();
    }
    
    public static CategoriaSubject getInstancia(){
        if(instancia == null){
            instancia = new CategoriaSubject();
        }
        return instancia;
    }

    @Override
    public void registerObserver(Observer obs) {
        observadores.add(obs);
    }

    @Override
    public void removeOberser(Observer obs) {
        observadores.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observadores) {
            observer.update();
        }
    }
}
