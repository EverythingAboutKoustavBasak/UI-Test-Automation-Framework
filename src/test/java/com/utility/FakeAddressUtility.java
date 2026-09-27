package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {

	public static AddressPOJO getFakeAddress() {

		Faker faker = new Faker(Locale.US);
		
		String stateValue = String.valueOf(
                faker.number().numberBetween(1, 54) //the state dropdown cotains the value from 1 to 53 for the web site (test data requirement)
        );
		String zipCode = String.valueOf(
				faker.number().numberBetween(10000, 100000) //we need the zipcode within 5 digit value (test data requirement) or we can user faker.numerify("#####") - basically it provide us the 5 digit number
				);

		AddressPOJO addressPojo = new AddressPOJO(faker.company().name(), faker.address().buildingNumber(), faker.address().streetAddress(),
				faker.address().city(), faker.numerify("#####"),  faker.phoneNumber().cellPhone(),
				faker.phoneNumber().cellPhone(), faker.lorem().sentence(), "Home Address", stateValue);
		
		return addressPojo;
	}

}
