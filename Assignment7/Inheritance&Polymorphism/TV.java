/**
 * @author YXH_XianYu
 * Created On 2022-04-19
 */
public class TV extends AudioDevice{

    public void changeChannel() {
        System.out.println("TV - changeChannel()");
    }

    public void adjustColor() {
        System.out.println("TV - adjustColor()");
    }

    @Override
    public void increaseVol() {
        super.increaseVol();
        System.out.println("TV - increaseVol()");
    }

    @Override
    public void decreaseVol() {
        super.decreaseVol();
        System.out.println("TV - decreaseVol()");
    }
}
