package ec.com.saviasoft.operaciones.repositorio;

import ec.com.saviasoft.operaciones.modelo.UsuarioPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPasswordRepositorio extends JpaRepository<UsuarioPassword, Long> {
    UsuarioPassword findByUsuarioUsername(String username);
}
