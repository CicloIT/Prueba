package footbal.game.Repositorio;

import footbal.game.Entidades.EstadisticaJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticasRepository extends JpaRepository<EstadisticaJugador,Long> {
}
