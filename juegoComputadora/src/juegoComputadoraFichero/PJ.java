package juegoComputadoraFichero;

public class PJ extends Jugador {
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
			this.nombre = Extra.entrada.next();
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
}
