package modeli;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.AbstractTableModel;

import domen.ElementProizvoda;
/**
 *Klasa koja definise model tabele za obradu elemenata proizvoda.
 *. Nasledjuje {@link AbstractTableModel }.
 * @author Mirjana Dimitrijevic
 */
public class ModelTabeleElementProizvoda extends AbstractTableModel{
	/**
	 * Lista elemenata proizvoda prikazanih u tabeli.
	 */
	ArrayList<ElementProizvoda> lista;
	/**
	 * Nazivi kolona.
	 */
	String[] kolone= {"Materijal","JM","Kolicina"};
	/**
	 * Kreira prazan objekat klase i inicijalizuje listu.
	 */
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
/**
 * Dodaje novi element proizvoda u listu, postavlja njegov
 * identifikator i prikazuje promenu na korisnickom interfejsu.
 * @param ep Element proizvoda koji se dodaje u listu.
 * 
 */
		public void dodajMaterijal(ElementProizvoda ep) {
			ep.setRbr(lista.size()+1);
			lista.add(ep);
			fireTableDataChanged();
		}
		/**
		 * Brise element proizvoda iz liste na osnovu selektovanog reda u tabeli, 
		 * menja identifikatore ostalih elemenata i 
		 *  prikazuje promenu na korisnickom interfejsu.
		 * @param row redni broj reda tabele u kom se nalazi element
		 * koji zelimo da obrisemo.
		 * 
		 */
		public void obrisiMaterijal(int row) {
			for (int i = lista.size()-1; i >row ; i--) {
				lista.get(i).setRbr(lista.get(i).getRbr()-1);
			}
		
			lista.remove(row);
			fireTableDataChanged();

		}
		/**
		 * Vraca listu elemenata proizvoda prikazanih u tabeli.
		 * @return Lista elemenata proizvoda iz tabele.
		 */
		public ArrayList<ElementProizvoda> getLista() {
			return lista;
		}
}
