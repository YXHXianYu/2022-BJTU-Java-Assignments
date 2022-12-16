/**
 * @author YXH_XianYu
 * Created On 2022-04-19
 */
public class Cat extends Animal implements Pet {
    private String name;

    public Cat(String name) {
        super(4);
        this.name = name;
    }
    public Cat() {
        this("");
    }

    @Override
    public void eat() {
        System.out.println("The cat is eating.");
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
        System.out.println("The cat is playing.");
    }
}
