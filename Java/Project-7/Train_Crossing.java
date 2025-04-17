import java.util.*;

class Train_Crossing extends Events {

//constructor for Train_Crossing events

  public Train_Crossing(double time, int id, double start) {
    super(time, id);
    this.time = start;
  }

//override of the toString method

  public String toString() {
    return this.time + ": Train arrives at crossing";
  }
}