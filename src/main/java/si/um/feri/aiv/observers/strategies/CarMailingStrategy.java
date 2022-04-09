package si.um.feri.aiv.observers.strategies;

public class CarMailingStrategy implements MailingStrategy {
    @Override
    public void sendMail() {
        System.out.println("Car");
        //Send to car drivers
    }
}
