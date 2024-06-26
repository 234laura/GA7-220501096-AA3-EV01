package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="usuarios")

public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id; 
	
	@Column(name="nombre",nullable=false,length=50)
	private String nombre;
	
	@Column(name="correo",nullable=false,length=50,unique=true)
	private String correo;
	
	@Column(name="contraseña",nullable=false,length=50)
	private String contraseña;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String nombre, String correo, String contraseña) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.contraseña = contraseña;
	}
	
	public Usuario( String nombre, String correo, String contraseña) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contraseña = contraseña;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", contraseña=" + contraseña + "]";
	}
	
}
