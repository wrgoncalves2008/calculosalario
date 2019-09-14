package br.fib.calculosalario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDrive {
			
	public static WebDriver chromeDriver(String pathDriver) {
		System.setProperty("webdriver.chrome.driver", pathDriver );

        WebDriver driver = new ChromeDriver();		
		return driver;
	}

}
