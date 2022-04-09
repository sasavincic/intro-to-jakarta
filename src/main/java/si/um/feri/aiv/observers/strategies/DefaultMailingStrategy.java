package si.um.feri.aiv.observers.strategies;

public class DefaultMailingStrategy implements MailingStrategy {
    @Override
    public void sendMail() {
        System.out.println("Default");
        //        if (observerEventType.equals(ObserverEventType.NOT_VALID)) {
        //            log.info("Sending mail from MailingObserver!");
        //            Email email = new Email();
        //            email.setTo("sasa.vincic16@gmail.com");
        //            email.setSubject("Neveljavna vinjeta");
        //            email.setBody("Vaša vinjeta je neveljavna!");
        //            try {
        //                email.send();
        //            } catch (Exception e) {
        //                e.printStackTrace();
        //            }
        //        }
    }
}
