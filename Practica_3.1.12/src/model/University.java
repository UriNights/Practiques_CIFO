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
Mètodes classe Party (activitats d’oci):
ArrayList de festes, activitats d’oci i locals per zones de la Universitat (afegir, treure, etc ..)
Calcular el preu mig de les entrades dels locals de la zona.
Triar el local més barat amb més serveis.
Mètode static.




Mètodes classe Universitat Restaurant menu:
ArrayList de plats (afegir, treure, etc ..):
Primers
Segons
Postres
Begudes
Crear Menus (amb noms, p.e. Menu Bàsic) de forma aleatòria i assignar preus.
Aplicar descomptes i taxes (fer el compte).
Mètode static.






Mètodes classe UniCard (Restaurant-Bar):
Pagar (restar del saldo, si hi ha saldo) segons el tipus de compra:
Cinc tipus de menus
Cinc productes del bar.
Càrrega de la targeta:
Màxim 300€
Mínim -30€
Pagar a dèbit i a crèdit:
Crèdit del 4%, en terminis mensuals.
Avisar números negatius (afegir un càrreg erroni i aleatori).
Mètode static.
*/