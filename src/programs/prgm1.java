package programs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.netty.util.internal.ThreadLocalRandom;

public class prgm1 {

	private static String dataAleatoria(int minYear, int maxYear) {
		SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");

		Random r = new Random();
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.set(java.util.Calendar.MONTH, Math.abs(r.nextInt()) % 12);
		c.set(java.util.Calendar.DAY_OF_MONTH, Math.abs(r.nextInt()) % 30);
		c.set(java.util.Calendar.YEAR, numeroAleatorio(minYear, maxYear));
		c.setLenient(true);
		return formato.format(c.getTime());
	}
	
	// Function to randomly generate a numeric value between minimum and maximum.
	// Used to fill in numeric text fields.
	private static int numeroAleatorio(int min, int max) {
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}

	// Function to read the values ​​of a select component and then randomly choose
	// one of the values ​​presented.
	private static String selectDropDownListOptions(String el, ChromeDriver driver) {
		Select Make = new Select(driver.findElement(By.id(el)));
		List<WebElement> list_options = Make.getOptions();

		int randomNum = numeroAleatorio(1, list_options.size());
		if (randomNum <= 0) {
			randomNum = 1;
		} else if (randomNum >= list_options.size()) {
			randomNum = list_options.size() - 1;
		}

		WebElement value = list_options.get(randomNum);

		return value.getAttribute("value");
	}

	public static void main(String[] args) throws InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// Navigate to web page
		driver.get("http://sampleapp.tricentis.com/101/app.php");
		new WebDriverWait(driver, Duration.ofSeconds(20));

		// Maximizing window
		driver.manage().window().maximize();

		// After the function randomly generates a value, a select option will be chosen
		// according to the generated value.
		String str = new String();
		str = selectDropDownListOptions("make", driver);
		WebElement selectElement = driver.findElement(By.id("make"));
		Select selectObject = new Select(selectElement);
		selectObject.selectByValue(str);
		// compare if the value selected on the page was the same as randomly defined by
		// the function
		// System.out.println(str);

		// After the function randomly generates a value, a select option will be chosen
		// according to the generated value.
		str = selectDropDownListOptions("model", driver);
		selectElement = driver.findElement(By.id("model"));
		selectObject = new Select(selectElement);
		selectObject.selectByValue(str);
		// compare if the value selected on the page was the same as randomly defined by
		// the function
		// System.out.println(str);

		// After the function randomly generates a value, a select option will be chosen
		// according to the generated value.
		str = selectDropDownListOptions("numberofseats", driver);
		selectElement = driver.findElement(By.id("numberofseats"));
		selectObject = new Select(selectElement);
		selectObject.selectByValue(str);
		// compare if the value selected on the page was the same as randomly defined by
		// the function
		// System.out.println(str);

		// After the function randomly generates a value, a select option will be chosen
		// according to the generated value.
		str = selectDropDownListOptions("numberofseatsmotorcycle", driver);
		selectElement = driver.findElement(By.id("numberofseatsmotorcycle"));
		selectObject = new Select(selectElement);
		selectObject.selectByValue(str);
		// compare if the value selected on the page was the same as randomly defined by
		// the function
		// System.out.println(str);

		// After the function randomly generates a value, a select option will be chosen
		// according to the generated value.
		str = selectDropDownListOptions("fuel", driver);
		selectElement = driver.findElement(By.id("fuel"));
		selectObject = new Select(selectElement);
		selectObject.selectByValue(str);
		// compare if the value selected on the page was the same as randomly defined by
		// the function
		// System.out.println(str);

		// Randomly fills the field with a numeric value between 1 and 2000.
		driver.findElement(By.id("cylindercapacity")).sendKeys(String.valueOf(numeroAleatorio(1, 2000)));

		// Randomly fills the field with a numeric value between 1 and 2000.
		driver.findElement(By.id("engineperformance")).sendKeys(String.valueOf(numeroAleatorio(1, 2000)));

		// Randomly fills the field with a numeric value between 1 and 1000.
		driver.findElement(By.id("payload")).sendKeys(String.valueOf(numeroAleatorio(1, 1000)));

