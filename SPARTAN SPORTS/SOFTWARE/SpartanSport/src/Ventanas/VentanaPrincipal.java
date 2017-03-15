package Ventanas;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VentanaPrincipal extends javax.swing.JFrame {
	
	public VentanaPrincipal () {
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        new VentanaLogin(this);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Logo principal.png")).getImage());
	}
}
