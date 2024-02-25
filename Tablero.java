//Proyecto Grupal
//Juan Pablo Porras Alvarado C36086, Dennis Josue Bustos Soto C31381, Axel Obando Bermudez c25595

public class Tablero{
	
	//Atributos 
	private boolean realizado, ganador;
	private boolean infoJugada;
	private int posicion;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	//Referencias
	private Ficha tablero [][];
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//Metodo Constructor
	public Tablero (){
		tablero= new Ficha [6][7];
	}// fin del metodo constructor 
	//Se crea el tablero que se llenara con X u O, que representa la jugada
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//Inicializar tablero
	public void iniciarTablero (){
		realizado= false;
		
		for (int fila=0; fila<tablero.length; fila++){ // Inicio del primer bucle for
			for (int columna=0; columna<tablero[fila].length; columna++){ // Inicio del segundo bucle for
				tablero[fila][columna]=null;
			} // Fin del segundo bucle for
		} // Fin del primer bucle for
		
	} // Fin del método iniciarTablero
	// Se vacían todos los espacios al inicio de cada partida

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	//verificar movimiento
	public boolean verificarMovimiento (int fila, int columna){
		realizado=false;
		
		if (tablero[fila][columna]==null){ // Inicio del primer bloque if anidado
			
			if  (fila==5){ // Inicio del segundo bloque if anidado
			
				return realizado=true;
			
			} else if  (tablero[(fila+1)][columna]!=null){// Inicio del bloque else if
				
				return realizado=true;
				
			} // Fin del bloque else if
			
		} // Fin del primer bloque if anidado
		
		return realizado;
	} // Fin del método verificarMovimiento
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	//Realizar movimiento
	public String realizarMovimiento (int fila, int columna, Ficha jugada){
									
		tablero[fila][columna]=jugada;
		
		return null;
	} // Fin del metodo realizarMovimiento
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	//Metodo verificar ganador recursivo
	public Ficha verificarGanadorRecursivo(int fila, int columna) {
		if (fila < 6 && columna < 7) { // Inicio del bloque if externo
			if (tablero[fila][columna] != null) { // Inicio del primer bloque if anidado
				if (ganadorEnColumna(fila, columna) || ganadorFila(fila, columna) ||
					ganadorVerticalDerechaIzquierda(fila, columna) || ganadorVerticalIzquierdaDerecha(fila, columna)) { // Inicio del segundo bloque if anidado
					
					return tablero[fila][columna];
					
				} // Fin del segundo bloque if anidado
			} // Fin del primer bloque if anidado

			// Llamada recursiva para moverse a la siguiente posición en el tablero
			if (columna == 6) { // Inicio del bloque if para columna == 6
				return verificarGanadorRecursivo(fila + 1, 0);
			} else { // Inicio del bloque else
				return verificarGanadorRecursivo(fila, columna + 1);
			} // Fin del bloque else
		} // Fin del bloque if externo

		return null;
	} // Fin del método verificarGanadorRecursivo


//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
	//Metodo ganador en linea horizontal
	private boolean ganadorEnColumna (int fila, int columna){
		realizado=false;
		
		if (columna > 2){ // Inicio del bloque if externo
			if (tablero[fila][columna].getColorFicha().equals("Amarillo")){ // Inicio del bloque if para "Amarillo"
				if (tablero[fila][(columna-1)]!=null && tablero[fila][(columna-1)].getColorFicha().equals("Amarillo")){ // Inicio del primer bloque if anidado
					if (tablero[fila][(columna-2)]!=null && tablero[fila][(columna-2)].getColorFicha().equals("Amarillo")){ // Inicio del segundo bloque if anidado
						if (tablero[fila][(columna-3)]!=null && tablero[fila][(columna-3)].getColorFicha().equals("Amarillo")){ // Inicio del tercer bloque if anidado
							
							return realizado=true;
							
						} // Fin del tercer bloque if anidado
					} // Fin del segundo bloque if anidado
				} // Fin del primer bloque if anidado
				
			} else if (tablero[fila][columna].getColorFicha().equals("Rojo")){ // Inicio del bloque else if para "Rojo"
				if (tablero[fila][(columna-1)]!=null && tablero[fila][(columna-1)].getColorFicha().equals("Rojo")){ // Inicio del primer bloque if anidado
					if (tablero[fila][(columna-2)]!=null && tablero[fila][(columna-2)].getColorFicha().equals("Rojo")){ // Inicio del segundo bloque if anidado
						if (tablero[fila][(columna-3)]!=null && tablero[fila][(columna-3)].getColorFicha().equals("Rojo")){ // Inicio del tercer bloque if anidado
							
							return realizado=true;
							
						} // Fin del tercer bloque if anidado
					} // Fin del segundo bloque if anidado
				} // Fin del primer bloque if anidado
			} // Fin del bloque else if para "Rojo"
		} // Fin del bloque if externo

		return realizado;
	} // Fin del método ganadorEnColumna

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	//Metodo ganador linea vertical
	private boolean ganadorFila (int fila, int columna){
		realizado=false;
		
		if (fila > 2) { // Inicio del bloque if externo
			if (tablero[fila][columna].getColorFicha().equals("Amarillo")){ // Inicio del bloque if para "Amarillo"
				if (tablero[(fila-1)][(columna)]!=null && tablero[(fila-1)][(columna)].getColorFicha().equals("Amarillo")){ // Inicio del primer bloque if anidado
					if (tablero[(fila-2)][(columna)]!=null && tablero[(fila-2)][(columna)].getColorFicha().equals("Amarillo")){ // Inicio del segundo bloque if anidado
						if (tablero[(fila-3)][(columna)]!=null && tablero[(fila-3)][(columna)].getColorFicha().equals("Amarillo")){ // Inicio del tercer bloque if anidado
							
							return realizado=true;
							
						} // Fin del tercer bloque if anidado
					} // Fin del segundo bloque if anidado
				} // Fin del primer bloque if anidado
				
			} else if (tablero[fila][columna].getColorFicha().equals("Rojo")){ // Inicio del bloque else if para "Rojo"
				if (tablero[(fila-1)][(columna)]!=null && tablero[(fila-1)][(columna)].getColorFicha().equals("Rojo")){ // Inicio del primer bloque if anidado
					if (tablero[(fila-2)][(columna)]!=null && tablero[(fila-2)][(columna)].getColorFicha().equals("Rojo")){ // Inicio del segundo bloque if anidado
						if (tablero[(fila-3)][(columna)]!=null && tablero[(fila-3)][(columna)].getColorFicha().equals("Rojo")){ // Inicio del tercer bloque if anidado
							
							return realizado=true;
							
						} // Fin del tercer bloque if anidado
					} // Fin del segundo bloque if anidado
				} // Fin del primer bloque if anidado
			} // Fin del bloque else if para "Rojo"
		} // Fin del bloque if externo

		return realizado;
	} // Fin del método ganadorFila
	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	//~ //Metodo ganador en diagonal
	private boolean ganadorVerticalDerechaIzquierda (int fila, int columna){
    realizado=false;
    
		if (fila > 2 && columna > 2) { // Inicio del bloque if externo
			if (tablero[fila][columna].getColorFicha().equals("Amarillo")){ // Inicio del bloque if para "Amarillo"
				if (tablero[(fila-1)][(columna-1)]!=null && tablero[(fila-1)][(columna-1)].getColorFicha().equals("Amarillo")){ // Inicio del primer bloque if anidado
					if (tablero[(fila-2)][(columna-2)]!=null && tablero[(fila-2)][(columna-2)].getColorFicha().equals("Amarillo")){ // Inicio del segundo bloque if anidado
						if (tablero[(fila-3)][(columna-3)]!=null && tablero[(fila-3)][(columna-3)].getColorFicha().equals("Amarillo")){ // Inicio del tercer bloque if anidado
                        
							return realizado=true;
                        
						} // Fin del tercer bloque if anidado
					} // Fin del segundo bloque if anidado
				} // Fin del primer bloque if anidado
            
			} else if (tablero[fila][columna].getColorFicha().equals("Rojo")){ // Inicio del bloque else if para "Rojo"
				if (tablero[(fila-1)][(columna-1)]!=null && tablero[(fila-1)][(columna-1)].getColorFicha().equals("Rojo")){ // Inicio del primer bloque if anidado
					if (tablero[(fila-2)][(columna-2)]!=null && tablero[(fila-2)][(columna-2)].getColorFicha().equals("Rojo")){ // Inicio del segundo bloque if anidado
						if (tablero[(fila-3)][(columna-3)]!=null && tablero[(fila-3)][(columna-3)].getColorFicha().equals("Rojo")){ // Inicio del tercer bloque if anidado
                        
							return realizado=true;
                        
						} // Fin del tercer bloque if anidado
					} // Fin del segundo bloque if anidado
				} // Fin del primer bloque if anidado
			} // Fin del bloque else if para "Rojo"
		} // Fin del bloque if externo

		return realizado;
	} // Fin del método ganadorVerticalDerechaIzquierda

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// este metodo verifica el ganador de izquirda a derecha unicamente 
	public boolean ganadorVerticalIzquierdaDerecha (int fila, int columna){
	realizado=false;
	
		if (fila > 2 && columna < 4) { // Inicio del bloque if externo
			if (tablero[fila][columna]!=null && tablero[fila][columna].getColorFicha().equals("Amarillo")){ // Inicio del bloque if para "Amarillo"
				if (tablero[(fila-1)][(columna+1)]!=null && tablero[(fila-1)][(columna+1)].getColorFicha().equals("Amarillo")){ // Inicio del primer bloque if anidado
					if (tablero[(fila-2)][(columna+2)]!=null && tablero[(fila-2)][(columna+2)].getColorFicha().equals("Amarillo")){ // Inicio del segundo bloque if anidado
						if (tablero[(fila-3)][(columna+3)]!=null && tablero[(fila-3)][(columna+3)].getColorFicha().equals("Amarillo")){ // Inicio del tercer bloque if anidado
						
							return realizado=true;
						
						} // Fin del tercer bloque if anidado
					} // Fin del segundo bloque if anidado
				} // Fin del primer bloque if anidado
			
			} else if (tablero[fila][columna].getColorFicha().equals("Rojo")){ // Inicio del bloque else if para "Rojo"
				if (tablero[(fila-1)][(columna+1)]!=null && tablero[(fila-1)][(columna+1)].getColorFicha().equals("Rojo")){ // Inicio del primer bloque if anidado
					if (tablero[(fila-2)][(columna+2)]!=null && tablero[(fila-2)][(columna+2)].getColorFicha().equals("Rojo")){ // Inicio del segundo bloque if anidado
						if (tablero[(fila-3)][(columna+3)]!=null && tablero[(fila-3)][(columna+3)].getColorFicha().equals("Rojo")){ // Inicio del tercer bloque if anidado
						
							return realizado=true;
						
						} // Fin del tercer bloque if anidado
					} // Fin del segundo bloque if anidado
				} // Fin del primer bloque if anidado
			} // Fin del bloque else if para "Rojo"
		} // Fin del bloque if externo

		return realizado;
	} // Fin del método ganadorVerticalIzquierdaDerecha

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}// fin class 
