package footbal.game.Entidades;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "partidos")
@Builder
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipo_local", nullable = false)
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante", nullable = false)
    private Equipo equipoVisitante;

    private LocalDateTime fecha;
    private Integer marcadorLocal = 0;
    private Integer marcadorVisitante = 0;

    public Partido() {
    }

    public Partido(Long id, Equipo equipoLocal, Equipo equipoVisitante, LocalDateTime fecha, Integer marcadorLocal, Integer marcadorVisitante) {
        this.id = id;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.marcadorLocal = marcadorLocal;
        this.marcadorVisitante = marcadorVisitante;
    }

    public Long getId() {
        return id;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Integer getMarcadorLocal() {
        return marcadorLocal;
    }

    public Integer getMarcadorVisitante() {
        return marcadorVisitante;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setMarcadorLocal(Integer marcadorLocal) {
        this.marcadorLocal = marcadorLocal;
    }

    public void setMarcadorVisitante(Integer marcadorVisitante) {
        this.marcadorVisitante = marcadorVisitante;
    }
}