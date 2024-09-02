package com.sena.cristian.InterfaceService;


import java.util.List;
import java.util.Optional;
import com.sena.cristian.Models.usuario;

public interface IUsuarioService {
    public String save(usuario usuario);    
    public List<usuario> findAll();
    public Optional<usuario> findOne(String id);
    public int delete(String id);
    // public List<usuario> filtroUsuario(String filtro);
    public List<usuario> cambiarTipoDocumento();
    public List<usuario> contraseñaActualizada(String contraseñaActualizada);
    public List<usuario> UltimoInicio(String UltimoInicio);
}
