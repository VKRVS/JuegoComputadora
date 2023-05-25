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
		if ((jugadores - jugadoresHumanos) > 0) {
			anadirJugadorCPU();
		}
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
				String nombre;
				System.out.println("Introduce el nombre del jugador #" + (i + 1));
				nombre = Extra.entrada.next();
				if (Ficheros.buscarCoincidencia(nombre) != 0) {
					System.out.println("Jugador encontrado en el sistema");
					participantes.add(new PJ(nombre, 0));
				} else {
					System.out.println("El jugador no existe en el sistema. Creando jugador...");
					Ficheros.anadirJugador();
				}
			}
			System.out.println("Comienza el juego:");
			for (int i = 0; i < (rondas); i++) {
				for (int j = 0; j < participantes.size(); j++) {
					System.out.println();
					System.out.println();
					System.out.println("Pregunta para " + participantes.get(j).getNombre());
					if (Ejecucion()) {
						participantes.get(j).setPuntos((participantes.get(j).getPuntos())+1);
						System.out.println("El jugador "+participantes.get(j).getNombre());
						System.out.println("Tiene "+participantes.get(j).getPuntos()+ " puntos");
					}
				}
			}

		}
		for (int i=0;i<participantes.size();i++) {
			Ficheros.anadirPuntos(participantes.get(i).getNombre(), participantes.get(i).getPuntos());
		}
		Ficheros.partidaAlHistorico(participantes);
		System.out.println();
		System.out.println("¡FIN DE LA PARTIDA!");
		System.out.println();
	}

	public boolean Ejecucion() throws IOException {
		switch (Extra.aleatorio(1, 3)) {
		case 1: {
			System.out.println("Categoria: Mates");
			System.out.println();
			return (new Mates().acertada);

		}
		case 2: {
			System.out.println("Categoria: Letras");
			System.out.println();
			return (new Letras().acertada);
		}
		case 3: {
			System.out.println("Categoria: Ingles");
			System.out.println();
			return (new Ingles().acertada);
		}
		}
		return false;
	}

	//
	public void anadirJugadorCPU() {
		for (int i = 0; i < (jugadores - jugadoresHumanos); i++) {
			participantes.add(new Cpu(0, ("Cpu" + (i + 1))));
		}
	}
}
