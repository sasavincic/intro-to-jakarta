//package si.um.feri.aiv.mail;
//
//import jakarta.annotation.Resource;
//
//import jakarta.enterprise.context.SessionScoped;
//import jakarta.inject.Named;
//import jakarta.mail.Address;
//import jakarta.mail.Message;
//import jakarta.mail.Session;
//import jakarta.mail.Transport;
//import jakarta.mail.internet.InternetAddress;
//import jakarta.mail.internet.MimeMessage;
//
//import java.io.Serializable;
//
//@Named
//@SessionScoped
//public class Email implements Serializable {
//    private static final long serialVersionUID = 1544680932114626710L;
//
//    @Resource(mappedName = "java:jboss/mail/TestMail")
//    private Session mySession;
//
//    private String to;
//
//    private String from;
//
//    private String subject;
//
//    private String body;
//
//    public String getTo() {
//        return to;
//    }
//
//    public void setTo(String to) {
//        this.to = to;
//    }
//
//    public String getFrom() {
//        return from;
//    }
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public void send() throws Exception {
//        Message message = new MimeMessage(mySession);
//        message.setFrom(new InternetAddress(from));
//        Address toAddress = new InternetAddress(to);
//        message.addRecipient(Message.RecipientType.TO, toAddress);
//        message.setSubject(subject);
//        message.setContent(body, "text/plain");
//        Transport.send(message);
//    }
//}
