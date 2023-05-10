package juegoComputadora;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.script.ScriptException;

public class Main {

	public static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) throws ScriptException, IOException {

		// Menu.menuInicial();

		// Preguntas Mates

		ArrayList<Integer> nums = Mates.generaNum();
		ArrayList<String> operac = Mates.generaOperac(nums);
		System.out.println(Mates.preguntaCompleta(nums, operac));

		// Preguntas Letras
		/*
		 * Letras.muestraPalabra();
		 */

		// Preguntas Ingles
		//System.out.println("Respuesta: " + Ingles.enunciado());
	}

}
