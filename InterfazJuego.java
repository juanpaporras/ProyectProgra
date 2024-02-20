//Proyecto Grupal

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class InterfazJuego extends JFrame {
    
    //Atributos Swing
    JButton jbPause, jbSalirJogo, jbGuardarJugador;
    JComboBox jcIzquierda,jcDerecha;
    JTextField jtComputadorGanadas, jtJugadorGanadas, jtNombreJugador, jtTotalPartidas;
    JLabel jlComputadorInfo, jlJugadorInfo, jlJugadorGanadas, jlComputadorGanadas, jlNombreJugador;
    private JLabel jlTotalPartidas;
    
    //Atributos
    private String personasIzquierda[] = {"Computador","Persona"};
    private String personasDerecha[]={"Computador","Persona"};
    private int tamanoBoton= 60;
    private int espacioEntreBotones= 5;
    private boolean turnoJugador1= true; //Indica si es el turno del jugador 1
    //---------------------------------------------------------------------------------------------------
    
	//Referencias
	private Ficha jugada;
	private Tablero tablero;
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
		
		//~ //Se crea, posiciona y añade el boton de jugador 1
        //~ jbJugador1= new JButton("Guardar Jugador");
        //~ jbJugador1.setBounds(335, 450, 130, 30);
        //~ add(jbJugador1);
		//~ //-----------------------------------------------------------------------------------------------
		
		//~ //Se crea, posiciona y añade el boton de jugador 2
        //~ jbJugador2= new JButton("Guardar Jugador");
        //~ jbJugador2.setBounds(335, 450, 130, 30);
        //~ add(jbJugador2);
		//~ //-----------------------------------------------------------------------------------------------
		
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
        jlComputadorInfo.setBounds(45, 60, 150, 60);
        add(jlComputadorInfo);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JLabel "Partidas Ganadas"
        jlComputadorGanadas = new JLabel("Partidas Ganadas");
        jlComputadorGanadas.setBounds(50, 80, 150, 60);
        add(jlComputadorGanadas);
        //-----------------------------------------------------------------------------------------------
        
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
        
        //Se crea, posiciona y añade el JTextField "Jugadas Ganadas computadoras"
        jtComputadorGanadas = new JTextField(20);
        jtComputadorGanadas.setBounds(30, 120, 150, 60);
        add(jtComputadorGanadas);
        jtComputadorGanadas.setEditable(false);
        //-----------------------------------------------------------------------------------------------
        
        //
        setVisible(true);
		//-----------------------------------------------------------------------------------------------
		
		//Se concatena el ActionListener
        jbPause.addActionListener(new ManejadorBoton());
        jbSalirJogo.addActionListener(new ManejadorBoton());
        //-----------------------------------------------------------------------------------------------
    }
	
	//Manejador
    private class ManejadorBoton implements ActionListener {
        //Atributos para manejador
        private int opcion;
        
        public void actionPerformed(ActionEvent accion) {
        
            if (accion.getSource()==jbPause) {
                opcion= Integer.parseInt(JOptionPane.showInputDialog(null,
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

            if (accion.getSource()==jbSalirJogo) {
                JOptionPane.showMessageDialog(null,"me cago en todo");
                System.exit(0);
            }

            // Si se hace clic en un botón de la cuadrícula
            JButton boton = (JButton) accion.getSource();
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
                
                //~ if (){
					
				//~ }
            }
        }
    }

    public static void main(String[] args) {
        InterfazJuego inter = new InterfazJuego();
    }
}
