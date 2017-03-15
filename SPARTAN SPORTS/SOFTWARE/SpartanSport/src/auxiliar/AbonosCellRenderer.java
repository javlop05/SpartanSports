package auxiliar;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import transfer.TransferAbono;

public class AbonosCellRenderer  implements ListCellRenderer<TransferAbono> {


	@Override
	public Component getListCellRendererComponent(
			JList<? extends TransferAbono> list, TransferAbono value, int index,
			boolean isSelected, boolean cellHasFocus) {
		String text = "Tipo Abono: " +value.getNombre() +" - Dni: "+ value.getDniUsuario()+" - Fecha: " +value.getFechaFinal();
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