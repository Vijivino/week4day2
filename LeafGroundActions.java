package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//browser setup	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml\r\n");
		driver.manage().window().maximize();
//drag and drop	into random position	
	    WebElement drag = driver.findElement(By.xpath("//span[text()='Drag and Drop']"));	
		Actions builder=new Actions(driver); 
		Thread.sleep(3000);
		builder.dragAndDropBy(drag, 500,0).perform();
///draggable columns
		WebElement source = driver.findElement(By.xpath("//span[text()='Name']"));	
		WebElement dest = driver.findElement(By.xpath("//span[text()='Category']"));
		builder.dragAndDrop(source, dest).perform();
		Thread.sleep(3000);
//resize image
		WebElement size = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));
	    builder.dragAndDropBy(size, 120,0).perform();	
	    Thread.sleep(3000);
//droppable to target
	    WebElement source2 = driver.findElement(By.xpath("//div[@id='form:drag_content']"));	
		WebElement dest2 = driver.findElement(By.xpath("//div[@id='form:drop_content']"));	
		builder.dragAndDrop(source2, dest2).perform();
		Thread.sleep(3000);
//draggable rows
		WebElement source1 = driver.findElement(By.xpath("(//td[text()='Black Watch'])[2]"));	
		WebElement dest1 = driver.findElement(By.xpath("(//td[text()='Chakra Bracelet'])[2]"));	
		builder.dragAndDrop(source1, dest1).perform();
		Thread.sleep(3000);
//progressbar
		WebElement pro = driver.findElement(By.xpath("//span[text()='Start']"));
		builder.click(pro).perform();
		Thread.sleep(5000);
//range slider		
		WebElement slid = driver.findElement(By.xpath("//span[@style='left: 30%;']"));
		//WebElement slid2 = driver.findElement(By.xpath("//span[@style='left: 60%;']"));
		builder.dragAndDropBy(slid,300,0).perform();
		Thread.sleep(5000);
		
	}

}
