package turizam;

import java.io.*;

public class Letovanje implements Put, Comparable<Put> {
	
	private String naziv;
	private int broj_dana;
	private double cena_po_danu;
	
	public Letovanje(String n, int b, double c) {
		naziv = n;
		broj_dana = b;
		cena_po_danu = c;
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
		
		return (cena_po_danu * broj_dana * (Math.random() + 1));
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
