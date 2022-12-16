/**
 * @author YXH_XianYu
 * Created On 2022-04-19
 */
public class Radio extends AudioDevice{

    public void adjustWavelength() {
        System.out.println("Radio - adjustWavelength()");
    }

    @Override
    public void increaseVol() {
        super.increaseVol();
        System.out.println("Radio - increaseVol()");
    }

    @Override
    public void decreaseVol() {
        super.decreaseVol();
        System.out.println("Radio - decreaseVol()");
    }
}
