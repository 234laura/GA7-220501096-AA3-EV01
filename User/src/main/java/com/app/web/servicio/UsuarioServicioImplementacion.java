package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Usuario;
import com.app.web.repositorio.UsuarioRepositorio;

@Service

public class UsuarioServicioImplementacion implements UsuarioServicio {

	@Autowired
	private UsuarioRepositorio repositorio;

	// Método para listar todos los usuarios existentes
	@Override
	public List<Usuario> listarUsuarios() {
		return repositorio.findAll();
	}

	// Método para guardar un nuevo usuario en la base de datos
	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return repositorio.save(usuario);
	}

	// Método para obtener un usuario por su ID
	@Override
	public Usuario obtenerUsuario(Long id) {
		return repositorio.findById(id).get();
	}

	// Método para actualizar un usuario existente en la base de datos
	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return repositorio.save(usuario);
	}

	// Método para eliminar un usuario de la base de datos por su ID
	@Override
	public void eliminarUsuario(Long id) {
		repositorio.deleteById(id);
	}

	// Método para verificar si ya existe un usuario con un correo electrónico
	// específico en la base de datos
	@Override
	public boolean existeUsuarioPorCorreo(String correo) {
		return repositorio.existsByCorreo(correo);
	}

}
