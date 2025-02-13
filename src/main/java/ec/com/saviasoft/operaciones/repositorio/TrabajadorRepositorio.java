package ec.com.saviasoft.operaciones.repositorio;


import ec.com.saviasoft.operaciones.modelo.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepositorio extends JpaRepository<Trabajador, Long> {
}
