package Project_test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Project_pages.Pages_Project;

public class Test_Project {
	WebDriver driver;
	@BeforeTest
	public void SetUp()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void url()
	{
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize(); 
	}
	@Test
	
	public void test() throws Exception
	{
		Pages_Project ob=new Pages_Project(driver);
		ob.logo_checking();
		ob.title_verification();
		ob.site_login();
		ob.actions_mouse();
		ob.screenshot_element();
		ob.window_handle();
		ob.link_count();
		
		
	}
	

}
