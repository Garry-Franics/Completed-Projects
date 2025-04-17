import java.util.*;

class Truck_Tracks extends Events {

//constructor of Truck_Tracks events

  public Truck_Tracks(double time, int id, double arrival, int id2) {
    super(time, id);
    this.time = arrival;
    this.id = id2;
  }

//override of the toString method
  
  public String toString() {
    return this.time + ": Truck #" + this.id + " waits at crossing";
  }
}