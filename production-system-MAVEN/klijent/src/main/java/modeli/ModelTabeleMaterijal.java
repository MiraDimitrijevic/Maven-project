package modeli;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import domen.Materijal;
/**
 *Klasa koja definise model tabele za prikaz materijala koji se nalaze
 *u bazi podataka.
 *. Nasledjuje {@link AbstractTableModel }.
 * @author Mirjana Dimitrijevic
 */
public class ModelTabeleMaterijal extends AbstractTableModel {
	/**
	 * Lista materijala prikazanih u tabeli.
	 */
ArrayList<Materijal> lista;
/**
 * Nazivi kolona.
 */
String[] kolone= {"Naziv", "Opis", "Kolicina"};
/**
 * Kreira prazan objekat klase i inicijalizuje listu.
 */
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
	/**
	 * Postavlja listu materijala na listu materijala preuzetu
	 * iz baze podataka.
	 * @param materijali Lista materijala iz baze podataka.
	 */
	public void setLista(ArrayList<Materijal> materijali) {
lista= materijali;
fireTableDataChanged();
	}

}
