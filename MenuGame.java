
//Proyecto grupal
//Juan Pablo Porras Alvarado C36086, Dennis Josue Bustos Soto C31381, Axel Obando Bermudez c25595
// Importaciones
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
public class MenuGame extends JFrame {

	private ImagenComponent Imagenes;

	// Este método inicializa el menú del juego, establece el tamaño de la ventana y
	// carga la imagen de fondo.
	public MenuGame() {
		setLayout(null);
		setTitle("Menú del Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);

		// Parte de la imagen
		try { // Inicio del bloque try

			Image imagen = ImageIO.read(new File("Recursos/Connect4.jpg"));
			Imagenes = new ImagenComponent(imagen);
			Imagenes.setBounds(0, 0, getWidth(), getHeight());
			add(Imagenes);

		} catch (IOException e) { // Inicio del bloque catch

			e.printStackTrace();

		} // Fin del bloque catch

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		JButton btJugar, btSalir;

		// Crear botones
		btJugar = new JButton("Jugar");
		btSalir = new JButton("Salir");

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Establecer posición y tamaño de los botones
		btJugar.setBounds(500, 250, 130, 40);
		btSalir.setBounds(500, 320, 130, 40);

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Agregar botones a la ventana
		add(btJugar);
		add(btSalir);

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		JMenu menuJuego;
		JMenu menuAcercaDe;

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		JMenuItem subMenuEmpezarJuego;
		JMenuItem subMenuAcerca;

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		menuJuego = new JMenu("Reglas");
		menuAcercaDe = new JMenu("Acerca de");

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		subMenuEmpezarJuego = new JMenuItem("Reglas");
		subMenuAcerca = new JMenuItem("Creadores");

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		menuJuego.add(subMenuEmpezarJuego);
		menuAcercaDe.add(subMenuAcerca);

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		JMenuBar barra = new JMenuBar();
		setJMenuBar(barra);
		barra.add(menuJuego);
		barra.add(menuAcercaDe);

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		ManejadorEventoMenu manejadorEventoMenu = new ManejadorEventoMenu();

		subMenuEmpezarJuego.addActionListener(manejadorEventoMenu);
		subMenuAcerca.addActionListener(manejadorEventoMenu);
		btJugar.addActionListener(manejadorEventoMenu);
		btSalir.addActionListener(manejadorEventoMenu);

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				Imagenes.setBounds(0, 0, getWidth(), getHeight());
			}
		});
		setVisible(true);
		repaint();

	} // Fin del constructor MenuGame
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Esta clase privada maneja y almacena la imagen en el componente.

	private class ImagenComponent extends JComponent {
		private Image imagen;

		// Constructor de la clase ImagenComponent
		public ImagenComponent(Image imagen) {
			this.imagen = imagen;
		}

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// En este método, se dibuja la imagen en el componente.
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), this);
			// Esto asegura que la imagen se ajuste al tamaño del componente.
		} // Fin del método paintComponent

	} // Fin de la clase ImagenComponent

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Esta clase maneja las acciones del menú en el juego.
	private class ManejadorEventoMenu implements ActionListener {

		public void actionPerformed(ActionEvent evento) { // Inicio del método actionPerformed

			if (evento.getActionCommand().equals("Salir")) { // Inicio del bloque if para "Salir"

				JOptionPane.showMessageDialog(null, "Saliendo...");
				System.exit(0);

			} // Fin del bloque if para "Salir"

			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			if (evento.getActionCommand().equals("Jugar")) { // Inicio del bloque if para "Jugar"

				new InterfazJuego();

			} // Fin del bloque if para "Jugar"

			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			if (evento.getActionCommand().equals("Reglas")) { // Inicio del bloque if para "Reglas"

				JOptionPane.showMessageDialog(null,
						"Necesitas conectar 4 fichas en una linea vertical, horinzontal o en X para poder ganar");

			} // Fin del bloque if para "Reglas"

			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			if (evento.getActionCommand().equals("Creadores")) { // Inicio del bloque if para "Creadores"

				JOptionPane.showMessageDialog(null,
						"Proyecto Elaborado por:\nJuan Pablo Porras Alvarado C36086 \nAxel Obando Bermudez c25595 \nDennis Josue Bustos Soto C31381\nUniversidad de Costa Rica\nProgramación 1");

			} // Fin del bloque if para "Creadores"
		} // Fin del método actionPerformed

	} // Fin de la clase ManejadorEventoMenu

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void main(String arg[]) {

		new MenuGame();

	}// fin main
}// fin de la class
