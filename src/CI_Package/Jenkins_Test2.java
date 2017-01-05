package CI_Package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Runtime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class Jenkins_Test2 {

	public static void main(String[] args) throws Exception {
		
//		File f = new File( "C:\\Selenium\\factory.txt");
//		String data = FileUtils.readFileToString(f);
		//System.out.println(data);

		
		String output = getProcessOutput("C:\\Akshay_Simulator\\Debug\\Simulator.exe -t lcbs -f");
		String code = getOwnershipCode(output);
		System.out.println("ownership code received is: ");
		System.out.println(code);
		
		
		
		
		/*
		// set up the command and parameter
		String pythonScriptPath = "C:\\Selenium\\mybat.bat";
		String[] cmd = new String[2];
		cmd[0] = "python"; // check version of installed python: python -V
		cmd[1] = pythonScriptPath;

		// create runtime to execute external command
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec(pythonScriptPath);

		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(
				pr.getInputStream()));
		String line = "";
		while ((line = bfr.readLine()) != null) {
			// display each output line form python script
			System.out.println(line);
		}
		
		*/
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

	public static String getProcessOutput(String commands) throws IOException, InterruptedException {
		
		//commands = "start ping google.com";
		ProcessBuilder builder = new ProcessBuilder(commands);
		builder.redirectErrorStream(true);
		Process process = builder.start();
		process.waitFor();
		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		StringBuffer output = new StringBuffer();
		String line = "";
		while ((line = bfr.readLine()) != null) {
			// display each output line form python script
			output.append(line);
			System.out.println(line);
			
		}
		return output.toString(); 
	}

}
