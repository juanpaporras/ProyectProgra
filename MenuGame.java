
// importaciones
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

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
                JOptionPane.showMessageDialog(rootPane,
                        "Necesitas conectar 4 fichas en una linea para poder ganar\n               Intenta evitar los ataques de tu enemigo \n                                        !Suerte!");
            }
            if (evento.getActionCommand().equals("Creadores")) {
                JOptionPane.showMessageDialog(rootPane,
                        "Proyecto Elaborado por:\nJuan Pablo Porras Alvarado C36086 \nAxel Obando Bermudez c25595 \nDennis Josué Bustos Soto C31381\nUniversidad de Costa Rica\nProgramación 1");
            }
        }
    }

    // -------------------------------------------------------------------------------------------
    public static void main(String arg[]) {
        new MenuGame();
    }
}
