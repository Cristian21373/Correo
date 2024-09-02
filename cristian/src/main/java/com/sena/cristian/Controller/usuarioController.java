package com.sena.cristian.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.cristian.Interfaces.IUsuario;
import com.sena.cristian.Models.usuario;
import com.sena.cristian.Service.emailService;


@RestController
@RequestMapping("/api/v1/usuario")
public class usuarioController {

    @Autowired
	private IUsuario usuarioService;

    @Autowired
    private emailService emailService;

    @PostMapping("/")
    public ResponseEntity<Object> save (@ModelAttribute("usuario") usuario usuario){
        if (usuario.getTipo_Documento().equals("")) {

            return new ResponseEntity<>("El tipo de documento es obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (usuario.getContraseña().equals("")) {

            return new ResponseEntity<>("La contraseña es obligatorio", HttpStatus.BAD_REQUEST);
        }


        if (usuario.getCorreo_electronico().equals("")) {

            return new ResponseEntity<>("El correo electronico es obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (usuario.getFecha_nacimiento().equals("")) {

            return new ResponseEntity<>("La fecha de nacimiento es obligatorio", HttpStatus.BAD_REQUEST);
        }

        usuarioService.save(usuario);
        emailService.enviarCorreoBienvenida(usuario.getCorreo_electronico());
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        var ListUsuario =usuarioService.findAll();
        return new ResponseEntity<>(ListUsuario, HttpStatus.OK);
    }

    // @GetMapping("/busquedafiltro/{filtro}")
    // public ResponseEntity<Object>findFiltro(@PathVariable String filtro){
    //     var ListUsuario = usuarioService.filtroUsuario(filtro);
    //     return new ResponseEntity<>(ListUsuario, HttpStatus.OK);
    // }
	
	@GetMapping("/{id_usuario}")
    public ResponseEntity<Object> findOne(@PathVariable("id_usuario") String id){
        var usuario = usuarioService.findById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
	
    @GetMapping("/edadMaxima")
    public ResponseEntity<Object> findEdad() {
        var ListUsuario = usuarioService.cambiarTipoDocumento();
        return new ResponseEntity<>(ListUsuario, HttpStatus.OK);
    }

	@DeleteMapping("/{id_usuario}")
    public ResponseEntity<Object> delete(@PathVariable("id_usuario") String id_usuario){
        usuarioService.deleteById(id_usuario);
        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
    }
	
	@PutMapping("/{id_usuario}")
    public ResponseEntity<Object> update(@PathVariable("id_usuario") String id_usuario, @ModelAttribute usuario usuarioUpdate){
	    var usuario = usuarioService.findById(id_usuario).orElse(null);
	    if (usuario != null) {
            usuario.setNombre(usuarioUpdate.getNombre());
	        usuario.setCorreo_electronico(usuarioUpdate.getCorreo_electronico());
	        usuario.setTipo_Documento(usuarioUpdate.getTipo_Documento());
            usuario.setNum_Documento(usuarioUpdate.getNum_Documento());
            usuario.setFecha_nacimiento(usuarioUpdate.getFecha_nacimiento());
            usuario.setContraseña(usuarioUpdate.getContraseña());
            usuario.setEstado(usuarioUpdate.getEstado());


	        
	        usuarioService.save(usuario);
	        return new ResponseEntity<>("Guardado", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Error: usuario no encontrado", HttpStatus.BAD_REQUEST);
	    }
	}

}
