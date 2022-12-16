/**
 * @author YXH_XianYu
 * Created On 2022-04-19
 */
public class Fish extends Animal implements Pet {
    private String name;

    public Fish(String name) {
        super(0); // legs == 0 means this animal can't walk
        this.name = name;
    }
    public Fish() {
        this("");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("The fish is playing.");
    }

    @Override
    public void walk() {
        System.out.println("Fish can't walk.");
    }

    @Override
    public void eat() {
        System.out.println("The fish is eating.");
    }

    public void superWalk() {
        super.walk();
    }
}
