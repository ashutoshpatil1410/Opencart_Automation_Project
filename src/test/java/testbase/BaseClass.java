
package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    public static WebDriver driver;
    public Logger log;
    public Properties p;

    @BeforeClass(groups = {"sanity","regression","master"})
    @Parameters({"browser","os"})
    public void setup(String br,String os) throws IOException {

        // Load properties file
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        // Logger initialization
        log = LogManager.getLogger(this.getClass());

        if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
        {
        	DesiredCapabilities cp=new DesiredCapabilities();
        	
        	//OS
        	if(os.equalsIgnoreCase("windows"))
        	{
        		cp.setPlatform(Platform.WIN11);
        	}
        	else if(os.equalsIgnoreCase("mac"))
        	{
        		cp.setPlatform(Platform.IOS);
        	}
        	else if(os.equalsIgnoreCase("linux"))
        	{
        		cp.setPlatform(Platform.LINUX);
        	}
        	
        	else {
				System.out.println("No matching os");
				return;
			}
       
        	
        	//browser
        	switch (br.toLowerCase()) {
			case "chrome":cp.setBrowserName("chrome");break;
			case "edge":cp.setBrowserName("edge");break;
			case "firefox":cp.setBrowserName("firefox");break;
			default:
				System.out.println("No matching browser");
				return;
			}
//        	driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cp); 
        	//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cp);
        	
        //	driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cp);
        	driver = new RemoteWebDriver(URI.create("http://localhost:4444/").toURL(), cp);
        	
        }
        
        
        // Browser setup
        if(p.getProperty("execution_env").equalsIgnoreCase("local"))
        {
        switch (br.toLowerCase()) 
        	{
	            case "edge":
	                driver = new EdgeDriver();
	                break;
	            case "chrome":
	                driver = new ChromeDriver();
	                break;
	            default:
	                System.out.println("Enter a valid browser");
	                return;
        	}
        }

        // WebDriver configurations
        driver.get(p.getProperty("appurl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
    }

    @AfterClass(groups = {"sanity","regression","master"})
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    public String randomstring()
	{
		String genaratedstring=RandomStringUtils.randomAlphabetic(5);
		return genaratedstring;
	}
	
	public String randomnumber()
	{
		String genaratedstring=RandomStringUtils.randomNumeric(10);
		return genaratedstring;
	}
	
	public String randomalphanumeric()
	{
		String genaratedstring=RandomStringUtils.randomAlphabetic(3);
		String genaratednumber=RandomStringUtils.randomNumeric(3);
		
		return (genaratedstring+genaratednumber);
		
	}
	
	 public String captureScreen(String tname) throws IOException {
	        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
	        File targetFile = new File(targetFilePath);

	        sourceFile.renameTo(targetFile);

	        return targetFilePath;
	    }

}
