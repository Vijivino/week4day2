package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealActions {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//1. Launch https://www.snapdeal.com/
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		options.addArguments("disable notifications");
		driver.manage().window().maximize();
// 2. Go to Mens and Sports Shoes
		WebElement element = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		WebElement shoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(element).click(shoes).perform();
		Thread.sleep(3000);
// 4. Get the count of the sports shoes
		String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Total shoes " + count);
// 5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(3000);
// 6. Sort by Low to High
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		Thread.sleep(3000);
// 7. Check if the items displayed are sorted correctly
	 // get all the display price webelement in a webele list
		List<WebElement> pricelist = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
	// add the attribute of display price into other string list
		List<String> plist = new ArrayList<String>();
		for (WebElement each : pricelist) {
			String price = each.getText();
			plist.add(price);
			}
	// convert the string into int and store it in other int list
		List<Integer> listint = new ArrayList<Integer>();
		for (String each : plist) {
			String replaceAll = each.replaceAll("[^0-9]", "");
			int intvalue = Integer.parseInt(replaceAll);
			listint.add(intvalue);
		}
		System.out.println(listint);
    // sort the list and store it in other list 
		Collections.sort(listint);
		List<Integer> list2 = new ArrayList<Integer>();
		for (Integer integer : listint) {
			list2.add(integer);
		}
		System.out.println(list2);
		
/*	// then check before and after sort list 
		for (int i = 0; i <= listint.size() - 1; i++) {
			//for(int j=0;j<list2.size()-1;j++) {
			   if (listint.get(i).equals(list2.get(i))) {
				   System.out.println("Sorting is verified");
				  // break;
			} else {
				System.out.println("sorting is not verified");
			}
		}
		//}
	*/	
		
// 8.Select the price range (900-1200)
		WebElement from = driver.findElement(By.name("fromVal"));
		from.clear();
		from.sendKeys("900");
		Thread.sleep(3000);
		WebElement to = driver.findElement(By.name("toVal"));
		to.clear();
		to.sendKeys("1200");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(3000);
// 9.Filter with color Navy
		driver.findElement(By.xpath("//label[@for='Color_s-Yellow']")).click();
//10 verify the all applied filters 
		// verify the price filter
		String price = driver.findElement(By.xpath("//a[@data-key='Price|Price']")).getText();
		if (price.contains("900")) {
			System.out.println("price filter is applied");
		} else {
			System.out.println("no filter");
		}
		Thread.sleep(3000);
		// verify the color filter
		String color = driver.findElement(By.xpath("//a[@data-key='Color_s|Color']")).getText();
		if (color.equals("Yellow")) {
			System.out.println("color filter is applied");
		} else {
			System.out.println("no filter");
		}
// 11. Mouse Hover on first resulting Training shoes and click QuickView button
		WebElement pic = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		WebElement quick = driver.findElement(By.xpath("//div[contains(text(),'Quick')]"));
		Thread.sleep(3000);
		builder.moveToElement(pic).click(quick).perform();
		Thread.sleep(3000);
// 13. Print the cost and the discount percentage
        String text2 = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Cost of shoe - " + text2);
		String text3 = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Discount " + text3);
// 14. Take the snapshot of the shoes.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File desti = new File("./snaps/snaps2.png");
		FileUtils.copyFile(source, desti);
		Thread.sleep(3000);
// 15. Close the current window
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		Thread.sleep(3000);
// 16. Close the main window
		driver.close();

	}

}
