package Project_pages;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Pages_Project {
	
	WebDriver driver;
	
	WebElement logo;
	
	List<WebElement> li;

	public  Pages_Project (WebDriver driver)
	{
	    this.driver=driver;
	    logo=driver.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[1]/a[1]/img"));
	    li=driver.findElements(By.tagName("a"));
	
	}

	public void logo_checking()
	{
	if(logo.isDisplayed())
	{
	System.out.println("logo is displayed");
	}
	else
	{
	System.out.println("logo is not displayed");
	}}
	
	@Test
	public void title_verification()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));          //Wait to load content
		
		//Title verification
		 String actualtitle=driver.getTitle();
			
			String expectedtitle="Shop Online for Men, Women & Kids Clothing, Shoes, Home Decor Items ";       //Title verification
			System.out.println(actualtitle);
			if(actualtitle.equals(expectedtitle))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}
	}
	
	@Test
	public void site_login()
	{
		//Login
		
		driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div[3]/div[3]/div/span[1]")).click();        //Find element by x path
		driver.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[3]/div[3]/div/div/div[2]/div[1]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("/html/body/header/div/div[3]/div/div/div[6]/form/div/input")).click();
		driver.findElement(By.xpath("/html/body/header/div/div[3]/div/div/div[6]/form/div/input")).sendKeys("gouri12@gmail.com");
		driver.findElement(By.id("checkUser")).click();                                                            //Find element by id
		
		driver.findElement(By.name("j_number")).sendKeys("7994336216");                                             //Find element by name  
		driver.findElement(By.xpath("//*[@id=\"j_name\"]")).sendKeys("Gouri");
	    driver.findElement(By.xpath("//*[@id=\"userDobTemplate\"]")).click();
	    driver.findElement(By.xpath("//*[@id=\"j_password\"]")).click();
	    driver.findElement(By.xpath("//*[@id=\"j_password\"]")).sendKeys("Abcd#123");
	    driver.findElement(By.xpath("//*[@id=\"userSignup\"]")).click();
	
	}
				
	@Test
	public void actions_mouse()
	{
		
		//Actions Mouse
		
        WebElement mouse=driver.findElement(By.xpath("//*[@id=\"leftNavMenuRevamp\"]/div[1]/div[2]/ul/li[1]/a/span[2]"));
		
		Actions act=new Actions(driver);     
		
		act.moveToElement(mouse).perform();
		 
		driver.findElement(By.xpath("//*[@id=\"inputValEnter\"]")).sendKeys("Tshirt",Keys.ENTER);             //Search
		
		driver.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[1]/a[1]/img")).click();
	}
	
	@Test
	public void screenshot_element() throws IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;                //To scroll down

		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[@id=\"sdFooter\"]/div[2]/div[2]/div/div[2]")));  
		
		
		WebElement connectelement=driver.findElement(By.xpath("//*[@id=\"sdFooter\"]/div[2]/div[2]/div/div[2]"));  //Screenshot of element connect
		File src=connectelement.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("E://ConnectScrt.png"));
			
	}
	
	@Test
	public void window_handle()
	{
		String parentWindow=driver.getWindowHandle();
		System.out.println("parent window Title" +driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"inputValEnter\"]")).sendKeys("Shoes",Keys.ENTER);
		Set<String> allwindowhandles = driver.getWindowHandles();
		      for(String handle:allwindowhandles)
		      {
		    	  System.out.println(handle);
		    	  
		    	  if(!handle.equalsIgnoreCase(parentWindow))
		    	  {
		    		  driver.switchTo().window(handle);
		    		  driver.findElement(By.xpath("//*[@id=\"category1Data\"]/div[1]/div/div/p[2]/a/span")).click();
		    		  
		    	  }
	
		      }
	}
	
	@Test
	public void link_count() throws Exception
	{
		String baseurl = "https://www.snapdeal.com/";
		URL ob=new URL(baseurl);
		
		   HttpURLConnection con=(HttpURLConnection)ob.openConnection();
		   con.connect();
		   if(con.getResponseCode()==200)
		   {
			   System.out.println("valid url");
		   }
		   else
		   {
			   System.out.println("invalid url");
		   }
		
	}
	
	@Test
	public class Page_Content {

		public void main(String[] args) {
			ChromeDriver driver=new ChromeDriver();
			driver.get("https://www.snapdeal.com/");
			
	        String actualcontent=driver.getPageSource();
			if(actualcontent.contains("Help Center"))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}
		}
	}
	
	
	
}
