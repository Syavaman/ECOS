package PageObject;

import PageObject.Users.UsersInfo;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendMail {

    final String username = Constants.gmailAccount;
    final String password = Constants.gmailPassword;


    public SendMail sendMail(String typeOfThreat) {

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {


            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(UsersInfo.emailNameOfTestedUser)
            );

            if (typeOfThreat.equals("Spam")) {
                message.setSubject("Spam letter");
                message.setText("XJS*C4JDBQADN1.NSBN3*2IDNEN*GTUBE-ESETS-STANDARD-ANTI-UBE-TEST-EMAIL*C.34X");
                Transport.send(message);
            } else if (typeOfThreat.equals("Phishing")) {
                message.setSubject("Phishing letter");
                message.setText("Here is your phishing link : " + "http://utm.io/290617");
                Transport.send(message);
            } else if (typeOfThreat.equals("Malware")) {
                message.setSubject("Malware letter");
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                Multipart multipart = new MimeMultipart();
                messageBodyPart = new MimeBodyPart();
                String file = ".\\drivers\\testfile.txt";
                String fileName = "testfile";
                DataSource source = new FileDataSource(file);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(fileName);
                multipart.addBodyPart(messageBodyPart);
                message.setContent(multipart);
                Transport.send(message);

            }

            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return this;
    }


}

