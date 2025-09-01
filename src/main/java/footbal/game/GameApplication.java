package footbal.game;

import footbal.game.Entidades.Jugador;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);

        Jugador jugador = new Jugador();
	}

}
