import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] myArray2 = { 622, 2, 5, 85, 21, 3, 73, 26, 1, 88, 35 };

		Opdracht opdracht1 = new Opdracht();
		opdracht1.aanElkaarPlakken();

		Opdracht opdracht2 = new Opdracht();
		opdracht2.lettersTellen();

		Opdracht opdracht3 = new Opdracht();
		opdracht3.cijfersTellen();

		Opdracht opdracht4 = new Opdracht();
		opdracht4.arraySorteren();

		Opdracht opdracht5 = new Opdracht();
		opdracht5.returnArray(myArray2);

		Auto auto1 = new Auto();
		
		Monteur monteur = new Monteur();
		monteur.repareren(auto1.onderdelen, auto1.maken);

	}

	static class Opdracht {
		void aanElkaarPlakken() {
			System.out.println("Opdracht 1\n\n" + "Po" + "ging" + "en" + "\n" + "---");
		}

		void lettersTellen() {
			System.out.println("Opdracht 2\n");
			String woord = "Regenen";
			int count = 0;
			for (int i = 0; i < woord.length(); i++) {
				if (woord.charAt(i) == 'e') {
					System.out.println(woord.charAt(i));
					count++;
				}
			}
			System.out.println(count + "\n" + "---");
		}

		void cijfersTellen() {
			int sum = 0;
			int[] nummers = { 1, 2, 3, 4, 5 };
			for (int nummer : nummers) {
				sum += nummer;
			}
			System.out.println("Opdracht 3\n\n" + sum + "\n" + "---");
		}

		void arraySorteren() {
			int[] myArray = { 5, 1, 52, 12, 92, 74, 26, 95 };

			System.out.println("Nog niet gesorteerd\n");
			for (int i = 0; i < myArray.length; i++) {
				System.out.println(myArray[i]);
			}
			Arrays.sort(myArray);

			System.out.println("\nGesorteerd\n");
			for (int i = 0; i < myArray.length; i++) {
				System.out.println(myArray[i]);
			}
			System.out.println("\n");
		}

		int[] returnArray(int[] myArray) {
			int i = 0;
			System.out.println("Opdracht 4" + "\n" + "---");
			for (int x = 0; x < 10; x++) {
				boolean done = false;
				for (i = 0; i < myArray.length - 1; i++) {
//				System.out.println(myArray1[i] + " - " + myArray1[i+1]);
					if (myArray[i] > myArray[i + 1]) {
//					System.out.println(myArray1[i] + " - " + myArray1[i+1] + " Swap");
						int getalTemp = myArray[i];
						myArray[i] = myArray[i + 1];
						myArray[i + 1] = getalTemp;
//						System.out.println(myArray1[i] + " - " + myArray1[i + 1]);
					}
				}
			}
			System.out.println(Arrays.toString(myArray));
			return myArray;
		}
		void lettersOpVolgorde() {
			
		}
	}
	static class Auto {
		String[] onderdelen = {"motor", "uitlaat", "deur", "voorruit"};
		boolean[] maken = { false, false, false, false};
	}
	static class Monteur {
		public void repareren(String[] onderdelen, boolean[] maken) {
			System.out.println("\n\nOpdracht 5\n---");
			int kosten = 0;
			for(int i = 0; i < onderdelen.length; i++) {
				if(maken[i] == false) {
					maken[i] = true;
					kosten += 25;
					System.out.println("Gemaakt: " + onderdelen[i] + "kosten: " + kosten);
				}
			}
		}
	}
	
}


	
