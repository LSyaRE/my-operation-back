package ec.com.saviasoft.operaciones.modelo;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario_password")
@TableGenerator(
    table = "secuencia",
    schema = "operacion",
    name = "sec_default",
    pkColumnName = "nombre",
    pkColumnValue = "usuario_password",
    valueColumnName = "valor",
    allocationSize = 1
)
public class UsuarioPassword implements Serializable {

	private static final long serialVersionUID = 1L;

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "password", nullable = false)
    private String password;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

