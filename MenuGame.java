//Proyecto grupal
//Juan Pablo Porras Alvarado C36086, Dennis Josue Bustos Soto C31381, Axel Obando Bermudez c25595

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;


// -------------------------------------------------------------------------------------------
public class MenuGame extends JFrame {

    private ImagenComponent Imagenes;

    public MenuGame() {
        setLayout(null);
        setTitle("Menú del Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // parte imagen
        try {
			
            Image imagen = ImageIO.read(new File("Recursos/Connect4.jpg"));
            Imagenes = new ImagenComponent(imagen);
            Imagenes.setBounds(0, 0, getWidth(), getHeight());
            add(Imagenes);
            
        } catch (IOException e) {
			
            e.printStackTrace();
            
        }
        // -------------------------------------------------------------------------------------------

        JButton btJugar, btSalir;

        // Crear botones
        btJugar = new JButton("Jugar");
        btSalir = new JButton("Salir");
        // -------------------------------------------------------------------------------------------
        
        // Establecer posición y tamaño de los botones
        btJugar.setBounds(500, 250, 130, 40);
        btSalir.setBounds(500, 320, 130, 40);
        // -------------------------------------------------------------------------------------------

        // Agregar botones a la ventana
        add(btJugar);
        add(btSalir);
        // -------------------------------------------------------------------------------------------

        JMenu menuJuego;
        JMenu menuAcercaDe;
        // -------------------------------------------------------------------------------------------

        JMenuItem subMenuEmpezarJuego;
        JMenuItem subMenuAcerca;
        // -------------------------------------------------------------------------------------------

        menuJuego = new JMenu("Reglas");
        menuAcercaDe = new JMenu("Acerca de");
        // -------------------------------------------------------------------------------------------

        subMenuEmpezarJuego = new JMenuItem("Reglas");
        subMenuAcerca = new JMenuItem("Creadores");
        // -------------------------------------------------------------------------------------------

        menuJuego.add(subMenuEmpezarJuego);
        menuAcercaDe.add(subMenuAcerca);
        // -------------------------------------------------------------------------------------------

        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra);
        barra.add(menuJuego);
        barra.add(menuAcercaDe);
        // -------------------------------------------------------------------------------------------

        ManejadorEventoMenu manejadorEventoMenu = new ManejadorEventoMenu();

        subMenuEmpezarJuego.addActionListener(manejadorEventoMenu);
        subMenuAcerca.addActionListener(manejadorEventoMenu);
        btJugar.addActionListener(manejadorEventoMenu);
        btSalir.addActionListener(manejadorEventoMenu);
        // -------------------------------------------------------------------------------------------

        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                Imagenes.setBounds(0, 0, getWidth(), getHeight());
            }
        });
        setVisible(true);
        repaint();
    }
    // -------------------------------------------------------------------------------------------

    // clase privada para manejar y almacenar la imagen
    private class ImagenComponent extends JComponent {
        private Image imagen;

        public ImagenComponent(Image imagen) {
            this.imagen = imagen;
        }

        // -------------------------------------------------------------------------------------------

        // En este método, se dibuja la imagen en el componente.
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), this);
            // Esto asegura que la imagen se ajuste al tamaño del componente.
        }
    }
    // -------------------------------------------------------------------------------------------

    private class ManejadorEventoMenu implements ActionListener {
       
        public void actionPerformed(ActionEvent evento) {
			
            if (evento.getActionCommand().equals("Salir")) {
				
                JOptionPane.showMessageDialog(null, "Saliendo...");
                System.exit(0);
            }
            
            if (evento.getActionCommand().equals("Jugar")) {
				
                new InterfazJuego();
            }
            
            if (evento.getActionCommand().equals("Reglas")) {
				
                JOptionPane.showMessageDialog(null,"Necesitas conectar 4 fichas en una linea vertical, horinzontal o en X para poder ganar");
                        
			}
			
            if (evento.getActionCommand().equals("Creadores")) {
				
                JOptionPane.showMessageDialog(null,
                        "Proyecto Elaborado por:\nJuan Pablo Porras Alvarado C36086 \nAxel Obando Bermudez c25595 \nDennis Josue Bustos Soto C31381\nUniversidad de Costa Rica\nProgramación 1");
                        
            }
        }
    }

    // -------------------------------------------------------------------------------------------
    public static void main(String arg[]) {
        new MenuGame();
    }
}
