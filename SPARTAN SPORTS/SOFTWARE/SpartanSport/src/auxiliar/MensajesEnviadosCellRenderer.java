package auxiliar;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import transfer.TransferMensaje;


public class MensajesEnviadosCellRenderer  implements ListCellRenderer<TransferMensaje> {


	@Override
	public Component getListCellRendererComponent(
			JList<? extends TransferMensaje> list, TransferMensaje value, int index,
			boolean isSelected, boolean cellHasFocus) {
		String text = "Para: " + value.getReceptor() + " - Asunto: "+ value.getAsunto() +" - Fecha: " + value.getFecha();
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