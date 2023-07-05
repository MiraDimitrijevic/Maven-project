package modeli;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import domen.Pogon;
/**
 *Klasa koja definise model tabele za obradu pogona koji se nalaze
 *u bazi podataka.
 *. Nasledjuje {@link AbstractTableModel }.
 * @author Mirjana Dimitrijevic
 */
public class ModelTabelePogon extends AbstractTableModel{
	/**
	 * Lista pogona prikazanih u tabeli.
	 */
	ArrayList<Pogon> lista;
	/**
	 * Nazivi kolona.
	 */
	String[] kolone= {"Grad","Aresa","Kontakt","Datum pocetka rada","Aktivan","Nadlezni"};
	/**
	 * Kreira prazan objekat klase i inicijalizuje listu.
	 */
	public ModelTabelePogon() {
		lista= new ArrayList<Pogon>();
		
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
			Pogon pog=lista.get(rowIndex);
			switch (columnIndex) {
case 0:
				
				return pog.getGrad();
				case 1:
					
					return pog.getAdresa();
					case 2:
						
						return pog.getKontakt();
						case 3:
							
							return pog.getDatumPocetkaRada();
							case 4:
								
								return pog.isAktivan();
								case 5:
									
									return pog.getKorisnik();

			default:
				return "return";
			}
		}
		/**
		 * Postavlja listu pogona na listu pogona preuzetu
		 * iz baze podataka.
		 * @param pogoni Lista pogona iz baze podataka.
		 */
		public void setLista(ArrayList<Pogon> pogoni) {
			lista=pogoni;
			fireTableDataChanged();
		}
		/**
		 * Vraca pogon koji se nalazi u selektovanom redu u tabeli.
		 * @param row Redni broj reda u tabeli.
		 * @return Pogon koji se nalazi u odgovarajucem redu u tabeli.
		 */
		public Pogon getPogon(int row) {
			return lista.get(row);
		}
}
