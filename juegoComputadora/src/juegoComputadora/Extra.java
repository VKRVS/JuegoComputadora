package juegoComputadora;

import java.util.Scanner;

public abstract class Extra {

	public static Scanner entrada = new Scanner(System.in);

	// Genera un número aleatorio entre los valores que le pases
	public static int aleatorio(int min, int max) {
		return (int) (Math.random() * ((max - min) + 1)) + min;

	}

	public static int comprobador(int min, int max, String mensajeEntrada, String mensajeMal) {
		boolean correcto = false;
		String entradaValor = ""; 
		while (!correcto) {
			System.out.println(mensajeEntrada);
			entradaValor = entrada.next();
			if ((Integer.valueOf(entradaValor) >= min) || (Integer.valueOf(entradaValor) <= max)) {
				correcto = true;
				return Integer.valueOf(entradaValor);
			} else {
				System.out.println(mensajeMal);
				correcto = false;
			}
		}
		return Integer.valueOf(entradaValor);
	}

}
