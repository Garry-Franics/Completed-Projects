public class Item implements Comparable<Item> {

//class fields
  
  private String name;
  private int value;

//the constructor
  
  public Item(String n, int c) 
    {this.name = n;
    this.value = c;}

//getters and setters
  
  public String getItemName() 
    {return this.name;}

  public int getValue() 
    {return this.value;}

  public String toString() 
    {return this.name + " (" + this.value + ")";}

//sort items method
  
  public int compareTo(Item other) 
    {if (this.value > other.getValue()) 
      {return -1;}
    else if (this.value < other.getValue()) 
      {return 1;}
    else 
      {return 0;}}

}
