package com.comCast.crm.generic.baseClassUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comCast.crm.generic.ObjectUtility.UtilityClassObject;
import com.comCast.crm.generic.databaseUtility.DataBaseUtility;
import com.comCast.crm.generic.fileUtility.ExcelUtility;
import com.comCast.crm.generic.fileUtility.FileUtility;
import com.comCast.crm.generic.webDriverUtility.JavaUtility;
import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;
import com.comCast.crm.objectrepositoryutility.HomePage;
import com.comCast.crm.objectrepositoryutility.LoginPage;
/**
 * @author Pratyusha
 * class for configure all pre and post conditions for every test scripts
 */
@Listeners(com.comCast.crm.generic.listenersUtility.ListenersPractice.class)
public class BaseClass {

	public DataBaseUtility dlib = new DataBaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();

	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	@BeforeSuite(groups = { "smoke", "regression" })
	public void configBS() {
		System.out.println("====Connection to Db & Report configuration===");
		dlib.getDbConnection();
		
	}

	
	  @BeforeClass(groups = { "smoke", "regression" }) public void configBc()
	  throws IOException { System.out.println("==Launching browser=="); String
	  BROWSER = flib.getDataFromProperty("browser");
	  
	  if (BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver();
	  
	  } else if (BROWSER.equalsIgnoreCase("firefox")) { driver = new
	  FirefoxDriver();
	  
	  } else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
	  else { driver = new ChromeDriver();
	  
	  }  UtilityClassObject.setDriver(driver);
	  
	  }
	 

	/*
	 * this is for parallel execution
	 */
	
	/*
	 * @Parameters("BROWSER")
	 * 
	 * @BeforeClass(groups= {"smoke","regression"}) public void configBc(String
	 * browser) throws IOException { System.out.println("==Launching browser==");
	 * String BROWSER = browser;
	 * 
	 * if (BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver();
	 * 
	 * } else if (BROWSER.equalsIgnoreCase("firefox")) { driver = new
	 * FirefoxDriver();
	 * 
	 * } else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
	 * else { driver = new ChromeDriver();
	 * 
	 * } sdriver = driver; UtilityClassObject.setDriver(driver); }
	 */
	 
	@BeforeMethod(groups = { "smoke", "regression" })
	public void configBm() throws IOException {
		System.out.println("==Login==");
		String URL = flib.getDataFromProperty("url");
		String USERNAME = flib.getDataFromProperty("username");
		String PASSWORD = flib.getDataFromProperty("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginOperation(URL, USERNAME, PASSWORD);

	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void configAm() {
		System.out.println("==Logout==");
		HomePage hp = new HomePage(driver);
		hp.logoutOperation();
	}

	@AfterClass(groups = { "smoke", "regression" })
	public void configAc() {
		System.out.println("==Closed the Browser==");

		driver.quit();
	}

	@AfterSuite(groups = { "smoke", "regression" })
	public void configAS() {
		System.out.println("====Closed db Connection & report backup====");
		dlib.closeDbConnection();
		
	}

}
