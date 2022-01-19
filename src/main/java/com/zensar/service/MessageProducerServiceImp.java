package com.zensar.service;

import java.io.StringWriter;
import java.util.UUID;

import javax.xml.bind.JAXB;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zensar.component.ProducerComponent;
import com.zensar.config.MessagingConfig;
import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.FulfillmentOrderOld;
import com.zensar.dto.OrderStatus;
import com.zensar.dto.ProducerMessageDTO;



@Service
public class MessageProducerServiceImp implements MessageProducerService {

	
//	@Autowired
//	//@Qualifier("templateJSON")
//	private RabbitTemplate template;
//	
//	@Autowired 
//	//@Qualifier("templateXML")
//	private RabbitTemplate templateXML;
	

	@Autowired
	private ProducerComponent producerComponent;

	
	@Override
	public ResponseEntity<String> createNewOrder(String token, ProducerMessageDTO newOrder) {
		
	  newOrder.setMessageId(UUID.randomUUID().toString());
	
	 // template.convertAndSend(MessagingConfig.TOPIC_EXCHANGE,MessagingConfig.ROUTING_KEY,newOrder);
	  producerComponent.sendJSON(newOrder);
	 
		return new ResponseEntity<String>("Order Placed Successfully!",HttpStatus.OK);
	}


	@Override
	public ResponseEntity<String> createNewOrderXML(String token, FulfillmentOrder newOrder) {
		
		
		
		  //OrderStatus order = new OrderStatus(newOrder,"CREATED");
		
		  producerComponent.sendXML(newOrder);
		 
//		  templateXML.convertAndSend(MessagingConfig.QUEUE_NAME_XML,newOrder,m->{m.getMessageProperties().setContentEncoding("UTF-8");
//				  														m.getMessageProperties().setContentType("application/xml");
//		  																m.getMessageProperties().setHeader("TypeId",FulfillmentOrder.class);
//		  																
//				  													     return m;});
		  
		  
//		  StringWriter sw = new StringWriter();
//		  JAXB.marshal(newOrder, sw);
//		  String xmlString = sw.toString();
		  
		//  templateXML.convertAndSend(MessagingConfig.QUEUE_NAME_XML,xmlString);
		  
		  
		  
		  
		return new ResponseEntity<String>("Order Placed Successfully!",HttpStatus.OK);
		
	}

}
