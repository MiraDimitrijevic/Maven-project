package modeli;

import java.util.ArrayList;
import java.util.Iterator;

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

		public void dodajMaterijal(ElementProizvoda ep) {
			ep.setRbr(lista.size()+1);
			lista.add(ep);
			fireTableDataChanged();
		}

		public void obrisiMaterijal(int row) {
			for (int i = lista.size()-1; i >row ; i--) {
				lista.get(i).setRbr(lista.get(i).getRbr()-1);
			}
		
			lista.remove(row);
			fireTableDataChanged();

		}
		
		public ArrayList<ElementProizvoda> getLista() {
			return lista;
		}
}
