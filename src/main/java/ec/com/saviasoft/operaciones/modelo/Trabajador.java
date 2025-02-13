package ec.com.saviasoft.operaciones.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;


@Entity
@Table(name = "trabajador")
@TableGenerator(table = "secuencia", schema = "operacion", name = "sec_default", pkColumnName = "nombre", pkColumnValue = "trabajador", valueColumnName = "valor", allocationSize = 1)
public class Trabajador {

    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sec_preferido")
    private Long id;

    @Column(name = "nombre", length = 150)
   private String nombre;
    @Column(name = "correo", length = 150)
    private String correo;
    @Column(name = "id_redmine", length = 32)
    private String idRedmine;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdRedmine() {
        return idRedmine;
    }

    public void setIdRedmine(String idRedmine) {
        this.idRedmine = idRedmine;
    }
}

