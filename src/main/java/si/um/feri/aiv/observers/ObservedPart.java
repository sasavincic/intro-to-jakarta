package si.um.feri.aiv.observers;

public interface ObservedPart {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyAll(ObserverEventType observerEventType);
}
