//Proyecto Grupal

public class Tablero{
	
	//Atributos 
	private boolean realizado, ganador;
	private boolean infoJugada;
	private int posicion;
    //---------------------------------------------------------------------------------------------------
	//Referencias
	private Ficha tablero [][];
	//---------------------------------------------------------------------------------------------------
	
	//Metodo Constructor
	public Tablero (){
		tablero= new Ficha [6][7];
	}
	//Se crea el tablero que se llenara con X u O, que representa la jugada
	//---------------------------------------------------------------------------------------------------

	//Inicializar tablero
	public void iniciarTablero (){
		realizado= false;
		
		for (int fila=0; fila<tablero.length; fila++){
			for (int columna=0; columna<tablero[fila].length; columna++){
				tablero[fila][columna]=null;
			}
		}
		
	}
	//Se vacían todos los espacios al inicio de cada partida
	//---------------------------------------------------------------------------------------------------
	
	//verificar movimiento
	public boolean verificarMovimiento (int fila, int columna){
		realizado=false;
		
		
		if (tablero[fila][columna]==null){
			
			if  (fila==5){
			
				return realizado=true;
			
			} else if  (tablero[(fila+1)][columna]!=null){
				
				return realizado=true;
				
			}
			
		}
		
		return realizado;
	} 
	//---------------------------------------------------------------------------------------------------
	
	//Realizar movimiento
	public String realizarMovimiento (int fila, int columna, Ficha jugada){
									
		tablero[fila][columna]=jugada;
		
		return null;
	} 
	//---------------------------------------------------------------------------------------------------
	
	//Metodo verificar un ganador
	public Ficha verificarGanadorRecursivo(int fila, int columna) {
	    if (fila < 6 && columna < 7) {
	        if (tablero[fila][columna] != null) {
	            if (ganadorEnColumna(fila, columna) || ganadorFila(fila, columna) ||
	                ganadorVerticalDerechaIzquierda(fila, columna) || ganadorVerticalIzquierdaDerecha(fila, columna)) {
	                return tablero[fila][columna];
	            }
	        }
	
	        // Llamada recursiva para moverse a la siguiente posición en el tablero
	        if (columna == 6) {
	            return verificarGanadorRecursivo(fila + 1, 0);
	        } else {
	            return verificarGanadorRecursivo(fila, columna + 1);
	        }
	    }
	
	    return null;
	}

	//---------------------------------------------------------------------------------------------------
	
	//Metodo ganador en linea horizontal
	private boolean ganadorEnColumna (int fila, int columna){
		realizado=false;
		
		if (columna > 2){
			if (tablero[fila][columna].getColorFicha().equals("Amarillo")){
				if (tablero[fila][(columna-1)]!=null && tablero[fila][(columna-1)].getColorFicha().equals("Amarillo")){
					if (tablero[fila][(columna-2)]!=null && tablero[fila][(columna-2)].getColorFicha().equals("Amarillo")){
						if (tablero[fila][(columna-3)]!=null && tablero[fila][(columna-3)].getColorFicha().equals("Amarillo")){
							
							return realizado=true;
							
						}
					}
				}
				
			} else if (tablero[fila][columna].getColorFicha().equals("Rojo")){
				if (tablero[fila][(columna-1)]!=null && tablero[fila][(columna-1)].getColorFicha().equals("Rojo")){
					if (tablero[fila][(columna-2)]!=null && tablero[fila][(columna-2)].getColorFicha().equals("Rojo")){
						if (tablero[fila][(columna-3)]!=null && tablero[fila][(columna-3)].getColorFicha().equals("Rojo")){
							
							return realizado=true;
							
						}
					}
				}
			}
		}

		
		
		return realizado;
	}
	//---------------------------------------------------------------------------------------------------
	
