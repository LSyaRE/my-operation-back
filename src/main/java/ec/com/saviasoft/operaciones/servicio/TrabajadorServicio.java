package ec.com.saviasoft.operaciones.servicio;


import ec.com.saviasoft.operaciones.modelo.Trabajador;
import ec.com.saviasoft.operaciones.repositorio.TrabajadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorServicio {

    @Autowired
    private TrabajadorRepositorio trabajadorRepositorio;

    public List<Trabajador> listarTodos() {
        return trabajadorRepositorio.findAll();
    }

    public Trabajador guardar(Trabajador trabajador) {
        return trabajadorRepositorio.save(trabajador);
    }

    public Trabajador obtenerPorId(Long id) {
        return trabajadorRepositorio.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        trabajadorRepositorio.deleteById(id);
    }
    

    public Trabajador actualizar(Long id,Trabajador trabajador) {
    	
    	Trabajador trabajadorBase = trabajadorRepositorio.findById(id).orElseThrow();
    	if(trabajador.getCorreo() != null) {
    	trabajadorBase.setCorreo(trabajador.getCorreo());
    	}    	
    	if(trabajador.getIdRedmine() != null) {
    		trabajadorBase.setIdRedmine(trabajador.getIdRedmine());    		
    	}
    	if(trabajador.getNombre() != null) {
    		trabajadorBase.setNombre(trabajador.getNombre());
    	}
    	
        return trabajadorRepositorio.save(trabajadorBase);
    }
    
}

