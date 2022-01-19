package com.zensar.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.Jackson2XmlMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {

	public static String ROUTING_KEY = "macy_order_routing_key";

	public static String TOPIC_EXCHANGE = "macy_order_exchange";

	public static String QUEUE_NAME = "macy_order_queue";

	public static String QUEUE_NAME_XML = "macy_order_xml_queue";

	@Bean(name = "JsonProducerQueue")
	public Queue jsonProducerQueue() {
		return new Queue(QUEUE_NAME);
	}

	@Bean(name = "XMLProducerQueue")
	public Queue xmlProducerQueue() {
		return new Queue(QUEUE_NAME_XML);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(TOPIC_EXCHANGE);
	}

	@Bean
	Binding jsonProducerBinding(DirectExchange exchange) {
		return BindingBuilder.bind(jsonProducerQueue()).to(exchange).with(jsonProducerQueue().getName());
	}

	@Bean
	Binding xmlProducerBinding(DirectExchange exchange) {
		return BindingBuilder.bind(xmlProducerQueue()).to(exchange).with(xmlProducerQueue().getName());
	}

	@Bean(name = "JSON_AMQP_TEMPLATE")
	public AmqpTemplate jsonTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setRoutingKey(ROUTING_KEY);
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		rabbitTemplate.setDefaultReceiveQueue(jsonProducerQueue().getName());
		return rabbitTemplate;
	}

	@Bean(name = "XML_AMQP_TEMPLATE")
	public AmqpTemplate xmlTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setRoutingKey(ROUTING_KEY);
		rabbitTemplate.setMessageConverter(new Jackson2XmlMessageConverter());
		rabbitTemplate.setDefaultReceiveQueue(xmlProducerQueue().getName());
		return rabbitTemplate;
	}
}
