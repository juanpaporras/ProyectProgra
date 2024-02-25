//Proyecto grupal
//Juan Pablo Porras Alvarado C36086, Dennis Josue Bustos Soto C31381, Axel Obando Bermudez c25595

//Importaciones 
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.Component;

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
public class InterfazJuego extends JFrame {

    // Se crean las referencias para los botones, etiquetas, campos de textos y
    // demas.
    JButton jbPause, jbSalirJogo, jbGuardarJugador, jbReiniciarJuego;
    JComboBox jcJugadorAmarillo, jcJugadorRojo;
    JTextField jtAmarilloGanadas, jtRojoGanadas, jtNombreJugador, jtInfoImportante;
    JLabel jlJugadorAmarillo, jlJugadorRojo, jlRojoGanadas, jlAmarilloGanadas;
    JLabel jlNombreJugador;

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Atributos
    private String turno, colorXcomputador = "Amarillo", colorXjugador = "Rojo";
    private String seleccionAmarillo[] = { "Computador", "Persona" };
    private String seleccionRojo[] = { "Persona", "Computador" };
    private int tamanoBoton = 60, espacioEntreBotones = 5, marcadorAmarillo=0, marcadorRojo=0;

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Referencias
    private Tablero tablero;
    private Ficha jugador, computadora;

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Método Constructor
    public InterfazJuego() {
        // Se define el JFrame y sus características
        super("Menu juego");
        setSize(1000, 575);
        setLayout(null);
        getContentPane().setBackground(new Color(26, 82, 118));

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Cuadrícula 1
        // se usan dos for para crear la cuadricula de botones
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                JButton boton = new JButton("(" + fila + "," + columna + ")");
                boton.addActionListener(new ManejadorBoton());
                
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                // Calcular las coordenadas para cada botón
                int x = columna * (tamanoBoton + espacioEntreBotones) + 275;
                int y = fila * (tamanoBoton + espacioEntreBotones) + 20; // Agregar espacio en blanco arriba
                boton.setBounds(x, y, tamanoBoton, tamanoBoton);
                
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                 //Establecer la imagen como icono del botón
                ImageIcon icono = new ImageIcon("Recursos/FichaVacia.png");
                Image imagen = icono.getImage().getScaledInstance(tamanoBoton + 10, tamanoBoton + 6,
                        Image.SCALE_SMOOTH); // Ajustar el ancho y el alto al tamaño del botón
                boton.setIcon(new ImageIcon(imagen));

                add(boton);
            } // fin del segundo for
        } // fin del primer for

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea, posiciona y añade el botón de pausa
        jbPause = new JButton("Boton de Pausa");
        jbPause.setBounds(335, 450, 130, 30); // Establecer el comando del botón
        add(jbPause);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea, posiciona y añade el botón de salir
        jbSalirJogo = new JButton("Salir del juego");
        jbSalirJogo.setBounds(535, 450, 130, 30);
        jbSalirJogo.setActionCommand("Salir del juego"); // Establecer el comando del botón
        add(jbSalirJogo);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea, posiciona y añade el borde izquierdo
        JPanel panelIzquierda = new JPanel();
        panelIzquierda.setBackground(Color.BLACK);
        panelIzquierda.setBounds(245, 0, 5, 1000);
        add(panelIzquierda);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea, posiciona y añade el borde derecho
        JPanel panelDerecha = new JPanel();
        panelDerecha.setBackground(Color.BLACK);
        panelDerecha.setBounds(750, 0, 5, 1000);
        add(panelDerecha);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea, posiciona y añade el JLabel "Jugador Amarillo"
        jlJugadorAmarillo = new JLabel("Jugador Amarillo");
        jlJugadorAmarillo.setBounds(65, 60, 150, 60);
        add(jlJugadorAmarillo);
        
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea y posiciona y añade el jtInfoImportante "Informacion"
        jtInfoImportante = new JTextField (50);
        jtInfoImportante.setBounds(350, 490, 300, 30);
        add(jtInfoImportante);
        jtInfoImportante.setText("Recuerda rellenar las columnas de abajo hacia arriba");
        jtInfoImportante.setEditable(false);
        
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea, posiciona y añade el JLabel "Partidas Ganadas"
        jlAmarilloGanadas = new JLabel("Partidas Ganadas");
        jlAmarilloGanadas.setBounds(50, 110, 150, 60);
        add(jlAmarilloGanadas);
        
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea, posiciona y añade el JTextField "Jugadas Ganadas computadoras"
        jtAmarilloGanadas = new JTextField(20);
        jtAmarilloGanadas.setBounds(30, 150, 150, 60);
        jtAmarilloGanadas.setHorizontalAlignment(SwingConstants.CENTER); 
        add(jtAmarilloGanadas);
        jtAmarilloGanadas.setText(String.valueOf(marcadorAmarillo));
        jtAmarilloGanadas.setEditable(false);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea, posiciona y añade el JLabel "Jugador 1"
        jlJugadorRojo = new JLabel("Jugador Rojo");
        jlJugadorRojo.setBounds(65, 230, 150, 60);
        add(jlJugadorRojo);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea, posiciona y añade el JLabel "Partidas ganadas"
        jlRojoGanadas = new JLabel("Partidas ganadas");
        jlRojoGanadas.setBounds(50, 280, 150, 60);
        add(jlRojoGanadas);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea, posiciona y añade el JTextField "Jugadas Ganadas rojo"
        jtRojoGanadas = new JTextField(20);
        jtRojoGanadas.setBounds(30, 320, 150, 60);
        add(jtRojoGanadas);
        jtRojoGanadas.setHorizontalAlignment(SwingConstants.CENTER);
        jtRojoGanadas.setText(String.valueOf(marcadorRojo));
        jtRojoGanadas.setEditable(false);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea, posiciona y añade el JLabel "Partidas Ganadas"
        jlNombreJugador = new JLabel("Nombre de Jugador");
        jlNombreJugador.setBounds(810, 60, 150, 60);
        add(jlNombreJugador);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea, posiciona y añade el JTextField nombreJugador
        jtNombreJugador = new JTextField(20);
        jtNombreJugador.setBounds(795, 100, 150, 60);
        add(jtNombreJugador);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea, posiciona y añade el JButton "Registrar Jugador"
        jbGuardarJugador = new JButton("Registrar jugador");
        jbGuardarJugador.setBounds(795, 170, 150, 30);
        add(jbGuardarJugador);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea el JComboBox de jugador1
        jcJugadorRojo = new JComboBox(seleccionRojo);
        jcJugadorRojo.setBounds(30, 270, 150, 30);
        add(jcJugadorRojo);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea el botón de reiniciar el juego
        jbReiniciarJuego = new JButton("Reiniciar juego");
        jbReiniciarJuego.setBounds(420, 420, 150, 20);
        add(jbReiniciarJuego);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se crea el JComboBox de jugador2
        jcJugadorAmarillo = new JComboBox(seleccionAmarillo);
        jcJugadorAmarillo.setBounds(30, 100, 150, 30);
        add(jcJugadorAmarillo);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Instanciamos el Tablero y los manejadores
        tablero = new Tablero();
        ManejadorBoton manejador = new ManejadorBoton();
        ManejadorJugador manejadorJugador = new ManejadorJugador();
        ManejadorBotones manejadorPause = new ManejadorBotones();
        
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Definimos la ventana como visible
        setVisible(true);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // Se concatena el ActionListener
        jbReiniciarJuego.addActionListener(manejadorPause);
        jbPause.addActionListener(manejadorPause);
        jbSalirJogo.addActionListener(manejadorPause);
        jbGuardarJugador.addActionListener(manejadorJugador);
        jcJugadorAmarillo.addActionListener(manejadorJugador);
        jcJugadorRojo.addActionListener(manejadorJugador);
        
    }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Manejador de botón
    private class ManejadorBoton implements ActionListener {
        // Atributos
        private String coordenadas, coordenadasArray[];
        private int fila, columna;
        private JButton boton;
        private Ficha ganador;
        
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        public void actionPerformed(ActionEvent evento) {

            // Si se hace clic en un botón de la cuadrícula
            boton = (JButton) evento.getSource();

            coordenadas = boton.getText();

            coordenadasArray = coordenadas.split(",");

            fila = Integer.parseInt(coordenadasArray[0].substring(1)); // Obtenemos la fila

            columna = Integer.parseInt(coordenadasArray[1].substring(0, coordenadasArray[1].length() - 1));
            
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            // Verifica si los objetos ya estan creados
            if (jugador != null && computadora != null) {

                // Verifica si la posicion está ocupada o si en la posición de la fila posterior
                // esta llena
                if (tablero.verificarMovimiento(fila, columna) == true) {

                    if (coordenadas.startsWith("(")) {

                        if (turno.equals("Rojo")) {
							
                            Toolkit.getDefaultToolkit().beep();
                            ImageIcon icono = new ImageIcon("Recursos/FichaRojo.png");
                            Image imagen = icono.getImage().getScaledInstance(tamanoBoton + 10, tamanoBoton + 6,
                                   Image.SCALE_SMOOTH);
                            boton.setIcon(new ImageIcon(imagen));
                        } // fin del if turno rojo
                        
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        else if (turno.equals("Amarillo")) {
							
                            Toolkit.getDefaultToolkit().beep();
                            ImageIcon icono = new ImageIcon("Recursos/FichaAmarilla.png");
                            Image imagen = icono.getImage().getScaledInstance(tamanoBoton + 10, tamanoBoton + 6,
                                   Image.SCALE_SMOOTH);
                            boton.setIcon(new ImageIcon(imagen));

                        } // fin del if turno amarillo

                    } // fin del if cordenadas
                    
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    // Alterna turno y registra jugadas en el tablero
                    if (colorXjugador.equals(turno)) {

                        tablero.realizarMovimiento(fila, columna, jugador);
                        turno = colorXcomputador;
                        
                        
                        jugadaComputadora();
                        
                         ganador = tablero.verificarGanadorRecursivo(0, 0);
                         
                         if (ganador!=null){
							 
							 JOptionPane.showMessageDialog(null, "el ganador es: " + ganador.getNombre());
							 
								if (ganador.getColorFicha().equals("Amarillo")){
									
									marcadorAmarillo++;
									jtAmarilloGanadas.setText(String.valueOf(marcadorAmarillo));
									
								} else if (ganador.getColorFicha().equals("Rojo")){
									
									marcadorRojo++;
									jtRojoGanadas.setText(String.valueOf(marcadorRojo));
									
								}
							 
							 
						 }

					}

                } // fin del if verificar movimiento

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                else {

                    JOptionPane.showMessageDialog(null,
                            "Jugada no disponible");

                } // fin del else
                
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            } // fin del if para verificar la creacion de los objetos
            
            else {
				
                JOptionPane.showMessageDialog(null, "Primero defina los jugadores");
                
            } // fin del else
            
        }// fin del public void ActionPerformed
        
    }// fin de la clase privada manejadorBoton
    
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Esta clase maneja las acciones de los jugadores en el juego.
	private class ManejadorJugador implements ActionListener {
		
		// Atributos del manejador
		public String nombreXjugador;

		public void actionPerformed(ActionEvent accionJC) { // Inicio del método actionPerformed
			
			if (accionJC.getSource() == jcJugadorAmarillo) { // Inicio del bloque if para "jcJugadorAmarillo"
				
				if (jcJugadorAmarillo.getSelectedItem().equals("Computador")) { // Inicio del bloque if para "Computador"
					
					jcJugadorRojo.setSelectedItem("Persona");
					colorXcomputador = "Amarillo";
					colorXjugador = "Rojo";
					
				} // Fin del bloque if para "Computador"
				else 
				
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if (jcJugadorAmarillo.getSelectedItem().equals("Persona")) { // Inicio del bloque else if para "Persona"
					
					jcJugadorRojo.setSelectedItem("Computador");
					colorXjugador = "Amarillo";
					colorXcomputador = "Rojo";
					
				} // Fin del bloque else if para "Persona"
				
			} // Fin del bloque if para "jcJugadorAmarillo"
			
			if (accionJC.getSource() == jcJugadorRojo) { // Inicio del bloque if para "jcJugadorRojo"
				
				if (jcJugadorRojo.getSelectedItem().equals("Persona")) { // Inicio del bloque if para "Persona"
					
					jcJugadorAmarillo.setSelectedItem("Computador");
					colorXjugador = "Rojo";
					colorXcomputador = "Amarillo";
					
				} // Fin del bloque if para "Persona"
				else 
				
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if (jcJugadorRojo.getSelectedItem().equals("Computador")) { // Inicio del bloque else if para "Computador"
					
					jcJugadorAmarillo.setSelectedItem("Persona");
					colorXcomputador = "Rojo";
					colorXjugador = "Amarillo";
					
				} // Fin del bloque else if para "Computador"
				
			} // Fin del bloque if para "jcJugadorRojo"
			
			if (accionJC.getSource() == jbGuardarJugador) { // Inicio del bloque if para "jbGuardarJugador"
				
				if (jtNombreJugador.getText().equals("")) { // Inicio del bloque if para verificar el nombre del jugador
					
					JOptionPane.showMessageDialog(null, "Jugador sin nombre");
					
				} 
				
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++				
				else { // Inicio del bloque else
					
					tablero.iniciarTablero();
					nombreXjugador = jtNombreJugador.getText();
					jugador = new Ficha(colorXjugador, nombreXjugador);
					computadora = new Ficha(colorXcomputador, "Computador");
					turno = colorXjugador;
					jtNombreJugador.setEditable(false);
					jbGuardarJugador.setEnabled(false);
					jcJugadorAmarillo.setEnabled(false);
					jcJugadorRojo.setEnabled(false);
					JOptionPane.showMessageDialog(null, jugador.getColorFicha() + " || " + jugador.getNombre() + "\n"
							+ computadora.getColorFicha() + " || " + computadora.getNombre());
					
				} // Fin del bloque else
				
			} // Fin del bloque if para "jbGuardarJugador"

		} // Fin del método actionPerformed
		
	} // Fin de la clase ManejadorJugador

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Esta clase maneja las acciones de los botones en el juego.
	private class ManejadorBotones implements ActionListener {
		private int opcion;
		
		public void actionPerformed(ActionEvent accion) { // Inicio del método actionPerformed
			
			if (accion.getActionCommand().equals("Boton de Pausa")) { // Inicio del bloque if para "Boton de Pausa"
				
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Menu de Pausa\n1) Volver a el juego\n2) Salir del juego"));
						
				switch (opcion) { // Inicio del bloque switch
					
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
						
				} // Fin del bloque switch
				
			} // Fin del bloque if para "Boton de Pausa"
			
			if (accion.getActionCommand().equals("Salir del juego")) { // Inicio del bloque if para "Salir del juego"
				
				JOptionPane.showMessageDialog(null, "-----------------CREDITOS-----------------"+
				"\nJuan Pablo Porras Alvarado C36086 \nDennis Josue Bustos Soto C31381 \nAxel Obando Bermudez c25595");
				System.exit(0);
				
			} // Fin del bloque if para "Salir del juego"
			
			if (accion.getActionCommand().equals("Reiniciar juego")) { // Inicio del bloque if para "Reiniciar juego"
				
				JOptionPane.showMessageDialog(null, "Reiniciando todo el tablero...");
				reiniciarJuego();
				
			} // Fin del bloque if para "Reiniciar juego"

		} // Fin del método actionPerformed
		
	} // Fin de la clase ManejadorBotones


