package com.qa.ims.persistence.domain;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderInfoTest {

	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(OrderInfo.class).verify();
	}
	
	
	
}
