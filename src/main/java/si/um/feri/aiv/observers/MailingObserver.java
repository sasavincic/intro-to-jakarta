package si.um.feri.aiv.observers;

import si.um.feri.aiv.observers.strategies.CarMailingStrategy;
import si.um.feri.aiv.observers.strategies.DefaultMailingStrategy;
import si.um.feri.aiv.observers.strategies.MailingContext;
import si.um.feri.aiv.observers.strategies.MinivanMailingStrategy;
import si.um.feri.aiv.entity.Nakup;

import java.util.logging.Logger;

public class MailingObserver implements Observer {

    Logger log = Logger.getLogger(MailingObserver.class.toString());

    @Override
    public void observe(Nakup nakup, ObserverEventType observerEventType) {
        if (observerEventType.equals(ObserverEventType.NOT_VALID)) {
            MailingContext mailingContext = new MailingContext();
            if (nakup.getTipVozila().equals("Osebni avtomobil")) {
                mailingContext.setMailingStrategy(new CarMailingStrategy());
            } else if (nakup.getTipVozila().equals("Kombi")) {
                mailingContext.setMailingStrategy(new MinivanMailingStrategy());
            } else {
                mailingContext.setMailingStrategy(new DefaultMailingStrategy());
            }
            mailingContext.executeStrategy();
        }
    }
}
