package juegoComputadora;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Menu {

	public static void menuInicial() throws IOException {
		boolean salir = false;
		String opcion;
		while (!salir) {
			System.out.println("Elige una opcion:\n" + "	1.-Jugar Partida\n" + "	2.-Ranking\n" + "	3.-Histórico\n"
					+ "	4.-Jugadores\n" + "	5.-Salir\n");
			opcion = Main.entrada.next();
			switch (opcion) {
			case "1": {
				System.out.println("\nJugar Partida");
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

	public static void menuJugarPartida() {
		System.out.println("¿Cuántos jugadores humanos van a participar en la partida? (elige entre 0-4)");
		String cantidad = null;
		boolean correcto = false;
		while (correcto) {
			switch (cantidad) {
			case "0": {
				ArrayList<Cpu> jugadores = new ArrayList<Cpu>();
				jugadores.add(new Cpu(0, "cpu1"));
				jugadores.add(new Cpu(0, "cpu2"));
				jugadores.add(new Cpu(0, "cpu3"));
				jugadores.add(new Cpu(0, "cpu4"));
				// return jugadores;
			}
			case "1": {

				break;
			}
			case "2": {

				break;
			}
			case "3": {

				break;
			}
			case "4": {

				break;
			}
			default:
				System.out.println("Introduce un valor comprendido entre 0 y 4, por favor");
			}
		}
	}

	public static void menuJugadores() throws IOException {
		boolean volver = false;
		String opcion;
		while (!volver) {
			System.out.println("Elige una opcion:\n" + "	1.-Ver Jugadores\n" + "	2.-Añadir Jugador\n"
					+ "	3.-Eliminar Jugador\n" + "	4.-Volver");
			opcion = Main.entrada.next();
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
}
