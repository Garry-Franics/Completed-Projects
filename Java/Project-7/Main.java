import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {

//section for base information caltulation

    double time = 0.0;
    int id = 0;
    final double PERCENT_BY_DRONE = 0.60;
    double drones = (1500 * PERCENT_BY_DRONE);
    int trucks = (int) Math.ceil((1500 - drones) / 10);
    double droneTime = 60 + 3 * drones;
    System.out.println("With " + PERCENT_BY_DRONE + "% drones and 1500 packages,\nThere will be:\n-" + drones
        + " drones\n-" + trucks + " trucks\n");
    System.out.println("TRAIN SCHEDULE\n--------------");
    PriorityQueue<Events> Order = new PriorityQueue<>();

//section for reading in the train schedule and creating train events

    File schedule = new File("train_schedule.txt");
    Scanner in = new Scanner(schedule);
    while (in.hasNextInt()) {
      double start = (double) in.nextInt();
      System.out.print(start + "-");
      double leave = (double) in.nextInt();
      System.out.println(leave);
      Train_Crossing tc = new Train_Crossing(time, id, start);
      Train_Leave tl = new Train_Leave(time, id, leave + start);
      Order.offer(tc);
      Order.offer(tl);
    }
    System.out.print("\n");

//section for creating Truck_Start events

    for (int q = 0; q < trucks; q++) {
      double truStart = q * 15;
      int num = q + 1;
      Truck_Start ts = new Truck_Start(time, id, truStart, num);
      Order.offer(ts);
    }
    ArrayList<Events> Truck_Line = new ArrayList<>();
    ArrayList<Integer> ID_Line = new ArrayList<>();
    ArrayList<Double> Time_Line = new ArrayList<>();
    double simClock = 0.0;
    boolean isBlocking = false;
    double ttTime = 0.0;

//begining of the main while loop

    while (!Order.isEmpty()) {
      Events e = Order.poll();
      System.out.println(e);
      simClock = e.getTime();

//section for handling Train_Crossing events

      if (e instanceof Train_Crossing) {
        isBlocking = true;
      }
//section for handling Train_Leave events and creating Truck_Cross events
      else if (e instanceof Train_Leave) {
        isBlocking = false;
        if (!Truck_Line.isEmpty()) {
          double waiting = e.getTime() + 1.0;
          int id4 = ID_Line.get(0);
          Truck_Cross tc = new Truck_Cross(time, id, waiting, id4);
          Order.offer(tc);
          Truck_Line.remove(0);
          ID_Line.remove(0);
        }
      }
//section for handling Truck_Start events and creating Truck_Tracks events
      else if (e instanceof Truck_Start) {
        double arrival = e.getTime() + 100.0;
        int id2 = e.getID();
        Truck_Tracks tt = new Truck_Tracks(time, id, arrival, id2);
        Order.offer(tt);
      }
//section for handling Truck_Tracks events and either placing events into Truck_Line or creating Truck_End events
      else if (e instanceof Truck_Tracks) {
        if (isBlocking || !Truck_Line.isEmpty()) {
          Truck_Line.add((Truck_Tracks) e);
          ID_Line.add(e.getID());
        } else {
          double finish = e.getTime() + 900.0;
          int id3 = e.getID();
          Truck_End te = new Truck_End(time, id, finish, id3);
          Order.offer(te);
        }
      }
//section for handling Truck_Cross events and creating Truck_End events
      else if (e instanceof Truck_Cross) {
        double finish = e.getTime() + 900.0;
        int id3 = e.getID();
        Truck_End te = new Truck_End(time, id, finish, id3);
        Order.offer(te);
        if (!Truck_Line.isEmpty()) {
          double waiting = e.getTime() + 1.0;
          int id4 = ID_Line.get(0);
          Truck_Cross tc = new Truck_Cross(time, id, waiting, id4);
          Order.offer(tc);
          Truck_Line.remove(0);
          ID_Line.remove(0);
        }
      } else if (e instanceof Truck_End) {
        Time_Line.add(e.getTime());
        ttTime = e.getTime();
      }
    }

//section for calculating the average truck time

    System.out.print("\n");
    System.out.println("STATS\n-----");
    double avgTime = 0.0;
    for (int p = 1; p < Time_Line.size(); p++) {
      double E = Time_Line.get(p) - p * 15.0;
      avgTime = avgTime + E;
      System.out.println("Truck #" + p + " total trip time: " + E + " minutes");
    }
    double timeAvg = Math.round((avgTime / Time_Line.size()) * 10) / 10.0;
    System.out.println("\nTRUCK AVG TRIP TIME: " + timeAvg + " minutes");
    System.out.println("TRUCK TOTAL TIME: " + ttTime + " minutes");
    System.out.println("\nDRONE TRIP TIME: 60.0 minutes");
    System.out.println("DRONE TOTAL TIME: " + droneTime + " minutes");

//section for deciding what to print for "total time"

    if (ttTime > droneTime) {
      System.out.println("\nTOTAL TIME: " + ttTime + " minutes");
    } else if (ttTime < droneTime) {
      System.out.println("\nTOTAL TIME: " + droneTime + " minutes");
    } else {
      System.out.println("\nTOTAL TIME: " + ttTime + " minutes");
    }
  }
}