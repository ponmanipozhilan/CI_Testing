package CI_Package;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class FindElementsTesting {
	
	//public WebDriver driver;
	//private String alertName;

	@Test(dataProviderClass = TestData.class, dataProvider = "logindataAlert")
	public void CreateAlertTesting(String url, String username, String password, String BuildingName, String RTUname, String AlertType, String CreateAlert, String Priority, String PointName, String limit, String editalert) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		//Login
		driver.findElement(By.id("cred_userid_inputtext")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.id("cred_password_inputtext")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.id("cred_sign_in_button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		//Clicking on Buildings Tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='main-nav']/ul/li[2]/a")));

		driver.findElement(By.xpath("//*[@id='main-nav']/ul/li[2]/a")).click();
		
		//Clicking on the Building
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='main-content']/ul/li/div[1]/a/article/span[contains(text(), '"
						+ BuildingName + "')]")));

		driver.findElement(By.xpath("//*[@id='main-content']/ul/li/div[1]/a/article/span[contains(text(), '"
						+ BuildingName + "')]")).click();
        
		int i;
		
		for(i=1; i<=500; i++)
		
		{
		//Clicking on Controls tab
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='main-tab']/nav/a[2]")));

		driver.findElement(By.xpath("//*[@id='main-tab']/nav/a[2]")).click();
		
		long start = System.currentTimeMillis();
		
		WebDriverWait wait3 = new WebDriverWait(driver, 25);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='main-body']/section/ul/li[1]/section/div[1]/span[contains(text(), 'PCT00011')]")));
		
		driver.findElement(By.xpath("//*[@id='main-body']/section/ul/li[1]/section/div[1]/span[contains(text(), 'PCT00011')]"));
		
		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		System.out.println(i+"- Total Time for page load in ms- "+totalTime); 
		double totaltime_Seconds = totalTime/1000.0;
		System.out.println(i+"- Total Time for page load in seconds-"+totaltime_Seconds);
		
		
		
		System.out.println(i+"- Gateway loaded successfully");
		
//		Thread.sleep(3000);
//		
//		driver.findElement(By.xpath("//*[@id='main-body']/section/ul/li[1]/ul/li/a/div/div/span[contains(text(), 'emRTU_2')]/parent::div/parent::div/dl[1]/dd"));
//		
//		System.out.println("RTU2 loaded successfully" +i);
//		
//		Thread.sleep(3000);
//		
//        driver.findElement(By.xpath("//*[@id='main-body']/section/ul/li[1]/ul/li/a/div/div/span[contains(text(), 'emRTU_7')]/parent::div/parent::div/dl[1]/dd"));
//		
//		System.out.println("RTU7 loaded successfully" +i);
//		
//		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='main-tab']/nav/a[1]")).click();
		
		Thread.sleep(5000);
		
		}
	
		
			
		
		
		
		
		
		
		
		
	}
	
	

	

}
