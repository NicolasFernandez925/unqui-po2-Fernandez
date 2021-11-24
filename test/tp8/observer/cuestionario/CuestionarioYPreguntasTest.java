package tp8.observer.cuestionario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp8_Patrones1.observer.cuestionarioYPreguntas.Cuestionario;
import tp8_Patrones1.observer.cuestionarioYPreguntas.IJugador;
import tp8_Patrones1.observer.cuestionarioYPreguntas.Pregunta;
import tp8_Patrones1.observer.cuestionarioYPreguntas.Servidor;

class CuestionarioYPreguntasTest {
	
	Servidor server;
	Cuestionario cuestionario;
	IJugador jugador;
	Pregunta pregunta;

	@BeforeEach
	void setUp() throws Exception {
		
		cuestionario = mock(Cuestionario.class);
		pregunta = mock(Pregunta.class);
		jugador = mock(IJugador.class);
		server = new Servidor(cuestionario);
	}

	@Test
	void testJugadorRespondeUnaPreguntaIncorrectaYLoNotifica() throws Exception {
		
		String respuesta = "10";
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		
		server.nuevoParticipante(jugador);
		preguntas.add(pregunta);
		server.iniciar();
		
		when(pregunta.getNombre()).thenReturn("Cuanto es 5 + 5");
		when(cuestionario.getPreguntas()).thenReturn(preguntas);
		
		when(pregunta.getRespuesta()).thenReturn("25");
		
		server.verificarRespuesta(pregunta, respuesta, jugador);
		
		verify(jugador).preguntaIncorrecta(pregunta);
	}

}
