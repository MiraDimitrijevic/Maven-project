/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import java.util.ArrayList;

import domen.Materijal;
import konstante.Operacije;
import logika.Komunikacija;
import modeli.ModelTabeleMaterijal;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;


/**
 *Klasa koja predstavlja GKI i sluzi za prikaz svih materijala koji su
 *uneti u sistem, kao i za unos novog materijala.
 *. Nasledjuje {@link javax.swing.JFrame }.
 * @author Mirjana Dimitrijevic
 */
public class MaterijalForma extends javax.swing.JFrame {

    /**
     * Creates new form MaterijalForma
     */
    public MaterijalForma() {
        initComponents();
           setLocationRelativeTo(null);
        setTitle("Materijali");
        tblMaterijali.setModel(new ModelTabeleMaterijal());
        popuniTabelu();
    }
/**
 * Metoda koja popunjava tabelu koja se nalazi na formi sa
 * podacima o svim materijalima koji se nalaze u bazi podataka.
 */
    private void popuniTabelu() {
		ModelTabeleMaterijal mtm= (ModelTabeleMaterijal) tblMaterijali.getModel();
	KlijentskiZahtev kz= new KlijentskiZahtev(Operacije.PRIKAZI_SVE_MATERIJALE, null);
	Komunikacija.getInstance().posaljiZahtev(kz);
	ServerskiOdgovor so= Komunikacija.getInstance().primiOdgovor();
	ArrayList<Materijal> materijali=(ArrayList<Materijal>) so.getOdgovor();
    mtm.setLista(materijali);
    }

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txtKolicina = new javax.swing.JFormattedTextField();
        txtNaziv = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOpis = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMaterijali = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		popuniTabelu();
        	}
        });
        jButton2 = new javax.swing.JButton();
        jButton2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String naziv= txtNaziv.getText();
        		String opis= txtOpis.getText();
        		if(naziv.isEmpty() || opis.isEmpty() || txtKolicina.getText().isEmpty())
        		{
        			JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena!", "Cuvanje nije omoguceno", JOptionPane.WARNING_MESSAGE);
        		return;
        		}
        		double kolicina= Double.valueOf(txtKolicina.getText().replace(',', '.'));
        		Materijal materijal= new Materijal(-1, naziv, opis, kolicina);
        		
        		KlijentskiZahtev kz= new KlijentskiZahtev(Operacije.SACUVAJ_MATERIJAL , materijal);
        		Komunikacija.getInstance().posaljiZahtev(kz);
        		ServerskiOdgovor so= Komunikacija.getInstance().primiOdgovor();
        		if((Boolean) so.getOdgovor()) {
        			JOptionPane.showMessageDialog(null, "Materijal je uspesno sacuvan", "Cuvanje uspesno", JOptionPane.INFORMATION_MESSAGE);

        		} else         			JOptionPane.showMessageDialog(null, "Doslo je do greske, pokusajte ponovo", "Cuvanje nije omoguceno", JOptionPane.ERROR_MESSAGE);

        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtKolicina.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txtOpis.setColumns(20);
        txtOpis.setRows(5);
        jScrollPane1.setViewportView(txtOpis);

        jLabel2.setText("Naziv materijala:");

        jLabel3.setText("Opis materijala:");

        jLabel4.setText(" Kolicina na stanju:");

        tblMaterijali.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblMaterijali);

        jButton1.setText("Osvezi listu materijala");

        jButton2.setText("Dodaj materijal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(jLabel2)
        							.addComponent(jLabel4, Alignment.TRAILING))
        						.addComponent(jLabel3))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(txtNaziv)
        						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtKolicina, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
        					.addGap(0, 0, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(0, 11, Short.MAX_VALUE)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jButton1)
        							.addGap(18)
        							.addComponent(jButton2))
        						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(txtNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(12))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel2)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jLabel3)
        					.addGap(31)))
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(txtKolicina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton1)
        				.addComponent(jButton2))
        			.addContainerGap(36, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

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
            java.util.logging.Logger.getLogger(MaterijalForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaterijalForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaterijalForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaterijalForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaterijalForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMaterijali;
    private javax.swing.JFormattedTextField txtKolicina;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextArea txtOpis;
    // End of variables declaration                   
}
