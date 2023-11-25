package Ata.JiraCh3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	WebDriver driver;

	@BeforeSuite
	public void Setup() {

		ObjectRepository login = new ObjectRepository();

		System.out.println("Before");
		System.setProperty("webdriver.edge.driver",
				System.getProperty("user.dir") + "\\target\\driver\\edgedriver_win64\\msedgedriver.exe");

		// Initiating dirver
		driver = new EdgeDriver();

		// Navigating to the web Page
		driver.get("http://35.199.59.108/secure/Dashboard.jspa");

		// Maximize the window
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.Username)));
		driver.findElement(By.xpath(login.Username)).sendKeys("ata");
		driver.findElement(By.xpath(login.Passowrd)).sendKeys("ata@123");
		driver.findElement(By.xpath(login.Loginbtn)).click();
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(login.ProjectTab)));
		String Expected = driver.findElement(By.xpath(login.ProjectTab)).getText();
		Assert.assertEquals(Expected, "Projects");
	}

	@Test
	public void CreateProject() {
		ObjectRepository Proj = new ObjectRepository();
		driver.findElement(By.xpath(Proj.ProjectTab)).click();
		driver.findElement(By.xpath(Proj.CrtProject)).click();
		driver.findElement(By.xpath(Proj.ProjctType)).click();
		driver.findElement(By.xpath(Proj.NextBtn)).click();
		driver.findElement(By.xpath(Proj.SelctBtn)).click();
		driver.findElement(By.xpath(Proj.name)).sendKeys("Sample Test Project");
		driver.findElement(By.xpath(Proj.SubmitBtn)).click();
	}

	@Test
	public void CreateIssue() {
		ObjectRepository issue = new ObjectRepository();
		driver.findElement(By.xpath(issue.CreateBtn)).click();
		driver.findElement(By.xpath(issue.IssueType)).sendKeys("Epic");
		driver.findElement(By.xpath(issue.IssueType)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(issue.Summary)).sendKeys("Issue");
		driver.findElement(By.xpath(issue.Priority)).sendKeys("Medium");
		driver.findElement(By.xpath(issue.Priority)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(issue.Labels)).sendKeys("Kanban");
		driver.findElement(By.xpath(issue.Labels)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(issue.issueCreatebtn)).click();
	}

//	public void TearDown() {
//		driver.close();
//	}
}
