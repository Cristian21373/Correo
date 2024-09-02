package com.sena.cristian.Models;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_usuario", nullable = false, length = 36)
    private String id_usuario;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Enumerated(EnumType.STRING)
	@Column(name = "tipo_Documento", nullable = false, length = 100)
    private tipo_Documento tipo_Documento;

    @Column(name = "num_Documento", nullable = false, length = 11)
    private int num_Documento;

    @Column(name = "fecha_nacimiento", nullable = false)
	private Date fecha_nacimiento;

    @Column(name = "correo_electronico", nullable = false, length = 100)
    private String correo_electronico;

    @Column(name = "fecha_ultima_actua", nullable = false)//fecha de última actualización de contraseña 
	private Date fecha_ultima_actua;
    
    @Column(name = "fecha_ultima_inicio", nullable = false)//fecha de último inicio sesión
	private LocalDate fecha_ultima_inicio;

    @Column(name = "contraseña", nullable = false, length = 100)
	private String contraseña;
    

    @Column(name = "estado", nullable = false, length = 100)
	private String estado;
    
    




    






    







    public usuario() {
    }








    public usuario(String id_usuario, String nombre, com.sena.cristian.Models.usuario.tipo_Documento tipo_Documento,
            int num_Documento, Date fecha_nacimiento, String correo_electronico, Date fecha_ultima_actua,
            LocalDate fecha_ultima_inicio, String contraseña, String estado) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.tipo_Documento = tipo_Documento;
        this.num_Documento = num_Documento;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo_electronico = correo_electronico;
        this.fecha_ultima_actua = fecha_ultima_actua;
        this.fecha_ultima_inicio = fecha_ultima_inicio;
        this.contraseña = contraseña;
        this.estado = estado;
    }








    public String getId_usuario() {
        return id_usuario;
    }








    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }








    public String getNombre() {
        return nombre;
    }








    public void setNombre(String nombre) {
        this.nombre = nombre;
    }








    public tipo_Documento getTipo_Documento() {
        return tipo_Documento;
    }








    public void setTipo_Documento(tipo_Documento tipo_Documento) {
        this.tipo_Documento = tipo_Documento;
    }








    public int getNum_Documento() {
        return num_Documento;
    }








    public void setNum_Documento(int num_Documento) {
        this.num_Documento = num_Documento;
    }








    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }








    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }








    public String getCorreo_electronico() {
        return correo_electronico;
    }








    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }








    public Date getFecha_ultima_actua() {
        return fecha_ultima_actua;
    }








    public void setFecha_ultima_actua(Date fecha_ultima_actua) {
        this.fecha_ultima_actua = fecha_ultima_actua;
    }








    public LocalDate getFecha_ultima_inicio() {
        return fecha_ultima_inicio;
    }








    public void setFecha_ultima_inicio(LocalDate fecha_ultima_inicio) {
        this.fecha_ultima_inicio = fecha_ultima_inicio;
    }








    public String getContraseña() {
        return contraseña;
    }








    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }








    public String getEstado() {
        return estado;
    }








    public void setEstado(String estado) {
        this.estado = estado;
    }








    public enum tipo_Documento {
        cc,
        ti
    }

 






    public String getId() {
        return id_usuario;
    }



}
