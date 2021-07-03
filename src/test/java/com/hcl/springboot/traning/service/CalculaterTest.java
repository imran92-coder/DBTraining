package com.hcl.springboot.traning.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculaterTest {
	
	static Calculater calculater=null;
	@BeforeClass
	public static void  setup() {
		calculater=new Calculater();
		System.out.println("****first setup() will be called ******* ");
	}
	
	@Before
	public void methodSetUp() {
		calculater=new Calculater();
		System.out.println("****Before executing each test case methodSetUp() will be executed ******* ");
	}
	@Test
	public void testAddForPosativeNumber() {
		System.out.println("****test case1 ******* ");
		long result=calculater.add(2, 4);
		Assert.assertEquals(6, result);
	}
	
	@Test
	public void testAddForNegativeNumber() {
		System.out.println("****test case2 ******* ");
		int result=calculater.add(-3, -5);
		Assert.assertEquals(-8, result);
		
	}
	
	@Test
	public void testDivisionForPositiveNumber() {
		System.out.println("****test case3 ******* ");
		int result=calculater.Division(10, 2);
		Assert.assertEquals(5, result);
	}
	
	@Test
	public void testDivisionForNegativeNumber() {
		System.out.println("****test case4 ******* ");
		int result=calculater.Division(-10, -2);
		Assert.assertEquals(5, result);
	}
	@Test(expected=NullPointerException.class)
	public void testDivisionForException() {
		System.out.println("****test case5 ******* ");
		int result=calculater.Division(4, 0);
	}
	
	@After
	public  void methodTeardown() {
		System.out.println("*****methodTeardown() will be the last***");
		calculater=null;
	}
	
	@AfterClass
	public static void teardown() {
		System.out.println("*****teardown() will be the last***");
		calculater=null;
	}
	

}
