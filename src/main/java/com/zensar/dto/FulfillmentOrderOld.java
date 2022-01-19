package com.zensar.dto;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(namespace = "ns0:http://www.mst.macys.com/main/eos/fulfillmentOrder/orderDetails.v1.1")
public class FulfillmentOrderOld implements Serializable  {

	
	
	@JacksonXmlProperty(isAttribute = true, localName = "orderID")
    private int orderID;

    @JacksonXmlProperty(localName = "orderTypeCode")
    private String orderTypeCode;

    @JacksonXmlProperty(localName = "partnerOrderID")
    private String partnerOrderID;

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getOrderTypeCode() {
		return orderTypeCode;
	}

	public void setOrderTypeCode(String orderTypeCode) {
		this.orderTypeCode = orderTypeCode;
	}

	public String getPartnerOrderID() {
		return partnerOrderID;
	}

	public void setPartnerOrderID(String partnerOrderID) {
		this.partnerOrderID = partnerOrderID;
	}

	@Override
	public String toString() {
		return "FulfillmentOrder [orderID=" + orderID + ", orderTypeCode=" + orderTypeCode + ", partnerOrderID="
				+ partnerOrderID + "]";
	}

	public FulfillmentOrderOld(int orderID, String orderTypeCode, String partnerOrderID) {
		super();
		this.orderID = orderID;
		this.orderTypeCode = orderTypeCode;
		this.partnerOrderID = partnerOrderID;
	}

	public FulfillmentOrderOld() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    
    
    
}
