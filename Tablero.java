//Proyecto Grupal

public class Tablero{
	
	//Atributos 
	private boolean realizado;
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
	public boolean iniciarTablero (){
		realizado= false;
		
		for (int fila=0; fila<tablero.length; fila++){
			for (int columna=0; columna<tablero[fila].length; columna++){
				tablero[fila][columna]=null;
				realizado=true;
			}
		}
		return realizado;
	}
	//Se vacían todos los espacios al inicio de cada partida
	//---------------------------------------------------------------------------------------------------
	
	//Realizar movimiento
	public int realizarMovimiento (int columna, Ficha jugada){
		
		//Fila 0 para verificar si la columna esta llena
		if (tablero[0][columna]!=null){
			posicion= -1;			
		} else {
			for (int fila=1; fila<tablero.length; fila++){
				if (tablero[fila][columna]!=null){
					tablero[(fila-1)][columna]=jugada;
					posicion=(fila-1);
				} 
			}
		}
		return posicion;
	}
	//Recibe la columna donde quiere hacer la jugada, el tipo de jugada y la ficha cae donde hay una fila
	//ocupada(ejem. fila 6 jugada X) y lo guarda fila anterior(fila 5= nueva jugada O).
	//Retorna la posicion en la que se va a mostrar la jugada
	//Si retorna un -1 uno es porque la columna no va a estar disponible
	//---------------------------------------------------------------------------------------------------
	
	//Metodo verificar un ganador
	public Ficha verificarGanador (){
		
		for (int fila=6; fila>=3; fila--){
			for (int columna=7; columna>=3; columna--){
				if (tablero[fila][columna]!=null){
					if (ganadorEnColumna(fila, columna)==true || ganadorFila(fila, columna)==true || ganadorVerticalDerechaIzquierda(fila, columna)==true || ganadorVerticalIzquierdaDerecha(fila, columna)==true){  
						
						return tablero[fila][columna];
						
					}
				}
			}
		}
		return null;
	}
	//---------------------------------------------------------------------------------------------------
	
	//Metodo ganador en linea horizontal
	private boolean ganadorEnColumna (int fila, int columna){
		if (tablero[fila][columna].getColorFicha().equals("azul")){
			if (tablero[fila][(columna-1)]!=null && tablero[fila][(columna-1)].getColorFicha().equals("azul")){
				if (tablero[fila][(columna-2)]!=null && tablero[fila][(columna-2)].getColorFicha().equals("azul")){
					if (tablero[fila][(columna-3)]!=null && tablero[fila][(columna-3)].getColorFicha().equals("azul")){
						
						return realizado=true;
						
					}
				}
			}
			
		} else if (tablero[fila][columna].getColorFicha().equals("rojo")){
			if (tablero[fila][(columna-1)]!=null && tablero[fila][(columna-1)].getColorFicha().equals("rojo")){
				if (tablero[fila][(columna-2)]!=null && tablero[fila][(columna-2)].getColorFicha().equals("rojo")){
					if (tablero[fila][(columna-3)]!=null && tablero[fila][(columna-3)].getColorFicha().equals("rojo")){
						
						return realizado=true;
						
					}
				}
			}
		}

		
		
		return realizado;
	}
	//---------------------------------------------------------------------------------------------------
	
	//Metodo ganador linea vertical
	private boolean ganadorFila (int fila, int columna){
				
		if (tablero[fila][columna].getColorFicha().equals("azul")){
			if (tablero[(fila-1)][(columna)]!=null && tablero[(fila-1)][(columna)].getColorFicha().equals("azul")){
				if (tablero[(fila-2)][(columna)]!=null && tablero[(fila-2)][(columna)].getColorFicha().equals("azul")){
					if (tablero[(fila-3)][(columna)]!=null && tablero[(fila-3)][(columna)].getColorFicha().equals("azul")){

						return realizado=true;
						
					}
				}
			}
			
		} else if (tablero[fila][columna].getColorFicha().equals("rojo")){
			if (tablero[(fila-1)][(columna)]!=null && tablero[(fila-1)][(columna)].getColorFicha().equals("rojo")){
				if (tablero[(fila-2)][(columna)]!=null && tablero[(fila-2)][(columna)].getColorFicha().equals("rojo")){
					if (tablero[(fila-3)][(columna)]!=null && tablero[(fila-3)][(columna)].getColorFicha().equals("rojo")){
						
						return realizado=true;
						
					}
				}
			}
		}
		
		return realizado;
	}
	//---------------------------------------------------------------------------------------------------
	
	//Metodo ganador en diagonal
	private boolean ganadorVerticalDerechaIzquierda (int fila, int columna){
		realizado=false;
		
		if (tablero[fila][columna].getColorFicha().equals("azul")){
			if (tablero[(fila-1)][(columna-1)]!=null && tablero[(fila-1)][(columna-1)].getColorFicha().equals("azul")){
				if (tablero[(fila-2)][(columna-2)]!=null && tablero[(fila-2)][(columna-2)].getColorFicha().equals("azul")){
					if (tablero[(fila-3)][(columna-3)]!=null && tablero[(fila-3)][(columna-3)].getColorFicha().equals("azul")){
						
						return realizado=true;
						
					}
				}
			}
			
		} else if (tablero[fila][columna].getColorFicha().equals("rojo")){
			if (tablero[(fila-1)][(columna-1)]!=null && tablero[(fila-1)][(columna-1)].getColorFicha().equals("rojo")){
				if (tablero[(fila-2)][(columna-2)]!=null && tablero[(fila-2)][(columna-2)].getColorFicha().equals("rojo")){
					if (tablero[(fila-3)][(columna-3)]!=null && tablero[(fila-3)][(columna-3)].getColorFicha().equals("rojo")){
						
						return realizado=true;
						
					}
				}
			}
		}

		return realizado;
	}
	
	public boolean ganadorVerticalIzquierdaDerecha (int fila, int columna){
		realizado=false;
		
		if (tablero[fila][columna]!=null && tablero[fila][columna].getColorFicha().equals("azul")){
			if (tablero[(fila+1)][(columna+1)]!=null && tablero[(fila-1)][(columna-1)].getColorFicha().equals("azul")){
				if (tablero[(fila+2)][(columna+2)]!=null && tablero[(fila-2)][(columna-2)].getColorFicha().equals("azul")){
					if (tablero[(fila+3)][(columna+3)]!=null && tablero[(fila-3)][(columna-3)].getColorFicha().equals("azul")){
						
						return realizado=true;
						
					}
				}
			}
			
		} else if (tablero[fila][columna].getColorFicha().equals("rojo")){
			if (tablero[(fila+1)][(columna+1)]!=null && tablero[(fila+1)][(columna+1)].getColorFicha().equals("rojo")){
				if (tablero[(fila+2)][(columna+2)]!=null && tablero[(fila+2)][(columna+2)].getColorFicha().equals("rojo")){
					if (tablero[(fila+3)][(columna+3)]!=null && tablero[(fila+3)][(columna+3)].getColorFicha().equals("rojo")){
						
						return realizado=true; 
						
					}
				}
			}
		}
		
		return realizado;
	}
	
}
