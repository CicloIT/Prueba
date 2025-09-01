package footbal.game.Entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estadisticas_jugador")
@Builder
public class EstadisticaJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jugador_id", nullable = false)
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "partido_id", nullable = false)
    private Partido partido;

    private Integer goles = 0;
    private Integer asistencias = 0;
    private Integer amarillas = 0;
    private Integer rojas = 0;
    private Integer minutosJugados = 0;

    public EstadisticaJugador() {
    }

    public EstadisticaJugador(Long id, Jugador jugador, Partido partido, Integer goles, Integer asistencias, Integer amarillas, Integer rojas, Integer minutosJugados) {
        this.id = id;
        this.jugador = jugador;
        this.partido = partido;
        this.goles = goles;
        this.asistencias = asistencias;
        this.amarillas = amarillas;
        this.rojas = rojas;
        this.minutosJugados = minutosJugados;
    }

    public Long getId() {
        return id;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Partido getPartido() {
        return partido;
    }

    public Integer getGoles() {
        return goles;
    }

    public Integer getAsistencias() {
        return asistencias;
    }

    public Integer getAmarillas() {
        return amarillas;
    }

    public Integer getRojas() {
        return rojas;
    }

    public Integer getMinutosJugados() {
        return minutosJugados;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public void setGoles(Integer goles) {
        this.goles = goles;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }

    public void setAmarillas(Integer amarillas) {
        this.amarillas = amarillas;
    }

    public void setRojas(Integer rojas) {
        this.rojas = rojas;
    }

    public void setMinutosJugados(Integer minutosJugados) {
        this.minutosJugados = minutosJugados;
    }
}
