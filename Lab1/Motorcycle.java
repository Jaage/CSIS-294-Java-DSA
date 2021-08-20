public class Motorcycle extends MotorVehicle {
    private boolean isChopper;
    public Motorcycle(boolean running, int year, boolean isChopper) {
        super(running, year);
        this.isChopper = isChopper;
    }
    void start() {
        setRunning(true);
        System.out.println("Running: " + getRunning());
        System.out.println("Year: " + getYear());
        System.out.println("isChopper: " + isChopper);
        System.out.println("Vehicle: Motorcycle");
        System.out.println("Motorcycle started");
    }
    void stop() {
        setRunning(false);
        System.out.println("Running: " + getRunning());
        System.out.println("Year: " + getYear());
        System.out.println("isChopper: " + isChopper);
        System.out.println("Vehicle: Motorcycle");
        System.out.println("Motorcycle stopped");
    }
}