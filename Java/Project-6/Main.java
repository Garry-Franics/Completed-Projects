import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

//section for class feilds
  
  static int flip = 0;
  static String preCard = "";
  static int preIndex;
  static Timer t;
  static int moves = 0;
  static int count = 0;

  private static void createAndShowGUI() {

//creation of jframe for cards
    
    JFrame jFrame = new JFrame("Memory");
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(600, 740);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//creation of jframe for instructions
    
    JFrame instructions = new JFrame("Instructions");
    instructions.setLayout(new FlowLayout());
    instructions.setSize(300, 320);

//adding the game instructions to the instructions jframe
    
    JPanel panel2 = new JPanel();
    panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
    JLabel instructionsText1 = new JLabel();
    instructionsText1.setText("Click on a card to turn it over.");
    panel2.add(instructionsText1);
    JLabel instructionsText2 = new JLabel();
    instructionsText2.setText("Find two cards with the same image to");
    panel2.add(instructionsText2);
    JLabel instructionsText3 = new JLabel();
    instructionsText3.setText("create a match and remove them from the game board.");
    panel2.add(instructionsText3);
    JLabel instructionsText4 = new JLabel();
    instructionsText4.setText("Clear the board to win.");
    panel2.add(instructionsText4);

//storing the front sides of the cards in an ArrayList and suffling the order
    
    ArrayList<JButton> cards = new ArrayList<JButton>();
    ArrayList<String> fronts = new ArrayList<String>();
    for (int o = 0; o < 2; o++) {
      fronts.add("cardfront2.jpg");
      fronts.add("cardfront3.jpg");
      fronts.add("cardfront4.jpg");
      fronts.add("cardfront5.jpg");
      fronts.add("cardfront6.jpg");
      fronts.add("cardfront7.jpg");
      fronts.add("cardfront8.jpg");
      fronts.add("cardfront9.jpg");
    }
    Collections.shuffle(fronts);

//placing the cards in their 4x4 grid with move counter at the bottom
    
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 4));
    JPanel panel3 = new JPanel();
    panel3.setLayout(new BorderLayout());
    JLabel numMoves = new JLabel();
    numMoves.setText("You have made " + moves + " moves so far.");
    panel3.add(numMoves, BorderLayout.SOUTH);
    for (int i = 0; i < 16; i++) {
      JButton card = new JButton(new ImageIcon("cardback.jpg"));
      Dimension size = card.getPreferredSize();
      card.setBounds(1, 1, size.width, size.height);
      final int j = i;

//action listener for cards being selected, cards being reset, and the game ending
      
      card.addActionListener(e -> {
        card.setIcon(new ImageIcon(fronts.get(j)));
        if (flip < 1) {
          preCard = fronts.get(j);
          preIndex = j;
          flip++;
        } else {
          moves++;
          flip = 0;
          numMoves.setText("You have made " + moves + " moves so far.");
          if (preCard.equals(fronts.get(j))) {
            cards.get(j).setVisible(false);
            cards.get(preIndex).setVisible(false);
            count++;
            if (count == 8) {
              numMoves.setText("You won in " + moves + " moves!");
            }
          }
          t = new Timer(1250, q -> {
            flipAll(cards);
          });
          t.setRepeats(false);
          t.start();
        }
      });
      ;
      panel.add(card);
      cards.add(card);
    }

//making GUI assets visible
    
    jFrame.getContentPane().add(panel);
    jFrame.getContentPane().add(panel3);
    jFrame.setVisible(true);
    instructions.getContentPane().add(panel2);
    instructions.pack();
    instructions.setVisible(true);
  }

//method for setting all cards to their backs
  
  public static void flipAll(ArrayList<JButton> cards) {
    for (JButton button : cards) {
      button.setIcon(new ImageIcon("cardback.jpg"));
    }
  }

  public static void main(String[] args) {
    createAndShowGUI();
  }
}