import java.io.*;
import java.util.*;

import Inflacija.Preskupo;
import turizam.*;

public class Agencija <T extends Put> {
	private ArrayList<T> putevi;
	private int trenutno;
	private int max_broj;
	
	Agencija(){
		trenutno = 0;
		putevi = new ArrayList<>();
	}
	
	public void dodaj(T el) {
		putevi.add(el);
	}
	
	public void uvedi_red() throws Preskupo {
		putevi.sort(null);
		if(putevi.get(putevi.size() - 1).vrati_cenu() > 2000) {
			throw new Preskupo("Cena prelazi preko 2000 evra!");
		}
		for(int i=0;i<putevi.size();i++) {
			putevi.get(i).upisi();
		}
		putevi.get(putevi.size() - 1).binarni_upis();
	}
	
	public void stampa() {
		for(int i=0;i<putevi.size();i++) {
			System.out.println(putevi.get(i).getNaziv());
		}
	}
}
