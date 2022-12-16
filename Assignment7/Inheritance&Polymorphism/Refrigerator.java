/**
 * @author YXH_XianYu
 * Created On 2022-04-19
 */
public class Refrigerator implements ElectricalDevice {

    public void setFreezingLevel() {
        System.out.println("Refrigerator - setFreezingLevel()");
    }

    @Override
    public void turnOn() {
        System.out.println("Refrigerator - turnOn()");
    }

    @Override
    public void turnOff() {
        System.out.println("Refrigerator - turnOff()");
    }
}
