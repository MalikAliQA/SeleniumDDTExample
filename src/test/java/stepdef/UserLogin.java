package stepdef;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserLogin {
	
	private static WebDriver driver;
	private static String URL = "http://automationpractice.com/index.php";
	private static DataFormatter dataFormatter = new DataFormatter();

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.get("http://automationpractice.com/index.php");
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Given("^I can access the shopping site$")
	public void i_can_access_the_shopping_site() throws Throwable {
		driver.get(URL);
		Thread.sleep(1000);// sleep implemented for visual purpose to slow process down
	}

	@When("^I enter the correct info$")
	public void i_enter_the_correct_info() throws Throwable {
		WebElement homesigninbutton = driver
				.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"));
		homesigninbutton.click();
		Thread.sleep(1000);// sleep implemented for visual purpose to slow process down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.cssSelector("#SubmitLogin"));
		js.executeScript("arguments[0].scrollIntoView(false);", Element);
//		Thread.sleep(1000);
//		WebElement emailinput = driver.findElement(By.cssSelector("#email"));
//		String email = "test999@gmail.com";
//		emailinput.sendKeys(email);
//		Thread.sleep(1000);// sleep implemented for visual purpose to slow process down
//		WebElement passinput = driver.findElement(By.cssSelector("#passwd"));
//		String pass = "root123";
//		passinput.sendKeys(pass);
		FileInputStream file = new FileInputStream("src/test/resources/data/LoginData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		//System.out.println("next output should be malik123");
		//System.out.println(sheet.getRow(2).getCell(1));
	     //Reading
	     for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
	   	//for (int colNum = 0; colNum < sheet.getRow(rowNum).getPhysicalNumberOfCells()-1; colNum++) {
	   		
			XSSFCell cell = sheet.getRow(rowNum).getCell(0);
			String emailCell = cell.getStringCellValue();
			System.out.println(emailCell);
			
			Thread.sleep(1000);// sleep implemented for visual purpose to slow process down
			WebElement emailinput = driver.findElement(By.cssSelector("#email"));
			String email = emailCell;
			emailinput.sendKeys(email);
			
			XSSFCell passcell = sheet.getRow(rowNum).getCell(1);
			String passwordcell = passcell.getStringCellValue();
			System.out.println(passwordcell);
			
			Thread.sleep(1000);// sleep implemented for visual purpose to slow process down
			WebElement passinput = driver.findElement(By.cssSelector("#passwd"));
			String pass = passwordcell;
			passinput.sendKeys(pass);
			
			Thread.sleep(1000);// sleep implemented for visual purpose to slow process down
			WebElement loginclick = driver.findElement(By.cssSelector("#SubmitLogin > span"));
			loginclick.click();
			
			XSSFCell infocell = sheet.getRow(rowNum).getCell(2);
			String fullnamecell = infocell.getStringCellValue();
			System.out.println(fullnamecell);
			
			WebElement info = driver
					.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a > span"));
			System.out.println(info.getText());		
			
			
			if (fullnamecell.equals(info.getText())) {
				assertEquals(fullnamecell, info.getText());
				System.out.println("passed");
				XSSFRow row = sheet.getRow(rowNum);
				XSSFCell assertationcell = row.getCell(3);

				if (assertationcell == null) {
					assertationcell = row.createCell(3) ;
				}
				assertationcell.setCellValue("Successful");
				XSSFRow row1 = sheet.getRow(rowNum);
				XSSFCell statuscell = row1.getCell(4);
				if (statuscell == null) {
					statuscell = row1.createCell(4);
				}
				statuscell.setCellValue("Passed");
			}

				
			FileOutputStream fileOut = new FileOutputStream("src/test/resources/data/LoginData.xlsx");

			workbook.write(fileOut);
			

			
			Thread.sleep(1000);// sleep implemented for visual purpose to slow process down
			WebElement signoutclick = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a"));
			signoutclick.click();
			
			Thread.sleep(1000);// sleep implemented for visual purpose to slow process down
			WebElement homesigninbutton1 = driver
					.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"));
			homesigninbutton1.click();
			
			Thread.sleep(1000);// sleep implemented for visual purpose to slow process down
			WebElement Element1 = driver.findElement(By.cssSelector("#SubmitLogin"));
			js.executeScript("arguments[0].scrollIntoView(false);", Element1);
			
		}

	     // }
			
		file.close();	
		

	}

	@Then("^I sign in$")
	public void i_sign_in() throws Throwable {
//		Thread.sleep(1000);// sleep implemented for visual purpose to slow process down
//		WebElement signinclick = driver.findElement(By.cssSelector("#SubmitLogin > span"));
//		signinclick.click();
//		Thread.sleep(1000);// sleep implemented for visual purpose to slow process down
//		WebElement info = driver
//				.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a > span"));
//		assertEquals("root root", info.getText());
//		Thread.sleep(1000);// sleep implemented for visual purpose to slow process down

	}

}
