/**
 * 
 */
package com.zensar.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author SC64222
 *
 */

public class ProducerMessageDTO {

	
	private String messageId;

	private String messageName;

	private String command;
	
	
	private String itemName;
	
	private String itemDescription;
	private double itemLength;
	private double itemWidth;
	private double itemHeight;
	private double itemWeight;
	
	private String imagePathname;
	private String rfidTagged;
	private int storageAttribute;
	private String pickType;
	
	private String upcList;


	public ProducerMessageDTO(String messageName, String command, String itemName, String itemDescription,
			double itemLength, double itemWidth, double itemHeight, double itemWeight, String imagePathname,
			String rfidTagged, int storageAttribute, String pickType, String upcList) {
		super();
		this.messageName = messageName;
		this.command = command;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemLength = itemLength;
		this.itemWidth = itemWidth;
		this.itemHeight = itemHeight;
		this.itemWeight = itemWeight;
		this.imagePathname = imagePathname;
		this.rfidTagged = rfidTagged;
		this.storageAttribute = storageAttribute;
		this.pickType = pickType;
		this.upcList = upcList;
	}


	public ProducerMessageDTO(String messageId, String messageName, String command, String itemName,
			String itemDescription, double itemLength, double itemWidth, double itemHeight, double itemWeight,
			String imagePathname, String rfidTagged, int storageAttribute, String pickType, String upcList) {
		super();
		this.messageId = messageId;
		this.messageName = messageName;
		this.command = command;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemLength = itemLength;
		this.itemWidth = itemWidth;
		this.itemHeight = itemHeight;
		this.itemWeight = itemWeight;
		this.imagePathname = imagePathname;
		this.rfidTagged = rfidTagged;
		this.storageAttribute = storageAttribute;
		this.pickType = pickType;
		this.upcList = upcList;
	}

	public String getMessageId() {
		return messageId;
	}


	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}


	public String getMessageName() {
		return messageName;
	}


	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}


	public String getCommand() {
		return command;
	}


	public void setCommand(String command) {
		this.command = command;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemDescription() {
		return itemDescription;
	}


	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}


	public double getItemLength() {
		return itemLength;
	}


	public void setItemLength(double itemLength) {
		this.itemLength = itemLength;
	}


	public double getItemWidth() {
		return itemWidth;
	}


	public void setItemWidth(double itemWidth) {
		this.itemWidth = itemWidth;
	}


	public double getItemHeight() {
		return itemHeight;
	}


	public void setItemHeight(double itemHeight) {
		this.itemHeight = itemHeight;
	}


	public double getItemWeight() {
		return itemWeight;
	}


	public void setItemWeight(double itemWeight) {
		this.itemWeight = itemWeight;
	}


	public String getImagePathname() {
		return imagePathname;
	}


	public void setImagePathname(String imagePathname) {
		this.imagePathname = imagePathname;
	}


	public String getRfidTagged() {
		return rfidTagged;
	}


	public void setRfidTagged(String rfidTagged) {
		this.rfidTagged = rfidTagged;
	}


	public int getStorageAttribute() {
		return storageAttribute;
	}


	public void setStorageAttribute(int storageAttribute) {
		this.storageAttribute = storageAttribute;
	}


	public String getPickType() {
		return pickType;
	}


	public void setPickType(String pickType) {
		this.pickType = pickType;
	}


	public String getUpcList() {
		return upcList;
	}


	public void setUpcList(String upcList) {
		this.upcList = upcList;
	}


	public ProducerMessageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "ProducerMessageDTO [ messageId ="+messageId+"messageName=" + messageName + ", command=" + command + ", itemName=" + itemName
				+ ", itemDescription=" + itemDescription + ", itemLength=" + itemLength + ", itemWidth=" + itemWidth
				+ ", itemHeight=" + itemHeight + ", itemWeight=" + itemWeight + ", imagePathname=" + imagePathname
				+ ", rfidTagged=" + rfidTagged + ", storageAttribute=" + storageAttribute + ", pickType=" + pickType
				+ ", upcList=" + upcList + "]";
	}
	
	
	
	
	
	
	
}
