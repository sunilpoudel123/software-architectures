package kafka;

public class FeeCalculator {

    public static int calculateFine(double speed) {
        if (speed >= 72 && speed < 77) {
            return 25;
        } else if (speed >= 77 && speed < 82) {
            return 45;
        } else if (speed >= 82 && speed <= 90) {
            return 80;
        } else if (speed > 90) {
            return 125;
        }
        return 0;
    }
	
}
