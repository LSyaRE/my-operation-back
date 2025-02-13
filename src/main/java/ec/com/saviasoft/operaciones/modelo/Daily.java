package ec.com.saviasoft.operaciones.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "daily")
@TableGenerator(
    table = "secuencia",
    schema = "operacion",
    name = "sec_default",
    pkColumnName = "nombre",
    pkColumnValue = "daily",
    valueColumnName = "valor",
    allocationSize = 1
)
public class Daily {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "observacion", length = 255)
    private String observacion;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha = LocalDate.now();

    @Column(name = "escrito", nullable = false)
    private boolean escrito;

    @Column(name = "tiempo_en_minutos", nullable = false)
    private int tiempoEnMinutos;

    @ManyToMany
    @JoinTable(
        name = "daily_trabajador",
        joinColumns = @JoinColumn(name = "daily_id"),
        inverseJoinColumns = @JoinColumn(name = "trabajador_id")
    )
    private List<Trabajador> trabajadores;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isEscrito() {
        return escrito;
    }
    

    public void setEscrito(boolean escrito) {
        this.escrito = escrito;
    }

    public int getTiempoEnMinutos() {
        return tiempoEnMinutos;
    }

    public void setTiempoEnMinutos(int tiempoEnMinutos) {
        this.tiempoEnMinutos = tiempoEnMinutos;
    }

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }
}
