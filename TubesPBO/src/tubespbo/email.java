package tubespbo;
import com.sun.istack.internal.logging.Logger;
import java.util.Properties;
import java.util.logging.Level;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class email {
    public static void sendMail(String address, String subjek, String message) throws Exception{
        int i;
        System.out.println("Preparing to send email");
        
        String myAccount = "layanan.informasi.if17@gmail.com";
        String ps = "layanan123";
        String[]to = {address};
        String host = "smtp.gmail.com";
        
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true"); //TLS adalah penerus dari SSL
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", myAccount);
        properties.put("mail.smtp.password", ps);
        properties.put("mail.smtp.port", "587"); //port TLS = 587
        properties.put("mail.smtp.auth", "true"); //untuk mengautektikasi ke server agar memastikan tidak digunakan open relay/spam
        
        
        Session session = Session.getDefaultInstance(properties); //Properti yang sudah diatur dijadikan argument untuk Session yang nantinya akan terhubung ke server SMTP
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(myAccount));
        InternetAddress[] toaddress = new InternetAddress[to.length];
        for(i=0; i<to.length; i++){
            toaddress[i]= new InternetAddress(to[i]);
        }
        
        for(i=0; i<toaddress.length; i++){
            msg.setRecipient(Message.RecipientType.TO, toaddress[i]);
        }
        msg.setSubject(subjek);
        msg.setContent(message, "text/html; charset=utf-8");
        Transport ts = session.getTransport("smtp");
        ts.connect(host,myAccount,ps); //Dengan menggunakan fungsi static maka kita tidak perlu menutup koneksi karena akan otomatis tertutup setelah pengiriman.
        ts.sendMessage(msg, msg.getAllRecipients());
        ts.close();
    }
    
    
    
}
