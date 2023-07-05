package konstante;
/**
 * Interfejs koji sluzi za definisanje operacija nad sistemom.
 * 
 *Interfejs koji definise moguce operacije koje korisnik moze izvoditi nad sistemom.
 * @author Mirjana Dimitrijevic
 *
 */
public interface Operacije {
    /**
     * Operacija za logovanje korisnika sa odgovarajucim korisnickim imenom i lozinkom.
     */
	public static final int LOGIN = 1;
    /**
     * Operacija za registraciju korisnika.
     */
	public static final int REGISTRACIJA = 2;
    /**
     * Operacija kojom se korisniku prikazuju svi materijali koji su uneti u sistem.
     */
	public static final int PRIKAZI_SVE_MATERIJALE = 3;
    /**
     * Operacija za cuvanje podataka o novom materijalu.
     */
	public static final int SACUVAJ_MATERIJAL = 4;
    /**
     * Operacija za prikaz podataka o svim pogonima koji postoje u sistemu.
     */
	public static final int PRIKAZI_SVE_POGONE = 5;
    /**
     * Operacija za prikaz podataka o svim gradovima koji postoje u sistemu.
     */
	public static final int PRIKAZI_SVE_GRADOVE = 6;
    /**
     * Operacija za prikaz podataka o svim korisnicima koji postoje u sistemu.
     */
	public static final int PRIKAZI_SVE_KORISNIKE = 7;
    /**
     * Operacija za cuvanje podataka o novom pogonu.
     */
	public static final int SACUVAJ_POGON = 8;
    /**
     * Operacija za izmenu podataka o pogonu koji je vec unet u sistem.
     */
	public static final int IZMENI_POGON = 9;
    /**
     * Operacija za vracanje svih jedinica mere koje su dostupne u sistemu.
     */
	public static final int PRIKAZI_SVE_JM = 10;
    /**
     * Operacija za cuvanje podataka o novom proizvodu i svim materijalima koji
     * su potrebni za proizvodnju tog proizvoda.
     */
	public static final int SACUVAJ_PROIZVOD = 11;
    /**
     * Operacija za prikaz podataka o svim proizvodima koji postoje u sistemu.
     */
	public static final int PRIKAZI_SVE_PROIZVODE = 12;
    /**
     * Operacija za brisanje podataka o izabranom proizvodu, kao i 
     * podataka o sastavnici tog proizvoda.
     */	
	public static final int OBRISI_PROIZVOD = 13;
    /**
     * Operacija za cuvanje podataka o realizovanoj proizvodnji i svim proizvedenim
     * proizvodima.
     */
	public static final int SACUVAJ_PROIZVODNJU = 14;

}
