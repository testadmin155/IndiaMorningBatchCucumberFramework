package StepDefnition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.LoginPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import junit.framework.Assert;

public class steps {
  public WebDriver driver;
  public LoginPage lp;
  public Properties confProp;
  
  @Before
  public void setup() throws IOException
  {
	 confProp = new Properties();
	 FileInputStream fis = new FileInputStream("config.properties");
	 confProp.load(fis);
	 
	 String br = confProp.getProperty("browser");
	 
	 if(br.equals("chrome"))
	 {
		 System.setProperty("webdriver.chrome.driver", confProp.getProperty("chromepath"));
		 driver = new ChromeDriver();
	 }
	 
	 else if(br.equals("firefox"))
	 {
		 System.setProperty("webdriver.gecko.driver", confProp.getProperty("firefoxpath"));
		 driver = new FirefoxDriver();
	 }
	 else if(br.equals("edge"))
	 {
		 System.setProperty("webdriver.edge.driver", confProp.getProperty("edgepath"));
		 driver = new EdgeDriver();
	 }
  }
	
	@Given("User launch browser")
	public void user_launch_browser() {
	    
	    lp = new LoginPage(driver);
	}

	@When("user opens url {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@When("User enters valid email as {string} and valid Password as {string}")
	public void user_enters_valid_email_as_and_valid_Password_as(String username, String pwd) {
		lp.setUsername(username);
		lp.setPassword(pwd);
	}

	@When("Click on Login button")
	public void click_on_Login_button() {
	    lp.clkLogin();
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String expTitle) {
	    String actualtitle=driver.getTitle();
	    Assert.assertEquals(expTitle, actualtitle);
	}

	@Then("Close browser")
	public void close_browser() throws InterruptedException {
		Thread.sleep(5000);
	    driver.close();
	}
	
}
