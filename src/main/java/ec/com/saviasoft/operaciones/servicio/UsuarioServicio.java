package ec.com.saviasoft.operaciones.servicio;


import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.saviasoft.operaciones.exception.MensajeException;
import ec.com.saviasoft.operaciones.modelo.Usuario;
import ec.com.saviasoft.operaciones.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    // Método para guardar un usuario
    public Usuario guardarUsuario(Usuario usuario) throws MensajeException {
    	   if (usuarioRepositorio.findByUsername(usuario.getUsername()) != null) {
    	        throw new MensajeException("El nombre de usuario ya existe.");
    	   } try {
        return usuarioRepositorio.save(usuario);
    	} catch (DataIntegrityViolationException e) {
            // Manejar violaciones de integridad de datos
            throw new MensajeException("Error de integridad de datos: no se pudo guardar el usuario. Verifique que no haya duplicados u otros conflictos.");
    } catch (DataAccessException e) {
    	throw new MensajeException("no se pudo guardar el usuario");
	}
    	
    }
    
    

    public Usuario actualizar(Long id, Usuario usuario) {
    	Usuario usuarioBase = usuarioRepositorio.findById(id).orElseThrow();
    	
    	if(usuario.getUsername() != null) {
    		usuarioBase.setUsername(usuario.getUsername());
    	}
    	
    	if(usuario.getEstado() != null) {
    		usuarioBase.setEstado(usuario.getEstado());
    	}
    	
    	if(usuario.getTrabajador() != null) {
    		usuarioBase.setTrabajador(usuario.getTrabajador());
    	}
    	
    	return usuarioRepositorio.save(usuarioBase);
    }

    public Usuario buscarPorUsername(String username) throws MensajeException {
        Usuario usuario = usuarioRepositorio.findByUsername(username);
        if (usuario == null) {
            throw new MensajeException("Usuario con el username '" + username + "' no encontrado");
        }
        return usuario;
    }
    
    
    public Usuario buscarPorTrabajador(Long trabajador) throws MensajeException {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        
        return usuarios.stream().filter(usuarioStream -> usuarioStream.getTrabajador().getId() == trabajador)
				   .findFirst()
				   .orElseThrow(() -> new MensajeException("Usuario con el id del trabajador '" + trabajador + "' no encontrado"));
    }

}