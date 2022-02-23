package test;

import org.testng.annotations.Test;

import resourses.Action;
import util.Driver;

public class executeFirst {
  @Test
  public void executeTest() throws Exception {
	  Action.openBrowser("Chrome");
	  Action.navigate();
	  Driver.execute_TestCase();
	 // Action.closeBrowser();
  }
}
