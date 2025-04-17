import java.util.*;

class Truck_Start extends Events {

//constructor for Truck_Start events

  public Truck_Start(double time, int id, double truStart, int num) {
    super(time, id);
    this.time = truStart;
    this.id = num;
  }

//override of the toString method

  public String toString() {
    return this.time + ": Truck #" + this.id + " begins journey";
  }
}