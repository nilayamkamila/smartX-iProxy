package com.tserc.api.smart.iproxy.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class TopicConfig 
{
	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	@Value(value = "${iproxy.topic.name}")
	private String topicName;

	@Bean
	public NewTopic generalTopic() {
		return TopicBuilder.name(topicName)
			      .partitions(1)
			      .replicas(1)
			      .build();
	}

	@Bean
    public KafkaAdmin kafkaAdmin() 
	{
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }
}
