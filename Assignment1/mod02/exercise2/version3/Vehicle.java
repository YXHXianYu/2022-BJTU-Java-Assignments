public class Vehicle {
    private double load;
    private double maxLoad;

    public Vehicle(double max_load) {
        maxLoad = kiloToNewts(max_load);
    }

    public double getLoad() {
        return newtsToKilo(load);
    }
    public double getMaxLoad() {
        return newtsToKilo(maxLoad);
    }

    public boolean addBox(double weight) {
        weight = kiloToNewts(weight); // conversion from kilograms to newtons
        if(load + weight > maxLoad) // a violation occurs
            return false;
        else {
            load += weight;
            return true;
        }
    }

    private double kiloToNewts(double weight) {
        return (weight * 9.8);
    }
    private double newtsToKilo(double weight) {
        return (weight / 9.8);
    }
}
