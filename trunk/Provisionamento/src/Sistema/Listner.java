package Sistema;

import java.util.HashSet;

public abstract class Listner {

    public HashSet<Observer> observers;

    public Listner() {
        observers = new HashSet<>();
    }

    public abstract void Notify();

    public void Add(Observer obs) {
        observers.add(obs);
    }
}