//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Este método reinicia el juego limpiando el tablero y restableciendo las variables.
	private void reiniciarJuego() {
		tablero.iniciarTablero();
		jugador = null;
		computadora = null;
		jtAmarilloGanadas.setText(String.valueOf(marcadorAmarillo));
		jtRojoGanadas.setText(String.valueOf(marcadorRojo));
		jtNombreJugador.setEditable(true);
		jbGuardarJugador.setEnabled(true);
		jcJugadorAmarillo.setEnabled(true);
		jcJugadorRojo.setEnabled(true);
		
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		
		// Recorrer todos los componentes en el contenedor
		Component[] components = getContentPane().getComponents();
		
		for (Component component : components) { // Inicio del bucle for
			
			// Verificar si el componente es un botón
			if (component instanceof JButton) { // Inicio del bloque if
				
				JButton boton = (JButton) component;
				// Verificar si el botón es parte del tablero (por ejemplo, si es un botón de las celdas)
				
				if (boton.getX() >= 275 && boton.getX() <= 790 && boton.getY() >= 20 && boton.getY() <= 380) { // Inicio del bloque if
					
					// Si es un botón del tablero, cambiar su icono a la imagen de ficha vacía
					ImageIcon icono = new ImageIcon("Recursos/FichaVacia.png");
					Image imagen = icono.getImage().getScaledInstance(tamanoBoton + 10, tamanoBoton + 6,
							Image.SCALE_SMOOTH);
					boton.setIcon(new ImageIcon(imagen));
					boton.setBackground(null);
					
				} // Fin del bloque if
			} // Fin del bloque if
		} // Fin del bucle for
	} // Fin del método reiniciarJuego

    
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//Jugada computadora
	// Este método realiza una jugada de la computadora en el tablero de juego.
	private void jugadaComputadora (){
		int a, b;
		String coordsP;
		
		//Do-While para generar coordenadas hasta que la jugada sea legal
		do { // Inicio del bloque do-while
			
			Random random = new Random();
			a = random.nextInt(6);
			b = random.nextInt(7);
			coordsP = "(" + a + "," + b + ")";
		
		} while (tablero.verificarMovimiento(a, b)!=true); // Fin del bloque do-while
		
		JButton boton13 = (JButton) getContentPane().getComponentAt(275 + (b * (tamanoBoton + espacioEntreBotones)), 20 + (a * (tamanoBoton + espacioEntreBotones)));
		
		if (colorXjugador.equals("Rojo")) { // Inicio del bloque if para "Rojo"
			
			ImageIcon icono = new ImageIcon("Recursos/FichaAmarilla.png");
			Image imagen = icono.getImage().getScaledInstance(tamanoBoton + 10, tamanoBoton + 6,
				Image.SCALE_SMOOTH);
			boton13.setIcon(new ImageIcon(imagen));
			
		} else {   // Inicio del bloque else
			
			ImageIcon icono = new ImageIcon("Recursos/FichaRojo.png");
			Image imagen = icono.getImage().getScaledInstance(tamanoBoton + 10, tamanoBoton + 6,
					   Image.SCALE_SMOOTH);
			boton13.setIcon(new ImageIcon(imagen));
			
		} // Fin del bloque else
		
		tablero.realizarMovimiento(a, b, computadora);
		turno = colorXjugador;
		
	} // Fin del método jugadaComputadora

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

}// fin del class 
