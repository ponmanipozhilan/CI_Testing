package CI_Package;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateNewAlertConfiguration {
	
	//public WebDriver driver;
	//private String alertName;

	@Test(dataProviderClass = TestAlertData.class, dataProvider = "logindataAlert")
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
        
		//Clicking on Settings page
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='alert-config-nav']/a[3]")));

		driver.findElement(By.xpath("//*[@id='alert-config-nav']/a[3]")).click();
		Thread.sleep(5000);

		//int i;
		
		//for(i=19; i<=19; i++){
		
		//Clicking on Add New Alert button
		driver.findElement(By.xpath("//*[@id='alert-settings-sort']/a")).click();
		//Clicking on RTU name field
		WebDriverWait wait3 = new WebDriverWait(driver, 15);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='add-alert-container']/section/div[1]/div/a")));
        		
		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[1]/div/a")).click();
		
		//Selecting the RTU
		WebDriverWait wait4 = new WebDriverWait(driver, 10);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='add-alert-container']/section/div[1]/div/ul/li/a[contains(text(), '"
						+ RTUname + "')]")));
		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[1]/div/ul/li/a[contains(text(), '"
						+ RTUname + "')]")).click();
        Thread.sleep(5000);
        
      //Clicking on Alert type field
		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[2]/div/a")).click();
		
		//Selecting the Alert type
		WebDriverWait wait5 = new WebDriverWait(driver, 5);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='add-alert-container']/section/div[2]/div/ul/li/a[contains(text(), '"
						+ AlertType + "')]")));

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[2]/div/ul/li/a[contains(text(), '"
						+ AlertType + "')]")).click();

        //Entering Alert name
		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[3]/input")).sendKeys(CreateAlert);

        //Clicking on Priority field
		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[4]/div/a")).click();
		Thread.sleep(3000);
        //Selecting the Priority
		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[4]/div/ul/li/a[contains(text(), '"
						+ Priority + "')]")).click();
        //Clicking on Point name field
		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[5]/div/a")).click();
		//Selecting the Point name
		WebDriverWait wait6 = new WebDriverWait(driver, 5);
		wait6.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='add-alert-container']/section/div[5]/div/ul/li/a[contains(text(), '"
						+ PointName + "')]")));
       
		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[5]/div/ul/li/a[contains(text(), '"
						+ PointName + "')]")).click();

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[6]/input")).clear();
		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[6]/input")).sendKeys("2");

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[7]/div/div")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[7]/div/ul/li/a[contains(text(), '"
						+ limit + "')]")).click();
		//String Alert = "Test"+i;
		
		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[10]/textarea")).sendKeys(CreateAlert);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/section/button")).click();
		
		Thread.sleep(20000);
		
		driver.findElement(By.xpath("//*[@id='alert-settings-filter-container']/div[4]/div[3]/label")).click();
		
		Thread.sleep(10000);
		
		String AlertName = driver.findElement(By.xpath("//*[@id='alert-settings-list']/ul/li/div/div/article/dl[1]/dt/a[contains(text(), '"
						+ CreateAlert + "')]")).getText();
		
		System.out.println("Alert Name is"+ AlertName);
		
		Assert.assertEquals(CreateAlert, AlertName);

		System.out.println("Alert Configuration created successfully");
		
		driver.quit();		
		//editalerttesting(Alert);
		//alertName = Alert;
		
		//}
	}
	
	

	

}
