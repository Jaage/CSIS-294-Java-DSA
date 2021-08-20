public class VehicleManager {
    Motorcycle bikes[] = new Motorcycle[3];
    Car cars[] = new Car[3];
    public void run() {
        bikes[0] = new Motorcycle(false, 2000, true);
        bikes[1] = new Motorcycle(false, 2021, false);
        bikes[2] = new Motorcycle(false, 1999, true);

        cars[0] = new Car(false, 2012, false);
        cars[1] = new Car(false, 2021, true);
        cars[2] = new Car(false, 2010, false);

        System.out.println("Which car would you like to start?");
    }
}
