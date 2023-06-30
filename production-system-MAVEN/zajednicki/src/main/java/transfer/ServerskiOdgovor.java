package transfer;

import java.io.Serializable;

public class ServerskiOdgovor implements Serializable{
	
private	Object odgovor;
private	String poruka;
	
	

public ServerskiOdgovor() {
}



public ServerskiOdgovor(Object odgovor, String poruka) {
	super();
	this.odgovor = odgovor;
	this.poruka = poruka;
}



public Object getOdgovor() {
	return odgovor;
}



public void setOdgovor(Object odgovor) {
	this.odgovor = odgovor;
}



public String getPoruka() {
	return poruka;
}



public void setPoruka(String poruka) {
	this.poruka = poruka;
}




}
