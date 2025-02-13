package ec.com.saviasoft.operaciones.ctrl;

import ec.com.saviasoft.operaciones.modelo.Trabajador;
import ec.com.saviasoft.operaciones.servicio.TrabajadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/trabajadores")
@CrossOrigin(origins = "*")
public class TrabajadorController{

    @Autowired
    private TrabajadorServicio trabajadorServicio;

    @GetMapping("/obtener-todos")
    public ResponseEntity<List<Trabajador>> listarTodos() {
        return ResponseEntity.ok(trabajadorServicio.listarTodos());
    }

    @PostMapping("/guardar")
    public ResponseEntity<Trabajador> guardar(@RequestBody Trabajador trabajador) {
        return ResponseEntity.ok(trabajadorServicio.guardar(trabajador));
    }

    @GetMapping("/buscar-id/{id}")
    public ResponseEntity<Trabajador> obtenerPorId(@PathVariable Long id) {
        Trabajador trabajador = trabajadorServicio.obtenerPorId(id);
        if (trabajador != null) {
            return ResponseEntity.ok(trabajador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        trabajadorServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> actualizar(@PathVariable Long id,@RequestBody Trabajador trabajador) {
        return ResponseEntity.ok(trabajadorServicio.actualizar(id, trabajador));
    }
}


