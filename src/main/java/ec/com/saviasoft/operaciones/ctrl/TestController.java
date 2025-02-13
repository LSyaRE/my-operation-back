package ec.com.saviasoft.operaciones.ctrl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/prueba")
@CrossOrigin(origins = "*")
public class TestController {

	@GetMapping("/")
	public ResponseEntity<String> test() {

		return ResponseEntity.ok().body("el proyecto esta configurado...");
	}

}