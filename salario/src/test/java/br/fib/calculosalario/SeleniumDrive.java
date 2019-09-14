package br.fib.calculosalario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class SeleniumDrive {
			
	public static WebDriver chromeDriver(String pathDriver) {
		System.setProperty("webdriver.chrome.driver", pathDriver );

        WebDriver driver = new ChromeDriver();		
		return driver;
	}
	
	public static WebDriver operaDriver(String pathDriver) {
		System.setProperty("webdriver.opera.driver", pathDriver );

        WebDriver driver = new OperaDriver();		
		return driver;
	}

}
