//Proyecto grupal
//Juan Pablo Porras Alvarado C36086, Dennis Josue Bustos Soto C31381, Axel Obando Bermudez c25595

public class Ficha {

	// Atributos
	private String color;
	private String nombre;
	// ---------------------------------------------------------------------------------------------------

	// Metodo Constructor
	public Ficha(String color, String nombre) {
		setColorFicha(color);
		setNombre(nombre);
	}// fin del constructor
		// ---------------------------------------------------------------------------------------------------

	// Metodos Setters
	// Set Color Ficha
	public void setColorFicha(String color) {
		this.color = color;
	}// fin del set

	// Set Nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}// fin del set

	// ---------------------------------------------------------------------------------------------------

	// Metodos Getters
	// Get Color Ficha
	public String getColorFicha() {
		return color;
	}// fin del get

	// Get Nombre
	public String getNombre() {
		return nombre;
	}// fin del get

	// ---------------------------------------------------------------------------------------------------

}// fin de la clase
