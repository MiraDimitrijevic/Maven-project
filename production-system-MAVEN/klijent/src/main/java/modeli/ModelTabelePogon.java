package modeli;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import domen.Pogon;

public class ModelTabelePogon extends AbstractTableModel{
	ArrayList<Pogon> lista;
	String[] kolone= {"Grad","Aresa","Kontakt","Datum poèetka rada","Aktivan","Nadležni"};

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

		public void setLista(ArrayList<Pogon> pogoni) {
			lista=pogoni;
			fireTableDataChanged();
		}
}
