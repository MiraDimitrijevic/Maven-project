package modeli;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import domen.Proizvod;
/**
 *Klasa koja definise model tabele za obradu proizvoda koji se nalaze
 *u bazi podataka.
 *. Nasledjuje {@link AbstractTableModel }.
 * @author Mirjana Dimitrijevic
 */
public class ModelTabeleProizvod extends AbstractTableModel{
	/**
	 * Lista proizvoda prikazanih u tabeli.
	 */
	ArrayList<Proizvod> lista;
	/**
	 * Nazivi kolona.
	 */
	String[] kolone= {"Naziv","Opis","Kolicina","Patent","Vek trajanja (mesec)","Datum pocetka proizvodnje"};
	/**
	 * Kreira prazan objekat klase i inicijalizuje listu.
	 */
	public ModelTabeleProizvod() {
		lista= new ArrayList<Proizvod>();
		
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
			Proizvod pr=lista.get(rowIndex);
			switch (columnIndex) {
			case 0:
				
				return pr.getNazivProizvoda();
	case 1:
				
				return pr.getOpisProizvoda();
	case 2:
		
		return pr.getKolicinaNaStanju();
	case 3:
		
		return pr.isPatent();
	case 4:
		
		return pr.getVekTrajanjaUMesecima();
	case 5:
		
		return pr.getDatumPocetkaProizvodnje();

			default:
				return "return";
			}
		}
/**
 * Postavlja listu proizvoda na listu proizvoda preuzetu
 * iz baze podataka.
 * @param proizvodi Lista proizvoda iz baze podataka.
 */
		public void setLista(ArrayList<Proizvod> proizvodi) {
			lista= proizvodi;
			fireTableDataChanged();
		}
/**
 * Vraca proizvod koji se nalazi u selektovanom redu u tabeli.
 * @param row Redni broj reda u tabeli.
 * @return Proizvod koji se nalazi u odgovarajucem redu u tabeli.
 */
		public Proizvod getProizvod(int row) {
			return lista.get(row);
		}
}
