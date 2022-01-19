package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.FulfillmentOrderOld;
import com.zensar.dto.ProducerMessageDTO;
import com.zensar.service.MessageProducerService;

import io.swagger.annotations.ApiOperation;





@RestController
@RequestMapping("macy/producer")
public class MessageProducerController {

	
	@Autowired
	MessageProducerService messageProducerService;
	
	
	
	

	@ApiOperation("Publish Message in Json Format")
	@PostMapping(value ="/order",consumes = {MediaType.APPLICATION_JSON_VALUE, },
			produces = {MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_PROBLEM_XML_VALUE})
	
    public ResponseEntity<String> createNewOrder(@RequestHeader("Authorization") String token,
    		@RequestBody ProducerMessageDTO newDTO) {
			
		System.out.println("Received Token "+token);

	  return messageProducerService.createNewOrder(token, newDTO);
	}	
	
	@ApiOperation("Publish Message in XML Format")
	@PostMapping(value ="/orderxml",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = {MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	
    public ResponseEntity<String> createNewOrderXML(@RequestHeader("Authorization") String token,
    		@RequestBody FulfillmentOrder newDTO) {
			
		System.out.println("Received Token "+token);

	  return messageProducerService.createNewOrderXML(token, newDTO);
	}	
	
}
