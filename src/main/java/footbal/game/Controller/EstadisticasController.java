package footbal.game.Controller;

import footbal.game.Entidades.EstadisticaJugador;
import footbal.game.Repositorio.EstadisticasRepository;
import footbal.game.Repositorio.JugadorRepository;
import footbal.game.Repositorio.PartidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticasController {
    private final EstadisticasRepository estadisticaJugadorRepository;
    private final JugadorRepository jugadorRepository;
    private final PartidoRepository partidoRepository;

    public EstadisticasController(EstadisticasRepository estadisticaJugadorRepository,
                                        JugadorRepository jugadorRepository,
                                        PartidoRepository partidoRepository) {
        this.estadisticaJugadorRepository = estadisticaJugadorRepository;
        this.jugadorRepository = jugadorRepository;
        this.partidoRepository = partidoRepository;
    }

    @GetMapping
    public List<EstadisticaJugador> getAllEstadisticas() {
        return estadisticaJugadorRepository.findAll();
    }

    @PostMapping
    public EstadisticaJugador createEstadistica(@RequestBody EstadisticaJugador estadistica) {
        jugadorRepository.findById(estadistica.getJugador().getId())
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        partidoRepository.findById(estadistica.getPartido().getId())
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));
        return estadisticaJugadorRepository.save(estadistica);
    }

    @GetMapping("/{id}")
    public EstadisticaJugador getEstadisticaById(@PathVariable Long id) {
        return estadisticaJugadorRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public EstadisticaJugador updateEstadistica(@PathVariable Long id, @RequestBody EstadisticaJugador estadisticaDetails) {
        EstadisticaJugador estadistica = estadisticaJugadorRepository.findById(id).orElseThrow();
        estadistica.setJugador(estadisticaDetails.getJugador());
        estadistica.setPartido(estadisticaDetails.getPartido());
        estadistica.setGoles(estadisticaDetails.getGoles());
        estadistica.setAsistencias(estadisticaDetails.getAsistencias());
        estadistica.setAmarillas(estadisticaDetails.getAmarillas());
        estadistica.setRojas(estadisticaDetails.getRojas());
        estadistica.setMinutosJugados(estadisticaDetails.getMinutosJugados());
        return estadisticaJugadorRepository.save(estadistica);
    }

    @DeleteMapping("/{id}")
    public void deleteEstadistica(@PathVariable Long id) {
        estadisticaJugadorRepository.deleteById(id);
    }
}
