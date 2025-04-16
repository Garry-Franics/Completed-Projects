import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {
  public static void main(String[] args) throws Exception {

//Section for playing the game
    
    ArrayList<String> wordList = useable();
    ArrayList<String> possible = content();    
    Scanner in = new Scanner(System.in);
    String[] scrambled = start(wordList);
    ArrayList<String> answerList = new ArrayList<String>();
    int score = 0;
    System.out.println(Arrays.toString(scrambled));
    System.out.println("Score: " + score);
    String userInput = "";
    while ((userInput.contentEquals("bye")) == false)
      {String userInputI = in.nextLine();
      userInput = userInputI.toLowerCase();
      if (userInput.contentEquals("mix"))
        {scrambled = shuffle(scrambled);
        System.out.println(Arrays.toString(scrambled));
        System.out.println("Score: " + score);}
      else if (userInput.contentEquals("ls"))
        {System.out.println(answerList);
        System.out.println("Score: " + score);}
      else
        {Integer[] scoreChecked = guess(userInput, possible, answerList, scrambled, score);
          if (scoreChecked[0] == 1)
            {score = scoreChecked[1];
            System.out.println("Score: " + score);
            scoreChecked[0] = 0;}}}
    in.close();
  }

//Section for extra methods

//Method for finding answers from the file

  public static ArrayList<String> content() throws Exception
    {File f = new File("words.txt");
    Scanner read = new Scanner(f);
    ArrayList<String> possible = new ArrayList<String>();
    String word = "";
    while (read.hasNextLine())
      {word = read.nextLine();
       possible.add(word);}
    read.close();
    return possible;}

//Method for finding starting words in the file

  public static ArrayList<String> useable() throws Exception
    {File f = new File("words.txt");
    Scanner read = new Scanner(f);
    ArrayList<String> wordList = new ArrayList<String>();
    ArrayList<Character> solo = new ArrayList<Character>();
    String word = "";
    while (read.hasNextLine())
      {word = read.nextLine();
       if (word.length() == 7)
         {for (int y = 0; y < 7; y++)
           {char letter = word.charAt(y);
            if (solo.contains(letter) == false)
              {solo.add(letter);}}
              if (solo.size() == 7)
                {wordList.add(word);
                solo.clear();}
              else
                {solo.clear();
                continue;}}}
    read.close();
    return wordList;}
  
//Method for re-shuffling avalable letters
  
  public static String[] shuffle(String[] scrambled)
    {List<String> scrambling = Arrays.asList(scrambled);
    Collections.shuffle(scrambling);
    scrambled = scrambling.toArray(new String[0]);
    return scrambled;}

//Method for the initail selecting and shuffling of a word

  public static String[] start(ArrayList<String> wordList)
    {int pick = (int)(Math.random() * wordList.size() + 1);
    String[] words = wordList.toArray(new String[0]);
    String scramble = words[pick];
    String[] scrambled = scramble.split("");
    scrambled = shuffle(scrambled);
    return scrambled;}
  
//Method for detecting a correct answer and updating score

  public static Integer[] guess(String userInput, ArrayList<String> possible, ArrayList<String> answerList, String[] scrambled, int score)
    {ArrayList<Character> scrambleC = new ArrayList<Character>();
    for (int p = 0; p < scrambled.length; p++)
      {String fodder = scrambled[p];
      char fodderI = fodder.charAt(0); //Fodder as in cannon fodder
      scrambleC.add(fodderI);}
    Integer[] scoreCheck = {2};
    int tester;
    int check = 0;
    if (userInput.length() >= 4)
      {if (possible.contains(userInput))
        {for (int z = 0; z < userInput.length(); z++)
          {if (scrambleC.contains(userInput.charAt(z)))
            {check = check + 1;}}
            if (check == userInput.length())
              {if (answerList.contains(userInput) == false)
                {tester = 1;
                answerList.add(userInput);
                ArrayList<Integer> scoreChecker = new ArrayList<Integer>();
                scoreChecker.add(tester);
                if (userInput.length() == 4)
                  {score = score + 1;
                  scoreChecker.add(score);}
                else if (userInput.length() > 4)
                  {score = score + userInput.length();
                  scoreChecker.add(score);}
                scoreCheck = scoreChecker.toArray(new Integer[0]);}}}}
    return scoreCheck;}
}