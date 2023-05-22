package juegoComputadora;

public class Partida {

	int jugadores;
	int rondas;
	boolean tipo;

	public Partida(int jugadores, int rondas, boolean tipo) {
		this.jugadores = jugadores;
		this.rondas = rondas;
		this.tipo = tipo;
	}

	public void JugarPartida() {
		if (!tipo) {
			for (int i = 0; i < rondas; i++) {
				Ejecucion();
			}
		}
	}

	public void Ejecucion() {
		switch (Extra.aleatorio(1, 1)) {
		case 1: {
			System.out.println("Pregunta de Mates");
			new Mates();
			break;
		}
		case 2: {
			System.out.println("Pregunta de Letras");
			break;
		}
		case 3: {
			System.out.println("Pregunta de Ingles");
			break;
		}

		}
	}
}
