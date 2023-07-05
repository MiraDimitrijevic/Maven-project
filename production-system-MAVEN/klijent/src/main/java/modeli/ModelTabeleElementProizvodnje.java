package modeli;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import domen.ElementProizvodnje;
/**
 *Klasa koja definise model tabele za obradu elemenata proizvodnje.
 *. Nasledjuje {@link AbstractTableModel }.
 * @author Mirjana Dimitrijevic
 */
public class ModelTabeleElementProizvodnje extends AbstractTableModel{
	/**
	 * Lista elemenata proizvodnje prikazanih u tabeli.
	 */
	ArrayList<ElementProizvodnje> lista;
	/**
	 * Nazivi kolona.
	 */
	String[] kolone= {"Proizvod","JM","Kolicina"};
	/**
	 * Kreira prazan objekat klase i inicijalizuje listu.
	 */
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
		/**
		 * Dodaje novi element proizvodnje u listu, postavlja njegov
		 * identifikator i prikazuje promenu na korisnickom interfejsu.
		 * @param epro Element proizvodnje koji se dodaje u listu.
		 * 
		 */
		public void dodajElement(ElementProizvodnje epro) {
			epro.setRbr(lista.size()-1);
			lista.add(epro);
			fireTableDataChanged();
		}
		/**
		 * Brise element proizvodnje iz liste na osnovu selektovanog reda u tabeli, 
		 * menja identifikatore ostalih elemenata i 
		 *  prikazuje promenu na korisnickom interfejsu.
		 * @param row redni broj reda tabele u kom se nalazi element
		 * koji zelimo da obrisemo.
		 * 
		 */
		public void obrisiElement(int row) {
			for (int i = lista.size()-1; i >row ; i--) {
				lista.get(i).setRbr(lista.get(i).getRbr()-1);
			}
		
			lista.remove(row);
			fireTableDataChanged();


			
		}
		/**
		 * Vraca listu elemenata proizvodnje prikazanih u tabeli.
		 * @return Lista elemenata proizvodnje iz tabele.
		 */
		public ArrayList<ElementProizvodnje> getLista() {
			return lista;
		}
}
