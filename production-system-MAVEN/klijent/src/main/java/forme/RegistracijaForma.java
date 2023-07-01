/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import domen.Korisnik;
import konstante.Operacije;
import logika.Komunikacija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;

/**
 *
 * @author 38169
 */
public class RegistracijaForma extends javax.swing.JFrame {

    /**
     * Creates new form RegistracijaForma
     */
    public RegistracijaForma() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Registracija");
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
        jLabel4 = new javax.swing.JLabel();
        txtImePrezime = new javax.swing.JTextField();
        txtIKorisnickoIme = new javax.swing.JTextField();
        txtRadnoMesto = new javax.swing.JTextField();
        txtLozinka = new javax.swing.JPasswordField();
        btnRegistracija = new javax.swing.JButton();
        btnRegistracija.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String imePrezime=txtImePrezime.getText();
        		String korisnickoIme= txtIKorisnickoIme.getText();
        		String lozinka= String.valueOf(txtLozinka.getText());
        		String rm= txtRadnoMesto.getText();
        		if(imePrezime.isEmpty() || korisnickoIme.isEmpty() || lozinka.isEmpty() || rm.isEmpty())
        		{
        			JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena!", "Registracija nije omogu�ena", JOptionPane.WARNING_MESSAGE);
        		return;
        		}
        		Korisnik korisnik= new Korisnik(-1, imePrezime, korisnickoIme, lozinka, rm);
        		
        		KlijentskiZahtev kz= new KlijentskiZahtev(Operacije.REGISTRACIJA, korisnik);
        		Komunikacija.getInstance().posaljiZahtev(kz);
        		ServerskiOdgovor so= Komunikacija.getInstance().primiOdgovor();
        		boolean uspesno= (Boolean) so.getOdgovor();
        		
        		if(uspesno) JOptionPane.showMessageDialog(null, "Uspe�na registracija!", "Registracija", JOptionPane.INFORMATION_MESSAGE);
        		else {
        			 JOptionPane.showMessageDialog(null, "Korisni�ko ime je zauzeto, poku�ajte da se registrujete sa drugim!", "Registracija", JOptionPane.ERROR_MESSAGE);	
        		}
        	}
        });
        btnPrijava = new javax.swing.JButton();
        btnPrijava.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginForma lf=new LoginForma();
        		lf.setVisible(true);
        	dispose();
        	}
        });
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ime i prezime:");

        jLabel2.setText("Korisni�ko ime:");

        jLabel3.setText("Lozinka:");

        jLabel4.setText("Naziv radnog mesta:");

        btnRegistracija.setText("Registrujte se");

        btnPrijava.setBackground(new java.awt.Color(242, 242, 242));
        btnPrijava.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPrijava.setText("Prijavite se");
        btnPrijava.setBorder(new EmptyBorder(0, 0, 0, 0));

        jLabel5.setText("Imate nalog?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(134)
        					.addComponent(btnRegistracija))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(19)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel5)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btnPrijava, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel1)
        							.addGap(62)
        							.addComponent(txtImePrezime, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel2)
        								.addComponent(jLabel3)
        								.addComponent(jLabel4))
        							.addGap(27)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(txtIKorisnickoIme, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        								.addComponent(txtRadnoMesto, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        								.addComponent(txtLozinka))))))
        			.addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(16)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(txtImePrezime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(13)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(txtIKorisnickoIme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(txtLozinka, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(txtRadnoMesto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(btnRegistracija)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnPrijava, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5))
        			.addContainerGap(15, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(RegistracijaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistracijaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistracijaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistracijaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistracijaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnPrijava;
    private javax.swing.JButton btnRegistracija;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtIKorisnickoIme;
    private javax.swing.JTextField txtImePrezime;
    private javax.swing.JPasswordField txtLozinka;
    private javax.swing.JTextField txtRadnoMesto;
    // End of variables declaration                   
}
