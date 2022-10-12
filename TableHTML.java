package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableHTML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 1. Launch the URL 
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
//2. Get the count of number of rows"
		//table 1
		 List<WebElement> rows1 = driver.findElements(By.xpath("(//table)[1]//tr"));
		 int row1size = rows1.size();
		 System.out.println("Number of rows in table 1 - "+row1size);
		//table2
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='attributes-list']//tr"));
        int rowsize = rows.size();
	    System.out.println("Number of rows in table 2 - "+rowsize);
//3. Get the count of number of columns
	    //table 1
	    List<WebElement> columns1 = driver.findElements(By.xpath("(//table)[1]//tr//th"));
		int col1size = columns1.size();
		System.out.println("Number of columns in table 1 - "+col1size);
	    //table 2
		List<WebElement> columns = driver.findElements(By.xpath("//table[@class='attributes-list']//tr//th"));
        int colsize = columns.size();
	    System.out.println("Number of columns in table 2 - "+colsize);
	}

}
