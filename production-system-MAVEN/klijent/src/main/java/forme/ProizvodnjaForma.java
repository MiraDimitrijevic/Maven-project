/*
 */
package forme;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import domen.ElementProizvodnje;
import domen.JedinicaMere;
import domen.Korisnik;
import domen.Materijal;
import domen.Pogon;
import domen.Proizvod;
import domen.Proizvodnja;
import konstante.Operacije;
import logika.Komunikacija;
import modeli.ModelTabeleElementProizvoda;
import modeli.ModelTabeleElementProizvodnje;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

/**
 *Klasa koja predstavlja GKI i sluzi za unos nove
 *proizvodnje u bazu podataka, kao i svih elemenata koji ce
 *se u toj seriji proizvoditi.
 *. Nasledjuje {@link javax.swing.JFrame }.
 * @author Mirjana Dimitrijevic
 */
public class ProizvodnjaForma extends javax.swing.JFrame {
	/**
	 * Korisnik koji manipulise formom.
	 */
Korisnik kor;
    /**
     * Creates new form ProizvodnjaForma
     */
    public ProizvodnjaForma() {
        initComponents();
           setLocationRelativeTo(null);
        setTitle("Proizvodnja");
        popuniProizvode();
        popuniJediniceMere();
        popuniPogone();
        jTable1.setModel(new ModelTabeleElementProizvodnje());
        
    }
	/**
	 * Metoda koja popunjava combobox sa podacima o svim pogonima,
	 * koji su uzeti iz baze podataka.
	 */
    private void popuniPogone() {
    	cmbPogon.removeAllItems();
		KlijentskiZahtev kz= new KlijentskiZahtev(Operacije.PRIKAZI_SVE_POGONE, null);
		Komunikacija.getInstance().posaljiZahtev(kz);
		ServerskiOdgovor so= Komunikacija.getInstance().primiOdgovor();
		ArrayList<Pogon> pogoni= (ArrayList<Pogon>) so.getOdgovor();
		for (Pogon pogon : pogoni) {
			cmbPogon.addItem(pogon);
		}
	}
	/**
	 * Metoda koja popunjava combobox sa podacima o svim jedinicama mere,
	 * koji su uzeti iz baze podataka.
	 */
	private void popuniJediniceMere() {
    	cmbJM.removeAllItems();
		KlijentskiZahtev kz= new KlijentskiZahtev(Operacije.PRIKAZI_SVE_JM, null);
		Komunikacija.getInstance().posaljiZahtev(kz);
		ServerskiOdgovor so= Komunikacija.getInstance().primiOdgovor();
		ArrayList<JedinicaMere> jms=(ArrayList<JedinicaMere>) so.getOdgovor();
	for (JedinicaMere jedinicaMere : jms) {
		cmbJM.addItem(jedinicaMere);
	}		
	}
	/**
	 * Metoda koja popunjava combobox sa podacima o svim proizvodima,
	 * koji su uzeti iz baze podataka.
	 */
	private void popuniProizvode() {
		cmbProizvod.removeAllItems();
		KlijentskiZahtev kz= new KlijentskiZahtev(Operacije.PRIKAZI_SVE_PROIZVODE, null);
		Komunikacija.getInstance().posaljiZahtev(kz);
		ServerskiOdgovor so= Komunikacija.getInstance().primiOdgovor();
		ArrayList<Proizvod> proizvodi=(ArrayList<Proizvod>) so.getOdgovor();
		for (Proizvod proizvod : proizvodi) {
			cmbProizvod.addItem(proizvod);
		}
	}

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtKolPro = new javax.swing.JFormattedTextField();
        cmbProizvod = new javax.swing.JComboBox();
        cmbJM = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDVpoc = new javax.swing.JFormattedTextField();
        txtDVzav = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbPogon = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(txtKolPro.getText().isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena!", "Dodavanje materijala nije omoguceno", JOptionPane.WARNING_MESSAGE);
        		return;
        		}
        	JedinicaMere jm= (JedinicaMere) cmbJM.getSelectedItem();
        	Proizvod pro= (Proizvod) cmbProizvod.getSelectedItem();
        	double kolicina= Double.valueOf(txtKolPro.getText().replace(',', '.'));
        	
