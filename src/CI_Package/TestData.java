package CI_Package;

import org.testng.annotations.DataProvider;

public class TestData {

		
			
		@DataProvider(name="logindataAlert")
		
		public static Object[][] Testdata(){
			Object[][] obj = new Object[1][11];
			
			
			obj[0][0]="https://perfdev.testqa-lcbs.honeywell.com";
			obj[0][1]="WNutjob5747@cbploaddev.onmicrosoft.com";
			obj[0][2]="lcbs@123";
			obj[0][3]="Borsheims6476";
			obj[0][4]="RTU_1";
			obj[0][5]="Digital";	
			obj[0][6]="Create Alert2";
			obj[0][7]="High";
			obj[0][8]="Dirty Filter";
			obj[0][9]="0-Normally Closed";
			obj[0][10]="Edit Alert2";
			
			return obj;
				
	}
}