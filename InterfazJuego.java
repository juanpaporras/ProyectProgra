//Proyecto Grupal

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class InterfazJuego extends JFrame {
    
    //Atributos Swing
<<<<<<< Updated upstream
    JButton jbPause, jbSalirJogo;
    JComboBox jcIzquierda,jcDerecha;
    JTextField jtComputadorGanadas, jtJugadorGanadas;
    JLabel jlComputadorInfo, jlJugadorInfo, jlJugadorGanadas, jlComputadorGanadas;
=======
    private JButton jbPause, jbSalirJogo, jbGuardarJugador;
    private JComboBox jcIzquierda,jcDerecha;
    private JTextField jtComputadorGanadas, jtJugadorGanadas, jtNombreJugador, jtTotalPartidas;
    private JLabel jlComputadorInfo, jlJugadorInfo, jlJugadorGanadas, jlComputadorGanadas, jlNombreJugador;
    private JLabel jlTotalPartidas;
    //--------------------------------------------------------------------------------------------------- 
>>>>>>> Stashed changes
    
    //Atributos
    private String personasIzquierda[] = {"Computador","Persona"};
    private String personasDerecha[]={"Computador","Persona"};
    private int tamanoBoton= 60;
    private int espacioEntreBotones= 5;
    private boolean turnoJugador1= true; //Indica si es el turno del jugador 1
    //---------------------------------------------------------------------------------------------------
<<<<<<< Updated upstream

=======
    
    //Referencias
    private Tablero tablero;
	//---------------------------------------------------------------------------------------------------
	
	//Metodo Constructor
>>>>>>> Stashed changes
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
        jlComputadorInfo = new JLabel("Jugador Computadora");
        jlComputadorInfo.setBounds(50, 60, 150, 60);
        add(jlComputadorInfo);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JLabel "Partidas Ganadas"
        jlComputadorGanadas = new JLabel("Partidas Ganadas");
        jlComputadorGanadas.setBounds(50, 80, 150, 60);
        add(jlComputadorGanadas);
        //-----------------------------------------------------------------------------------------------
        
<<<<<<< Updated upstream
        //Se crea, posiciona y añade el JLabel "Jugador 1"
        jlJugadorInfo = new JLabel("Jugador 1");
        jlJugadorInfo.setBounds(830, 60, 150, 60);
        add(jlJugadorInfo);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JLabel "Partidas ganadas"
        jlJugadorGanadas = new JLabel("Partidas ganadas");
        jlJugadorGanadas.setBounds(830, 80, 150, 60);
        add(jlJugadorGanadas);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JTextField "Jugadas Ganadas jugador"
        jtJugadorGanadas = new JTextField(20);
        jtJugadorGanadas.setBounds(800, 120, 150, 60);
        add(jtJugadorGanadas);
        jtJugadorGanadas.setEditable(false);
        //-----------------------------------------------------------------------------------------------
        
=======
>>>>>>> Stashed changes
        //Se crea, posiciona y añade el JTextField "Jugadas Ganadas computadoras"
        jtComputadorGanadas = new JTextField(20);
        jtComputadorGanadas.setBounds(30, 120, 150, 60);
        add(jtComputadorGanadas);
        jtComputadorGanadas.setEditable(false);
        //-----------------------------------------------------------------------------------------------
        
<<<<<<< Updated upstream
        //Se crea, posiciona y añade el JComboBox izquierdo
        jcIzquierda = new JComboBox(personasIzquierda);
        jcIzquierda.setBounds(30, 195, 140, 30);
        jcIzquierda.setMaximumRowCount(2);
        add(jcIzquierda);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JComboBox derecho
        jcDerecha= new JComboBox(personasDerecha);
        jcDerecha.setBounds(800,195,140,30);
        jcIzquierda.setMaximumRowCount(2);
        add(jcDerecha);
        //-----------------------------------------------------------------------------------------------
        
        //
=======
        //Se crea, posiciona y añade el JLabel "Jugador 1"
        jlJugadorInfo = new JLabel("Jugador 1");
        jlJugadorInfo.setBounds(70, 180, 150, 60);
        add(jlJugadorInfo);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JLabel "Partidas ganadas"
        jlJugadorGanadas = new JLabel("Partidas ganadas");
        jlJugadorGanadas.setBounds(50, 200, 150, 60);
        add(jlJugadorGanadas);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JTextField "Jugadas Ganadas jugador"
        jtJugadorGanadas = new JTextField(20);
        jtJugadorGanadas.setBounds(30, 240, 150, 60);
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
        
        //Instanciamos el Tablero
        tablero= new Tablero();
        ManejadorBoton manejador= new ManejadorBoton();
        
        //Definimos la ventana como visible
>>>>>>> Stashed changes
        setVisible(true);
		//-----------------------------------------------------------------------------------------------
		
		//Se concatena el ActionListener
<<<<<<< Updated upstream
        jbPause.addActionListener(new ManejadorBoton());
        jbSalirJogo.addActionListener(new ManejadorBoton());
=======
        jbPause.addActionListener(manejador);
        jbSalirJogo.addActionListener(manejador);
        jbGuardarJugador.addActionListener(manejador);
>>>>>>> Stashed changes
        //-----------------------------------------------------------------------------------------------
    }
	
	//Manejador
    private class ManejadorBoton implements ActionListener {
        //Atributos para manejador
        private int opcion;
<<<<<<< Updated upstream
        
        public void actionPerformed(ActionEvent e) {
        
            if (e.getActionCommand().equals("Boton de Pausa")) {
                opcion= Integer.parseInt(JOptionPane.showInputDialog(null,
=======
        //-----------------------------------------------------------------------------------------------
        
        //Referencias
        private Ficha jugador, computadora;
        //-----------------------------------------------------------------------------------------------
        
        public void actionPerformed(ActionEvent accion) {
	    
			if (accion.getSource()==jbGuardarJugador){
				
				//Controlador espacio vacio
				if (jtNombreJugador.getText().equals("")){
					
					JOptionPane.showMessageDialog(null, "Digite su nombre");
					
				} else {
					jugador= new Ficha ("Azul", jtNombreJugador.getText());
					computadora= new Ficha ("Rojo", "Computadora");
					
					jtNombreJugador.setEditable(false);
				}
				
			}
	        //-------------------------------------------------------------------------------------------
	        
            if (accion.getSource()==jbPause) {
                opcion= Integer.parseInt(JOptionPane.showInputDialog(
>>>>>>> Stashed changes
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

            if (e.getActionCommand().equals("Salir del juego")) {
                JOptionPane.showMessageDialog(null,"me cago en todo");
                System.exit(0);
            }

            // Si se hace clic en un botón de la cuadrícula
            JButton boton = (JButton) e.getSource();
            String coordenadas = boton.getText();
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
            }
        }
    }

    public static void main(String[] args) {
        InterfazJuego inter = new InterfazJuego();
    }
}
