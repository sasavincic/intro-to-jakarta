package si.um.feri.aiv.observers.strategies;

public class MailingContext {
    private MailingStrategy mailingStrategy;

    public void setMailingStrategy(MailingStrategy mailingStrategy) {
        this.mailingStrategy = mailingStrategy;
    }

    public void executeStrategy() {
        mailingStrategy.sendMail();
    }
}
