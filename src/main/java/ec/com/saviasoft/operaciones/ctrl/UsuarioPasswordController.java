package ec.com.saviasoft.operaciones.ctrl;

import ec.com.saviasoft.operaciones.modelo.UsuarioPassword;
import ec.com.saviasoft.operaciones.servicio.UsuarioPasswordServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usuarios/passwords")
@CrossOrigin(origins = "*")

public class UsuarioPasswordController {

	 @Autowired
	    private UsuarioPasswordServicio usuarioPasswordServicio;
	 
	 @PostMapping("/guardar")
	 public ResponseEntity<UsuarioPassword> guardarPassword(@RequestBody UsuarioPassword usuarioPassword) {
	     return ResponseEntity.status(201).body(usuarioPasswordServicio.guardarPassword(usuarioPassword));
	 }

	 @GetMapping("/validar")
	    public ResponseEntity<Boolean> validarPassword(@RequestParam String username, @RequestParam String password) {
	        boolean valido = usuarioPasswordServicio.validarUsuario(username, password);
	        return ResponseEntity.ok(valido);
	    }
}
