package footbal.game.Repositorio;

import footbal.game.Entidades.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository<Partido,Long> {
}
