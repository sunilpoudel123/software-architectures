package kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    @KafkaListener(topics = {"toownertopic"})
    public void receive(@Payload VehicleOwnerRecord record,
                        @Headers MessageHeaders headers) {
        int fine = FeeCalculator.calculateFine(record.getSpeed());

        if (fine > 0) {
            System.out.println("FeeCalculatorService => " +
                    "Plate: " + record.getLicencePlate() +
                    ", Owner: " + record.getOwnerName() +
                    ", Speed: " + record.getSpeed() +
                    " mph, Fine: $" + fine);
        }
    }

}