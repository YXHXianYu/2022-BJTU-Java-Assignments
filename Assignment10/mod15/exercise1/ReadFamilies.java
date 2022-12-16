import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class ReadFamilies {
  public static void main(String[] args) {
    Family family1;
    Family family2;
    Family family3;
    Person pat_willcutt;
    Person bryan_basham;

    try {
      ObjectInputStream input = new ObjectInputStream(new FileInputStream("families.ser"));
      family1 = (Family) input.readObject();
      family2 = (Family) input.readObject();
      family3 = (Family) input.readObject();

      pat_willcutt = family1.findChild("Pat");
      bryan_basham = family3.findChild("Bryan");

      // queries
      System.out.println("Pat Willcutt has " + pat_willcutt.getNumberOfSiblings() + " sibilings.");
      System.out.println("Bryan Basham has " + bryan_basham.getNumberOfSiblings() + " sibilings.");

      // Handle exceptions
    } catch (IOException e1) {
      e1.printStackTrace();
    } catch (ClassNotFoundException e2) {
      e2.printStackTrace();
    }
  }
}
