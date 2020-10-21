package model;

public class University {
	
	private String name;
	private String country;
	private String city;
	
	public University(String name, String country, String city) {
		
		this.name = name;
		this.country = country;
		this.city = city;
	}
}

/*
M�todes classe Party (activitats d�oci):
ArrayList de festes, activitats d�oci i locals per zones de la Universitat (afegir, treure, etc ..)
Calcular el preu mig de les entrades dels locals de la zona.
Triar el local m�s barat amb m�s serveis.
M�tode static.




M�todes classe Universitat Restaurant menu:
ArrayList de plats (afegir, treure, etc ..):
Primers
Segons
Postres
Begudes
Crear Menus (amb noms, p.e. Menu B�sic) de forma aleat�ria i assignar preus.
Aplicar descomptes i taxes (fer el compte).
M�tode static.






M�todes classe UniCard (Restaurant-Bar):
Pagar (restar del saldo, si hi ha saldo) segons el tipus de compra:
Cinc tipus de menus
Cinc productes del bar.
C�rrega de la targeta:
M�xim 300�
M�nim -30�
Pagar a d�bit i a cr�dit:
Cr�dit del 4%, en terminis mensuals.
Avisar n�meros negatius (afegir un c�rreg erroni i aleatori).
M�tode static.
*/