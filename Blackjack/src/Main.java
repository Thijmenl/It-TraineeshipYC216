import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Card> Cards = new ArrayList();

		for (int i = 1; i < 13; i++) {
			for (int u = 1; u < 5; u++) {
				Card newCard = new Card();

				switch (i) {
				case 1:
					newCard.value = 11;
					newCard.symbol = "A";
					break;
				case 11:
					newCard.value = 10;
					newCard.symbol = "B";
					break;
				case 12:
					newCard.value = 10;
					newCard.symbol = "Q";
					break;
				case 13:
					newCard.value = 10;
					newCard.symbol = "K";
					break;
				default:
					newCard.value = i;
					newCard.symbol = String.valueOf(i);
				}

				switch (u) {
				case 1:
					newCard.type = "Hearts";
					break;
				case 2:
					newCard.type = "Spades";
					break;
				case 3:
					newCard.type = "Clubs";
					break;
				case 4:
					newCard.type = "Diamonds";
					break;
				}
				System.out.println(newCard.symbol + " " + newCard.type + " VALUE: " + newCard.value);
				Cards.add(newCard);
			}
		}
	}
}