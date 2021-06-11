import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		int[] myArray2 = { 622, 2, 5, 85, 21, 3, 73, 26, 1, 88, 35 };
//
//		Opdracht opdracht1 = new Opdracht();
//		opdracht1.aanElkaarPlakken();
//
//		Opdracht opdracht2 = new Opdracht();
//		opdracht2.lettersTellen();
//
//		Opdracht opdracht3 = new Opdracht();
//		opdracht3.cijfersTellen();
//
//		Opdracht opdracht4 = new Opdracht();
//		opdracht4.arraySorteren();
//
//		Opdracht opdracht5 = new Opdracht();
//		opdracht5.returnArray(myArray2);
//
//		Auto auto1 = new Auto();
//		
//		Monteur monteur = new Monteur();
//		monteur.repareren(auto1.onderdelen, auto1.maken);
//	    
//	    Sort sort = new Sort();
//	    sort.woordPrinten();
	    
	    Lingo lingo = new Lingo();
	    lingo.spelen();
	}
}


class Opdracht {
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
//			System.out.println(myArray1[i] + " - " + myArray1[i+1]);
				if (myArray[i] > myArray[i + 1]) {
//				System.out.println(myArray1[i] + " - " + myArray1[i+1] + " Swap");
					int getalTemp = myArray[i];
					myArray[i] = myArray[i + 1];
					myArray[i + 1] = getalTemp;
//					System.out.println(myArray1[i] + " - " + myArray1[i + 1]);
				}
			}
		}
		System.out.println(Arrays.toString(myArray));
		return myArray;
	}
	void lettersOpVolgorde() {
		
	}
}
class Auto {
	String[] onderdelen = {"motor", "uitlaat", "deur", "voorruit"};
	boolean[] maken = { false, false, false, false};
} 
class Monteur {
	public void repareren(String[] onderdelen, boolean[] maken) {
		System.out.println("\n\nOpdracht 5\n---");
		int kosten = 25;
		int totaal = 0;
		for(int i = 0; i < onderdelen.length; i++) {
			if(maken[i] == false) {
				maken[i] = true;
				totaal += kosten;
				System.out.println("Gemaakt: " + onderdelen[i] + " - kosten: €" + kosten);
			}
		}
		System.out.println("\nTotaal gemaakte kosten: €" + totaal);
	}
}
class Sort {
	Scanner sc = new Scanner(System.in);
	
	void woordPrinten() {
		System.out.println("\n\nEnter Tekst\n");
	    String userInput = sc.next();  // Read user input
	    System.out.println("\nUser input is: \n" + userInput);  // Output user input
	    char[] userInputArray = userInput.toCharArray();
	    Arrays.sort(userInputArray);
	    System.out.println("Sorted input: " + Arrays.toString(userInputArray));
	    
	}
}
class Lingo {
    static int countOccurrences(char arr[], int n, char x)
    {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (x == arr[i]) {
              res++;
            }
        }
        return res;
    }
    Scanner scan = new Scanner(System.in);
    String woord = "aarde";
    String aantalLetterString = "";
    int aantalLetters = 0;
    
    void lingoWoord() {        
        for(int i = 0; i < woord.length(); i++) {
            aantalLetters += 1;
            aantalLetterString += "_";
        }
    }
    void spelen() {
        this.lingoWoord();
        System.out.println("The word is " + aantalLetters + " characters long\nPlease enter a word to begin\n");

        char[] ingevuldArray = aantalLetterString.toCharArray();
        char[] letterArray = woord.toCharArray();
        int [] scoreArray = new int[aantalLetters];
        
        Map<Character, Integer> dictionary = new HashMap<Character, Integer>();
        
        for (int i = 0; i < letterArray.length; i++) {
            int count = countOccurrences(letterArray, letterArray.length, letterArray[i]);
            dictionary.put(letterArray[i], count);
            scoreArray[i] = 0;
        }

        while (true) {
            String userInput = scan.nextLine();
            char[] userInputArray = userInput.toCharArray();
            if (userInputArray.length != 5) {
            	System.out.println("Enter 5 letter please");
            	continue;
            }
            System.out.println(Arrays.toString(userInputArray));
            
            for (int x = 0; x < letterArray.length; x++) {
            	int secondCount = countOccurrences(userInputArray, x+1, userInputArray[x]);
            	try {
	            	if (secondCount > dictionary.get(userInputArray[x])) {
	                	ingevuldArray[x] = '_';
	            		continue;
	            	}
            	} catch (NullPointerException ne) {
            		
            	}
                if (userInputArray[x] == letterArray[x]) {
                    scoreArray[x] = 2;
                    ingevuldArray[x] = userInputArray[x];
                } else if (woord.contains(Character.toString(userInputArray[x]))) {
                    scoreArray[x] = 1;
                    ingevuldArray[x] = userInputArray[x];
                }                
            }
            if (Arrays.equals(userInputArray, letterArray)){
                System.out.println("\nGewonnen!");
                System.out.println("Gespeeld woord: \n");
                System.out.println(Arrays.toString(ingevuldArray));
                break;
            }
            System.out.println("\nna het spelen");
            System.out.println("Gespeeld woord: \n");
            System.out.println(Arrays.toString(scoreArray));
            System.out.println(Arrays.toString(ingevuldArray));
        }
    }
}
	