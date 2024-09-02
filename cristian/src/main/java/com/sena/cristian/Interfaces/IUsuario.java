package com.sena.cristian.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.cristian.Models.usuario;

@Repository
public interface IUsuario extends CrudRepository<usuario,String>{

    @Query ("SELECT u FROM usuario u WHERE TIMESTAMPDIFF(YEAR, u.fecha_nacimiento, NOW())>=18 AND tipo_Documento = 'ti'")
    List<usuario> cambiarTipoDocumento();

    @Query("SELECT u FROM usuario u WHERE  DATEDIFF(NOW(), u.fecha_ultima_actua) >= 90")
    List<usuario> contraseñaActualizada(String contraseñaActualizada);
	
    @Query("SELECT u FROM usuario u WHERE DATEDIFF(CURRENT_DATE, u.fecha_ultima_inicio) > 30")
    List<usuario> UltimoInicio(String UltimoInicio);
	
}

