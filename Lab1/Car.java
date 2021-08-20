public class Car extends MotorVehicle {
    private boolean isElectric;
    public Car(boolean running, int year, boolean isElectric) {
        super(running, year);
        this.isElectric = isElectric;
    }
    void start() {
        setRunning(true);
        System.out.println("Running: " + getRunning());
        System.out.println("Year: " + getYear());
        System.out.println("isElectric: " + isElectric);
        System.out.println("Vehicle: Car");
        System.out.println("Car started");
    }
    void stop() {
        setRunning(false);
        System.out.println("Running: " + getRunning());
        System.out.println("Year: " + getYear());
        System.out.println("isElectric: " + isElectric);
        System.out.println("Vehicle: Car");
        System.out.println("Car stopped");
    }
}