package juegoComputadora;

import java.io.IOException;
import java.util.ArrayList;

public class Partida {

	int jugadores;
	ArrayList<Jugador> participantes;
	int jugadoresHumanos;
	int rondas;
	// 1=practica, 2=normal
	int tipo;

	public Partida(int jugadores, int jugadoresHumanos, int rondas, int tipo) throws IOException {
		participantes = new ArrayList<Jugador>();
		this.jugadores = jugadores;
		this.jugadoresHumanos = jugadoresHumanos;
		this.rondas = rondas;
		this.tipo = tipo;
		anadirJugador();
		JugarPartida();
	}

	public void JugarPartida() throws IOException {
		// Partida práctica
		if (tipo == 1) {
			for (int i = 0; i < rondas; i++) {
				System.out.println("Pregunta #" + (i + 1));
				Ejecucion();
			}
		}
		// Partida normal
		if (tipo == 2) {
			for (int i = 0; i < jugadoresHumanos; i++) {
				System.out.println("Introduce el nombre del jugador #" + (i + 1));
				if (PJ.buscarCoincidencia(Extra.entrada.next()) != 0) {
					System.out.println("Jugador encontrado en el sistema");
				} else {
					System.out.println("El jugador no existe en el sistema. Creando jugador...");
					PJ.anadirJugador();
				}
			}

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

	//
	public void anadirJugador() {
		
	}
}
