//Proyecto grupal

public class Ficha {

	//Atributos
	private String color;
	private String nombre;
	//---------------------------------------------------------------------------------------------------
	
	//Metodo Constructor
	public Ficha(String color, String nombre){
		setColorFicha(color);
		setNombre(nombre);
	}
	//---------------------------------------------------------------------------------------------------
	
	//Metodos Setters
	//Set Color Ficha
	public void setColorFicha(String color){
		this.color=color;
	}
	
	//Set Nombre
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	//---------------------------------------------------------------------------------------------------
	
	//Metodos Getters
	//Get Color Ficha
	public String getColorFicha(){
		return color;
	}
	
	//Get Nombre
	public String getNombre(){
		return nombre;
	}
	//---------------------------------------------------------------------------------------------------

}// fin de la clase 
