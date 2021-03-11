package TestNG_1.TestNG_1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Class2 {
	
	
	@Test
	@Parameters("parameter1")
	public void test1(String parameter1){
		System.out.println(parameter1);
	}
}
