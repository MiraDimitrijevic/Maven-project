package modeli;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import domen.Proizvod;

public class ModelTabeleProizvod extends AbstractTableModel{
	ArrayList<Proizvod> lista;
	String[] kolone= {"Naziv","Opis","Kolièina","Patent","Vek trajanja (mesec)","Datum poèetka proizvodnje"};

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

		public void setLista(ArrayList<Proizvod> proizvodi) {
			lista= proizvodi;
			fireTableDataChanged();
		}

		public Proizvod getProizvod(int row) {
			return lista.get(row);
		}
}
