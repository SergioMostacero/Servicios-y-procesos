package Correo;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import GestorFichs.Usuario;

import java.util.Properties;

public class EnviarMail {

    //enviar un correo electrónico a un usuario
    public static void enviarCorreo(Usuario usuario) {

        // credenciales del correo electrónico desde donde se mandara
        String username = "smosta0@gmail.com";
        String password = "ausdfagenhzixuec";

        // configuración servidor correo electronico
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com"); 
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // creación de la sesión con autenticacion del correo remitente
        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password); 
            }
        });

        try {
            // creación del mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); 
            message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(usuario.getCorreo()) // direccion del destinatario del usuario
            );
            message.setSubject("RESULTADOS"); // asunto del correo
            // cuerpo del mensaje 
            message.setText(
                usuario.getNombre() +  
                " las estadísticas son:\n" + 
                usuario.getEstadisticas().get(0) + "\n" + 
                "estadísticas 2:\n" + 
                usuario.getEstadisticas().get(1)
            );

            // envio del mensaje
            Transport.send(message);

        } catch (MessagingException e) {

            JOptionPane.showMessageDialog(null, "error al enviar el email", "error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
