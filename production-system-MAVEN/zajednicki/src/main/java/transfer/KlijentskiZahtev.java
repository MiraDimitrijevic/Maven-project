package transfer;

import java.io.Serializable;

public class KlijentskiZahtev implements Serializable {
private int operacija;
private Object parametar;

public KlijentskiZahtev() {
}  



 
public KlijentskiZahtev(int operacija, Object parametar) {
	super();
	this.operacija = operacija;
	this.parametar = parametar;
}




public Object getParametar() {
	return parametar;
}

public void setOperacija(int operacija) {
	this.operacija = operacija;
}


public void setParametar(Object parametar) {
	this.parametar = parametar;
}

public int getOperacija() {
	return operacija;
}




}
