import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class Mail {
    private  static final  String SMTP_GMAIL = "smtp.gmail.com";
    private  static final  int SMTP_PORT = 465;

    public static void main(String[] args) throws MessagingException {
        getSend();
    }

    private static void getSend() throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol","smtp" );
        properties.put("mail.smtp.host", SMTP_GMAIL);
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.sendpartial","true");


        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        message.setSubject("US tourist VISA");
        message.setText("COME TO US, ALMAZ");
        message.setSentDate(new Date());
        message.addRecipients(Message.RecipientType.TO, "yamuz@mail.ru");


        String login = "yamuuzz@gmail.com";
        String password = "";
        Scanner sc = new Scanner(System.in);
        password = sc.nextLine();
        if (password.isEmpty())
            throw new RuntimeException("no pass");

        Transport transport = session.getTransport();
        transport.connect(SMTP_GMAIL, SMTP_PORT, login, password);
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));


    }
}
