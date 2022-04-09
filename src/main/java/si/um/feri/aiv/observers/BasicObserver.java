package si.um.feri.aiv.observers;

import si.um.feri.aiv.entity.Nakup;

public class BasicObserver implements Observer {
    @Override
    public void observe(Nakup nakup, ObserverEventType observerEventType) {
        System.out.println("BasicObserver: Izvedeno preverjanje veljavnosti vinjet za registracijsko oznako: " + nakup.getRegistrskaOznakaVozila());
    }
}
