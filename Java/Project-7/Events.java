import java.util.*;

public class Events implements Comparable<Events> {

  public double time;
  public int id;

//super-constructor for events

  public Events(double time, int id) {
    this.time = 0.0;
    this.id = 0;
  }

//override of the compareTo method

  public int compareTo(Events other) {
    if (this.time > other.time) {
      return 1;
    } else if (this.time < other.time) {
      return -1;
    } else {
      if (this instanceof Train_Crossing || this instanceof Train_Leave) {
        return -1;
      } else if (this instanceof Truck_Tracks && other instanceof Truck_Cross) {
        return -1;
      } else {
        return 1;
      }
    }
  }

//method for getting time value

  public double getTime() {
    return this.time;
  }

//method for getting ID value

  public int getID() {
    return this.id;
  }
}