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
		int jugadores;
		int jugadoresHumanos;
		int tipo = Extra.comprobador(1, 2,
				"Elige el tipo de partida:\n    1.-Partida de práctica\n    2.-Partida normal", null);
		switch (tipo) {
		case 1: {
			Partida practica = new Partida(1, 1, menuTipoPartida(), 1);
			break;
		}
		case 2: {
			jugadores = Extra.comprobador(1, 4,
					"Introduce la cantidad de jugadores para la partida (mínimo 1, máximo 4)",
					"Error, introduce un valor válido");
			jugadoresHumanos = Extra.comprobador(0, jugadores,
					"Introduce la cantidad de jugadores Humanos (mínimo 0, máximo" + jugadores + ")",
					"Error, introduce un valor válido");
			Partida normal = new Partida(jugadores, jugadoresHumanos, menuTipoPartida(), 2);
		}
		}

		/*
		 * boolean valido = false; while (!valido) {
		 * System.out.println("Elige tipo de partida:");
		 * System.out.println("	1.-Partida de práctica");
		 * System.out.println("	2.-Partida normal"); String opcion = entrada.next(); if
		 * ((opcion.equals("1")) || (opcion.equals("2"))) { if (opcion.equals("1")) {
		 * valido = true; Partida practica = new Partida(1, menuTipoPartida(), 1);
		 * practica.JugarPartida(); } else { int jugadoresHumanos; int
		 * jugadores=Extra.comprobador(1,
		 * 4,"Introduce la cantidad de jugadores para la partida (mínimo 1, máximo 4)"
		 * ,"Error, introduce un valor válido"); if (jugadores==1) {
		 * jugadoresHumanos=Extra.comprobador(0, 1,
		 * "¿Jugar partida como jugador humano (1) o ver partida de CPU (0)?",
		 * "Error, introduce un valor válido"); } } } }
		 */
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
