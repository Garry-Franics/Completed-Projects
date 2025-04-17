import java.util.*;

class Train_Leave extends Events {

//constructor for Train_Leave events

  public Train_Leave(double time, int id, double leave) {
    super(time, id);
    this.time = leave;
  }

//override of the toString method

  public String toString() {
    return this.time + ": Train leaves crossing";
  }
}