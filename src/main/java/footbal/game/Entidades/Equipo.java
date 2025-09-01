package footbal.game.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "equipos")
@Builder
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String nombre;
    public String ciudad;
    public String entrenador;
    public Integer fundacion;

    public Equipo() {
    }

    public Equipo(Long id, String nombre, String ciudad, String entrenador, Integer fundacion) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.entrenador = entrenador;
        this.fundacion = fundacion;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public Integer getFundacion() {
        return fundacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public void setFundacion(Integer fundacion) {
        this.fundacion = fundacion;
    }
}
