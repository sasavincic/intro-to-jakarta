package si.um.feri.aiv.observers.strategies;

public class MinivanMailingStrategy implements MailingStrategy {
    @Override
    public void sendMail() {
        System.out.println("Minivan");
        //Send to minivan drivers
    }
}
