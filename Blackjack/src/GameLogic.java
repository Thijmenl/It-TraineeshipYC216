import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class GameLogic {
	ArrayList<Card> cards = new ArrayList();
	ArrayList<Card> currentCards = new ArrayList();
	ArrayList<Card> bankCurrentCards = new ArrayList();
	int sum = 0;
	
	
	public GameLogic() {
		Welcome();
		GameStart();
	}
	
	void ResetGame() {
		System.out.println("\n");
		sum = 0;
		currentCards.clear();
		bankCurrentCards.clear();
		cards.clear();
		GameStart();
	}
	
	void Welcome() {
		System.out.println("Welcome to blackjack");
		System.out.println("Here are you cards.. \n");
	}
	
	void GameStart() {
		CreateCards();
		currentCards.add(DealCard());
		currentCards.add(DealCard());
		GameLoop();
	}
	
	void GameLoop() {

		System.out.println("Total value: " + TotalValue(currentCards)); 
		Scanner sc = new Scanner(System.in);
		
		System.out.println(("\nGive your input [C]ard, [P]ass, [Q]uit"));
		String input = sc.next();
		ProcessInput(input);
		sc.reset();
		if(TotalValue(currentCards) > 21) {
			System.out.println("You went over 21 with a total of " + TotalValue(currentCards) + "\n Game Over");
			System.out.println("----------------------------------------------------------");
			ResetGame();
			return;
		}
		
		GameLoop();
	}
	
	Card DealCard() {
		Card dealCard = cards.get(0);
		cards.remove(0);
		System.out.println("Dealt card: " + dealCard.symbol + " of " + dealCard.type);
		return dealCard;
	}
	
	void ProcessInput(String input) {
		switch(input) {
		case "c": 
			currentCards.add(DealCard()); 
			//System.out.println(TotalValue(currentCards)); 
			
			break;
		case "p": 
				System.out.println("Stand with a score of " + TotalValue(currentCards));
				ResetGame();
			//pass
			break;
		case "q":
			//quit
			break;
		}
	}
	
	int TotalValue(ArrayList<Card> cardList) {
		int total = 0;
		
		for(int i = 0; i < currentCards.size(); i++) {
			total += currentCards.get(i).value;
		}
		
		return total;
	}
	
	void ShowCard() {
		
	}
	
	void CreateCards() {
		for (int i = 1; i < 14; i++) {
			for (int u = 1; u < 5; u++) {
				Card newCard = new Card();

				switch (i) {
				case 1:
					newCard.value = 11;
					newCard.symbol = "Ace";
					break;
				case 11:
					newCard.value = 10;
					newCard.symbol = "Jack";
					break;
				case 12:
					newCard.value = 10;
					newCard.symbol = "Queen";
					break;
				case 13:
					newCard.value = 10;
					newCard.symbol = "King";
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
				//System.out.println(newCard.symbol + " " + newCard.type + " VALUE: " + newCard.value);
				cards.add(newCard);
				
			}
		}
		Collections.shuffle(cards);
		/*
		int count = 0;
		for(int x = 0; x < cards.size(); x++) {
			count++;
			Card tempCard = cards.get(x);
			System.out.println(tempCard.symbol + " " + tempCard.type + " VALUE: " + tempCard.value);
		}  
		System.out.println(count);*/
	}
}
