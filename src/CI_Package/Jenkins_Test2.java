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
import org.testng.annotations.Test;

public class Jenkins_Test2 {
	
	@Test
	public void printOwnershipCode() throws Exception{
//		String[] commands = {"C:\\Selenium\\Akshay_Simulator\\Debug\\Simulator.exe", "-t lcbs",  "-f"};
//		String output = getProcessOutput(commands);
//		String code = getOwnershipCode(output);
//		System.out.println("ownership code received is: ");
//		System.out.println(code);
		String[] commands5 = {"C:\\Akshay_Simulator\\Debug\\copy.bat"};
        String output = copydata(commands5);
		
//		associate(code);
//		copydata();
//		Thread.sleep(600000);
//		String[] commands1 = {"C:\\Selenium\\Akshay_Simulator\\Debug\\Simulator.exe", "-t lcbs",  "-r"};
//		register(commands1);
//		String[] commands2 = {"C:\\Selenium\\Akshay_Simulator\\Debug\\Simulator.exe", "-t lcbs",  "-s"};
//		start(commands2);
		
	}



//	public static void main(String[] args) throws Exception {
//		
//		String[] cmds = {"C:\\Selenium\\Akshay_Simulator\\Debug\\Simulator.exe",   "-t lcbs", "-f"};
//		String output = getProcessOutput(cmds);
//		String code = getOwnershipCode(output);
//		System.out.println("ownership code received is: ");
//		System.out.println(code);
//	}		
	
	
	
	private void associate(String ownershipcode) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://datdev.test-lcbs.honeywell.com");
		
		driver.findElement(By.id("cred_userid_inputtext")).sendKeys("dcontractor37@datdev.lcbsconnect.com");
		Thread.sleep(2000);
		driver.findElement(By.id("cred_password_inputtext")).sendKeys("lcbs@1234");
		Thread.sleep(2000);
		driver.findElement(By.id("cred_sign_in_button")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@id='main-nav']/ul/li[2]/a")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[@id='main-content']/ul/li/div[1]/a/article/span[contains(text(), 'Buidling1')]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='main-tab']/nav/a[2]")).click();
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//*[@id='main-body']/section/header/div/a")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='main-body']/section/section[1]/input")).sendKeys(ownershipcode);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='main-body']/section/section[1]/div/button")).click();
		
	}

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

	public static String getProcessOutput(String[] commands) throws IOException, InterruptedException {
		System.out.println("executing: "+String.join(" ", commands));
		//commands = "start ping google.com";
		
		ProcessBuilder builder = new ProcessBuilder(commands);
		builder.redirectErrorStream(true);
		Process process = builder.start();
		//process.waitFor();
		System.out.println("wait for 2 mins");
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		StringBuffer output = new StringBuffer();
		String line = "";
		while ((line = bfr.readLine()) != null) {
			// display each output line form python script
			output.append(line);
			System.out.println(line);
			if(output.lastIndexOf("<Enter>") != -1){
				System.out.println("found last");
				process.destroyForcibly();
			}
		}
		return output.toString(); 
	}

	public static String register(String[] commands1) throws IOException{
		System.out.println("executing: "+String.join(" ", commands1));
		//commands = "start ping google.com";
		
		ProcessBuilder builder = new ProcessBuilder(commands1);
		builder.redirectErrorStream(true);
		Process process = builder.start();
		//process.waitFor();
		System.out.println("wait for 2 mins");
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		StringBuffer output = new StringBuffer();
		String line = "";
		while ((line = bfr.readLine()) != null) {
			// display each output line form python script
			output.append(line);
			System.out.println(line);
			if(output.lastIndexOf("<Enter>") != -1){
				System.out.println("found last");
				process.destroyForcibly();
			}
		}
		return null;	
		
	}
	
	public static String start(String[] commands2) throws IOException{
		System.out.println("executing: "+String.join(" ", commands2));
		//commands = "start ping google.com";
		
		ProcessBuilder builder = new ProcessBuilder(commands2);
		builder.redirectErrorStream(true);
		Process process = builder.start();
		//process.waitFor();
		System.out.println("wait for 2 mins");
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		StringBuffer output2 = new StringBuffer();
		String line = "";
		while ((line = bfr.readLine()) != null) {
			// display each output line form python script
			output2.append(line);
			System.out.println(line);
			
		}
		return null;	
		
						
	}
	
	
	
	public static String copydata(String[] commands5) throws IOException{
		System.out.println("executing: "+String.join(" ", commands5));
		//commands = "start ping google.com";
		
		ProcessBuilder builder = new ProcessBuilder(commands5);
		builder.redirectErrorStream(true);
		Process process = builder.start();
		//process.waitFor();
		System.out.println("wait for 2 mins");
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		StringBuffer output = new StringBuffer();
		String line = "";
		while ((line = bfr.readLine()) != null) {
			// display each output line form python script
			output.append(line);
			System.out.println(line);
//			if(output.lastIndexOf("<Enter>") != -1){
//				System.out.println("found last");
//				process.destroyForcibly();
//			}
		}
		return null;	
		
	}
	
	
}
