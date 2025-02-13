package ec.com.saviasoft.operaciones.modelo;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
@TableGenerator(
    table = "secuencia",
    schema = "operacion",
    name = "sec_default",
    pkColumnName = "nombre",
    pkColumnValue = "usuario",
    valueColumnName = "valor",
    allocationSize = 1
)
public class Usuario implements Serializable {
	
    private static final long serialVersionUID = 1L; 

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 150)
    private String username;

    @OneToOne
    @JoinColumn(name = "id_trabajador", nullable = false)
    private Trabajador trabajador;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}


