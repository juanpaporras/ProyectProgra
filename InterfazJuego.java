import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class InterfazJuego extends JFrame {
    JButton jbPause, jbSalirJogo;
    JLabel jlComputadorInfo, jlJugadorInfo, jlJugadorGanadas, jlComputadorGanadas;
    JTextField jtComputadorGanadas, jtJugadorGanadas;
    JComboBox jcIzquierda,jcDerecha;
    String personasIzquierda[] = {"Computador","Persona"};
    String personasDerecha[]={"Computador","Persona"};
    private int tamanoBoton = 60;
    private int espacioEntreBotones = 5;
    private boolean turnoJugador1 = true; // Indica si es el turno del jugador 1

    public InterfazJuego() {
        super("Menu juego");
        setSize(1000, 575);
        setLayout(null);
        getContentPane().setBackground(new Color(127, 127, 127));

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

        jbPause = new JButton("Boton de Pausa"); // Establecer el texto del botón de pausa
        jbPause.setBounds(335, 450, 130, 30);
        add(jbPause);

        jbSalirJogo = new JButton("Salir del juego"); // Establecer el texto del botón de salir
        jbSalirJogo.setBounds(535, 450, 130, 30);
        add(jbSalirJogo);

        //raya izquierda
        JPanel panelIzquierda = new JPanel();
        panelIzquierda.setBackground(Color.BLACK);
        panelIzquierda.setBounds(245, 0, 5, 1000);
        add(panelIzquierda);
        //raya derecha
        JPanel panelDerecha = new JPanel();
        panelDerecha.setBackground(Color.BLACK);
        panelDerecha.setBounds(750, 0, 5, 1000);
        add(panelDerecha);
        // label izquierda
        jlComputadorInfo = new JLabel("Jugador Computadora");
        jlComputadorInfo.setBounds(50, 60, 150, 60);
        add(jlComputadorInfo);
        jlComputadorGanadas = new JLabel("Partidas Ganadas");
        jlComputadorGanadas.setBounds(50, 80, 150, 60);
        add(jlComputadorGanadas);
        // label derecha
        jlJugadorInfo = new JLabel("Jugador 1");
        jlJugadorInfo.setBounds(830, 60, 150, 60);
        add(jlJugadorInfo);
        jlJugadorGanadas = new JLabel("Partidas ganadas");
        jlJugadorGanadas.setBounds(830, 80, 150, 60);
        add(jlJugadorGanadas);
        // jtext derecha
        jtJugadorGanadas = new JTextField(20);
        jtJugadorGanadas.setBounds(800, 120, 150, 60);
        add(jtJugadorGanadas);
        jtJugadorGanadas.setEditable(false);
        // jtext izquierda
        jtComputadorGanadas = new JTextField(20);
        jtComputadorGanadas.setBounds(30, 120, 150, 60);
        add(jtComputadorGanadas);
        jtComputadorGanadas.setEditable(false);
        // jcombo de la izquierda 
        jcIzquierda = new JComboBox(personasIzquierda);
        jcIzquierda.setBounds(30, 195, 140, 30);
        jcIzquierda.setMaximumRowCount(2);
        add(jcIzquierda);
        // jcombo de la derecha
        jcDerecha= new JComboBox(personasDerecha);
        jcDerecha.setBounds(800,195,140,30);
        jcIzquierda.setMaximumRowCount(2);
        add(jcDerecha);

        setVisible(true);

        jbPause.addActionListener(new ManejadorBoton());
        jbSalirJogo.addActionListener(new ManejadorBoton());
    }

    private class ManejadorBoton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Boton de Pausa")) {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
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
                JOptionPane.showMessageDialog(null,"meJHJRHU en ");
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
