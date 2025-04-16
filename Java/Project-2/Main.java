import java.util.Scanner;

class Main {
  public static void main(String[] args) {

//section for generating the numbers
    
    Scanner in = new Scanner(System.in);
    int score = 0;
    int round;
    for(round = 1; round <=10; round++)
      {int first = (int)(Math.random() * 100) + 1;
      int second = (int)(Math.random() * 100) + 1;
      while(second == first)
        {int reroll2 = (int)(Math.random() * 100) + 1;
        second = reroll2;}
      int third = (int)(Math.random() * 100) + 1;
      while(third == second || third == first)
        {int reroll3 = (int)(Math.random() * 100) + 1;
        third = reroll3;}
      System.out.print("The numbers for this round are: " + first + " " + second + " " + third);
      try
        {Thread.sleep(3000);}
      catch(InterruptedException e)
        {e.printStackTrace();}
      int x;
      for(x = 0; x < 100; x++)
        {System.out.println(" ");}

//section for presenting questions and reciving answers
    
      int quest = (int)(Math.random() * 4) + 1;
      if(quest == 1)
        {int smallAnsC = smallest(first, second, third);
        System.out.print("What was the smallest number? ");
        int smallAns = in.nextInt();
        if(smallAns == smallAnsC)
          {System.out.println("Correct.");
          score = score + 1;}
        else
          {System.out.println("Incorrect. The correct answer was " + smallAnsC);}}
      else if(quest == 2)
        {int largeAnsC = largest(first, second, third);
        System.out.print("What was the largest number? ");
        int largeAns = in.nextInt();
        if(largeAns == largeAnsC)
          {System.out.println("Correct.");
          score = score + 1;}
        else
          {System.out.println("Incorrect. The correct answer was " + largeAnsC);}}
      else if(quest == 3)
        {int medianAnsC = median(first, second, third);
        System.out.print("What was the median number? ");
        int medianAns = in.nextInt();
        if(medianAns == medianAnsC)
          {System.out.println("Correct.");
          score = score + 1;}
        else
          {System.out.println("Incorrect. The correct answer was " + medianAnsC);}}
      else if(quest == 4)
        {int sumAnsC = sum(first, second, third);
        System.out.print("What was the sum of the numbers? ");
        int sumAns = in.nextInt();
        if(sumAns == sumAnsC)
          {System.out.println("Correct.");
          score = score + 1;}
        else
          {System.out.println("Incorrect. The correct answer was " + sumAnsC);}}}
    System.out.print("Your total score is " + score + "/10");
    in.close();
  }

//section for calculation methods
  
//method for calculating the smallest number
  
  public static int smallest(int first, int second, int third)
    {if(first < second && first < third)
      {int small = first;
      return small;}
    else if(second < first && second < third)
      {int small = second;
      return small;}
    else
      {int small = third;
      return small;}}

//method for calculating the largest number

  public static int largest(int first, int second, int third)
    {if(first > second && first > third)
      {int large = first;
      return large;}
    else if(second > first && second > third)
      {int large = second;
      return large;}
    else
      {int large = third;
      return large;}}

//method for calculating the median number

  public static int median(int first, int second, int third)
    {if((first > second && first < third) || (first < second && first > third))
      {int median = first;
      return median;}
    else if((second > first && second < third) || (second < first && second > third))
      {int median = second;
      return median;}
    else
      {int median = third;
      return median;}}

//method for calculating the sum of the numbers

  public static int sum(int first, int second, int third)
    {int sum = first + second + third;
    return sum;}
}