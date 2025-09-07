package miu.edu.springcqrsproductquery.config;

import miu.edu.springcqrsproductquery.domain.ProductEvent;
import miu.edu.springcqrsproductquery.domain.StockEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJms
public class JMSConfig {

    @Bean
    public MappingJackson2MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        Map<String, Class<?>> typeIdMappings = new HashMap<>();
        typeIdMappings.put("StockEvent", StockEvent.class);
        typeIdMappings.put("ProductEvent", ProductEvent.class);
        converter.setTypeIdMappings(typeIdMappings);
        return converter;
    }
}