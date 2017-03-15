package auxiliar;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import transfer.TransferUsuario;

public class UsuariosCellRender  implements ListCellRenderer<TransferUsuario> {


	@Override
	public Component getListCellRendererComponent(JList<? extends TransferUsuario> list, TransferUsuario value, int index,
			boolean isSelected, boolean cellHasFocus) {
		String text = "Nombre: " +value.getNombre() + " - Dni: " + value.getDni();
		JLabel etiqueta;
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		if(isSelected){
			panel.setBackground(list.getSelectionBackground());
			panel.setForeground(list.getSelectionForeground());
		}
		else {
			panel.setBackground(list.getBackground());
			panel.setForeground(list.getForeground());
		}
		etiqueta = new JLabel(text);
		panel.add(etiqueta);


		return panel;
	}
}