		// Randomly fills the field with a numeric value between 100 and 50000.
		driver.findElement(By.id("totalweight")).sendKeys(String.valueOf(numeroAleatorio(100, 50000)));

		// Randomly fills the field with a numeric value between 500 and 100000.
		driver.findElement(By.id("listprice")).sendKeys(String.valueOf(numeroAleatorio(500, 100000)));

		// Randomly fills the field with a numeric value between 2000 and 50000.
		driver.findElement(By.id("licenseplatenumber")).sendKeys(String.valueOf(numeroAleatorio(2000, 50000)));

		// Randomly fills the field with a numeric value between 100 and 100000.
		driver.findElement(By.id("annualmileage")).sendKeys(String.valueOf(numeroAleatorio(100, 100000)));

		// Randomly fills the field with a numeric value between 100 and 100000.
		driver.findElement(By.id("dateofmanufacture")).sendKeys(String.valueOf(dataAleatoria(2000, 2022)));

		// Find the radio button and choose the option through the id
		WebElement button = driver.findElement(By.xpath("//input[@id='righthanddriveyes']"));
		new Actions(driver).moveToElement(button).click().build().perform();

		// Find the next button and click on it
		button = driver.findElement(By.id("nextenterinsurantdata"));
		button.click();
		
		// Wait 1.5 Seconds
	    Thread.sleep(1500);
		
		// fills the field with the value "Jociel".
		driver.findElement(By.id("firstname")).sendKeys("Jociel");
		
		// fills the field with the value "Dantas".
		driver.findElement(By.id("lastname")).sendKeys("Dantas");
		
		// fills the field with the value "01/01/2001".
		driver.findElement(By.id("birthdate")).sendKeys("01/01/2001");
		
		// Find the radio button and choose the option through the id
		button = driver.findElement(By.xpath("//input[@id='gendermale']"));
		new Actions(driver).moveToElement(button).click().build().perform();
		
		// fills the field with the value "Avenida Sample".
		driver.findElement(By.id("streetaddress")).sendKeys("Avenida Sample");
		
		// After the function randomly generates a value, a select option will be chosen
		// according to the generated value.
		selectElement = driver.findElement(By.id("country"));
		selectObject = new Select(selectElement);
		selectObject.selectByValue("Brazil");
		
		// fills the field with the value "59000000".
		driver.findElement(By.id("zipcode")).sendKeys("59000000");
		
		// fills the field with the value "Parnamirim".
		driver.findElement(By.id("city")).sendKeys("Parnamirim");
		
		// After the function randomly generates a value, a select option will be chosen
		// according to the generated value.
		str = selectDropDownListOptions("occupation", driver);
		selectElement = driver.findElement(By.id("occupation"));
		selectObject = new Select(selectElement);
		selectObject.selectByValue(str);
		// compare if the value selected on the page was the same as randomly defined by
		// the function
		// System.out.println(str);
		
		// Find the checkbox option and mark it through the id
		button = driver.findElement(By.xpath("//input[@id='speeding']"));
		new Actions(driver).moveToElement(button).click().build().perform();
		
		// Find the checkbox option and mark it through the id
		button = driver.findElement(By.xpath("//input[@id='cliffdiving']"));
		new Actions(driver).moveToElement(button).click().build().perform();
		
		//
		driver.findElement(By.id("website")).sendKeys("https://www.linkedin.com/in/jociel-dantas-a63789189/");
		
		//
		StringSelection ss = new StringSelection(System.getProperty("user.dir") + "\\src\\assets\\photo.jpg");
		//System.out.println(ss);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    button = driver.findElement(By.xpath("//button[@id='open']"));
		button.click();
		// Wait 1.5 Seconds
	    Thread.sleep(5000);
	    //imitate mouse events like ENTER, CTRL+C, CTRL+V
	    Robot robot = new Robot();
	    //robot.delay(250);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);	     
        robot.delay(90);
	    robot.keyRelease(KeyEvent.VK_ENTER);
		
	    // Wait 1.5 Seconds
	    Thread.sleep(1500);
	    
