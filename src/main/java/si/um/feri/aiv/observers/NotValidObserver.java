package si.um.feri.aiv.observers;

import si.um.feri.aiv.entity.Nakup;

public class NotValidObserver implements Observer {
    @Override
    public void observe(Nakup nakup, ObserverEventType observerEventType) {
        if (observerEventType.equals(ObserverEventType.NOT_VALID)) {
            System.out.println("NotValidObserver: Nakup " + nakup.hashCode() + " ni veljaven.");
        }
        if (observerEventType.equals(ObserverEventType.DOES_NOT_EXIST)) {
            System.out.println("NotValidObserver: Za vozilo z registrsko oznako: " + nakup.getRegistrskaOznakaVozila() + " ni bilo kupljenih vinjet.");
        }
    }
}
