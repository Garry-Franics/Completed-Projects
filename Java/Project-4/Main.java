import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    ArrayList<Character> characters = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    while (true) 
      {theWall();
      String input = in.next();

//Section for creating a character
       
      if (input.equals("1")) 
        {System.out.print("What is the character's name? ");
        in.nextLine();
        String name = in.nextLine();
        boolean duplicateName = false;
        for (Character c : characters) 
          {if (c.getName().equals(name)) 
            {System.out.println("Error: A character with that name already exists.\n");
            duplicateName = true;
            break;}}
        if (!duplicateName) 
          {System.out.print("How many credits does the character have? ");
          int credits = in.nextInt();
          ArrayList<Item> items = new ArrayList<>();
          Character c1 = new Character (name, credits, items);
          characters.add(c1);
          System.out.println(name + " added!\n");}} 

//Section for adding an item
        
      else if (input.equals("2")) 
        {System.out.print("Which character would you like to have get an item? ");
        in.nextLine();
        String name = in.nextLine();
        boolean foundCharacter = false;
        for (Character c : characters) 
          {if (c.getName().equals(name)) 
            {foundCharacter = true;
            System.out.print("What is the item's name? ");
            String itemName = in.nextLine();
            System.out.print("What is the item's value? ");
            int itemValue = in.nextInt();
            c.addItem(itemName, itemValue);
            System.out.println(name + " has acquired " + itemName +"\n");
            break;}}
        if (!foundCharacter) 
          {System.out.println("Error: Character not found.\n");}}

//Section for dropping an item
        
      else if (input.equals("3"))
        {System.out.print("Which character would you like to have drop an item? ");
        in.nextLine();
        String name = in.nextLine();
        boolean foundCharacter = false;
        for (Character c : characters) 
          {if (c.getName().equals(name)) 
            {foundCharacter = true;
            System.out.print("What item would you like to have the character drop? ");
            String itemName = in.nextLine();
            boolean dropped = c.dropItem(itemName);
            if (dropped) 
              {System.out.println(name + " has dropped " + itemName + "\n");}
            else 
              {System.out.println(name + " could not drop " + itemName + "\n");}
            break;}}
        if (!foundCharacter) 
          {System.out.println("Error: Character not found.\n");}}

//Section for selling an item to a vendor
        
      else if (input.equals("4"))
        {System.out.print("Which character would you like to have sell an item? ");
        in.nextLine();
        String name = in.nextLine();
        boolean foundCharacter = false;
        for (Character c : characters) 
          {if (c.getName().equals(name)) 
            {foundCharacter = true;
            System.out.print("What item would you like to have the character sell? ");
            String itemName = in.nextLine();
            boolean sold = c.sellItemToVendor(itemName);
            if (sold)
              {System.out.println(name + " has sold " + itemName + "\n");}
            else 
              {System.out.println(name + " could not sell " + itemName + "\n");}
            break;}}
        if (!foundCharacter) 
          {System.out.println("Error: Character not found.\n");}}

//Section for selling an item to another character
        
      else if (input.equals("5"))  
        {System.out.print("Which character would you like to have sell an item? ");
        in.nextLine();
        String seller = in.nextLine();
        boolean foundCharacter = false;
        for (Character c : characters) 
          {if (c.getName().equals(seller)) 
            {foundCharacter = true;
            System.out.print("Which character would you like to have buy the item? ");
            String buyerS = in.nextLine();
            foundCharacter = false;
            for (Character cA : characters) 
              {if (cA.getName().equals(buyerS)) 
                {foundCharacter = true;
                  if (cA.getName().equals(seller))
                    {System.out.println("Error: Character cannot sell to themself.\n");
                    break;}
                  Character buyer = cA;
                  System.out.print("What item would you like to have the character sell? ");
                  String itemName = in.nextLine();
                  boolean sold = c.sellItemToCharacter(itemName, buyer);
                  if (sold)
                    {System.out.println(seller + " has sold " + itemName + " to " + buyerS + "\n");}
                  else 
                    {System.out.println(seller + " could not sell " + itemName + " to " + buyerS + "\n");}
                  break;}}}}
        if (!foundCharacter) 
          {System.out.println("Error: Character not found.\n");}}

//Section for listing all characters
        
      else if (input.equals("6"))
        {for (Character c : characters)
          {System.out.println(c.getName() + " (" + c.getCredits() + ")");}
        System.out.println(" ");}

//Section for listing a character's inventory
        
      else if (input.equals("7"))
        {System.out.print("Which character would you like to list items? ");
        in.nextLine();
        String name = in.nextLine();
        boolean foundCharacter = false;
        for (Character c : characters)
          {if (c.getName().equals(name))
            {foundCharacter = true;
            c.printItemsInOrder();
            System.out.println(" ");
            break;}}
        if (!foundCharacter) 
          {System.out.println("Error: Character not found.\n");}}

//Section for listing all characters' inventories

      else if (input.equals("8"))
        {for (Character c : characters)
          {System.out.println(c.getName() + " (" + c.getCredits() + ")\n");
          c.printItemsInOrder();
          System.out.println("\n");}}

//Section for quiting the program

      else if (input.equals("9"))
        {in.close();
        System.exit(0);}

      else
        {System.out.println("Invalid input\n");}}
    
  }

//Method for printing the instructions
  
  public static void theWall()
    {System.out.println("1: Create a character");
    System.out.println("2: Character adds an item");
    System.out.println("3: Character drops an item");
    System.out.println("4: Character sells an item to a vendor");
    System.out.println("5: Character sells an item to another character");
    System.out.println("6: List characters");
    System.out.println("7: List a character's inventory by value");
    System.out.println("8: List all characters' inventories by value");
    System.out.println("9: Quit");
    System.out.print("What would you like to do? ");}
  
}







