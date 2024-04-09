import java.io.*;
import java.util.*;

import Inflacija.Preskupo;
import turizam.Letovanje;
import turizam.Put;
import turizam.Zimovanje;

public class Glavna {
	public static void main(String[] args) {
		try {
			Agencija<Put> agencija = new Agencija<Put>();
			Scanner tast = new Scanner (System.in);
			String slovo;
			while (true) {
				System.out.println("l - letovanje, z - zimovanje, k - kraj");
				slovo = tast.nextLine();
				switch (slovo) {
				case "l":
					System.out.println("Unesi naziv, broj dana i cenu po danu");
					String n = tast.nextLine();
					int b = tast.nextInt();
					double c = tast.nextDouble();
					agencija.dodaj(new Letovanje (n,b,c));
					break;
				case "z":
					System.out.println("Unesi naziv, broj dana, cenu po danu i cenu pass-a");
					String nn = tast.nextLine();
					int bb = tast.nextInt();
					double cc = tast.nextDouble();
					double ce = tast.nextDouble();
					agencija.dodaj(new Zimovanje(nn,bb,cc,ce));
					break;
				case "k":
					System.out.println("Kraj unsa");
					break;
				}
				if(slovo.equals("k")) {
					break;
				}
			}
			agencija.stampa();
			agencija.uvedi_red();
			agencija.stampa();
		}
		catch (Preskupo p) {
			System.out.println(p);
		}
	}
}
