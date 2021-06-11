// Factory Pattern
// je maakt een gerecht functie maar waarvan je nog niet weet welk gerecht het gaat worden. Hiervoor maak je een interface aan met een abstracte functie
// interface & abstracte functie - implements
// bouwen
// restaurant

public class factory {
	public static void main(String[] args) {
		GerechtFactory gerechtFactory = new GerechtFactory();
		Gerecht gerecht1 = gerechtFactory.getGerecht("Pizza");
		gerecht1.maakGerecht();
		Gerecht gerecht2 = gerechtFactory.getGerecht("Pasta");
		gerecht2.maakGerecht();
		Gerecht gerecht3 = gerechtFactory.getGerecht("Patat");
		gerecht3.maakGerecht();
		Gerecht gerecht4 = gerechtFactory.getGerecht("Pudding");
		gerecht4.maakGerecht();
	
	}
}

interface Gerecht {
	void maakGerecht();
}

class Pizza implements Gerecht {
	
	@Override
	public void maakGerecht() {
		System.out.println("Pizza komt eraan");
	}
}

class Pasta implements Gerecht {
	
	@Override
	public void maakGerecht() {
		System.out.println("Pasta komt eraan");
	}
}

class Patat implements Gerecht {
	
	@Override
	public void maakGerecht() {
		System.out.println("Patat komt eraan");
	}
}

class Pudding implements Gerecht {
	
	@Override
	public void maakGerecht() {
		System.out.println("Pudding komt eraan");
	}
}

class GerechtFactory {
	public Gerecht getGerecht(String gerechtType) {
		if (gerechtType == null) {
			return null;
		}
		if (gerechtType.equalsIgnoreCase("Pizza")) {
			return new Pizza();
			
		} else if (gerechtType.equalsIgnoreCase("Pasta")) {
			return new Pasta();
			
		} else if (gerechtType.equalsIgnoreCase("Patat")) {
			return new Patat();
			
		} else if (gerechtType.equalsIgnoreCase("Pudding")) {
			return new Pudding();
			
		}
		
		return null;
	}
}