import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class InterfazJuego extends JFrame {
<<<<<<< HEAD

    // Atributos Swing
    private JButton jbPause, jbSalirJogo, jbGuardarJugador, jbReiniciarJuego;
    private JComboBox<String> jcIzquierda, jcDerecha;
    private JTextField jtComputadorGanadas, jtJugadorGanadas, jtNombreJugador, jtTotalPartidas, jtTurno;
    private JLabel jlComputadorInfo, jlJugadorInfo, jlJugadorGanadas, jlComputadorGanadas, jlNombreJugador, jlJugador1,
            jlJugador2, jlTurno;
    private JLabel jlTotalPartidas;
    // ---------------------------------------------------------------------------------------------------

    // Atributos
    private String personasIzquierda[] = { "Computador", "Persona" };
    private String personasDerecha[] = { "Computador", "Persona" };
    private int tamanoBoton = 60;
    private int espacioEntreBotones = 5;
    private boolean turnoJugador1 = true; // Indica si es el turno del jugador 1
    // ---------------------------------------------------------------------------------------------------

    // Referencias
    private Tablero tablero;
    // ---------------------------------------------------------------------------------------------------

    // Metodo Constructor
=======
    
<<<<<<< Updated upstream
    // Atributos Swing
    private JButton jbPause, jbSalirJogo, jbGuardarJugador, jbReiniciarJuego;
    private JComboBox jcJugadorAmarillo, jcJugadorRojo;
    private JTextField jtAmarilloGanadas, jtRojoGanadas, jtNombreJugador;
    private JLabel jlJugadorAmarillo, jlJugadorRojo, jlRojoGanadas, jlAmarilloGanadas;
    private JLabel jlNombreJugador;
    //--------------------------------------------------------------------------------------------------- 
    
    // Atributos
    private String seleccionAmarillo[] = {"Computador","Persona"};
    private String seleccionRojo[]={"Persona","Computador"};
=======
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
>>>>>>> Stashed changes
    private int tamanoBoton= 60;
    private int espacioEntreBotones= 5;
    private boolean turnoJugador1= true; // Indica si es el turno del jugador 1
    //---------------------------------------------------------------------------------------------------
    
<<<<<<< Updated upstream
    // Referencias
    private Tablero tablero  ;
    private Ficha jugador, computadora;
    //---------------------------------------------------------------------------------------------------
    
    // Método Constructor
    public InterfazJuego() {
        // Se define el JFrame y sus características
=======
    //Referencias
    private Tablero tablero;
	private Ficha jugador, computadora;
	//---------------------------------------------------------------------------------------------------
	
	//Metodo Constructor
>>>>>>> 5514bbc0982989f20f57d586e3b857224c75a691
    public InterfazJuego() {
        // Se define el JFrame y sus caracteristicas
>>>>>>> Stashed changes
        super("Menu juego");
        setSize(1000, 575);
        setLayout(null);
        getContentPane().setBackground(new Color(127, 127, 127));
<<<<<<< Updated upstream
        //-----------------------------------------------------------------------------------------------
        
=======
        // -----------------------------------------------------------------------------------------------

>>>>>>> Stashed changes
        // Cuadrícula 1
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
<<<<<<< Updated upstream
        //-----------------------------------------------------------------------------------------------
        // Se crea, posiciona y añade el botón de pausa
        jbPause = new JButton("Boton de Pausa");
        jbPause.setBounds(335, 450, 130, 30);
        add(jbPause);
        //-----------------------------------------------------------------------------------------------
        
        // Se crea, posiciona y añade el botón de salir
        jbSalirJogo = new JButton("Salir del juego");
        jbSalirJogo.setBounds(535, 450, 130, 30);
        add(jbSalirJogo);
        //-----------------------------------------------------------------------------------------------
        
=======
<<<<<<< HEAD
        // -----------------------------------------------------------------------------------------------
        // se crea
        jtTurno = new JTextField(20);
        jtTurno.setBounds(795, 250, 150, 30);
        add(jtTurno);
        // -----------------------------------------------------------------------------------------------
        // Se crea los jlabels de los jcombo
        jlJugador1 = new JLabel("Jugador 1");
        jlJugador1.setBounds(45, 300, 150, 60);
        add(jlJugador1);
        // -----------------------------------------------------------------------------------------------
        jlJugador2 = new JLabel("Jugador 2");
        jlJugador2.setBounds(45, 370, 150, 60);
        add(jlJugador2);
        // -----------------------------------------------------------------------------------------------
        // Se crea, posiciona y añade el boton de pausa
=======
		//-----------------------------------------------------------------------------------------------
		//Se crea, posiciona y añade el boton de pausa
>>>>>>> 5514bbc0982989f20f57d586e3b857224c75a691
        jbPause = new JButton("Boton de Pausa");
        jbPause.setBounds(335, 450, 130, 30);
        add(jbPause);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el boton de salir
        jbSalirJogo = new JButton("Salir del juego");
        jbSalirJogo.setBounds(535, 450, 130, 30);
        add(jbSalirJogo);
        // -----------------------------------------------------------------------------------------------

>>>>>>> Stashed changes
        // Se crea, posiciona y añade el borde izquierdo
        JPanel panelIzquierda = new JPanel();
        panelIzquierda.setBackground(Color.BLACK);
        panelIzquierda.setBounds(245, 0, 5, 1000);
        add(panelIzquierda);
<<<<<<< Updated upstream
        //-----------------------------------------------------------------------------------------------
        
=======
        // -----------------------------------------------------------------------------------------------

>>>>>>> Stashed changes
        // Se crea, posiciona y añade el borde derecho
        JPanel panelDerecha = new JPanel();
        panelDerecha.setBackground(Color.BLACK);
        panelDerecha.setBounds(750, 0, 5, 1000);
        add(panelDerecha);
<<<<<<< HEAD
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JLabel "Jugador Computadora"
        jlComputadorInfo = new JLabel("Jugador Computadora");
        jlComputadorInfo.setBounds(45, 60, 150, 60);
=======
        //-----------------------------------------------------------------------------------------------
        
<<<<<<< Updated upstream
        // Se crea, posiciona y añade el JLabel "Jugador Amarillo"
        jlJugadorAmarillo = new JLabel("Jugador Azul");
        jlJugadorAmarillo.setBounds(65, 60, 150, 60);
        add(jlJugadorAmarillo);
        //-----------------------------------------------------------------------------------------------
        
        // Se crea, posiciona y añade el JLabel "Partidas Ganadas"
        jlAmarilloGanadas = new JLabel("Partidas Ganadas");
        jlAmarilloGanadas.setBounds(50, 110, 150, 60);
        add(jlAmarilloGanadas);
        //-----------------------------------------------------------------------------------------------
        
        // Se crea, posiciona y añade el JTextField "Jugadas Ganadas computadoras"
        jtAmarilloGanadas = new JTextField(20);
        jtAmarilloGanadas.setBounds(30, 150, 150, 60);
        add(jtAmarilloGanadas);
        jtAmarilloGanadas.setEditable(false);
        //-----------------------------------------------------------------------------------------------
        
        // Se crea, posiciona y añade el JLabel "Jugador 1"
        jlJugadorRojo = new JLabel("Jugador Rojo");
        jlJugadorRojo.setBounds(65, 230, 150, 60);
        add(jlJugadorRojo);
        //-----------------------------------------------------------------------------------------------
        
        // Se crea, posiciona y añade el JLabel "Partidas ganadas"
        jlRojoGanadas = new JLabel("Partidas ganadas");
        jlRojoGanadas.setBounds(50, 280, 150, 60);
        add(jlRojoGanadas);
        //-----------------------------------------------------------------------------------------------
        
        // Se crea, posiciona y añade el JTextField "Jugadas Ganadas jugador"
        jtRojoGanadas = new JTextField(20);
        jtRojoGanadas.setBounds(30, 320, 150, 60);
        add(jtRojoGanadas);
        jtRojoGanadas.setEditable(false);
        //-----------------------------------------------------------------------------------------------
        
        // Se crea, posiciona y añade el JLabel "Partidas Ganadas"
        jlNombreJugador= new JLabel ("Nombre de Jugador");
        jlNombreJugador.setBounds(810, 60, 150, 60);
        add(jlNombreJugador);
        //-----------------------------------------------------------------------------------------------
        
        // Se crea, posiciona y añade el JTextField nombreJugador
        jtNombreJugador= new JTextField(20);
        jtNombreJugador.setBounds(795, 100, 150, 60);
        add(jtNombreJugador);
        //-----------------------------------------------------------------------------------------------
        
        // Se crea, posiciona y añade el JButton "Registrar Jugador"
        jbGuardarJugador= new JButton("Registrar jugador");
        jbGuardarJugador.setBounds(795, 170, 150, 30);
        add(jbGuardarJugador);
        //-----------------------------------------------------------------------------------------------
        
        // Se crea el JComboBox de jugador1
        jcJugadorRojo= new JComboBox(seleccionRojo);
        jcJugadorRojo.setBounds(30, 270, 150, 30);
        add(jcJugadorRojo);
        
        //-----------------------------------------------------------------------------------------------
        // Se crea el botón de reiniciar el juego
        jbReiniciarJuego = new JButton("Reiniciar juego");
        jbReiniciarJuego.setBounds(420, 420, 150, 20);
        add(jbReiniciarJuego);
        
        // Se crea el JComboBox de jugador2
        jcJugadorAmarillo = new JComboBox(seleccionAmarillo);
        jcJugadorAmarillo.setBounds(30, 100, 150, 30);
        add(jcJugadorAmarillo);
        
        // Instanciamos el Tablero y los manejadores
=======
        //Se crea, posiciona y añade el JLabel "Jugador Computadora"
        jlComputadorInfo = new JLabel("Jugador Azul");
        jlComputadorInfo.setBounds(65, 60, 150, 60);
>>>>>>> 5514bbc0982989f20f57d586e3b857224c75a691
        add(jlComputadorInfo);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JLabel "Partidas Ganadas"
        jlComputadorGanadas = new JLabel("Partidas Ganadas");
        jlComputadorGanadas.setBounds(50, 110, 150, 60);
        add(jlComputadorGanadas);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JTextField "Jugadas Ganadas computadoras"
        jtComputadorGanadas = new JTextField(20);
        jtComputadorGanadas.setBounds(30, 150, 150, 60);
        add(jtComputadorGanadas);
        jtComputadorGanadas.setEditable(false);
<<<<<<< HEAD
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JLabel "Jugador 1"
        jlJugadorInfo = new JLabel("Jugador 1");
        jlJugadorInfo.setBounds(70, 180, 150, 60);
=======
        //-----------------------------------------------------------------------------------------------
        
        //Se crea, posiciona y añade el JLabel "Jugador 1"
        jlJugadorInfo = new JLabel("Jugador Rojo");
        jlJugadorInfo.setBounds(65, 230, 150, 60);
>>>>>>> 5514bbc0982989f20f57d586e3b857224c75a691
        add(jlJugadorInfo);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JLabel "Partidas ganadas"
        jlJugadorGanadas = new JLabel("Partidas ganadas");
        jlJugadorGanadas.setBounds(50, 280, 150, 60);
        add(jlJugadorGanadas);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JTextField "Jugadas Ganadas jugador"
        jtJugadorGanadas = new JTextField(20);
        jtJugadorGanadas.setBounds(30, 320, 150, 60);
        add(jtJugadorGanadas);
        jtJugadorGanadas.setEditable(false);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JLabel "Partidas Ganadas"
        jlNombreJugador = new JLabel("Nombre de Jugador");
        jlNombreJugador.setBounds(810, 60, 150, 60);
        add(jlNombreJugador);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JTextField nombreJugador
        jtNombreJugador = new JTextField(20);
        jtNombreJugador.setBounds(795, 100, 150, 60);
        add(jtNombreJugador);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JButton "Registrar Jugador"
        jbGuardarJugador = new JButton("Registrar jugador");
        jbGuardarJugador.setBounds(795, 170, 150, 30);
        add(jbGuardarJugador);
<<<<<<< HEAD
        // -----------------------------------------------------------------------------------------------

        // Se crea el JComboBox de jugador1
        jcDerecha = new JComboBox<>(personasDerecha);
        jcDerecha.setBounds(30, 350, 150, 30);
        add(jcDerecha);
        // -----------------------------------------------------------------------------------------------
        // Se crea el boton de reiniciar el juego
        jbReiniciarJuego = new JButton("Reiniciar juego");
        jbReiniciarJuego.setBounds(420, 420, 150, 20);
        add(jbReiniciarJuego);

        // Se agrega ActionListener al JComboBox de la derecha
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

        // Se crea el JComboBox de jugador2
        jcIzquierda = new JComboBox<>(personasIzquierda);
        jcIzquierda.setBounds(30, 420, 150, 30);
        add(jcIzquierda);

        // Se agrega ActionListener al JComboBox de la izquierda
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

        // Instanciamos el Tablero
        tablero = new Tablero();
        ManejadorBoton manejador = new ManejadorBoton();

        // Definimos la ventana como visible
=======
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
>>>>>>> Stashed changes
        tablero= new Tablero();
        ManejadorBoton manejador= new ManejadorBoton();
        ManejadorJugador manejadorJugador = new ManejadorJugador();
        
<<<<<<< Updated upstream
        // Definimos la ventana como visible
        setVisible(true);
        //-----------------------------------------------------------------------------------------------
        
=======
        //Definimos la ventana como visible
>>>>>>> 5514bbc0982989f20f57d586e3b857224c75a691
        setVisible(true);
        // -----------------------------------------------------------------------------------------------

>>>>>>> Stashed changes
        // Se concatena el ActionListener
        jbReiniciarJuego.addActionListener(manejador);
        jbPause.addActionListener(manejador);
        jbSalirJogo.addActionListener(manejador);
<<<<<<< Updated upstream
        jbGuardarJugador.addActionListener(manejadorJugador);
        jcJugadorAmarillo.addActionListener(manejadorJugador);
        jcJugadorRojo.addActionListener(manejadorJugador);
=======
<<<<<<< HEAD
        jbGuardarJugador.addActionListener(manejador);
        // -----------------------------------------------------------------------------------------------
=======
        jbGuardarJugador.addActionListener(manejadorJugador);
        jcIzquierda.addActionListener(manejadorJugador);
        jcDerecha.addActionListener(manejadorJugador);
>>>>>>> Stashed changes
        //-----------------------------------------------------------------------------------------------
>>>>>>> 5514bbc0982989f20f57d586e3b857224c75a691
    }
<<<<<<< Updated upstream
    
    // Manejador de botón
    private class ManejadorBoton implements ActionListener {
        //Referencias
        private ManejadorJugador color;
=======

    // Manejador
    private class ManejadorBoton implements ActionListener {
        // Atributos para manejador
        private int opcion;
<<<<<<< HEAD
        // -----------------------------------------------------------------------------------------------

        // Referencias
        private Ficha jugador, computadora;
        // -----------------------------------------------------------------------------------------------

=======
        //-----------------------------------------------------------------------------------------------
        
        //Referencias
        
        //-----------------------------------------------------------------------------------------------
>>>>>>> Stashed changes
        
>>>>>>> 5514bbc0982989f20f57d586e3b857224c75a691
        public void actionPerformed(ActionEvent accion) {
<<<<<<< Updated upstream
            // Si se hace clic en un botón de la cuadrícula
            JButton boton = (JButton) accion.getSource();
            String coordenadas = boton.getText();
            String[] coordenadasArray = coordenadas.split(",");
            int fila = Integer.parseInt(coordenadasArray[0].substring(1)); // Obtenemos la fila
            int columna = Integer.parseInt(coordenadasArray[1].substring(0, coordenadasArray[1].length() - 1)); // Obtenemos la columna
            System.out.println(columna);
            if (jugador!=null && computadora!=null){
                if (coordenadas.startsWith("(")) {
                    if (turnoJugador1) {
                        JOptionPane.showMessageDialog(null, "Turno del "+ color.colorXjugador +" en la posición: (" + fila + ", " + columna + ")");
                        boton.setEnabled(false);
                        Toolkit.getDefaultToolkit().beep();
                        boton.setBackground(Color.RED);
                    } else {
                        JOptionPane.showMessageDialog(null, "Turno del "+ color.colorXcomputador +" en la posición: (" + fila + ", " + columna + ")");
                        boton.setEnabled(false);
                        Toolkit.getDefaultToolkit().beep();
                        boton.setBackground(Color.BLUE);
                    }
                    // Alternar el turno
                    turnoJugador1 = !turnoJugador1;
                    
                    // Verificar si hay jugada ganadora
                    //~ if (){
                        
                    //~ } 
                }
            } else {
                JOptionPane.showMessageDialog(null, "Primero defina los jugadores");
            }
        }
    }
    
    // Manejador de jugador
    private class ManejadorJugador implements ActionListener {
        // Atributos del manejador
        private String colorXcomputador="Amarillo", nombreXjugador, colorXjugador="Rojo";
        
        public void actionPerformed(ActionEvent accionJC) {
			
            if  (accionJC.getSource()==jcJugadorAmarillo){
                if (jcJugadorAmarillo.getSelectedItem().equals("Computador")){
                    jcJugadorRojo.setSelectedItem("Persona");
                    colorXcomputador="Amarillo";
                    colorXjugador="Rojo";
                } else if (jcJugadorAmarillo.getSelectedItem().equals("Persona")){
                    jcJugadorRojo.setSelectedItem("Computador");
                    colorXjugador="Amarillo";
                    colorXcomputador="Rojo";
                }
            } 
            //-------------------------------------------------------------------------------------------
            
            if (accionJC.getSource()==jcJugadorRojo){
                if (jcJugadorRojo.getSelectedItem().equals("Persona")){
                    jcJugadorAmarillo.setSelectedItem("Computador");
                    colorXjugador="Rojo";
                    colorXcomputador="Amarillo";
                } else if (jcJugadorRojo.getSelectedItem().equals("Computador")){
                    jcJugadorAmarillo.setSelectedItem("Persona");
                    colorXcomputador="Rojo";
                    colorXjugador="Amarillo";
                }
=======

            if (accion.getSource() == jbReiniciarJuego) {
                JOptionPane.showMessageDialog(null, "Reiniciando todo el tablero...");
                dispose();
                InterfazJuego nuevaInterfaz = new InterfazJuego();

            }
<<<<<<< HEAD

            if (accion.getSource() == jbGuardarJugador) {

                // Controlador espacio vacio
                if (jtNombreJugador.getText().equals("")) {

                    JOptionPane.showMessageDialog(null, "Digite su nombre");

                } else {
                    jugador = new Ficha("Azul", jtNombreJugador.getText());
                    computadora = new Ficha("Rojo", "Computadora");

                    jtNombreJugador.setEditable(false);
                }

            }
            // -------------------------------------------------------------------------------------------

            if (accion.getSource() == jbPause) {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(
=======
	        //-------------------------------------------------------------------------------------------
	        
            if (accion.getSource()==jbPause) {
                opcion= Integer.parseInt(JOptionPane.showInputDialog(
>>>>>>> 5514bbc0982989f20f57d586e3b857224c75a691
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
            // -------------------------------------------------------------------------------------------

            if (accion.getSource() == jbSalirJogo) {
                JOptionPane.showMessageDialog(null, "me cago en todo");
                System.exit(0);
            }
            // -------------------------------------------------------------------------------------------

            // Si se hace clic en un botón de la cuadrícula
            JButton boton = (JButton) accion.getSource();
            String coordenadas = boton.getText();
<<<<<<< HEAD
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

                // Verificar Si hay jugada ganadora
                // ~ if (){

                // ~ }
>>>>>>> Stashed changes
            }
            // -------------------------------------------------------------------------------------------

=======
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
            
<<<<<<< Updated upstream
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
	//---------------------------------------------------------------------------------------------------
	
	//Main temporal
=======
>>>>>>> 5514bbc0982989f20f57d586e3b857224c75a691
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

>>>>>>> Stashed changes
    public static void main(String[] args) {
        InterfazJuego inter = new InterfazJuego();
    }
}
