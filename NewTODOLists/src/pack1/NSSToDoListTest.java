package pack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NSSToDoListTest {
	WebDriver driver;
	@BeforeTest
	public void BrowserSetUp() {
		System.setProperty("webdriver.chrome.driver","C:\\All Driver\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost/dotdash-project/index.php");
	}
	@Test(priority=0)
	public void HeadlineCheck() {
		driver.findElement(By.xpath("/html/body/b")).getText();
	}
	@Test(priority=1)
	public void CreatingToDoTest() throws InterruptedException {
		driver.findElement(By.name("data")).sendKeys("Laundry");
		Select CtgSelect1 = new Select (driver.findElement(By.xpath("//select[1]")));
		CtgSelect1.selectByVisibleText("Work");
		Select DySelect1 = new Select (driver.findElement(By.xpath("//select[2]")));
		DySelect1.selectByIndex(25);
		Select MnSelect1 = new Select (driver.findElement(By.xpath("//select[3]")));
		MnSelect1.selectByVisibleText("Feb");
		Select YrSelect1 = new Select (driver.findElement(By.xpath("//select[4]")));
		YrSelect1.selectByVisibleText("2019");
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("data")).sendKeys("Cooking Spaghetti");
		Select CtgSelect2 = new Select (driver.findElement(By.xpath("//select[1]")));
		CtgSelect2.selectByVisibleText("Leisure");
		Select DySelect2 = new Select (driver.findElement(By.xpath("//select[2]")));
		DySelect2.selectByIndex(25);
		Select MnSelect2 = new Select (driver.findElement(By.xpath("//select[3]")));
		MnSelect2.selectByVisibleText("Feb");
		Select YrSelect2 = new Select (driver.findElement(By.xpath("//select[4]")));
		YrSelect2.selectByVisibleText("2019");
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		Thread.sleep(3000);
	}
	@Test(priority=2)
	public void CreatingNewCategories() throws InterruptedException {
		driver.findElement(By.name("categorydata")).sendKeys("BillPayment");
		Select ClrSelect = new Select (driver.findElement(By.xpath("//select[5]")));
		ClrSelect.selectByVisibleText("Green");
		Thread.sleep(3000);
	}
	@Test(priority=3)
	public void ModifyExistingTodos() throws InterruptedException {
		driver.findElement(By.name("todo[3]")).click();
		driver.findElement(By.xpath("//input[@value='Complete']")).click();
		Thread.sleep(3000);
		}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}


}