        	ElementProizvodnje epro= new ElementProizvodnje(null, -1, pro, jm, kolicina);
        	ModelTabeleElementProizvodnje mtep= (ModelTabeleElementProizvodnje) jTable1.getModel();
        	mtep.dodajElement(epro);
        	}
        });
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int row= jTable1.getSelectedRow();
        		if(row!=-1) {
        			ModelTabeleElementProizvodnje mtep= (ModelTabeleElementProizvodnje) jTable1.getModel();
        		    mtep.obrisiElement(row);
        		}
        	}
        });
        jButton3 = new javax.swing.JButton();
        jButton3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Pogon pogon= (Pogon) cmbPogon.getSelectedItem();
        		SimpleDateFormat sdf= new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        		try {
        			if(txtDVpoc.getText().isEmpty() || txtDVzav.getText().isEmpty()) {
        				JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena!", "Cuvanje nije omoguceno", JOptionPane.WARNING_MESSAGE);
                		return;
        			}
					Date datumVremePoc= sdf.parse(txtDVpoc.getText());
					Date datumVremeZav= sdf.parse(txtDVzav.getText());
        			ModelTabeleElementProizvodnje mtep= (ModelTabeleElementProizvodnje) jTable1.getModel();

					Proizvodnja proizvodnja= new Proizvodnja(-1, datumVremePoc, datumVremeZav, pogon, kor, mtep.getLista());
					KlijentskiZahtev kz= new KlijentskiZahtev(Operacije.SACUVAJ_PROIZVODNJU, proizvodnja);
					Komunikacija.getInstance().posaljiZahtev(kz);
					ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
					if((Boolean) so.getOdgovor()) {
	        			JOptionPane.showMessageDialog(null, "Proizvodnja je uspesno sacuvana", "Cuvanje uspesno", JOptionPane.INFORMATION_MESSAGE);

	        		} else         			JOptionPane.showMessageDialog(null, "Doslo je do greske, pokusajte ponovo", "Cuvanje nije omoguceno", JOptionPane.ERROR_MESSAGE);

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Proizvod:");

        jLabel2.setText("Jedinica mere:");

        jLabel3.setText("Kolicina:");

        txtKolPro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        cmbProizvod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbJM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Datum i vreme pocetka proizvodnje:");

        jLabel5.setText("Datum i vreme zavrsetka proizvodnje:");

        txtDVpoc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm:ss"))));

        txtDVzav.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm:ss"))));

        jLabel6.setText("Pogon:");

        cmbPogon.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Dodaj proizvod");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Izbrisi proizvod");

        jButton3.setText("Sacuvaj proizvodnju");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDVpoc))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDVzav))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbPogon, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtKolPro, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbJM, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2)
                                        .addGap(46, 46, 46))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(119, 119, 119)
                                    .addComponent(cmbProizvod, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel1))))
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jButton3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDVpoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDVzav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cmbPogon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProizvod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbJM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKolPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProizvodnjaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProizvodnjaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProizvodnjaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProizvodnjaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProizvodnjaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox cmbJM;
    private javax.swing.JComboBox cmbPogon;
    private javax.swing.JComboBox cmbProizvod;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JFormattedTextField txtDVpoc;
    private javax.swing.JFormattedTextField txtDVzav;
    private javax.swing.JFormattedTextField txtKolPro;
    // End of variables declaration     
    /**
     * Metoda koja postavlja podatke o ulogovanom korisniku.
     * @param korisnik Ulogovani korisnik.
     */
	public void setKorisnik(Korisnik korisnik) {
this.kor=korisnik;		
	}
}
