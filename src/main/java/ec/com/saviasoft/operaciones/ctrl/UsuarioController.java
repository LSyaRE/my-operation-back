package ec.com.saviasoft.operaciones.ctrl;

import ec.com.saviasoft.operaciones.exception.MensajeException;
import ec.com.saviasoft.operaciones.modelo.Trabajador;
import ec.com.saviasoft.operaciones.modelo.Usuario;
import ec.com.saviasoft.operaciones.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/guardar")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) throws MensajeException {
        return ResponseEntity.status(201).body(usuarioServicio.guardarUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id,@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioServicio.actualizar(id, usuario));
    }

    @GetMapping("/buscar-username/{username}")
    public ResponseEntity<Usuario> buscarPorUsername(@PathVariable String username)throws MensajeException {
        Usuario usuario = usuarioServicio.buscarPorUsername(username);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
        	throw new MensajeException("Usuario con el username '" + username + "' no encontrado");
        }
    }
}
