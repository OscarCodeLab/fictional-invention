package com.automationexercise.base;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.automation.utilities.ExcelReader;
import com.automationexercise.actiondriver.Action;
import com.automationexercise.listener.ExtentManager;

public class Base {

	public static WebDriver driver;
	public ExcelReader excel = new ExcelReader("C:\\Users\\hp\\eclipse-workspace\\AutomationExercise\\src\\test\\resources\\TestData\\AccountCreationTestData.xlsx");
	public Properties prop;
	public FileInputStream fis;
	public Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriverWait wait;
	public ExtentManager extent = new  ExtentManager();
	
	@BeforeTest
	public void buildUp() throws IOException {
		extent.setExtent();
		prop = new Properties();
		String configPath = "C:\\Users\\hp\\eclipse-workspace\\AutomationExercise\\Configuration\\config.properties";
		
        try (FileInputStream fis = new FileInputStream(configPath)) {
            prop.load(fis);
            
            log.info("Configuration loaded successfully.");
        } catch (IOException e) {
            log.error("Error loading configuration file: ", e);
        }
        
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
           // options.setCapability("unhandledPromptBehavior", "dismiss"); 
            driver = new ChromeDriver(options);
            log.debug("Chrome Launched !!!");
        } else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            EdgeOptions options = new EdgeOptions();
            options.setExperimentalOption("prefs", prefs);
            driver = new EdgeDriver(options);
            log.debug("Edge Launched !!!");
        } else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {  // Corrected this line
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("dom.webnotifications.enabled", false);  // Firefox way of disabling notifications
            driver = new FirefoxDriver(options);
            log.debug("Firefox Launched !!!");
        } else {
            log.error("Browser not supported: " + prop.getProperty("browser"));
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));           
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        		
	
	}
	
	public static WebDriver getDriver() {
        return driver;
    }

	@AfterSuite
	public void tearDown() {
			if (driver!= null) {
            driver.quit();
        }
	}
	
}
