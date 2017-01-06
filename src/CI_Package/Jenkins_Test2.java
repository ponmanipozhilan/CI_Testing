package CI_Package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Runtime;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Jenkins_Test2 {
	
	@Test
	public void printOwnershipCode() throws Exception{
//		String[] commands = {"C:\\Akshay_Simulator\\Debug\\Simulator.exe", "-t lcbs",  "-f"};
//		String output1 = factoryregistration(commands);
//		String code = getOwnershipCode(output1);
//		System.out.println("ownership code received is: ");
//		System.out.println(code);
//		String[] commands4 = {"C:\\Akshay_Simulator\\Debug\\copy.bat"};
//        copydata(commands4);
//		
//		Gatewayassociate(code);


//      String[] commands1 = {"C:\\Akshay_Simulator\\Debug\\Simulator.exe", "-t lcbs",  "-r"};
//		register(commands1);
		
		start();
		
	}



//	public static void main(String[] args) throws Exception {
//
//		String[] cmds = {"C:\\windows\\system32\\calc.exe"};
//
//		ProcessBuilder builder = new ProcessBuilder(cmds);
//		builder.redirectErrorStream(true);
//		Process process = builder.start();
//
//
////		BufferedReader bfr = new BufferedReader(new InputStreamReader(
////				process.getInputStream()));
////		StringBuffer output = new StringBuffer();
////		String line = "";
////		while ((line = bfr.readLine()) != null) {
////			output.append(line);
////			System.out.println(line);
////			if(output.lastIndexOf("<Enter>") != -1){
////				System.out.println("found last");
////				process.destroyForcibly();
////			}
////		}
//		
//	}		
	
	
	
	private void Gatewayassociate(String ownershipcode) throws InterruptedException, IOException {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://datdev.test-lcbs.honeywell.com");
		
		driver.findElement(By.id("cred_userid_inputtext")).sendKeys("dcontractor37@datdev.lcbsconnect.com");
		Thread.sleep(2000);
		driver.findElement(By.id("cred_password_inputtext")).sendKeys("lcbs@1234");
		Thread.sleep(2000);
		driver.findElement(By.id("cred_sign_in_button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='main-nav']/ul/li[2]/a")));
		
		driver.findElement(By.xpath("//*[@id='main-nav']/ul/li[2]/a")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='main-content']/ul/li/div[1]/a/article/span[contains(text(), 'Buidling1')]")));

		driver.findElement(By.xpath("//*[@id='main-content']/ul/li/div[1]/a/article/span[contains(text(), 'Buidling1')]")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='main-tab']/nav/a[2]")));
		
		driver.findElement(By.xpath("//*[@id='main-tab']/nav/a[2]")).click();
		WebDriverWait wait4 = new WebDriverWait(driver, 20);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='main-body']/section/header/div/a")));
		
		driver.findElement(By.xpath("//*[@id='main-body']/section/header/div/a")).click();
		WebDriverWait wait5 = new WebDriverWait(driver, 5);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='main-body']/section/section[1]/input")));
		
		driver.findElement(By.xpath("//*[@id='main-body']/section/section[1]/input")).sendKeys(ownershipcode);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='main-body']/section/section[1]/div/button")).click();
		
		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='main-body']/section/section[2]/button[2]")));
		
		driver.findElement(By.xpath("//*[@id='main-body']/section/section[2]/button[2]")).click();
        System.out.print("Waiting 10min");
		Thread.sleep(600000);
		
		String[] commands1 = {"C:\\Akshay_Simulator\\Debug\\Simulator.exe", "-t lcbs",  "-r"};
		register(commands1);
		String[] commands2 = {"C:\\Akshay_Simulator\\Debug\\Simulator.exe", "-t lcbs",  "-s"};
		start();
			
		WebDriverWait wait6 = new WebDriverWait(driver, 25);
		wait6.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='main-body']/section/ul/li[1]/section/div[1]/span[contains(text(), '" + ownershipcode + "')]")));
		
		driver.findElement(By.xpath("//*[@id='main-body']/section/ul/li[1]/section/div[1]/span[contains(text(), '" + ownershipcode + "')]"));
				
		System.out.println("Gateway loaded successfully");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='main-body']/section/ul/li[1]/ul/li/a/div/div/span[contains(text(), 'RTU_360')]/parent::div/parent::div/dl[1]/dd"));
		
		System.out.println("RTU loaded successfully");
	}

	//To Get the Ownership code
	public static String getOwnershipCode(String processouts) {
		String ownershipCode = null;
		String strPattern = "DeviceOwnershipCode = ([\\w]{8})";
		Pattern pattern = Pattern.compile(strPattern);
		Matcher matcher = pattern.matcher(processouts);
		if(matcher.find()) {
			ownershipCode = matcher.group(1);
		}
		return ownershipCode;
	}

	//To do the Factory registration
	public static String factoryregistration(String[] commands) throws IOException, InterruptedException {
		System.out.println("executing: "+String.join(" ", commands));
				
		ProcessBuilder builder = new ProcessBuilder(commands);
		builder.redirectErrorStream(true);
		Process process = builder.start();
	
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		StringBuffer output = new StringBuffer();
		String line = "";
		while ((line = bfr.readLine()) != null) {
					output.append(line);
			System.out.println(line);
			if(output.lastIndexOf("<Enter>") != -1){
				System.out.println("found last");
				process.destroyForcibly();
			}
		}
		return output.toString(); 
	}

	//To Register the simulator
	public static String register(String[] commands1) throws IOException{
		System.out.println("executing: "+String.join(" ", commands1));
				
		ProcessBuilder builder = new ProcessBuilder(commands1);
		builder.redirectErrorStream(true);
		Process process = builder.start();
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		StringBuffer output = new StringBuffer();
		String line = "";
		while ((line = bfr.readLine()) != null) {
					output.append(line);
			System.out.println(line);
			if(output.lastIndexOf("<Enter>") != -1){
				System.out.println("found last");
				process.destroyForcibly();
			}
		}
		return null;	
		
	}
	
	//To Start the simulator
	public static String start() throws IOException, InterruptedException{
	System.out.println("executing: start "+String.join(""));
	
	Process runtime = Runtime.getRuntime().exec("cmd /c start C:\\Akshay_Simulator\\Debug\\simulation.bat");
Thread.sleep(5000);

		return null;	
								
	}
	
	
	//Execute CopyData Powershell script
	public static String copydata(String[] commands4) throws IOException{
		System.out.println("executing: "+String.join(" ", commands4));
				
		ProcessBuilder builder = new ProcessBuilder(commands4);
		builder.redirectErrorStream(true);
		Process process = builder.start();
				
		BufferedReader bfr = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		StringBuffer output = new StringBuffer();
		String line = "";
		while ((line = bfr.readLine()) != null) {
			output.append(line);
			System.out.println(line);

		}
		return null;	
		
	}
	
	
}
