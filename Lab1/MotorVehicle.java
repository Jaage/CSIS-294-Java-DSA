public class MotorVehicle {
    private boolean running;
    private int year;
    public MotorVehicle(boolean running, int year) {
        this.running = running;
        this.year = year;
    }
    public boolean getRunning() {
        return running;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}