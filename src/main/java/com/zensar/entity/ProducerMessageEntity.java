package com.zensar.entity;


import javax.persistence.*;

@Entity
@Table(name="MessageTable")
public class ProducerMessageEntity {

	@Id
	@Column(name = "MessageID")
	private String messageId;
	
	@Column(name= "MessageName")
	private String messageName;
	
	@Column(name= "Command")
	private String command;
	@Column(name= "itemName")
	private String itemName;
	@Column(name= "ItemDesc")
	private String itemDescription;
	@Column(name= "ItemLength")
	private double itemLength;
	@Column(name= "ItemWidth")
	private double itemWidth;
	@Column(name= "ItemHeight")
	private double itemHeight;
	@Column(name= "ItemWeight")
	private double itemWeight;
	@Column(name= "ImagePath")
	private String imagePathname;
	@Column(name= "RFIDTagged")
	private String rfidTagged;
	@Column(name= "StorageAttribute")
	private int storageAttribute;
	@Column(name= "PickType")
	private String pickType;
	@Column(name= "UPCList")
	private String upcList;
	public ProducerMessageEntity(String messageName, String command, String itemName, String itemDescription,
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
	public ProducerMessageEntity(String messageId, String messageName, String command, String itemName,
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
	public ProducerMessageEntity() {
		super();
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "ProducerMessageEntity [messageId=" + messageId + ", messageName=" + messageName + ", command=" + command
				+ ", itemName=" + itemName + ", itemDescription=" + itemDescription + ", itemLength=" + itemLength
				+ ", itemWidth=" + itemWidth + ", itemHeight=" + itemHeight + ", itemWeight=" + itemWeight
				+ ", imagePathname=" + imagePathname + ", rfidTagged=" + rfidTagged + ", storageAttribute="
				+ storageAttribute + ", pickType=" + pickType + ", upcList=" + upcList + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
