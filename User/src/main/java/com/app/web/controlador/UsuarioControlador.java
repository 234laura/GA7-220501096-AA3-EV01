package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Usuario;
import com.app.web.servicio.UsuarioServicio;

@Controller
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio servicio;

    // Método para listar todos los usuarios
    @GetMapping({ "/usuarios", "/" })
    public String listarUsuarios(Model modelo) {
        modelo.addAttribute("usuarios", servicio.listarUsuarios());
        return "usuarios";
    }

    // Método para mostrar el formulario de creación de usuario
    @GetMapping("/usuarios/nuevo")
    public String crearUsuarioFormulario(Model modelo) {
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "crear_usuario";
    }

    // Método para guardar un nuevo usuario
    @PostMapping("/usuarios")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, Model modelo) {
        String correo = usuario.getCorreo();
        // Verificar si ya existe un usuario con el mismo correo electrónico
        if (servicio.existeUsuarioPorCorreo(correo)) {
            // Mostrar un mensaje de error si el correo ya está en uso
            modelo.addAttribute("error", "Ya existe un usuario con ese correo electrónico");
            return "crear_usuario";
        } else {
            // Guardar el usuario si el correo no está en uso
            servicio.guardarUsuario(usuario);
            return "redirect:/usuarios";
        }
    }

    // Método para mostrar el formulario de edición de usuario
    @GetMapping("/usuarios/editar/{id}")
    public String crearUsuarioFormulario(@PathVariable("id") Long id, Model modelo) {
        modelo.addAttribute("usuario", servicio.obtenerUsuario(id));
        return "editar_usuario";
    }

    // Método para actualizar un usuario existente
    @PostMapping("/usuarios/{id}")
    public String actualizarUsuario(@PathVariable("id") Long id, @ModelAttribute("usuario") Usuario usuario,
            Model modelo) {
        String correo = usuario.getCorreo();
        // Obtener el usuario existente
        Usuario usuarioExistente = servicio.obtenerUsuario(id);
        // Verificar si el correo electrónico está siendo modificado y si ya está en uso por otro usuario
        if (!usuarioExistente.getCorreo().equals(correo) && servicio.existeUsuarioPorCorreo(correo)) {
            // Mostrar un mensaje de error si el correo ya está en uso
            modelo.addAttribute("error", "Ya existe un usuario con ese correo electrónico");
            return "editar_usuario";
        } else {
            // Actualizar el usuario si no hay errores
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setCorreo(correo);
            usuarioExistente.setContraseña(usuario.getContraseña());
            servicio.actualizarUsuario(usuarioExistente);
            return "redirect:/usuarios";
        }
    }

    // Método para eliminar un usuario
    @GetMapping("/usuarios/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id) {
        servicio.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}