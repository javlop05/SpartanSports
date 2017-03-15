package auxiliar;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import transfer.TransferReserva;
import transfer.TransferUsuario;

public class ReservasCellRenderer  implements ListCellRenderer<TransferReserva> {


	@Override
	public Component getListCellRendererComponent(
			JList<? extends TransferReserva> list, TransferReserva value, int index,
			boolean isSelected, boolean cellHasFocus) {
		String text = "Pista: " +value.getNumPista() + " - Deporte: "+value.getDeporte()+" - Dni: " + value.getDniUsuario() + " - Fecha: " + value.getFecha() +
				" - Hora: " + value.getHora();
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