import java.util.*;

class Truck_Cross extends Events {

//constructor for Truck_Cross events

  public Truck_Cross(double time, int id, double waiting, int id4) {
    super(time, id);
    this.time = waiting;
    this.id = id4;
  }

//override of the toString method
  
  public String toString() {
    return this.time + ": Truck #" + this.id + " crosses crossing";
  }
}