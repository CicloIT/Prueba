package footbal.game.Controller;

import footbal.game.Entidades.Equipo;
import footbal.game.Repositorio.EquipoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/equipo")
public class EquipoController {
    private final EquipoRepository equipoRepository;

    public EquipoController(EquipoRepository equipoRepository){
        this.equipoRepository=equipoRepository;
    }

    @GetMapping
    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    @PostMapping
    public Equipo createEquipo(@RequestBody Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @GetMapping("/{id}")
    public Equipo getEquipoById(@PathVariable Long id) {
        return equipoRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Equipo updateEquipo(@PathVariable Long id, @RequestBody Equipo equipoDetails) {
        Equipo equipo = equipoRepository.findById(id).orElseThrow();
        equipo.setNombre(equipoDetails.getNombre());
        equipo.setCiudad(equipoDetails.getCiudad());
        equipo.setEntrenador(equipoDetails.getEntrenador());
        equipo.setFundacion(equipoDetails.getFundacion());
        return equipoRepository.save(equipo);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable Long id) {
        equipoRepository.deleteById(id);
    }

}
