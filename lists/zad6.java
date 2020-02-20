import java.util.*;
import java.util.stream.Collectors;

class Main {
	
	private static final String FIRST = "First";
	private static final String SECOND = "Second";
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> player1Hand = getHandFromInput(sc.nextLine());
		List<Integer> player2Hand = getHandFromInput(sc.nextLine());
	  
	  String winingPlayer = playGame(player1Hand, player2Hand);
	  List<Integer> winingHand = null;
	  if(winingPlayer.equals(FIRST)) {
	  	  winingHand = player1Hand;
	  } else {
	  	  winingHand = player2Hand;
	  }
	  
	  System.out.printf("%s player wins! Sum: %d%n", winingPlayer, playerScore(winingHand));
		sc.close();
	}
	
	static String playGame(List<Integer> player1Hand, List<Integer> player2Hand) {
 				while (!player1Hand.isEmpty() && !player2Hand.isEmpty()) {
 						int player1Card = player1Hand.remove(0);
 						int player2Card = player2Hand.remove(0);
 						if(player1Card>player2Card) {
 							  player1Hand.add(player1Card);
 							  player1Hand.add(player2Card);
 						} else if(player1Card<player2Card) {
 							  player2Hand.add(player2Card);
 							  player2Hand.add(player1Card);
 						}
 				}
 				
 				if(player2Hand.isEmpty()) {
 						return FIRST;
 				} else {
 						return SECOND;
 				}
 }
	
	static List<Integer> getHandFromInput(String input) {
	     return Arrays
	     				.stream(input.split(" "))
	     				.map(Integer::parseInt)
	     				.collect(Collectors.toList());
	}

  static int playerScore(List<Integer> playerHand) {
  	   return playerHand.stream().mapToInt(i->i).sum();
  }
}
