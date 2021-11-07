package testNG_practice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameters_tag {
	
  @BeforeClass
  @Parameters({"browser","URL"})
  public void setUp(@Optional("Chrome")String browser,String url) {
	  System.out.println("Browser: "+browser);
	  System.out.println("URL: "+url);	  
  }
  @Test
  public void f() {
  }
}
