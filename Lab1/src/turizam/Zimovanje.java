package turizam;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Zimovanje implements Put, Comparable<Put> {

	private String naziv;
	private int broj_dana;
	private double cena_po_danu;
	private double cena_pass_po_danu;
	
	public Zimovanje(String n, int b, double c, double cc){
		naziv = n;
		broj_dana = b;
		cena_po_danu = c;
		cena_pass_po_danu = cc;
	}

	public int compareTo(Put o) {

		if(vrati_cenu() > o.vrati_cenu()) {
			return 1;
		}
		if(vrati_cenu() < o.vrati_cenu()) {
			return -1;
		}
		else {
			return 0;
		}
	}


	public double vrati_cenu() {

		return (cena_po_danu * broj_dana + cena_pass_po_danu * (broj_dana - 2));
	}


	public void upisi() {
		try {
			String datotetak = String.valueOf(vrati_cenu());
			FileWriter f = new FileWriter (datotetak + ".txt");
			BufferedWriter b = new BufferedWriter (f);
			String[] rec = naziv.split(" ");
			b.write(rec[0]);
			b.newLine();
			b.close();
			}
			catch (IOException izuz) {
				System.out.println("Pojavio se izuzetak" + izuz);
			}
		
	}
	
	public void binarni_upis() {
		try {
			FileOutputStream f = new FileOutputStream("ekskluziva.bin");
			BufferedOutputStream b = new BufferedOutputStream (f);
			DataOutputStream d = new DataOutputStream (b);
			d.writeDouble(vrati_cenu());
			d.close();
			}
			catch (IOException izuz) {
				System.out.println("Pojavio se izuzetak" + izuz);
			}
	}
	
	public String getNaziv() {
		return naziv;
	}
}
