package br.fib.calculosalario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class SeleniumDrive {
	
	public static WebDriver getDriver(String nomeDriver, String pathDriver) {
		WebDriver driver = null;
		
		if (nomeDriver.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", pathDriver );
	        driver = new ChromeDriver();	
		} else if (nomeDriver.equals("opera")) {
			System.setProperty("webdriver.opera.driver", pathDriver );
	        driver = new OperaDriver();
		}
		
		return driver;
	}

}
