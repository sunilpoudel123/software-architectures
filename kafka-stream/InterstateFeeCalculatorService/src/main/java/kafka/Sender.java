package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, VehicleOwnerRecord> kafkaTemplate;

    public void send(String topic, VehicleOwnerRecord record){
        kafkaTemplate.send(topic, record);
    }
}
