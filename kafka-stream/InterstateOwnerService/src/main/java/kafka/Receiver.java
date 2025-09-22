package kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    @Autowired
    OwnerInfoProcess ownerInfoProcess;

    @KafkaListener(topics = {"tofasttopic"})
    public void receive(@Payload SpeedRecord speedRecord,
                        @Headers MessageHeaders headers) {
        ownerInfoProcess.consumeSpeedRecord(speedRecord);
    }

}