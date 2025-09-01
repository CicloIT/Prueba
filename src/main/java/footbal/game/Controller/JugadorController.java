package footbal.game.Controller;

import footbal.game.Entidades.Jugador;
import footbal.game.Repositorio.EquipoRepository;
import footbal.game.Repositorio.JugadorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {
    private final JugadorRepository jugadorRepository;
    private final EquipoRepository equipoRepository;

    public JugadorController(JugadorRepository jugadorRepository, EquipoRepository equipoRepository) {
        this.jugadorRepository = jugadorRepository;
        this.equipoRepository = equipoRepository;
    }

    @GetMapping
    public List<Jugador> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    @PostMapping
    public Jugador createJugador(@RequestBody Jugador jugador) {
        // asegurar que el equipo existe
        equipoRepository.findById(jugador.getEquipo().getId())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        return jugadorRepository.save(jugador);
    }

    @GetMapping("/{id}")
    public Jugador getJugadorById(@PathVariable Long id) {
        return jugadorRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Jugador updateJugador(@PathVariable Long id, @RequestBody Jugador jugadorDetails) {
        Jugador jugador = jugadorRepository.findById(id).orElseThrow();
        jugador.setNombre(jugadorDetails.getNombre());
        jugador.setEdad(jugadorDetails.getEdad());
        jugador.setPosicion(jugadorDetails.getPosicion());
        jugador.setEquipo(jugadorDetails.getEquipo());
        return jugadorRepository.save(jugador);
    }

    @DeleteMapping("/{id}")
    public void deleteJugador(@PathVariable Long id) {
        jugadorRepository.deleteById(id);
    }
}