	    // Find the next button and click on it 
	    button = driver.findElement(By.id("nextenterproductdata")); 
	    button.click();
		
	    // Wait 1.5 Seconds
	    Thread.sleep(1500);
	    
	    // Randomly fills the field with a numeric value between 100 and 100000.
		driver.findElement(By.id("startdate")).sendKeys(String.valueOf(dataAleatoria(2023, 2024)));
		  
		  
		// After the function randomly generates a value, a select option will be chosen 
		// according to the generated value. 
		str =selectDropDownListOptions("insurancesum", driver); 
		selectElement =driver.findElement(By.id("insurancesum")); 
		selectObject = new Select(selectElement); 
		selectObject.selectByValue(str); 
		// compare if the value selected on the page was the same as randomly defined by 
		// the function 
		// System.out.println(str);
		  
		// After the function randomly generates a value, a select option will be chosen 
		// according to the generated value. 
		str = selectDropDownListOptions("meritrating", driver); 
	    selectElement = driver.findElement(By.id("meritrating")); 
	    selectObject = new Select(selectElement); 
	    selectObject.selectByValue(str); 
	    // compare if the value selected on the page was the same as randomly defined by 
	    // the function // System.out.println(str);
		  
		// After the function randomly generates a value, a select option will be chosen 
	    // according to the generated value. 
	    str = selectDropDownListOptions("damageinsurance", driver); 
		selectElement = driver.findElement(By.id("damageinsurance")); 
		selectObject = new Select(selectElement); 
		selectObject.selectByValue(str); 
		// compare if the value selected on the page was the same as randomly defined by 
		// the function // System.out.println(str);
		  
		// Find the checkbox option and mark it through the id 
		button = driver.findElement(By.xpath("//input[@id='EuroProtection']")); 
		new Actions(driver).moveToElement(button).click().build().perform();
		  
		// After the function randomly generates a value, a select option will be chosen 
		// according to the generated value. 
		str = selectDropDownListOptions("courtesycar", driver); 
		selectElement = driver.findElement(By.id("courtesycar")); 
		selectObject = new Select(selectElement); 
		selectObject.selectByValue(str); 
		// compare if the value selected on the page was the same as randomly defined by 
		// the function // System.out.println(str);
		 
		// Find the next button and click on it 
		button = driver.findElement(By.id("nextselectpriceoption")); 
		button.click();
		  
		// Wait 1.5 Seconds
	    Thread.sleep(1500);
		
		// Find the radio button and choose the option through the id 
	    button = driver.findElement(By.xpath("//input[@id='selectgold']")); 
		new Actions(driver).moveToElement(button).click().build().perform();
		  
		// Wait 1.0 Seconds
	    Thread.sleep(1000);
		  
		// Find the next button and click on it 
		button = driver.findElement(By.id("nextsendquote")); 
		button.click();
		  
		// fills the field with the value "email@email.com".
		driver.findElement(By.id("email")).sendKeys("email@email.com");
		  
		// fills the field with the value "999999999".
		driver.findElement(By.id("phone")).sendKeys("999999999");
		  
		// fills the field with the value "sampleuser".
		driver.findElement(By.id("username")).sendKeys("sampleuser");
		  
		// fills the field with the value "Sample2022".
		driver.findElement(By.id("password")).sendKeys("Sample2022");
		  
		// fills the field with the value "Sample2022".
		driver.findElement(By.id("confirmpassword")).sendKeys("Sample2022");
		  
		// fills the field with the text
		driver.findElement(By.id("Comments")).sendKeys("\r\n" +
		"Good Morning! I hope you have received all my data.\r\n" +
		"Have a great day!");
		  
		// Find the next button and click on it 
		button = driver.findElement(By.id("sendemail")); 
		button.click();
		
		// Wait 15.0 Seconds
	    Thread.sleep(15000);
	    
	    // Verify if value "Sending e-mail success!" is present on the page
	    if (driver.findElement(By.xpath("//*[text()='Sending e-mail success!']")) != null) {

	    // output "Sending e-mail success!" on console if it is showed on the page
	    System.out.println("Sending e-mail success!");
	 
		//driver.quit();
	    }
	}
}
