package footbal.game.Controller;

import footbal.game.Entidades.Partido;
import footbal.game.Repositorio.EquipoRepository;
import footbal.game.Repositorio.PartidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    private final PartidoRepository partidoRepository;
    private final EquipoRepository equipoRepository;

    public PartidoController(PartidoRepository partidoRepository, EquipoRepository equipoRepository) {
        this.partidoRepository = partidoRepository;
        this.equipoRepository = equipoRepository;
    }

    @GetMapping
    public List<Partido> getAllPartidos() {
        return partidoRepository.findAll();
    }

    @PostMapping
    public Partido createPartido(@RequestBody Partido partido) {
        // verificar que los equipos existen
        equipoRepository.findById(partido.getEquipoLocal().getId())
                .orElseThrow(() -> new RuntimeException("Equipo local no encontrado"));
        equipoRepository.findById(partido.getEquipoVisitante().getId())
                .orElseThrow(() -> new RuntimeException("Equipo visitante no encontrado"));
        return partidoRepository.save(partido);
    }

    @GetMapping("/{id}")
    public Partido getPartidoById(@PathVariable Long id) {
        return partidoRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Partido updatePartido(@PathVariable Long id, @RequestBody Partido partidoDetails) {
        Partido partido = partidoRepository.findById(id).orElseThrow();
        partido.setEquipoLocal(partidoDetails.getEquipoLocal());
        partido.setEquipoVisitante(partidoDetails.getEquipoVisitante());
        partido.setFecha(partidoDetails.getFecha());
        partido.setMarcadorLocal(partidoDetails.getMarcadorLocal());
        partido.setMarcadorVisitante(partidoDetails.getMarcadorVisitante());
        return partidoRepository.save(partido);
    }

    @DeleteMapping("/{id}")
    public void deletePartido(@PathVariable Long id) {
        partidoRepository.deleteById(id);
    }
}
