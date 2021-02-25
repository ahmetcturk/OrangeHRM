package package_1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("Before Test");
	}

	@Test(priority = 3,description = "This is the first Test Case", enabled = true, groups={"G1"})
	public void t1(){
		// Assertion -> 
		Assert.assertTrue(true);
		System.out.println("T1");
	}
	
	@Test(priority = 2,groups={"G2"})
	public void t2(){
		// Assertion -> 
		Assert.assertTrue(true);
		System.out.println("T2");
	}
	
	
	@Test(priority = 1, groups={"G1","G2"})
	public void t3(){
		// Assertion -> 
		Assert.assertTrue(true);
		System.out.println("T3");
	}
	@AfterTest
	public void afterTest(){
		System.out.println("After Test");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before Method");
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("After Method");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before Class");
	}
	@AfterClass
	public void afterClass(){
		System.out.println("After Class");
	}
	
	
}
