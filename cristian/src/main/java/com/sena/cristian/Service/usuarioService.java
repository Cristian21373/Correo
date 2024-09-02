package com.sena.cristian.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.cristian.InterfaceService.IUsuarioService;
import com.sena.cristian.Interfaces.IUsuario;
import com.sena.cristian.Models.usuario;


@Service 
public class usuarioService implements IUsuarioService {
	
	@Autowired
	private IUsuario data;

    @Override
	public String save(usuario usuario) {
		data.save(usuario);
        return usuario.getId();
	}

	@Override
	public List<usuario> findAll() {
		List<usuario> ListUsuario=(List<usuario>) data.findAll();
		return ListUsuario;
	}

	@Override
	public Optional<usuario> findOne(String id) {
		Optional<usuario> usuario=data.findById(id);
		return usuario;
	}

	@Override
	public int delete(String id) {
		data.deleteById(id);
		return 1;
	}

	// @Override
	// public List<usuario> filtroUsuario(String filtro) {
	// 	List <usuario> listUsuario=data.filtroUsuario(filtro);
    //     return listUsuario;
	// }

	@Override
    public List<usuario> cambiarTipoDocumento() {
        List<usuario> ListUsuario = data.cambiarTipoDocumento();
        return ListUsuario;
    }

	@Override
	public List<usuario> contraseñaActualizada(String contraseñaActualizada) {
		List<usuario> ListUsuario = data.contraseñaActualizada(contraseñaActualizada);
		return ListUsuario;
	}

	@Override
	public List<usuario> UltimoInicio(String UltimoInicio) {
		List<usuario> ListUsuario = data.UltimoInicio(UltimoInicio);
		return ListUsuario;
	}
}
