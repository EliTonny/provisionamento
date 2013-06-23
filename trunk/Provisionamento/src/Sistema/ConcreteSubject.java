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
public class ConcreteSubject implements Subject{
    
    private List<Observer> observadores;
    private static ConcreteSubject instancia;
    
    private ConcreteSubject(){
        observadores = new ArrayList();
    }
    
    public static ConcreteSubject getInstancia(){
        if(instancia == null){
            instancia = new ConcreteSubject();
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
    public void notifyObservers(Object obj) {
        
        for (Observer observer : observadores) {
            observer.update(obj);
        }
    }
}