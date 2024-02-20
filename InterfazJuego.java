import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class InterfazJuego extends JFrame {
    
    //Atributos Swing
    private JButton jbPause, jbSalirJogo, jbGuardarJugador,jbReiniciarJuego;
    private JComboBox<String> jcIzquierda, jcDerecha;
    private JTextField jtComputadorGanadas, jtJugadorGanadas, jtNombreJugador, jtTotalPartidas;
    private JLabel jlComputadorInfo, jlJugadorInfo, jlJugadorGanadas, jlComputadorGanadas, jlNombreJugador,jlJugador1,jlJugador2;
    private JLabel jlTotalPartidas;
    //--------------------------------------------------------------------------------------------------- 
    
    //Atributos
    private String personasIzquierda[] = {"Computador","Persona"};
    private String personasDerecha[]={"Computador","Persona"};
    private int tamanoBoton= 60;
    private int espacioEntreBotones= 5;
    private boolean turnoJugador1= true; //Indica si es el turno del jugador 1
    //---------------------------------------------------------------------------------------------------
    
    //Referencias
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
        //Se crea los jlabels de los jcombo
        jlJugador1 = new JLabel("Jugador 1");
        jlJugador1.setBounds(45, 300, 150, 60);
        add(jlJugador1);
		//-----------------------------------------------------------------------------------------------
        jlJugador2 = new JLabel("Jugador 2");
        jlJugador2.setBounds(45, 370, 150, 60);
        add(jlJugador2);
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
        jlComputadorInfo.setBounds(45, 60, 150, 60);
        add(jlComputadorInfo);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JLabel "Partidas Ganadas"
        jlComputadorGanadas = new JLabel("Partidas Ganadas");
        jlComputadorGanadas.setBounds(50, 80, 150, 60);
        add(jlComputadorGanadas);
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JTextField "Jugadas Ganadas computadoras"
        jtComputadorGanadas = new JTextField(20);
        jtComputadorGanadas.setBounds(30, 120, 150, 60);
        add(jtComputadorGanadas);
        jtComputadorGanadas.setEditable(false);
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
        jcDerecha= new JComboBox<>(personasDerecha);
        jcDerecha.setBounds(30, 350, 150, 30);
        add(jcDerecha);
        //-----------------------------------------------------------------------------------------------
        //Se crea el boton de reiniciar el juego
        jbReiniciarJuego = new JButton("Reiniciar juego");
        jbReiniciarJuego.setBounds(420, 420, 150, 20);
        add(jbReiniciarJuego);

        //Se agrega ActionListener al JComboBox de la derecha
        jcDerecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener la opción seleccionada
                String seleccion = (String) jcDerecha.getSelectedItem();

                // Hacer algo basado en la opción seleccionada
                if (seleccion.equals("Computador")) {
                    // Acción cuando se selecciona "Computador"
                    JOptionPane.showMessageDialog(null, "Se seleccionó Computador en la derecha");
                } else if (seleccion.equals("Persona")) {
                    // Acción cuando se selecciona "Persona"
                    JOptionPane.showMessageDialog(null, "Se seleccionó Persona en la derecha");
                }
                jcDerecha.setEnabled(false);
            }
        });
        
        //Se crea el JComboBox de jugador2
        jcIzquierda = new JComboBox<>(personasIzquierda);
        jcIzquierda.setBounds(30, 420, 150, 30);
        add(jcIzquierda);
        
        //Se agrega ActionListener al JComboBox de la izquierda
        jcIzquierda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener la opción seleccionada
                String seleccion = (String) jcIzquierda.getSelectedItem();

                // Hacer algo basado en la opción seleccionada
                if (seleccion.equals("Computador")) {
                    // Acción cuando se selecciona "Computador"
                    JOptionPane.showMessageDialog(null, "Se seleccionó Computador en la izquierda");
                } else if (seleccion.equals("Persona")) {
                    // Acción cuando se selecciona "Persona"
                    JOptionPane.showMessageDialog(null, "Se seleccionó Persona en la izquierda");
                }
                jcIzquierda.setEnabled(false);
            }
        });
        
        //Instanciamos el Tablero
        tablero= new Tablero();
        ManejadorBoton manejador= new ManejadorBoton();
        
        //Definimos la ventana como visible
        setVisible(true);
		//-----------------------------------------------------------------------------------------------
		
		//Se concatena el ActionListener
        jbReiniciarJuego.addActionListener(manejador);
        jbPause.addActionListener(manejador);
        jbSalirJogo.addActionListener(manejador);
        jbGuardarJugador.addActionListener(manejador);
        //-----------------------------------------------------------------------------------------------
    }
	
	//Manejador
    private class ManejadorBoton implements ActionListener {
        //Atributos para manejador
        private int opcion;
        //-----------------------------------------------------------------------------------------------
        
        //Referencias
        private Ficha jugador, computadora;
        //-----------------------------------------------------------------------------------------------
        
        public void actionPerformed(ActionEvent accion) {

            if (accion.getSource()==jbReiniciarJuego) {
                JOptionPane.showMessageDialog(null, "Reiniciando todo el tablero...");
                dispose();
                InterfazJuego nuevaInterfaz = new InterfazJuego();
                
            }
	    
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
            //-------------------------------------------------------------------------------------------
            
        }
    }

    public static void main(String[] args) {
        InterfazJuego inter = new InterfazJuego();
    }
}