	//Metodo ganador linea vertical
	private boolean ganadorFila (int fila, int columna){
		realizado=false;
		
		if (fila > 2) {
			if (tablero[fila][columna].getColorFicha().equals("Amarillo")){
				if (tablero[(fila-1)][(columna)]!=null && tablero[(fila-1)][(columna)].getColorFicha().equals("Amarillo")){
					if (tablero[(fila-2)][(columna)]!=null && tablero[(fila-2)][(columna)].getColorFicha().equals("Amarillo")){
						if (tablero[(fila-3)][(columna)]!=null && tablero[(fila-3)][(columna)].getColorFicha().equals("Amarillo")){
	
							return realizado=true;
							
						}
					}
				}
				
			} else if (tablero[fila][columna].getColorFicha().equals("Rojo")){
				if (tablero[(fila-1)][(columna)]!=null && tablero[(fila-1)][(columna)].getColorFicha().equals("Rojo")){
					if (tablero[(fila-2)][(columna)]!=null && tablero[(fila-2)][(columna)].getColorFicha().equals("Rojo")){
						if (tablero[(fila-3)][(columna)]!=null && tablero[(fila-3)][(columna)].getColorFicha().equals("Rojo")){
							
							return realizado=true;
							
						}
					}
				}
			}
		}
		
		return realizado;
	}
	//---------------------------------------------------------------------------------------------------
	
	//~ //Metodo ganador en diagonal
	private boolean ganadorVerticalDerechaIzquierda (int fila, int columna){
		realizado=false;
		
		if (fila > 2 && columna > 2) {
			if (tablero[fila][columna].getColorFicha().equals("Amarillo")){
				if (tablero[(fila-1)][(columna-1)]!=null && tablero[(fila-1)][(columna-1)].getColorFicha().equals("Amarillo")){
					if (tablero[(fila-2)][(columna-2)]!=null && tablero[(fila-2)][(columna-2)].getColorFicha().equals("Amarillo")){
						if (tablero[(fila-3)][(columna-3)]!=null && tablero[(fila-3)][(columna-3)].getColorFicha().equals("Amarillo")){
							
							return realizado=true;
							
						}
					}
				}
				
			} else if (tablero[fila][columna].getColorFicha().equals("Rojo")){
				if (tablero[(fila-1)][(columna-1)]!=null && tablero[(fila-1)][(columna-1)].getColorFicha().equals("Rojo")){
					if (tablero[(fila-2)][(columna-2)]!=null && tablero[(fila-2)][(columna-2)].getColorFicha().equals("Rojo")){
						if (tablero[(fila-3)][(columna-3)]!=null && tablero[(fila-3)][(columna-3)].getColorFicha().equals("Rojo")){
							
							return realizado=true;
							
						}
					}
				}
			}
		}

		return realizado;
	}
	
	public boolean ganadorVerticalIzquierdaDerecha (int fila, int columna){
		realizado=false;
		
		if (fila > 2 && columna < 4) {
			if (tablero[fila][columna]!=null && tablero[fila][columna].getColorFicha().equals("Amarillo")){
				if (tablero[(fila-1)][(columna+1)]!=null && tablero[(fila-1)][(columna+1)].getColorFicha().equals("Amarillo")){
					if (tablero[(fila-2)][(columna+2)]!=null && tablero[(fila-2)][(columna+2)].getColorFicha().equals("Amarillo")){
						if (tablero[(fila-3)][(columna+3)]!=null && tablero[(fila-3)][(columna+3)].getColorFicha().equals("Amarillo")){
							
							return realizado=true;
							
						}
					}
				}
				
			} else if (tablero[fila][columna].getColorFicha().equals("Rojo")){
				if (tablero[(fila-1)][(columna+1)]!=null && tablero[(fila-1)][(columna+1)].getColorFicha().equals("Rojo")){
					if (tablero[(fila-2)][(columna+2)]!=null && tablero[(fila-2)][(columna+2)].getColorFicha().equals("Rojo")){
						if (tablero[(fila-3)][(columna+3)]!=null && tablero[(fila-3)][(columna+3)].getColorFicha().equals("Rojo")){
							
							return realizado=true; 
							
						}
					}
				}
			}
		}
		return realizado;
	}
	
}
