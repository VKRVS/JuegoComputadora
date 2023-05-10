package juegoComputadora;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Letras extends Pregunta {

	static String diccionario = "diccionario.txt";

	// Este método lee la cantidad de líneas del archivo
	public static int cantidadLineas() throws FileNotFoundException {
		File archivoLector = new File("src/juegoComputadora/" + diccionario);
		Scanner archivo = new Scanner(archivoLector);
		int lineas = 0;
		while (archivo.hasNext()) {
			archivo.next();
			lineas++;
		}
		archivo.close();
		return lineas;
	}

	// Este método devuelve una palabra aleatoria del fichero
	public static String leerPalabra() throws IOException {
		File archivoLector = new File("src/juegoComputadora/" + diccionario);
		Scanner archivo = new Scanner(archivoLector);
		int num = Extra.aleatorio(1, cantidadLineas());
		System.out.println("línea: " + num);
		String palabra = null;
		for (int i = 0; i < num; i++) {
			palabra = archivo.next();
		}
		archivo.close();
		return palabra;
	}

	// Este método da la palabra lista para mostrar y resolver
	public static String muestraPalabra() throws IOException {
		int cantidadOcultas = 3;
		String palabra = leerPalabra();
		System.out.println("La palabra es: " + palabra);
		int ocultas = palabra.length() / cantidadOcultas;
		int cantidad = 0;
		int posicion;
		System.out.println("cantidad de letras que se ocultarán: " + ocultas);
		char[] array = palabra.toCharArray();
		System.out.println(array);
		while (cantidad < ocultas) {
			posicion = Extra.aleatorio(0, (array.length - 1));
			if (array[posicion] != '*') {
				array[posicion] = '*';
				cantidad++;
			}
			System.out.println(array);
		}
		return palabra;
	}

	// Este método comprueba que hayas acertado y devuelve true si acertaste
	public static boolean comprueba(String respuesta, String correcto) {
		if (respuesta.equalsIgnoreCase(correcto)) {
			System.out.println("¡Has acertado!\nLa respuesta era: " + correcto);
			return true;
		} else {
			System.out.println("¡Has fallado!\nLa respuesta correcta era: " + correcto);
			return false;
		}
	}
}
