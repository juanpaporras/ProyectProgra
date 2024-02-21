import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class InterfazJuego extends JFrame {
    
    //Atributos Swing
    private JButton jbPause, jbSalirJogo, jbGuardarJugador,jbReiniciarJuego;
    private JComboBox jcIzquierda, jcDerecha;
    private JTextField jtComputadorGanadas, jtJugadorGanadas, jtNombreJugador, jtTotalPartidas;
    private JLabel jlComputadorInfo, jlJugadorInfo, jlJugadorGanadas, jlComputadorGanadas, jlNombreJugador,jlJugador1,jlJugador2;
    private JLabel jlTotalPartidas;
    //--------------------------------------------------------------------------------------------------- 
    
    //Atributos
    private String personasIzquierda[] = {"Computador","Persona"};
    private String personasDerecha[]={"Persona","Computador"};
    private int tamanoBoton= 60;
    private int espacioEntreBotones= 5;
    private boolean turnoJugador1= true; //Indica si es el turno del jugador 1
    //---------------------------------------------------------------------------------------------------
    
    //Referencias
    private Tablero tablero;
	private Ficha jugador, computadora;
	//---------------------------------------------------------------------------------------------------
	
	//Metodo Constructor
    public InterfazJuego() {
        //Se define el JFrame y sus caracteristicas
        super("Menu juego");
        setSize(1000, 575); 
        setLayout(null);
        getContentPane().setBackground(new Color(127, 127, 127));
		//-----------------------------------------------------------------------------------------------
		
        //Cuadrícula 1
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                JButton boton = new JButton("(" + fila + "," + columna + ")");
                boton.addActionListener(new ManejadorBoton());
                
                // Calcular las coordenadas para cada botón
                int x = columna * (tamanoBoton + espacioEntreBotones) + 275;
                int y = fila * (tamanoBoton + espacioEntreBotones) + 20; // Agregar espacio en blanco arriba
                boton.setBounds(x, y, tamanoBoton, tamanoBoton);
                add(boton);
            }
        }
		//-----------------------------------------------------------------------------------------------
		//Se crea, posiciona y añade el boton de pausa
        jbPause = new JButton("Boton de Pausa");
        jbPause.setBounds(335, 450, 130, 30);
        add(jbPause);
		//-----------------------------------------------------------------------------------------------
		
		//Se crea, posiciona y añade el boton de salir
        jbSalirJogo = new JButton("Salir del juego");
        jbSalirJogo.setBounds(535, 450, 130, 30);
        add(jbSalirJogo);
		//-----------------------------------------------------------------------------------------------
		
        //Se crea, posiciona y añade el borde izquierdo
        JPanel panelIzquierda = new JPanel();
        panelIzquierda.setBackground(Color.BLACK);
        panelIzquierda.setBounds(245, 0, 5, 1000);
        add(panelIzquierda);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el borde derecho
        JPanel panelDerecha = new JPanel();
        panelDerecha.setBackground(Color.BLACK);
        panelDerecha.setBounds(750, 0, 5, 1000);
        add(panelDerecha);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JLabel "Jugador Computadora"
        jlComputadorInfo = new JLabel("Jugador Azul");
        jlComputadorInfo.setBounds(65, 60, 150, 60);
        add(jlComputadorInfo);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JLabel "Partidas Ganadas"
        jlComputadorGanadas = new JLabel("Partidas Ganadas");
        jlComputadorGanadas.setBounds(50, 110, 150, 60);
        add(jlComputadorGanadas);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JTextField "Jugadas Ganadas computadoras"
        jtComputadorGanadas = new JTextField(20);
        jtComputadorGanadas.setBounds(30, 150, 150, 60);
        add(jtComputadorGanadas);
        jtComputadorGanadas.setEditable(false);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JLabel "Jugador 1"
        jlJugadorInfo = new JLabel("Jugador Rojo");
        jlJugadorInfo.setBounds(65, 230, 150, 60);
        add(jlJugadorInfo);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JLabel "Partidas ganadas"
        jlJugadorGanadas = new JLabel("Partidas ganadas");
        jlJugadorGanadas.setBounds(50, 280, 150, 60);
        add(jlJugadorGanadas);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JTextField "Jugadas Ganadas jugador"
        jtJugadorGanadas = new JTextField(20);
        jtJugadorGanadas.setBounds(30, 320, 150, 60);
        add(jtJugadorGanadas);
        jtJugadorGanadas.setEditable(false);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JLabel "Partidas Ganadas"
        jlNombreJugador= new JLabel ("Nombre de Jugador");
        jlNombreJugador.setBounds(810, 60, 150, 60);
        add(jlNombreJugador);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JTextField nombreJugador
        jtNombreJugador= new JTextField(20);
        jtNombreJugador.setBounds(795, 100, 150, 60);
        add(jtNombreJugador);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JButton "Registrar Jugador"
        jbGuardarJugador= new JButton("Registrar jugador");
        jbGuardarJugador.setBounds(795, 170, 150, 30);
        add(jbGuardarJugador);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea el JComboBox de jugador1
        jcDerecha= new JComboBox(personasDerecha);
        jcDerecha.setBounds(30, 270, 150, 30);
        add(jcDerecha);
        
        //-----------------------------------------------------------------------------------------------
        //Se crea el boton de reiniciar el juego
        jbReiniciarJuego = new JButton("Reiniciar juego");
        jbReiniciarJuego.setBounds(420, 420, 150, 20);
        add(jbReiniciarJuego);
        
        //Se crea el JComboBox de jugador2
        jcIzquierda = new JComboBox(personasIzquierda);
        jcIzquierda.setBounds(30, 100, 150, 30);
        add(jcIzquierda);
        
        //Instanciamos el Tablero y los manejadores
        tablero= new Tablero();
        ManejadorBoton manejador= new ManejadorBoton();
        ManejadorJugador manejadorJugador = new ManejadorJugador();
        
        //Definimos la ventana como visible
        setVisible(true);
		//-----------------------------------------------------------------------------------------------
		
		//Se concatena el ActionListener
        jbReiniciarJuego.addActionListener(manejador);
        jbPause.addActionListener(manejador);
        jbSalirJogo.addActionListener(manejador);
        jbGuardarJugador.addActionListener(manejadorJugador);
        jcIzquierda.addActionListener(manejadorJugador);
        jcDerecha.addActionListener(manejadorJugador);
        //-----------------------------------------------------------------------------------------------
    }
	
	//Manejador
    private class ManejadorBoton implements ActionListener {
        //Atributos para manejador
        private int opcion;
        //-----------------------------------------------------------------------------------------------
        
        //Referencias
        
        //-----------------------------------------------------------------------------------------------
        
        public void actionPerformed(ActionEvent accion) {

            if (accion.getSource()==jbReiniciarJuego) {
                JOptionPane.showMessageDialog(null, "Reiniciando todo el tablero...");
                dispose();
                InterfazJuego nuevaInterfaz = new InterfazJuego();
                
            }
	        //-------------------------------------------------------------------------------------------
	        
            if (accion.getSource()==jbPause) {
                opcion= Integer.parseInt(JOptionPane.showInputDialog(
                        "Menu de Pausa\n1) Volver a el juego\n2) Salir del juego"));
                switch (opcion) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Volviendo a el juego...");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Saliendo....");
                        dispose();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Debe seleccionar una opción válida");
                        break;
                }
            }
            //-------------------------------------------------------------------------------------------
            
            if (accion.getSource()==jbSalirJogo) {
                JOptionPane.showMessageDialog(null,"me cago en todo");
                System.exit(0);
            }
            //-------------------------------------------------------------------------------------------
            
            // Si se hace clic en un botón de la cuadrícula
            JButton boton = (JButton) accion.getSource();
            String coordenadas = boton.getText();
            if (jugador!=null && computadora!=null){
	            if (coordenadas.startsWith("(")) {
	                if (turnoJugador1) {
	                    JOptionPane.showMessageDialog(rootPane, "Turno del Jugador 1");
	                    boton.setEnabled(false);
	                    Toolkit.getDefaultToolkit().beep();
	                    boton.setBackground(Color.RED);
	                } else {
	                    JOptionPane.showMessageDialog(rootPane, "Turno del Jugador 2");
	                    boton.setEnabled(false);
	                    Toolkit.getDefaultToolkit().beep();
	                    boton.setBackground(Color.BLUE);
	                }
	                // Alternar el turno
	                turnoJugador1 = !turnoJugador1;
	                
	                //Verificar Si hay jugada ganadora
	                //~ if (){
						
					//~ } 
	            }
			} else {
				
				JOptionPane.showMessageDialog(null, "Primero defina los jugadores");
				
			}
            //-------------------------------------------------------------------------------------------
            
        }
    }
    
    private class ManejadorJugador implements ActionListener{
		//Atributos del manejador
		private String colorXcomputador="Azul", nombreXjugador, colorXjugador="Rojo";
		//-----------------------------------------------------------------------------------------------
		
		public void actionPerformed (ActionEvent accionJC){
			
			if  (accionJC.getSource()==jcIzquierda){
				
				if (jcIzquierda.getSelectedItem().equals("Computador")){
					
					jcDerecha.setSelectedItem("Persona");
					colorXcomputador="Azul";
					colorXjugador="Rojo";
					 
				} else if (jcIzquierda.getSelectedItem().equals("Persona")){
					
					jcDerecha.setSelectedItem("Computador");
					colorXjugador="Azul";
					colorXcomputador="Rojo";
					
				}
				
				
			} 
			//-------------------------------------------------------------------------------------------
			
			if (accionJC.getSource()==jcDerecha){
				
				if (jcDerecha.getSelectedItem().equals("Persona")){
					
					jcIzquierda.setSelectedItem("Computador");
					colorXjugador="Rojo";
					colorXcomputador="Azul";
					 
				} else if (jcDerecha.getSelectedItem().equals("Computador")){
					
					jcIzquierda.setSelectedItem("Persona");
					colorXcomputador="Rojo";
					colorXjugador="Azul";
					
				}
				
				
			}
			//-------------------------------------------------------------------------------------------
			
			if (accionJC.getSource()==jbGuardarJugador){
				
				if (jtNombreJugador.getText().equals("")){
					
					JOptionPane.showMessageDialog(null, "Jugador sin nombre");
	
				} else {
					
					nombreXjugador=jtNombreJugador.getText();
					jugador= new Ficha (colorXjugador, nombreXjugador);
					computadora= new Ficha (colorXcomputador, "Computador");
					
					jtNombreJugador.setEditable(false);
					jbGuardarJugador.setEnabled(false);
					
					JOptionPane.showMessageDialog(null, jugador.getColorFicha() +" || "+ jugador.getNombre()+ "\n"+computadora.getColorFicha()+" || "+ computadora.getNombre() );
				}
				
			}
			//-------------------------------------------------------------------------------------------
		}
		
	}

    public static void main(String[] args) {
        InterfazJuego inter = new InterfazJuego();
    }
}
