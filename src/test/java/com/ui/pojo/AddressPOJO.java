package com.ui.pojo;

public class AddressPOJO {
	
	private String company;
	private String address1;
	private String address2;
	private String city;
	private String postCode;
	private String homePhNumber;
	private String mobilePhNumber;
	private String otherInfo;
	private String addressAlias;
	private String stateValue;
	
	
	public AddressPOJO(String company, String address1, String address2, String city, String postCode,
			String homePhNumber, String mobilePhNumber, String otherInfo, String addressAlias, String stateValue) {
		super();
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.postCode = postCode;
		this.homePhNumber = homePhNumber;
		this.mobilePhNumber = mobilePhNumber;
		this.otherInfo = otherInfo;
		this.addressAlias = addressAlias;
		this.stateValue = stateValue;
	}
	
	
	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", postCode=" + postCode + ", homePhNumber=" + homePhNumber + ", mobilePhNumber="
				+ mobilePhNumber + ", otherInfo=" + otherInfo + ", addressAlias=" + addressAlias + ", state=" + stateValue
				+ "]";
	}


	public String getCompany() {
		return company;
	}


	public String getAddress1() {
		return address1;
	}



	public String getAddress2() {
		return address2;
	}




	public String getCity() {
		return city;
	}



	public String getPostCode() {
		return postCode;
	}



	public String getHomePhNumber() {
		return homePhNumber;
	}



	public String getMobilePhNumber() {
		return mobilePhNumber;
	}



	public String getOtherInfo() {
		return otherInfo;
	}



	public String getAddressAlias() {
		return addressAlias;
	}



	public String getStateValue() {
		return stateValue;
	}

	
	
}
