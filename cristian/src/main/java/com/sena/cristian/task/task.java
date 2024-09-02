package com.sena.cristian.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sena.cristian.Models.usuario;
import com.sena.cristian.Service.emailService;
import com.sena.cristian.Service.usuarioService;

@Component
public class task {

     @Autowired
    private usuarioService data;

    @Autowired
    private emailService email;

    @Scheduled(fixedRate = 90000)//cron = "0 0 14 * * ?"
    public void sendNotificationcron() {
        var ListUsuario=data.cambiarTipoDocumento();
        for (usuario usuario : ListUsuario) {
            System.out.println("usuario que requiere actualizar documento "+ 
            usuario.getNombre());
            email.cambiarTipoDocumento(usuario);
        }
    }

    @Scheduled(fixedRate = 90000)//fixedRate = 1600000
    public void Contraseña_actualizada() {
        var ListUsuario=data.contraseñaActualizada("");
        for (usuario usuario : ListUsuario) {
            System.out.println("usuario que debe actualizar su contraseña "+ 
            usuario.getNombre());
            email.contraseñaActualizada(usuario.getCorreo_electronico());
        }
    }


   @Scheduled(cron = "0 0 0 * * SUN")
public void Ultimo_Inicio_Sesion() {
    var ListUsuario = data.UltimoInicio("");
    for (usuario usuario : ListUsuario) {
        if (!usuario.getEstado().equals("bloqueado")) {
            System.out.println("Usuario que se bloqueará: " + usuario.getNombre());
            email.UltimoInicio(usuario.getCorreo_electronico());
    
            usuario.setEstado("bloqueado");
            data.save(usuario); 
        }
    }
}



    

}
