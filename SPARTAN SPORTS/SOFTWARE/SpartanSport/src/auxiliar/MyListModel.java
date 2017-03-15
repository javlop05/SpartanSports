package auxiliar;

import java.*;
import java.util.List;

import javax.swing.AbstractListModel;

public class MyListModel<T> extends AbstractListModel<T> {

	private List<T> list;
	
	public MyListModel(List<T> list) {
		this.list = list;
	}
	
	@Override
	public T getElementAt(int index) {
		return list.get(index);
	}

	@Override
	public int getSize() {
		return list.size();
	}

}
