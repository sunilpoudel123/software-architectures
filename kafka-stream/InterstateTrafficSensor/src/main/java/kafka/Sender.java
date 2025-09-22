package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, SensorRecord> kafkaTemplate;

    public void send(String topic, SensorRecord sensorRecord){
        kafkaTemplate.send(topic, sensorRecord);
    }
}
