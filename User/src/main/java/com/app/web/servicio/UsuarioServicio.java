package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Usuario;

public interface UsuarioServicio {
	public List<Usuario> listarUsuarios();
	
	public Usuario guardarUsuario(Usuario usuario);
	
	public Usuario obtenerUsuario(Long id);
	
	public Usuario actualizarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Long id);

	public boolean existeUsuarioPorCorreo(String correo);
	
}
