package ec.com.saviasoft.operaciones.repositorio;

import ec.com.saviasoft.operaciones.modelo.Daily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DailyRepositorio extends JpaRepository<Daily, Long> {
    List<Daily> findByFecha(LocalDate fecha);
}
