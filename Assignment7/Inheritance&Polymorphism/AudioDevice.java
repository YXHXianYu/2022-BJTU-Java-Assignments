/**
 * @author YXH_XianYu
 * Created On 2022-04-19
 */
public class AudioDevice implements ElectricalDevice {

    public void increaseVol() {
        System.out.println("AudioDevice - increaseVol()");
    }

    public void decreaseVol() {
        System.out.println("AudioDevice - decreaseVol()");
    }

    @Override
    public void turnOn() {
        System.out.println("AudioDevice - turnOn()");
    }

    @Override
    public void turnOff() {
        System.out.println("AudioDevice - turnOff()");
    }
}
