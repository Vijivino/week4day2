package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykka {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
/*		Assignment 2:
			=============
			1) Go to https://www.nykaa.com/
			2) Mouseover on Brands and Search L'Oreal Paris
			3) Click L'Oreal Paris
			4) Check the title contains L'Oreal Paris(Hint-GetTitle)
			5) Click sort By and select customer top rated
			6) Click Category and click Hair->Click haircare->Shampoo
			7) Click->Concern->Color Protection
			8)check whether the Filter is applied with Shampoo
			9) Click on L'Oreal Paris Colour Protect Shampoo
			10) GO to the new window and select size as 175ml
			11) Print the MRP of the product
			12) Click on ADD to BAG
			13) Go to Shopping Bag 
			14) Print the Grand Total amount
			15) Click Proceed
			16) Click on Continue as Guest
			17) Check if this grand total is the same in step 14
			18) Close all windows

*/
//browser setup	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
	    ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		options.addArguments("disable notifications");
		driver.manage().window().maximize();
//Mouseover on Brands and Search L'Oreal Paris		
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(brands).perform();
		Thread.sleep(2000);
		//click L'oreal paris using " "
		driver.findElement(By.xpath("//a[text()=\"L'Oreal Paris\"]")).click();
//Check the title contains L'Oreal Paris(Hint-GetTitle)
		if(driver.getTitle().contains("Paris")) {
        	System.out.println("Title is verified -- "+driver.getTitle());
        }
        else {
        	System.out.println("Title is not verified");
        }
//Click sort By and select customer top rated		
        driver.findElement(By.xpath("//span[@class='sort-name']")).click();
        driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
//Click Category and click Hair->Click haircare->Shampoo
        driver.findElement(By.xpath("//span[text()='Category']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='Hair']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class=' css-b5p5ep']/span[text()='Hair Care']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='control-value']/span[text()='Shampoo']")).click();
        Thread.sleep(5000);
//Click on L'Oreal Paris Colour Protect Shampoo
        driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();
//GO to the new window and select size as 175ml	
        Thread.sleep(3000);
	    Set<String> handles = driver.getWindowHandles();
	    List<String> list=new ArrayList<String>(handles);
        driver.switchTo().window(list.get(1));
        //select using select class constructor
        WebElement select = driver.findElement(By.xpath("//select[@title='SIZE']"));
	    Select sel=new Select(select);
	    sel.selectByValue("0");
//Print the MRP of the product
	    String price = driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
	    System.out.println("price is "+price);
//Click on ADD to BAG	    
	    driver.findElement(By.xpath("//button[@type='button']/span[text()='Add to Bag']")).click();
//Go to Shopping Bag and Print the Grand Total amount	
	    driver.findElement(By.xpath("//button[@type='button']")).click();
	    Thread.sleep(9000);
	    driver.switchTo().frame(0);
	    String total = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
	    String replaceAll = total.replaceAll("[^0-9]", "");
	    int parseInt = Integer.parseInt(replaceAll);
	    System.out.println("Grand total "+parseInt);
// Click Proceed and Click on Continue as Guest	
	    driver.findElement(By.xpath("//span[@class='proceed-btn-text capitalize-uppercase-vernacular']")).click();
	    Thread.sleep(6000);
	    driver.switchTo().defaultContent();
	    driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
	    Thread.sleep(6000);
//Check if this grand total	
	    String total2 = driver.findElement(By.xpath("(//div[@class='value']/span)[2]")).getText();
	    String replaceAll2 = total2.replaceAll("\\D", " ");
	    int parseInt2 = Integer.parseInt(replaceAll2);
	    System.out.println(parseInt2);
	    if(parseInt==parseInt2) {
	    	System.out.println("total is verified");
	    }else {
	    	System.out.println("total is not verified");
	    }
	    
	    driver.close();
	    
	    
	
	}

}
