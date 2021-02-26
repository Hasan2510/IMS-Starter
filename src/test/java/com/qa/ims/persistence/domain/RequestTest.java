package com.qa.ims.persistence.domain;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
public class RequestTest{

@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Request.class).verify();
	}
}