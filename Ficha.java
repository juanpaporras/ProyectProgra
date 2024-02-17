public class Ficha {

	//atributos
	private String color;
	private String nombre;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// metodo constructor
	public Ficha(String color, String nombre){
	
	setColor(color);
	setNombre(nombre);
	
	}// fin del constructor
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
	// metodo get y set de color
	public String getColorFicha(){
	
		return color;
	
	}
	
	public void setColor(String color){
	
		this.color=color;
	
	}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
	// metodo get y set de nombre
	public String getNombre(){
	
		return nombre;
	
	}
	
	public void setNombre(String nombre){
	
		this.nombre=nombre;
	
	}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	

}// fin de la clase 
