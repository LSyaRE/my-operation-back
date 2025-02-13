package ec.com.saviasoft.operaciones.servicio;

import ec.com.saviasoft.operaciones.modelo.Daily;
import ec.com.saviasoft.operaciones.repositorio.DailyRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DailyServicio {

    @Autowired
    private DailyRepositorio dailyRepositorio;

    public List<Daily> listarTodos() {
        return dailyRepositorio.findAll();
    }

    public Daily guardar(Daily daily) {
        return dailyRepositorio.save(daily);
    }
    
    

    public Daily actualizar(Long id, Daily daily) {
    	Daily dailyBase = dailyRepositorio.findById(id).orElseThrow();
    	
    	if(daily.getFecha() != null) {
    		dailyBase.setFecha(daily.getFecha());
    	}
    	
    	if(daily.getObservacion() != null) {
    		dailyBase.setObservacion(daily.getObservacion());
    	}
    	
    	dailyBase.setTiempoEnMinutos(daily.getTiempoEnMinutos());
    	dailyBase.setEscrito(daily.isEscrito());
    	
    	if(daily.getTrabajadores() != null) {
    		dailyBase.setTrabajadores(daily.getTrabajadores());
    	}    	
    	
        return dailyRepositorio.save(dailyBase);
    }

    public Daily obtenerPorId(Long id) {
        return dailyRepositorio.findById(id).orElse(null);
    }

    public List<Daily> buscarPorFecha(LocalDate fecha) {
        return dailyRepositorio.findByFecha(fecha);
    }

    
    
    public Daily guardarConTrabajadores(Daily daily) {
        return dailyRepositorio.save(daily);
    }

    
    public void eliminar(Long id) {
        dailyRepositorio.deleteById(id);
    }
    
    public Daily guardarConTiempoEnMinutos(Daily daily, int tiempoEnMinutos) {
        daily.setTiempoEnMinutos(tiempoEnMinutos);
        return dailyRepositorio.save(daily);
    }

}
