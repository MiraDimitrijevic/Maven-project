package modeli;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import domen.ElementProizvodnje;

public class ModelTabeleElementProizvodnje extends AbstractTableModel{
	ArrayList<ElementProizvodnje> lista;
	String[] kolone= {"Proizvod","JM","Kolièina"};

	public ModelTabeleElementProizvodnje() {
		lista= new ArrayList<ElementProizvodnje>();
		
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
			ElementProizvodnje ep=lista.get(rowIndex);
			switch (columnIndex) {
			case 0:
				
				return ep.getProizvod().getNazivProizvoda();
	case 1:
				
				return ep.getJedinicaMere().getNazivJM();	case 2:
					
					return ep.getKolicina();
			default:
				return "return";
			}
		}
}
