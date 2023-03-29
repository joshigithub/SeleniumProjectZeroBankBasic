package TestZeroBankApplication;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		//Set property for Chrome driver
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//Visit https://www.google.com page, and maximize the window
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//On google search page search for specific website enter website name.
		WebElement GoogleSearch = driver.findElement(By.className("gLFyf"));
		GoogleSearch.click();
		GoogleSearch.sendKeys("http://zero.webappsecurity.com");

		//click on googleSearch Button
		WebElement GoogleSearchButton = driver.findElement(By.className("gNO89b"));
		GoogleSearchButton.click();
		Thread.sleep(3000);

		//find website and click on it.
		WebElement searchforZeroBankWebsite = driver.findElement(By.xpath("(//h3[contains(@class,'LC20lb MBeuO')])[1]"));
		searchforZeroBankWebsite.click();
		Thread.sleep(3000);

		//now we are on Zero Bank Webpage, and we want to signin.So we click on signIn button
		WebElement SignInButton = driver.findElement(By.id("signin_button"));
		SignInButton.click();
		Thread.sleep(3000);

		//Enter Valid username
		WebElement LogIn = driver.findElement(By.id("user_login"));
		LogIn.click();
		LogIn.sendKeys("username");
		Thread.sleep(3000);

		//Enter Valid Password
		WebElement Password = driver.findElement(By.id("user_password"));
		Password.click();
		Password.sendKeys("password");
		Thread.sleep(3000);

		//Click on Checkbox(Remember me)
		WebElement ClickCheckBox = driver.findElement(By.id("user_remember_me"));
		ClickCheckBox.click();
		Thread.sleep(3000);

		//Click on Signin button 
		WebElement SignIn = driver.findElement(By.name("submit"));
		SignIn.click();
		Thread.sleep(3000);

		//after SignIn we get an error page so we go back
		driver.navigate().back();

		//here we are in the zero bank as a logedIn USer.
		//now if we want to Logout then Click on Username dropdown.
		WebElement UserNameDropDown = driver.findElement(By.xpath("//a[contains(.,'username')]"));
		UserNameDropDown.click();
		Thread.sleep(3000);

		//under username dropdown find logout button and click on it.
		WebElement LogOutButton = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		LogOutButton.click();
		Thread.sleep(3000);

		//Verify that the Actual Title and Expected title is matched or not.
		String actualTitle = driver.getTitle();
		String expectedTitle = "Zero - Personal Banking - Loans - Credit Cards";
		if(actualTitle.equals(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");

		//close the driver.
		driver.close();

	}


}


