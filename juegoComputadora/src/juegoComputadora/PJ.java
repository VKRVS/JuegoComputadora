package juegoComputadora;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class PJ extends Jugador {
	static File rankingFichero = new File("ranking.txt");
	static Scanner entrada = new Scanner(System.in);
	private int puntos;
	private String nombre;

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public PJ(String nombre) {
		super();
		boolean correcto = false;
		while (!correcto) {
			System.out.println("Introduce un nombre de jugador (el nombre no puede contener espacios)");
			this.nombre = entrada.next();
			if ((this.nombre.contains(" ")) || (this.nombre.isEmpty())) {
				System.err.println("Nombre en formato incorrecto");
			} else {
				correcto = true;
			}

		}
		this.nombre = nombre;
		this.puntos = 0;
	}

	public PJ(String nombre, int puntos) {
		super();
		this.nombre = nombre;
		this.puntos = 0;
	}
/*
	public static void compruebaCreaFichero() {
		try {
			if (rankingFichero.createNewFile()) {
				System.out.println("Se ha creado correctamente el fichero Ranking");
			} else {
				System.out.println("Se ha cargado correctamente el fichero Ranking");
			}
			System.out.println("Fichero localizado en: " + rankingFichero.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Ocurrió un error con el fichero Ranking");
			e.printStackTrace();
		}
	}

	public static void compruebaCreaJugador() {
		try {
			Scanner lector = new Scanner(rankingFichero);
			lector.close();

		} catch (FileNotFoundException e) {
			System.err.println("Ocurrió un error con el fichero Ranking");
			e.printStackTrace();
		}

	}

	public static void verJugadores() {
		try {
			Scanner lector = new Scanner(rankingFichero);
			System.out.println("\nJugadores registrados en el sistema:");
			boolean lineaImpar = true;
			while (lector.hasNext()) {
				if (lineaImpar) {
					System.out.println(lector.nextLine());
					lineaImpar = false;
				} else {
					lector.nextLine();
					lineaImpar = true;
				}
			}
			lector.close();

		} catch (FileNotFoundException e) {
			System.err.println("Ocurrió un error con el fichero Ranking");
			e.printStackTrace();
		}

	}

	public static int tamanyoFichero() throws FileNotFoundException {
		Scanner lector = new Scanner(rankingFichero);
		int lineas = 0;
		while (lector.hasNext()) {
			lector.nextLine();
			lineas++;
		}
		lector.close();
		return lineas;
	}

	// Busca la línea en la que se encuentra un jugador en el Ranking y devuelve el
	// valor de la línea. Devuelve 0 si no lo encuentra
	public static int buscarCoincidencia(String jugador) throws FileNotFoundException {
		Scanner lector = new Scanner(rankingFichero);
		int contador = 0;
		int coincidencia = 0;
		while (lector.hasNext()) {
			contador++;
			if (lector.nextLine().equalsIgnoreCase(jugador)) {
				coincidencia = contador;
				lector.close();
				return coincidencia;
			}
		}
		lector.close();
		return coincidencia;
	}

	public static void anadirPuntos(String jugador, int puntos) throws IOException {
		Scanner lector = new Scanner(rankingFichero);
		int contador = 0;
		int coincidencia=0;
		int puntosEnFichero = 0;
		boolean encontrado = false;
		ArrayList supletorio=new ArrayList();
		while (lector.hasNext()) {
			supletorio.add(lector.nextLine());
			supletorio.add(lector.nextLine());
		}
		lector.close();
		coincidencia=supletorio.indexOf(jugador);
		puntosEnFichero=Integer.parseInt((String) supletorio.get((coincidencia+1)));
		supletorio.set((coincidencia+1), (puntosEnFichero+puntos));
		FileWriter escritor = new FileWriter("ranking.txt");
		for (int i=0;i<supletorio.size();i++) {
			escritor.write((supletorio.get(i)).toString());
			if ((i!=supletorio.size()-1)) {
				escritor.write("\n");
			}
		}escritor.close();
		ordenarRanking();
		

	}

	public static void eliminaJugador() throws IOException {
		Scanner lector = new Scanner(rankingFichero);
		// FileWriter escritor = new FileWriter(rankingFichero);
		System.out.println("Introduce el nombre del Jugador que deseas eliminar del sistema");
		String jugador = entrada.nextLine();
		boolean encontrado = false;
		int contador = 0;
		int coincidencia = 0;
		LinkedHashMap<String, String> supletorio = new LinkedHashMap<String, String>();
		while (lector.hasNext()) {
			contador++;
			if (lector.nextLine().equalsIgnoreCase(jugador)) {
				encontrado = true;
				coincidencia = contador;
			}
		}
		lector.close();
		System.out.println("Encontrado en la línea: " + coincidencia);
		System.out.println("El fichero tiene: " + contador);
		if (encontrado) {
			Scanner lector1 = new Scanner(rankingFichero);
			System.out.println("Entra");
			for (int i = 0; i < (contador / 2); i++) {
				if (i != Math.ceil(coincidencia / 2)) {
					System.out.println("Vuelta: " + i);
					supletorio.put(lector1.nextLine(), lector1.nextLine());
				} else {
					lector1.nextLine();
					lector1.nextLine();
				}
			}
			lector1.close();
			System.out.println(supletorio);
			FileWriter escritor = new FileWriter("ranking.txt");
			Set set = supletorio.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				Map.Entry mapEntry = (Map.Entry) iterator.next();
				System.out.println(mapEntry.getKey());
				System.out.println(mapEntry.getValue());
				escritor.write((String) mapEntry.getKey());
				escritor.write("\n");
				escritor.write((String) mapEntry.getValue());
				if (iterator.hasNext()) {
					escritor.write("\n");
				}
			}

			escritor.close();
		} else {
			System.out.println("No hay coincidencia con ningún Jugador en el sistema");

		}
	}

	public static void anadirJugador() throws IOException {
		Scanner lector = new Scanner(rankingFichero);
		// FileWriter escritor = new FileWriter(rankingFichero);
		System.out.println("Introduce el nombre del Jugador que deseas añadir al sistema");
		String jugador = entrada.next();
		boolean encontrado = false;
		while (lector.hasNext()) {
			if (lector.nextLine().equalsIgnoreCase(jugador)) {
				encontrado = true;
				System.out.println("El jugador ya existe en el sistema");
			}
		}
		lector.close();
		if (!encontrado) {
			FileWriter escritor = new FileWriter("ranking.txt", true);
			escritor.write("\n");
			escritor.write(jugador);
			escritor.write("\n");
			escritor.write("0");
			escritor.close();
			System.out.println("El jugador " + jugador + " se añadió satisfactoriamente");
		}

	}

	public static void verRanking() {
		try {
			Scanner lector = new Scanner(rankingFichero);
			while (lector.hasNext()) {
				System.out.println(lector.nextLine());
			}
			lector.close();

		} catch (FileNotFoundException e) {
			System.err.println("Ocurrió un error con el fichero Ranking");
			e.printStackTrace();
		}

	}

	public static void ordenarRanking() throws IOException {
		Scanner lector = new Scanner(rankingFichero);
		LinkedHashMap<String, Integer> supletorio = new LinkedHashMap<String, Integer>();
		while (lector.hasNext()) {
			supletorio.put(lector.nextLine(), Integer.valueOf(lector.nextLine()));
		}
		lector.close();
		List<Map.Entry<String, Integer>> ordenado = new ArrayList<>(supletorio.entrySet());
		Collections.sort(ordenado, (new Comparator<Map.Entry<String, Integer>>() {
			// Comparing two entries by value
			public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {

				// Subtracting the entries
				return entry1.getValue() - entry2.getValue();
			}
		}).reversed());
		System.out.println(ordenado);
		System.out.println(ordenado.size());

		FileWriter escritor = new FileWriter("ranking.txt");
		Iterator iterator = ordenado.iterator();
		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			//System.out.println("clave: " + mapEntry.getKey());
			//System.out.println("valor: " + mapEntry.getValue());
			escritor.write((String) mapEntry.getKey());
			escritor.write("\n");
			escritor.write(mapEntry.getValue().toString());
			if (iterator.hasNext()) {
				escritor.write("\n");
			}
		}
		escritor.close();

	}
	*/
}
