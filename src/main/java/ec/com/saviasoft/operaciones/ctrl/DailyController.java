package ec.com.saviasoft.operaciones.ctrl;

import ec.com.saviasoft.operaciones.modelo.Daily;
import ec.com.saviasoft.operaciones.servicio.DailyServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/dailies")
@CrossOrigin(origins = "*")
public class DailyController {

    @Autowired
    private DailyServicio dailyServicio;

    @GetMapping("/obtener-todos")
    public ResponseEntity<List<Daily>> listarTodos() {
        return ResponseEntity.ok(dailyServicio.listarTodos());
    }

    @PostMapping("/guardar")
    public ResponseEntity<Daily> guardar(@RequestBody Daily daily) {
        return ResponseEntity.ok(dailyServicio.guardar(daily));
    }

    @GetMapping("/buscar-id/{id}")
    public ResponseEntity<Daily> obtenerPorId(@PathVariable Long id) {
        Daily daily = dailyServicio.obtenerPorId(id);
        if (daily != null) {
            return ResponseEntity.ok(daily);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar-por-fecha/{fecha}")
    public ResponseEntity<List<Daily>> buscarPorFecha(@PathVariable LocalDate fecha) {
        return ResponseEntity.ok(dailyServicio.buscarPorFecha(fecha));
    }
    
    
    
    @PostMapping("/guardar-con-trabajadores")
    public ResponseEntity<Daily> guardarConTrabajadores(@RequestBody Daily daily) {
        return ResponseEntity.ok(dailyServicio.guardar(daily));
    }

    

    @PutMapping("/{id}")
    public ResponseEntity<Daily> actualizar(@PathVariable Long id, @RequestBody Daily daily) {
    	
        return ResponseEntity.ok(dailyServicio.actualizar(id, daily));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        dailyServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/guardar-con-tiempo-en-minutos")
    public ResponseEntity<Daily> guardarConTiempoEnMinutos(@RequestBody Daily daily) {
        // Asegúrate de que el objeto 'daily' ya tenga el campo 'tiempoEnMinutos'
        return ResponseEntity.ok(dailyServicio.guardar(daily));
    }

}

