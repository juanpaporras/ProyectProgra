import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class InterfazJuego extends JFrame {

    // Se crean las referencias para los botones, etiquetas, campos de textos y
    // demas.
    JButton jbPause, jbSalirJogo, jbGuardarJugador, jbReiniciarJuego;
    JComboBox jcJugadorAmarillo, jcJugadorRojo;
    JTextField jtAmarilloGanadas, jtRojoGanadas, jtNombreJugador, jtTurno;
    JLabel jlJugadorAmarillo, jlJugadorRojo, jlRojoGanadas, jlAmarilloGanadas;
    JLabel jlNombreJugador, jlTurno;
    // ---------------------------------------------------------------------------------------------------

    // Atributos
    private String turno;
    private String seleccionAmarillo[] = { "Computador", "Persona" };
    private String seleccionRojo[] = { "Persona", "Computador" };
    private int tamanoBoton = 60;
    private int espacioEntreBotones = 5;
    private boolean turnoJugador1 = true; // Indica si es el turno del jugador 1
    // ---------------------------------------------------------------------------------------------------

    // Referencias
    private Tablero tablero;
    private Ficha jugador, computadora;
    // ---------------------------------------------------------------------------------------------------

    // Método Constructor
    public InterfazJuego() {
        // Se define el JFrame y sus características
        super("Menu juego");
        setSize(1000, 575);
        setLayout(null);
        getContentPane().setBackground(new Color(127, 127, 127));
        // -----------------------------------------------------------------------------------------------

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
        // ------------------------------------------------------------------------------------------------
        // se crea, la etiqueta de turno y se posiciona.
        jlTurno = new JLabel("Turno del juegador: ");
        jlTurno.setBounds(815, 250, 150, 30);
        add(jlTurno);
        // -----------------------------------------------------------------------------------------------
        // se crea , el campo de texto para jTTurno.
        jtTurno = new JTextField(20);
        jtTurno.setEditable(false);
        jtTurno.setBounds(795, 280, 150, 40);
        add(jtTurno);
        // -----------------------------------------------------------------------------------------------
        // Se crea, posiciona y añade el botón de pausa
        jbPause = new JButton("Boton de Pausa");
        jbPause.setBounds(335, 450, 130, 30);
        add(jbPause);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el botón de salir
        jbSalirJogo = new JButton("Salir del juego");
        jbSalirJogo.setBounds(535, 450, 130, 30);
        add(jbSalirJogo);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el borde izquierdo
        JPanel panelIzquierda = new JPanel();
        panelIzquierda.setBackground(Color.BLACK);
        panelIzquierda.setBounds(245, 0, 5, 1000);
        add(panelIzquierda);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el borde derecho
        JPanel panelDerecha = new JPanel();
        panelDerecha.setBackground(Color.BLACK);
        panelDerecha.setBounds(750, 0, 5, 1000);
        add(panelDerecha);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JLabel "Jugador Amarillo"
        jlJugadorAmarillo = new JLabel("Jugador Azul");
        jlJugadorAmarillo.setBounds(65, 60, 150, 60);
        add(jlJugadorAmarillo);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JLabel "Partidas Ganadas"
        jlAmarilloGanadas = new JLabel("Partidas Ganadas");
        jlAmarilloGanadas.setBounds(50, 110, 150, 60);
        add(jlAmarilloGanadas);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JTextField "Jugadas Ganadas computadoras"
        jtAmarilloGanadas = new JTextField(20);
        jtAmarilloGanadas.setBounds(30, 150, 150, 60);
        add(jtAmarilloGanadas);
        jtAmarilloGanadas.setEditable(false);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JLabel "Jugador 1"
        jlJugadorRojo = new JLabel("Jugador Rojo");
        jlJugadorRojo.setBounds(65, 230, 150, 60);
        add(jlJugadorRojo);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JLabel "Partidas ganadas"
        jlRojoGanadas = new JLabel("Partidas ganadas");
        jlRojoGanadas.setBounds(50, 280, 150, 60);
        add(jlRojoGanadas);
        // -----------------------------------------------------------------------------------------------

        // Se crea, posiciona y añade el JTextField "Jugadas Ganadas jugador"
        jtRojoGanadas = new JTextField(20);
        jtRojoGanadas.setBounds(30, 320, 150, 60);
        add(jtRojoGanadas);
        jtRojoGanadas.setEditable(false);
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
        // -----------------------------------------------------------------------------------------------

        // Se crea el JComboBox de jugador1
        jcJugadorRojo = new JComboBox(seleccionRojo);
        jcJugadorRojo.setBounds(30, 270, 150, 30);
        add(jcJugadorRojo);

        // -----------------------------------------------------------------------------------------------
        // Se crea el botón de reiniciar el juego
        jbReiniciarJuego = new JButton("Reiniciar juego");
        jbReiniciarJuego.setBounds(420, 420, 150, 20);
        add(jbReiniciarJuego);

        // Se crea el JComboBox de jugador2
        jcJugadorAmarillo = new JComboBox(seleccionAmarillo);
        jcJugadorAmarillo.setBounds(30, 100, 150, 30);
        add(jcJugadorAmarillo);

        // Instanciamos el Tablero y los manejadores
        tablero = new Tablero();
        ManejadorBoton manejador = new ManejadorBoton();
        ManejadorJugador manejadorJugador = new ManejadorJugador();

        // Definimos la ventana como visible
        setVisible(true);
        // -----------------------------------------------------------------------------------------------

        // Se concatena el ActionListener
        jbReiniciarJuego.addActionListener(manejador);
        jbPause.addActionListener(manejador);
        jbSalirJogo.addActionListener(manejador);
        jbGuardarJugador.addActionListener(manejadorJugador);
        jcJugadorAmarillo.addActionListener(manejadorJugador);
        jcJugadorRojo.addActionListener(manejadorJugador);
        // -----------------------------------------------------------------------------------------------
    }

    // Manejador de botón
    private class ManejadorBoton implements ActionListener {
        // Referencias
        private ManejadorJugador color;

        public void actionPerformed(ActionEvent accion) {
            // Si se hace clic en un botón de la cuadrícula
            JButton boton = (JButton) accion.getSource();
            String coordenadas = boton.getText();
            String[] coordenadasArray = coordenadas.split(",");
            int fila = Integer.parseInt(coordenadasArray[0].substring(1)); // Obtenemos la fila
            int columna = Integer.parseInt(coordenadasArray[1].substring(0, coordenadasArray[1].length() - 1)); // Obtenemos
                                                                                                                // la
                                                                                                                // columna
            System.out.println(columna);
            if (jugador != null && computadora != null) {
                if (coordenadas.startsWith("(")) {
                    if (turnoJugador1) {
                        turno = "Turno del  en la posición:";
                        jtTurno.setText(turno);
                        boton.setEnabled(false);
                        Toolkit.getDefaultToolkit().beep();
                        boton.setBackground(Color.RED);
                    } else {
                        turno = "Turno del  en la posición: ";
                        jtTurno.setText(turno);
                        boton.setEnabled(false);
                        Toolkit.getDefaultToolkit().beep();
                        boton.setBackground(Color.yellow);
                    }
                    // Alternar el turno
                    turnoJugador1 = !turnoJugador1;

                    // Verificar si hay jugada ganadora
                    // ~ if (){

                    // ~ }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Primero defina los jugadores");
            }
        }
    }

    // Manejador de jugador
    private class ManejadorJugador implements ActionListener {
        // Atributos del manejador
        private String colorXcomputador = "Amarillo", nombreXjugador, colorXjugador = "Rojo";

        public void actionPerformed(ActionEvent accionJC) {

            if (accionJC.getSource() == jcJugadorAmarillo) {
                if (jcJugadorAmarillo.getSelectedItem().equals("Computador")) {
                    jcJugadorRojo.setSelectedItem("Persona");
                    colorXcomputador = "Amarillo";
                    colorXjugador = "Rojo";
                } else if (jcJugadorAmarillo.getSelectedItem().equals("Persona")) {
                    jcJugadorRojo.setSelectedItem("Computador");
                    colorXjugador = "Amarillo";
                    colorXcomputador = "Rojo";
                }
            }
            // -------------------------------------------------------------------------------------------

            if (accionJC.getSource() == jcJugadorRojo) {
                if (jcJugadorRojo.getSelectedItem().equals("Persona")) {
                    jcJugadorAmarillo.setSelectedItem("Computador");
                    colorXjugador = "Rojo";
                    colorXcomputador = "Amarillo";
                } else if (jcJugadorRojo.getSelectedItem().equals("Computador")) {
                    jcJugadorAmarillo.setSelectedItem("Persona");
                    colorXcomputador = "Rojo";
                    colorXjugador = "Amarillo";
                }
            }
            // -------------------------------------------------------------------------------------------

            if (accionJC.getSource() == jbGuardarJugador) {
                if (jtNombreJugador.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Jugador sin nombre");
                } else {
                    nombreXjugador = jtNombreJugador.getText();
                    jugador = new Ficha(colorXjugador, nombreXjugador);
                    computadora = new Ficha(colorXcomputador, "Computador");
                    jtNombreJugador.setEditable(false);
                    jbGuardarJugador.setEnabled(false);
                    JOptionPane.showMessageDialog(null, jugador.getColorFicha() + " || " + jugador.getNombre() + "\n"
                            + computadora.getColorFicha() + " || " + computadora.getNombre());
                }
            }
            // -------------------------------------------------------------------------------------------
        }
    }
    // ---------------------------------------------------------------------------------------------------

    // Main temporal
    public static void main(String[] args) {
        InterfazJuego inter = new InterfazJuego();
    }
}
