package modeli;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import domen.ElementProizvoda;

public class ModelTabeleElementProizvoda extends AbstractTableModel{
	ArrayList<ElementProizvoda> lista;
	String[] kolone= {"Materijal","JM","Kolièina"};

	public ModelTabeleElementProizvoda() {
		lista= new ArrayList<ElementProizvoda>();
		
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
			ElementProizvoda ep=lista.get(rowIndex);
			switch (columnIndex) {
case 0:
				
				return ep.getMaterijal().getNazivMaterijala();
	case 1:
				
				return ep.getJedinicaMere().getNazivJM();	case 2:
					
					return ep.getKolicina();
			default:
				return "return";
			}
		}
}
