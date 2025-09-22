package kafka;

public class VehicleOwnerRecord {
    private String licencePlate;
    private String ownerName;
    private int speed;

    public VehicleOwnerRecord(String licencePlate, String ownerName, int speed) {
        this.licencePlate = licencePlate;
        this.ownerName = ownerName;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "VehicleOwnerRecord{" +
                "licencePlate='" + licencePlate + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", speed=" + speed +
                '}';
    }

    public VehicleOwnerRecord() {
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
