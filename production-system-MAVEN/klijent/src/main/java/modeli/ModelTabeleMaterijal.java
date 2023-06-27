package modeli;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import domen.Materijal;

public class ModelTabeleMaterijal extends AbstractTableModel {
ArrayList<Materijal> lista;
String[] kolone= {"Naziv", "Opis", "Kolicina"};

public ModelTabeleMaterijal() {
	lista= new ArrayList<Materijal>();
	
}
	
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	
	
	public int getRowCount() {
	return lista.size();
	}

	public int getColumnCount() {
		return kolone.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Materijal mat=lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			
			return mat.getNazivMaterijala();
case 1:
			
			return mat.getOpisMaterijala();
case 2:
	
	return mat.getKolicinaNaStanju();

		default:
			return "return";
		}
	}

	public void setLista(ArrayList<Materijal> materijali) {
lista= materijali;
fireTableDataChanged();
	}

}
