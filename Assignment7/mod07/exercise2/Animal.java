/**
 * @author YXH_XianYu
 * Created On 2022-04-19
 */
public abstract class Animal {
    protected int legs;

    protected Animal(int legs) {
        this.legs = legs;
    }

    public void walk() {
        System.out.println("This kind of animal walks by " + legs + " legs.");
    }

    public abstract void eat();
}
