package com.app.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.app.dto.TransactionDTO;
import com.app.utils.KafkaConstants;


/**
 * 
 * @author Ashok
 *
 */
@Configuration
public class KafkaProduceConfig {
	
	/**
	 * This method is used to Kafka Producer Config details
	 * @return
	 */

	@Bean
	public ProducerFactory<String, TransactionDTO> producerFactory() {
		Map<String, Object> configProps = new HashMap<String, Object>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.HOST);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory(configProps);
	}

	/**
	 * This method is used to create KafkaTemplate bean obj
	 * @return
	 */
	@Bean(name = "kafkaTemplate")
	public KafkaTemplate<String, TransactionDTO> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

}