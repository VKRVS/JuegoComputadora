package juegoComputadora;

import java.io.IOException;

public class Partida {

	int jugadores;
	int jugadoresHumanos;
	int rondas;
	// 1=practica, 2=normal
	int tipo;

	public Partida(int jugadores, int jugadoresHumanos, int rondas, int tipo) throws IOException {
		this.jugadores = jugadores;
		this.jugadoresHumanos = jugadoresHumanos;
		this.rondas = rondas;
		this.tipo = tipo;
		JugarPartida();
	}

	public void JugarPartida() throws IOException {
		if (tipo == 1) {
			for (int i = 0; i < rondas; i++) {
				System.out.println("Pregunta #" + (i + 1));
				Ejecucion();
			}
		}
		if (tipo==2) {
			
		}
		
		System.out.println();
		System.out.println("¡FIN DE LA PARTIDA!");
		System.out.println();
	}

	public void Ejecucion() throws IOException {
		switch (Extra.aleatorio(1, 3)) {
		case 1: {
			System.out.println("Categoria: Mates");
			new Mates();
			break;
		}
		case 2: {
			System.out.println("Categoria: Letras");
			new Letras();
			break;
		}
		case 3: {
			System.out.println("Categoria: Ingles");
			new Ingles();
			break;
		}

		}
	}
}
