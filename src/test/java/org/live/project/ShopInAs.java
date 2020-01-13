package org.live.project;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ShopInAs {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "F:\\SOFTWARES\\selenium\\WORKED_FILED\\eclipse-workspace_selenium_projrcts\\Project1\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		TakesScreenshot tk = (TakesScreenshot)driver;
		driver.get("https://www.shopinas.com/");
		
		File s1 = tk.getScreenshotAs(OutputType.FILE);
		File d1 = new File ("F:\\SOFTWARES\\selenium\\PROJECT\\shopinas\\url.jpeg");
		FileUtils.copyFile(s1, d1);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"login_link\"]/i")).click();
		driver.findElement(By.xpath("//*[@id=\"UserUsername\"]")).sendKeys(getData(4,2));
		driver.findElement(By.xpath("//*[@id=\"UserPassword\"]")).sendKeys(getData(4,3));
		driver.findElement(By.xpath("//*[@id=\"bodyBox\"]/input[3]")).click();
		
		File s2 = tk.getScreenshotAs(OutputType.FILE);
		File d2 = new File ("F:\\SOFTWARES\\selenium\\PROJECT\\shopinas\\login.jpeg");
		FileUtils.copyFile(s2, d2);
		
		Thread.sleep(5000);
		WebElement search = driver.findElement(By.xpath("(//*[@id=\"SearchQuery\"])[2]"));
		search.sendKeys("DINNER BELL MAN");
		search.sendKeys(Keys.ENTER);
		
		File s3 = tk.getScreenshotAs(OutputType.FILE);
		File d3 = new File ("F:\\SOFTWARES\\selenium\\PROJECT\\shopinas\\product.jpeg");
		FileUtils.copyFile(s3, d3);
		
		WebElement product = driver.findElement(By.xpath("//*[@id=\"PageContainer\"]/main/div/div/div/div[1]/div/div[1]/div/div/div[3]/p[1]/a"));

		Actions acc = new Actions(driver);
		acc.contextClick(product).perform();
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		
		for (String x : child) {
		driver.switchTo().window(x);
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"AddToCartText\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"CartIndexForm\"]/div[2]/div[2]/a")).click();
		
		File s4 = tk.getScreenshotAs(OutputType.FILE);
		File d4 = new File ("F:\\SOFTWARES\\selenium\\PROJECT\\shopinas\\checkout.jpeg");
		FileUtils.copyFile(s4, d4);
	}
	public static String getData(int rowNo, int cellNo) throws Throwable {
		String v = null;
		File loc = new File("F:\\SOFTWARES\\selenium\\WORKED_FILED\\eclipse-workspace_selenium_projrcts\\Demo\\testdatas\\ListOfProjectWithUsername.xlsx");
		FileInputStream stream = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Project Details");
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		
		v = c.getStringCellValue();
		return v;
	}
}
