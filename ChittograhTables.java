package week4.day2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChittograhTables {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated 
// 1. Launch the URL 
		WebDriverManager.chromedriver().setup();
		//ChromeOptions options=new ChromeOptions();
	    ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
//2. Click on stock market
		//driver.findElement(By.xpath("//a[@title='Stock Market']"));
		driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
		Thread.sleep(8000);
//3. Click on NSE bulk Deals
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		Thread.sleep(8000);
//4. Get all the Security names
		//to know the size of column security names
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr//td[3]"));
		Thread.sleep(8000);
		int size = elements.size();
		//add the webelemt values into the list
		List<String> list=new ArrayList<String>();
		for(int i=1;i<size;i++) {
			String text = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr["+i+"]//td[3]")).getText();
	        list.add(text)	;
		}
		System.out.println(list);
//5. Ensure whether there are duplicate Security names
		////pass the list to set in order to check for duplicates
		LinkedHashSet<String> set=new LinkedHashSet<String>(list);
		int size2 = set.size();
		if(size==size2) {
			System.out.println("There are no duplicates");
		}else {
			System.out.println("There are duplicates");
		}
		
		
	}

}
