package org.drools.degrees;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimpleDegreeTest {
	
	SimpleDegree s0;
	SimpleDegree s1;
	SimpleDegree s5;
	SimpleDegree s3;
	SimpleDegree s8;
	

	@Before
	public void setUp() throws Exception {
		 s0 = new SimpleDegree(0);
		 s1 = new SimpleDegree(1);
		 s5 = new SimpleDegree(0.5000001f);
		 s3 = new SimpleDegree(0.3f);
		 s8 = new SimpleDegree(0.8f);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToBoolean() {
		assertTrue(s1.toBoolean());
		assertFalse(s0.toBoolean());
		assertFalse(s3.toBoolean());
		assertTrue(s5.toBoolean());
		assertTrue(s8.toBoolean());				
	}

	@Test
	public void testSetValue() {
		s8.setValue(0.74f);
		assertTrue(s8.getValue() == 0.74f);
	}

	@Test
	public void testGetValue() {
		assertEquals(1,s1.getValue(), 1e-6);
		assertEquals(0,s0.getValue(), 1e-6);
		assertEquals(0.3,s3.getValue(), 1e-6);
		assertEquals(0.5,s5.getValue(), 1e-6);
		assertEquals(0.8,s8.getValue(), 1e-6);
	}

	@Test
	public void testEqualsObject() {
		assertEquals(s1, s1);
		assertTrue(s1.equals(s1));
		
		assertFalse(s1.equals(null));
		
		assertFalse(s1.equals(s0));
		assertFalse(s3.equals(s5));
		assertEquals(s1, new SimpleDegree(1));
		
		assertFalse(s1.equals( new Object()));		
	}

	@Test
	public void testTRUE() {
		assertEquals(s1, SimpleDegree.TRUE());
	}

	@Test
	public void testFALSE() {
		assertEquals(s0, SimpleDegree.FALSE());
	}

	@Test
	public void testUNKNOWN() {
		assertEquals(s0, SimpleDegree.UNKNOWN(true));
	}

	@Test
	public void testSimpleDegree() {
		assertNotNull(new SimpleDegree(1));
		assertEquals(s1, new SimpleDegree(1));
	}

	@Test
	public void testGetDegree() {
		assertEquals(s1,s1.asSimpleDegree());
		assertTrue(s3.asSimpleDegree() instanceof IDegree );
		assertTrue(s5.asSimpleDegree() instanceof SimpleDegree);
	}

	@Test
	public void testToString() {
		assertNotNull(s1.toString());
	}

}
