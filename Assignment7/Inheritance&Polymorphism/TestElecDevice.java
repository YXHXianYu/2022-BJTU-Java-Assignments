/**
 * @author YXH_XianYu
 * Created On 2022-04-19
 */
public class TestElecDevice {
    // args[0] == "TV" or "Radio"
    public static void main(String[] args) {

        ElectricalDevice ed;
        AudioDevice ad;

        ed = new Refrigerator();
        ed.turnOn();
        ed.turnOff();

        if(args.length > 0 && args[0].equals("TV")) {
            ad = new TV();
        } else if(args.length > 0 && args[0].equals("Radio")) {
            ad = new Radio();
        } else {
            ad = new AudioDevice();
            System.out.println(" - Arguments error.");
            System.out.println(" - Set ad to AudioDevice.");
        }

        ad.increaseVol();
        ad.decreaseVol();
    }
}
