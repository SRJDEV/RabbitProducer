package com.zensar.service;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.FulfillmentOrderOld;
import com.zensar.dto.ProducerMessageDTO;

public interface MessageProducerService {

	
	public ResponseEntity<String> createNewOrder(String token,@RequestBody ProducerMessageDTO newOrder);
	
	public ResponseEntity<String> createNewOrderXML(String token,@RequestBody FulfillmentOrder newOrder);
	
	
	
}

