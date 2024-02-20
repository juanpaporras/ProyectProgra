//Proyecto Grupal

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
public class MenuGame extends JFrame {

    

    private JLabel label;
    public MenuGame() {
        setTitle("Menú del Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // parte imagen 
        label = new JLabel();
        adaptarTamanioImagen("Recursos/Connect4.jpg");
        add(label);

        JMenu menuSalir;
        JMenu menuJuego;
        JMenu menuAcercaDe;

        JMenuItem subMenuSalir;
        JMenuItem subMenuEmpezarJuego;
        JMenuItem subMenuReglas;
        JMenuItem subMenuMusica;
        JMenuItem subMenuAcerca;

        menuSalir = new JMenu("Salir");
        menuJuego = new JMenu("Reglas Y Juego");
        menuAcercaDe=new JMenu("Acerca de");

        subMenuSalir = new JMenuItem("Salir");
        subMenuEmpezarJuego = new JMenuItem("Reglas");
        subMenuReglas = new JMenuItem("Juego");
        subMenuMusica = new JMenuItem("Reproducir Música");
        subMenuAcerca = new JMenuItem("Creadores");

        menuSalir.add(subMenuSalir);
        menuJuego.add(subMenuEmpezarJuego);
        menuJuego.add(subMenuReglas);
        menuJuego.add(subMenuMusica);
        menuAcercaDe.add(subMenuAcerca);

        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra);
        barra.add(menuSalir);
        barra.add(menuJuego);
        barra.add(menuAcercaDe);

        ManejadorEventoMenu manejadorEventoMenu = new ManejadorEventoMenu();
        subMenuSalir.addActionListener(manejadorEventoMenu);
        subMenuEmpezarJuego.addActionListener(manejadorEventoMenu);
        subMenuReglas.addActionListener(manejadorEventoMenu);
        subMenuMusica.addActionListener(manejadorEventoMenu);
        subMenuAcerca.addActionListener(manejadorEventoMenu);

        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                adaptarTamanioImagen("Recursos/Connect4.jpg");
            }
        });
        setVisible(true);
    }

    private void adaptarTamanioImagen(String ruta) {
        int anchoVentana = getWidth();
        int altoVentana = getHeight();
        ImageIcon icono = new ImageIcon(ruta);
        Image imagen = icono.getImage().getScaledInstance(anchoVentana, altoVentana, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(imagen));
    }

    private class ManejadorEventoMenu implements ActionListener {
        public void actionPerformed(ActionEvent evento) {
            if (evento.getActionCommand().equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Saliendo...");
                System.exit(0);
            }
            if (evento.getActionCommand().equals("Juego")) {
                  new InterfazJuego();
            }
            if (evento.getActionCommand().equals("Reglas")) {
                JOptionPane.showMessageDialog(rootPane, "Necesitas conectar 4 fichas en una linea para poder ganar\n               Intenta evitar los ataques de tu enemigo \n                                        !Suerte!");
            }
            if (evento.getActionCommand().equals("Creadores")) {
                JOptionPane.showMessageDialog(rootPane, "Proyecto Elaborado por:\nJuan Pablo Porras Alvarado C36086 \nJordy Steven Ramirez Esquivel C36395\nUniversidad de Costa Rica\nProgramación 1");
            }
        }
    }
    public static void main(String arg[]) {
        new MenuGame();
    }
}
