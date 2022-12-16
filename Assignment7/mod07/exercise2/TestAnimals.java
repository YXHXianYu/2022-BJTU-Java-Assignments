/**
 * @author YXH_XianYu
 * Created On 2022-04-19
 */
public class TestAnimals {
    public static void main(String[] args) {
        Fish d = new Fish();
        Cat c = new Cat("Fluffy");
        Animal a = new Fish();
        Animal e = new Spider();
        Pet p = new Cat();

        System.out.println(" ----- ----- ----- ----- ----- ");
        System.out.println("a) calling methods in each object:");

        System.out.println("\n1) Fish d");
        System.out.println("This fish's name is \"" + d.getName() + "\" (an empty string)");
        d.play();
        d.walk();
        d.eat();

        System.out.println("\n2) Cat c");
        System.out.println("This cat's name is \"" + c.getName() + '\"');
        c.play();
        c.walk();
        c.eat();

        System.out.println("\n3) Animal a");
        a.walk();
        a.eat();

        System.out.println("\n4) Animal e");
        e.walk();
        e.eat();

        System.out.println("\n5) Pet p");
        p.play();

        System.out.println();
        System.out.println(" ----- ----- ----- ----- ----- ");
        System.out.println("b) casting object");

        ((Fish) a).play();
        ((Cat) p).eat();

        System.out.println();
        System.out.println(" ----- ----- ----- ----- ----- ");
        System.out.println("c) polymorphism");

        polymorphismChecker(d);
        polymorphismChecker(c);
        polymorphismChecker(a);
        polymorphismChecker(e);

        System.out.println();
        System.out.println(" ----- ----- ----- ----- ----- ");
        System.out.println("d) using \"super\" to call super class methods");

        // "super" can only be used in subclasses
        // So I must modify class Fish
        // => super.walk();
        d.walk();
        d.superWalk();
    }

    private static void polymorphismChecker(Animal a) {
        if(a instanceof Spider) {
            System.out.println("This animal is a spider.");
        } else if(a instanceof Cat) {
            System.out.println("This animal is a cat.");
        } else if(a instanceof Fish) {
            System.out.println("This animal is a fish.");
        } else {
            System.out.println("Error.");
        }
    }
}
