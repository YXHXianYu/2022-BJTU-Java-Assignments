import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Person implements Serializable {
  // Attributes
  private String firstName;
  private String lastName;
  // "transient" specifies that this attribute is not to be serialized.
  transient private int numOfSiblings;
  // Associations
  private Family family = null;

  // Constructor
  public Person(Family fam, String f, String l) {
    firstName = f;
    lastName = l;
    family = fam;
    if ( family != null ) {
      family.addChild(this);
    }
  }

  public String getFirstName() {
    return firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public int getNumberOfSiblings() {
    if(numOfSiblings != 0) return numOfSiblings;
    // value = subtract one from the total number of children in this person's family
    numOfSiblings = family.getChildren().size() - 1;
    System.out.println("Calculating number of siblings for " + firstName + " " + lastName);
    return numOfSiblings;
  }
}
