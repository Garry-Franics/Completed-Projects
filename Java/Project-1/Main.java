import java.util.Scanner;

class Main {
  public static void main(String[] args) {

//section for preperation of the cards
    
    System.out.print("Enter three cards (in form of RS): ");
    Scanner in = new Scanner(System.in);
    String betahand = in.nextLine();
    String smolhand = betahand.trim();
    String hand = smolhand.toUpperCase();
    int gap = hand.indexOf(" ");
    int gapp = hand.lastIndexOf(" ");
    String card1 = hand.substring(0,gap);
    String card2 = hand.substring(gap + 1,gapp);
    String card3 = hand.substring(gapp + 1);
    String suitup1 = hand.substring(0,gap - 1);
    String suitup2 = hand.substring(0,gapp - 1);
    String suitup3 = hand.substring(0,hand.length() - 1);

//section for identifying card ranks, terminating invalid ranks, and getting special ranks evaluated
    
    String rank1 = hand.substring(0,gap - 1);
    if(rank1.length() >= 2 && !rank1.contentEquals("10"))
      {System.out.print(card1 + " has an invalid rank. Exiting...");
      System.exit(0);}
    if(rank1.contentEquals("J"))
      {rank1 = "11";}
    else if(rank1.contentEquals("Q"))
      {rank1 = "12";}
    else if(rank1.contentEquals("K"))
      {rank1 = "13";}
    else if(rank1.contentEquals("A"))
      {rank1 = "14";}
    String rank2 = hand.substring(gap + 1,gapp - 1);
    if(rank2.length() >= 2 && !rank2.contentEquals("10"))
      {System.out.print(card2 + " has an invalid rank. Exiting...");
      System.exit(0);}
    if(rank2.contentEquals("J"))
      {rank2 = "11";}
    else if(rank2.contentEquals("Q"))
      {rank2 = "12";}
    else if(rank2.contentEquals("K"))
      {rank2 = "13";}
    else if(rank2.contentEquals("A"))
      {rank2 = "14";}
    String rank3 = hand.substring(gapp + 1,hand.length() - 1);
    if(rank3.length() >= 2 && !rank3.contentEquals("10"))
      {System.out.print(card3 + " has an invalid rank. Exiting...");
      System.exit(0);}
    if(rank3.contentEquals("J"))
      {rank3 = "11";}
    else if(rank3.contentEquals("Q"))
      {rank3 = "12";}
    else if(rank3.contentEquals("K"))
      {rank3 = "13";}
    else if(rank3.contentEquals("A"))
      {rank3 = "14";}

//section for identifying suits and terminating invalid suits    
    
    String suit1 = hand.substring(suitup1.length(),gap);
    if(!suit1.contentEquals("C") && !suit1.contentEquals("D") && !suit1.contentEquals("H")        && !suit1.contentEquals("S"))
      {System.out.print(card1 + " has an invalid suit. Exiting...");
      System.exit(0);}
    String suit2 = hand.substring(suitup2.length(),gapp);
    if(!suit2.contentEquals("C") && !suit2.contentEquals("D") && !suit2.contentEquals("H")        && !suit2.contentEquals("S"))
      {System.out.print(card2 + " has an invalid suit. Exiting...");
      System.exit(0);}
    String suit3 = hand.substring(suitup3.length(),hand.length());
    if(!suit3.contentEquals("C") && !suit3.contentEquals("D") && !suit3.contentEquals("H")        && !suit3.contentEquals("S"))
      {System.out.print(card3 + " has an invalid suit. Exiting...");
      System.exit(0);}

//section for converting ranks to integers and terminating invalid ranks
    
    int val1 = Integer.parseInt(rank1);
    if(val1 < 2 || val1 > 14)
      {System.out.print(card1 + " has an invalid rank. Exiting...");
      System.exit(0);}
    int val2 = Integer.parseInt(rank2);
    if(val2 < 2 || val2 > 14)
      {System.out.print(card2 + " has an invalid rank. Exiting...");
      System.exit(0);}
    int val3 = Integer.parseInt(rank3);
    if(val3 < 2 || val3 > 14)
      {System.out.print(card3 + " has an invalid rank. Exiting...");
      System.exit(0);}
    
//section for calculating the winner of the game
    
    if(val1 > val2 && val1 > val3)
      {if(val2 < val3)
        {System.out.println("Player 2 plays the " + card2 + ".");
        System.out.print("Player 1 wins the round.");}
      else if(val2 > val3)
        {System.out.println("Player 2 plays the " + card3 + ".");
        System.out.print("Player 1 wins the round.");}}
    else if(val1 < val2 && val1 > val3)
      {System.out.println("Player 2 plays the " + card2 + ".");
      System.out.print("Player 2 wins the round.");}
    else if(val1 > val2 && val1 < val3)
      {System.out.println("Player 2 plays the " + card3 + ".");
      System.out.print("Player 2 wins the round.");}
    else if(val1 < val2 && val1 < val3)
      {if(val2 > val3)
        {System.out.println("Player 2 plays the " + card3 + ".");
        System.out.print("Player 2 wins the round.");}
      else if(val2 < val3)
        {System.out.println("Player 2 plays the " + card2 + ".");
        System.out.print("Player 2 wins the round.");}}
    else if(val1 == val2 && val1 == val3)
      {System.out.println("Player 2 plays the " + card2 + ".");
      System.out.print("Player 1 wins the round.");}
    in.close();
  }
}