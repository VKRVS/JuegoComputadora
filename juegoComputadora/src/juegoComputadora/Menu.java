package juegoComputadora;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {

	public static Scanner entrada = new Scanner(System.in);

	public static void menuInicial() throws IOException {
		boolean salir = false;
		String opcion;
		while (!salir) {
			System.out.println("Elige una opcion:\n" + "	1.-Jugar Partida\n" + "	2.-Ranking\n" + "	3.-Histórico\n"
					+ "	4.-Jugadores\n" + "	5.-Salir");
			opcion = entrada.next();
			switch (opcion) {
			case "1": {
				System.out.println("\nJugar Partida");
				menuJugarPartida();
				break;
			}
			case "2": {
				System.out.println("\nRanking");
				PJ.verRanking();
				break;
			}
			case "3": {
				System.out.println("\nHistórico");
				break;
			}
			case "4": {
				System.out.println("\nJugadores");
				menuJugadores();
				break;
			}
			case "5": {
				salir = true;
				System.out.println("\nSalir");
				break;
			}
			default:
				System.out.println("Introduce una opción válida");
			}
		}
	}

	public static void menuJugarPartida() throws IOException {
		boolean valido = false;
		while (!valido) {
			System.out.println("Elige tipo de partida:");
			System.out.println("	1.-Partida de práctica");
			System.out.println("	2.-Partida normal");
			String opcion = entrada.next();
			if ((opcion.equals("1")) || (opcion.equals("2"))) {
				if (opcion.equals("1")) {
					valido = true;
					Partida practica = new Partida(1, menuTipoPartida(), false);
					practica.JugarPartida();
				} else {
					int jugadores;
					int jugadoresHumanos;
					valido = true;
					boolean correcto = false;
					while (!correcto) {
						System.out.println("Introduce la cantidad de jugadores (mínimo 1, máximo 4)");
						jugadores = entrada.nextInt();
						if ((jugadores < 1) || (jugadores > 4)) {
							System.out.println("Error, introduce un valor válido");
							correcto = false;
						} else {
							

						}
					}
				}
			}
		}

	}

	public static void menuJugadores() throws IOException {
		boolean volver = false;
		String opcion;
		while (!volver) {
			System.out.println("Elige una opcion:\n" + "	1.-Ver Jugadores\n" + "	2.-Añadir Jugador\n"
					+ "	3.-Eliminar Jugador\n" + "	4.-Volver");
			opcion = entrada.next();
			switch (opcion) {
			case "1": {
				System.out.println("\nVer Jugadores");
				PJ.verJugadores();
				break;
			}
			case "2": {
				System.out.println("\nAñadir Jugador");
				PJ.anadirJugador();
				break;
			}
			case "3": {
				System.out.println("\nEliminar Jugador");
				PJ.eliminaJugador();
				break;
			}
			case "4": {
				System.out.println("\nVolver\n");
				volver = true;
				break;
			}
			default:
				System.out.println("\nIntroduce una opción válida");
			}
		}
	}

	public static int menuTipoPartida() {
		boolean valido = false;
		while (!valido) {
			System.out.println("¿Cuántas rondas quieres jugar?");
			System.out.println("	1.-Partida rápida (3 preguntas)");
			System.out.println("	2.-Partida corta (5 preguntas)");
			System.out.println("	3.-Partida normal (10 preguntas)");
			System.out.println("	4.-Partida larga (20 preguntas)");
			String opcion = entrada.next();
			switch (opcion) {
			case "1": {
				valido = true;
				return 3;
			}
			case "2": {
				valido = true;
				return 5;
			}
			case "3": {
				valido = true;
				return 10;
			}
			case "4": {
				valido = true;
				return 20;
			}
			default:
				System.out.println("Error. Por favor, introduce un valor válido");
				valido = false;
			}
		}
		return 0;
	}

}
