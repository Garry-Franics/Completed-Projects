import java.util.ArrayList;
import java.util.Collections;

public class Character {

//class fields
  
  private String name;
  private int credits;
  private ArrayList<Item> items;

//the constructor
  
  public Character(String name, int credits, ArrayList<Item> items) 
    {this.name = name;
    this.credits = credits;
    this.items = items;}

//Getters and setters
  
  public String getName()
    {return this.name;}

  public void setName(String newName) 
    {this.name = newName;}

  public int getCredits() 
    {return this.credits;}

  public void setCredits(int newCredits) 
    {this.credits = newCredits;}

  public String toString() 
    {return this.name + " " + credits;}

//drop item method
  
  public boolean dropItem(String itemName) 
    {for (Item item : this.items) 
      {if (item.getItemName().equals(itemName)) 
        {this.items.remove(item);
        return true;}}
      return false;}

//item list method
  
  public void printItemsInOrder()
    {Collections.sort(this.items);
    for (Item i : this.items) 
      {System.out.println(i);}}

//add item method
  
  public void addItem(String itemName, int itemValue)
    {Item i1 = new Item(itemName, itemValue);
    this.items.add(i1);}

//sell item to vendor method
  
  public boolean sellItemToVendor(String itemName)
    {for (Item item : this.items) 
      {if (item.getItemName().equals(itemName)) 
        {this.credits = credits + item.getValue();
        this.items.remove(item);
        return true;}}
      return false;}

//sell item to character method
  
  public boolean sellItemToCharacter(String itemName, Character buyer)
    {for (Item item : this.items) 
      {if (item.getItemName().equals(itemName))
        {if (buyer.credits >= item.getValue())
          {this.credits = this.credits + item.getValue();
          buyer.credits = buyer.credits - item.getValue();
          buyer.items.add(item);
          this.items.remove(item);
          return true;}}}
      return false;}
  
}
