package juegoComputadora;

public abstract class Menu {

	public static void menuInicial() {
		boolean correcto = false;
		while (!correcto) {
			System.out.println("Elige una opcion:\n" + "1.-Jugar Partida\n" + "2.-Ranking\n" + "3.-Histórico\n"
					+ "4.-Jugadores\n" + "5.-Salir\n");
			String opcion = Main.entrada.next();
			switch (opcion) {
			case "1": {
				correcto = true;
				System.out.println("Jugar Partida");
				break;
			}
			case "2": {
				correcto = true;
				System.out.println("Ranking");
				break;
			}
			case "3": {
				correcto = true;
				System.out.println("Histórico");
				break;
			}
			case "4": {
				correcto = true;
				System.out.println("Jugadores");
				break;
			}
			case "5": {
				correcto = true;
				System.out.println("Salir");
				break;
			}
			default:
				System.out.println("Introduce un valor válido");
			}
		}
	};

	public static void menuJugarPartida() {
		System.out.println("");
	}
	
}
