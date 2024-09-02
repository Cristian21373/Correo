package com.sena.cristian.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sena.cristian.Models.usuario;

// import com.sena.cristian.Models.usuario;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String enviarCorreoBienvenida(String destinatario) {
        try {
            String asunto = "¡Bienvenid@ a nuestra plataforma!";
            String cuerpo = ""
                    + "<body style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; background-color: #f3f4f6; padding: 40px;\">\r\n"
                    + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 30px; border-radius: 12px; box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);\">\r\n"
                    + "  <h1 style=\"font-size: 32px; font-weight: bold; color: #333333; text-align: center;\">¡Bienvenid@ a nuestra plataforma!</h1>\r\n"
                    + "  <p style=\"font-size: 20px; color: #666666; text-align: center; margin-top: 20px;\">Estamos encantados de que te hayas registrado.</p>\r\n"
                    + "  <hr style=\"border: 0; border-top: 2px solid #eeeeee; margin: 30px 0;\">\r\n"
                    + "  <p style=\"font-size: 18px; color: #555555; line-height: 1.8; text-align: center;\">Gracias por unirte a nuestra plataforma.</p>\r\n"
                    + "</div>\r\n"
                    + "<div style=\"text-align: center; margin-top: 20px; font-size: 14px; color: #888888;\">\r\n"
                    + "  <p>&copy; 2024. Todos los derechos reservados.</p>\r\n"
                    + "</div>\r\n"
                    + "</body>";

            var retorno = enviarCorreo(destinatario, asunto, cuerpo);
            if (retorno) {
                return "se envió correctamente";
            } else {
                return "No se pudo envíar";
            }

        } catch (Exception e) {
            // TODO: handle exception
            return "Error al envíar " + e.getMessage();
        }
    }

    public String UltimoInicio(String destinatario) {
        try {
            String asunto = "Tu cuenta ha sido bloqueada";
            String cuerpo = ""
                    + "<body style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; background-color: #e0e0e0; padding: 40px;\">\r\n"
                    + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 30px; border-radius: 10px; box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);\">\r\n"
                    + "  <h1 style=\"font-size: 28px; font-weight: bold; color: #444444; text-align: center;\">Aviso importante: Cuenta bloqueada</h1>\r\n"
                    + "  <p style=\"font-size: 18px; color: #666666; text-align: center;\">Tu cuenta ha sido bloqueada debido a la inactividad.</p>\r\n"
                    + "  <hr style=\"border: 0; border-top: 1px solid #dddddd; margin: 20px 0;\">\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555; line-height: 1.6;\">Hemos detectado que no has iniciado sesión en los últimos 30 días. Por motivos de seguridad, tu cuenta ha sido bloqueada temporalmente.</p>\r\n"
                    + "</div>\r\n"
                    + "</body>";

            var retorno = enviarCorreo(destinatario, asunto, cuerpo);
            if (retorno) {
                return "se envió correctamente";
            } else {
                return "No se pudo envíar";
            }

        } catch (Exception e) {
            return "Error al envíar " + e.getMessage();
        }
    }

    public String contraseñaActualizada(String destinatario) {
        try {
            String asunto = "Es momento de actualizar tu contraseña";
            String cuerpo = ""
                    + "<body style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; background-color: #e0e0e0; padding: 40px;\">\r\n"
                    + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 30px; border-radius: 10px; box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);\">\r\n"
                    + "  <h1 style=\"font-size: 28px; font-weight: bold; color: #444444; text-align: center;\">Actualiza tu contraseña</h1>\r\n"
                    + "  <p style=\"font-size: 18px; color: #666666; text-align: center;\">Por tu seguridad, te recomendamos actualizar tu contraseña.</p>\r\n"
                    + "  <hr style=\"border: 0; border-top: 1px solid #dddddd; margin: 20px 0;\">\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555; line-height: 1.6;\">Para mantener la seguridad de tu cuenta, es importante que cambies tu contraseña de manera regular. Esto ayuda a proteger tu información personal y asegurar que solo tú tengas acceso.</p>\r\n"
                    + "</div>\r\n"
                    + "</body>";

            var retorno = enviarCorreo(destinatario, asunto, cuerpo);
            if (retorno) {
                return "se envió correctamente";
            } else {
                return "No se pudo envíar";
            }

        } catch (Exception e) {
            return "Error al envíar " + e.getMessage();
        }
    }

    public String cambiarTipoDocumento(usuario usuario) {
        try {
            String asunto = "Es hora de actualizar tu tipo de documento";
            String cuerpo = ""
                    + "<body style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; background-color: #e0e0e0; padding: 40px;\">\r\n"
                    + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 30px; border-radius: 10px; box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);\">\r\n"
                    + "  <h1 style=\"font-size: 28px; font-weight: bold; color: #444444; text-align: center;\">¡Hola! "
                    + usuario.getNombre() + "</h1>\r\n"
                    + "  <p style=\"font-size: 18px; color: #666666; text-align: center;\">Queremos recordarte que es el momento de actualizar tu tipo de documento.</p>\r\n"
                    + "  <hr style=\"border: 0; border-top: 1px solid #dddddd; margin: 20px 0;\">\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555; line-height: 1.6;\">Por favor, accede a tu cuenta y realiza la actualización lo antes posible.</p>\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555; line-height: 1.6;\">Gracias por tu colaboración.</p>\r\n"
                    + "</div>\r\n"
                    + "</body>";

            var retorno = enviarCorreo(usuario.getCorreo_electronico(), asunto, cuerpo);
            if (retorno) {
                return "se envió correctamente";
            } else {
                return "No se pudo envíar";
            }

        } catch (Exception e) {
            return "Error al envíar " + e.getMessage();
        }
    }

    public boolean enviarCorreo(String destinatario, String asunto, String cuerpo) throws MessagingException {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(destinatario);
            helper.setSubject(asunto);
            helper.setText(cuerpo, true);

            javaMailSender.send(message);
            return true;
        } catch (Exception e) {

            return false;
        }

    }

}
