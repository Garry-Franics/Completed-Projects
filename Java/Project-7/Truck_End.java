import java.util.*;

class Truck_End extends Events {

//constructor for Truck_End events

  public Truck_End(double time, int id, double finish, int id3) {
    super(time, id);
    this.time = finish;
    this.id = id3;
  }

//override of the toString method

  public String toString() {
    return this.time + ": Truck #" + this.id + " completes journey";
  }
}