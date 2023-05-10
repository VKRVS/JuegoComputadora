package juegoComputadora;

public abstract class Extra {

	//Genera un número aleatorio entre los valores que le pases
	public static int aleatorio(int min, int max) {
		return (int) (Math.random() * ((max - min) + 1)) + min;

	}

}
