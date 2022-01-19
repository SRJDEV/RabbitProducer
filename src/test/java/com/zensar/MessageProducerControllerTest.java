package com.zensar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaTypeEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.zensar.controller.MessageProducerController;
import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.ProducerMessageDTO;
import com.zensar.service.MessageProducerService;

//@RunWith(SpringRunner.class)
//@WebMvcTest(value = MessageProducerControllerTest.class)

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MessageProducerControllerTest {

	
//
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	MessageProducerService service;
	
	
	@Mock
    private RestTemplate restTemplate;

    
	

	@Test
	public void createNewOrderTest() throws Exception {

		System.out.println("Inside Test");
		String jsonRequest = "{\"messageName\":\"ITEMMASTER_Test\",\"command\":\"ADD\",\"itemName\":\"Phone\","
				+ "\"itemDescription\":\"iPhone13\",\"itemLength\":2.3,\"itemWidth\":2.1,"
				+ "\"itemHeight\":1.9,\"itemWeight\":1.5,\"imagePathname\":\"image_path/iphone13\","
				+ "\"rfidTagged\":\"IPHONE\",\"storageAttribute\":1,\"pickType\":\"I\"}";
		
	
	  ProducerMessageDTO producerJsonDto = new
	  ProducerMessageDTO("ITEMMASTER_TEST","ADD","Mobile","iPhone13",
	  13.8,8.9,15.8,90.8,"imapgepath/iPhone13.jpeg","rfID",1,"Y","N");
	 
		 

		ResponseEntity<String> responseEntity = new ResponseEntity<String>("", HttpStatus.OK);

		Mockito.when(service.createNewOrder(Mockito.anyString(), Mockito.any(ProducerMessageDTO.class)))
 			.thenReturn(responseEntity);
		
//		when(service.createNewOrder(Mockito.anyString(), producerJsonDto)).
//		thenReturn(new ResponseEntity<String>("Success",HttpStatus.OK));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/macy/producer/order")
				
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(jsonRequest)
				.header("Authorization","xyzx")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON);
				

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		System.out.println("Test Completed");

	}
	
	
	
	@Test
	public void createNewOrderXMLTest() throws Exception {

		System.out.println("Inside Test");
		String xmlRequest = "\r\n"
				+ "\r\n"
				+ "<ns0:fulfillmentOrder xmlns:ns0=\"http://www.mst.macys.com/main/eos/fulfillmentOrder/orderDetails.v1.1\">\r\n"
				+ "<ns0:orderID>777</ns0:orderID>\r\n"
				+ "<ns0:orderTypeCode>Digital</ns0:orderTypeCode>\r\n"
				+ "<ns0:partnerOrderID>SAN10000137</ns0:partnerOrderID>\r\n"
				+ "\r\n"
				+ "<ns0:orderStatus>CREATED</ns0:orderStatus>\r\n"
				+ "<ns0:messageCreateTimeStamp>2017-08-16T15:20:29.657-04:00</ns0:messageCreateTimeStamp>\r\n"
				+ "<ns0:fulfillmentChannelCode>POOL</ns0:fulfillmentChannelCode>\r\n"
				+ "\r\n"
				+ "<ns0:orderStatusCode>110</ns0:orderStatusCode>\r\n"
				+ "\r\n"
				+ "<ns0:orderStatusDescription>IN_PROCESS</ns0:orderStatusDescription>\r\n"
				+ "\r\n"
				+ "<ns0:sellZLDivisionNbr>71</ns0:sellZLDivisionNbr>\r\n"
				+ "<ns0:sellZLLocationNbr>139</ns0:sellZLLocationNbr>\r\n"
				+ "\r\n"
				+ "<ns0:source>\r\n"
				+ "<ns0:clientID>MCOM</ns0:clientID>\r\n"
				+ "<ns0:subClientID>SITE</ns0:subClientID>\r\n"
				+ "<ns0:sellingChannelCode>MCOM</ns0:sellingChannelCode>\r\n"
				+ "<ns0:seperatorSource0>0</ns0:seperatorSource0>\r\n"
				+ "<ns0:separatorSource1>1</ns0:separatorSource1>\r\n"
				+ "</ns0:source>\r\n"
				+ "\r\n"
				+ "<ns0:orderTotals>\r\n"
				+ "<ns0:totalPurchaseAmount>41.95</ns0:totalPurchaseAmount>\r\n"
				+ "<ns0:seperatorOrderTotals0>0</ns0:seperatorOrderTotals0>\r\n"
				+ "</ns0:orderTotals>\r\n"
				+ "\r\n"
				+ "<ns0:billingAddress>\r\n"
				+ "\r\n"
				+ "<ns0:contact>\r\n"
				+ "<ns0:custID>51238851</ns0:custID>\r\n"
				+ "<ns0:name>\r\n"
				+ "<ns0:firstName>SUPRAJA</ns0:firstName>\r\n"
				+ "<ns0:lastName>CHIDURAL</ns0:lastName>\r\n"
				+ "<ns0:seperatorName0>0</ns0:seperatorName0>\r\n"
				+ "<ns0:seperatorName1>1</ns0:seperatorName1>\r\n"
				+ "</ns0:name>\r\n"
				+ "\r\n"
				+ "<ns0:address>\r\n"
				+ "<ns0:line1>2200 Galvin Dr</ns0:line1>\r\n"
				+ "<ns0:line2>2200 Galvin Dr</ns0:line2>\r\n"
				+ "<ns0:line3>2200 Galvin Dr</ns0:line3>\r\n"
				+ "<ns0:city>BUFORD</ns0:city>\r\n"
				+ "<ns0:state>GA</ns0:state>\r\n"
				+ "<ns0:zipCode>30087</ns0:zipCode>\r\n"
				+ "<ns0:countryCode>USA</ns0:countryCode>\r\n"
				+ "<ns0:seperatorAddress0>0</ns0:seperatorAddress0>\r\n"
				+ "</ns0:address>\r\n"
				+ "\r\n"
				+ "<ns0:daytimePhoneNbr>968-789-87642345</ns0:daytimePhoneNbr>\r\n"
				+ "<ns0:homePhoneNbr>968-789-8764</ns0:homePhoneNbr>\r\n"
				+ "<ns0:alternatePhoneNbr>741-119-3501</ns0:alternatePhoneNbr>\r\n"
				+ "<ns0:sendSMSMessage>false</ns0:sendSMSMessage>\r\n"
				+ "<ns0:emailAddress>SUPRAJA.CHIDURAL@MACYS.COM</ns0:emailAddress>\r\n"
				+ "<ns0:seperatorContact0>0</ns0:seperatorContact0>\r\n"
				+ "</ns0:contact>\r\n"
				+ "\r\n"
				+ "</ns0:billingAddress>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</ns0:fulfillmentOrder> \r\n"
				+ "";
		
	
		
	 
		 

		ResponseEntity<String> responseEntity = new ResponseEntity<String>("", HttpStatus.OK);

		Mockito.when(service.createNewOrderXML(Mockito.anyString(), Mockito.any(FulfillmentOrder.class)))
 			.thenReturn(responseEntity);
		
//		when(service.createNewOrder(Mockito.anyString(), producerJsonDto)).
//		thenReturn(new ResponseEntity<String>("Success",HttpStatus.OK));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/macy/producer/orderxml")
				
				.accept(org.springframework.http.MediaType.APPLICATION_XML)
				.content(xmlRequest)
				.header("Authorization","xyzx")
				.contentType(org.springframework.http.MediaType.APPLICATION_XML);
				

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		System.out.println("Test Completed");

	}
	
	
	
//    @Test
//	public void createNewOrderTest() throws Exception {
//    	
//    	 ProducerMessageDTO producerJsonDto = new
//    			 ProducerMessageDTO("ITEMMASTER_TEST","ADD","Mobile","iPhone13",
//    			 13.8,8.9,15.8,90.8,"imapgepath/iPhone13.jpeg","rfID",1,"Y","N");
//    	
//    	 Mockito
//         .when(restTemplate.getForEntity(
//           "http:localhost:9001/macy/producer/order",ResponseEntity.class))
//         .thenReturn(new ResponseEntity("", HttpStatus.OK));
//    	 
//    	 ResponseEntity<String>response = service.createNewOrder("xyz",producerJsonDto);
//    	 
//    	 assertEquals(response.getStatusCode(),200);
//    	 
//    	
//    	
//	}
    
//    @Test
//    public void addTest() {
//    	assertEquals(1, 1);
//    }
    

}
