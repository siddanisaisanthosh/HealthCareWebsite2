package AutomatedTesting;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CapstoneProject{
	WebDriver driver;
	// launching the browser
	@BeforeClass
	public void SetUp() {
		driver = new ChromeDriver();		
		driver.get("https://westfloridaahec.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
	}
	
	// Verifications 
	// Title verification
	@Test(priority=1)
	public void TitleVerification() {
		String Actualtitle = driver.getTitle();
		String ExpectedTitle = "Home - West Florida Area Health Education Center, Inc";
		Assert.assertEquals(ExpectedTitle, Actualtitle);
	}
	
	// navigation menu verification
	@Test(priority=2)
	public void NavigationMenuVerification() {
		WebElement navigationMenu = driver.findElement(By.className("fusion-main-menu"));
		Assert.assertTrue(navigationMenu.isDisplayed());
	}
	
	// Health Programs DropDown Verification
	@Test(priority=3)
	public void HealthProgramsDropDownVerification() {
		WebElement HealthPrograms = driver.findElement(By.xpath("//*[@id=\"menu-item-264\"]/a/span[1]"));
		HealthPrograms.click();
		Assert.assertTrue(HealthPrograms.isDisplayed());
	}
	
	// Services DropDown Verification
	@Test(priority=4)
	public void ServicesDropDownVerification() {
		WebElement Services = driver.findElement(By.xpath("//*[@id=\"menu-item-331\"]/a/span[1]"));
		Services.click();
		Assert.assertTrue(Services.isDisplayed());
	}
	
	// CPR DropDown Verification
	@Test(priority=5)
	public void CprDropDownVerification() {
		WebElement Cpr = driver.findElement(By.xpath("//*[@id=\"menu-item-467\"]/a"));
		Cpr.click();
		Assert.assertTrue(Cpr.isDisplayed());
	}
	
	// About DropDown Verification
	@Test(priority=6)
	public void AboutDropDownVerification() {
		WebElement About = driver.findElement(By.xpath("//*[@id=\"menu-item-616\"]/a/span[1]"));
		About.click();
		Assert.assertTrue(About.isDisplayed());
	}
	
	// About Text Verification
	@Test(priority=7)
	public void AboutTextVerification() {
		WebElement AboutText = driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div[2]/div/div[1]/div/div[1]/h2"));
		String availableActualText = AboutText.getText();
		String ExpectedText = "ABOUT WEST FLORIDA AREA HEALTH EDUCATION CENTER";
		Assert.assertEquals(availableActualText, ExpectedText);
	}
	
	// AboutUs Link Verification
	@Test(priority=8)
	public void AboutUsLinkVerification() {
		WebElement AboutUS = driver.findElement(By.linkText("ABOUT US"));
		Assert.assertTrue(AboutUS.isEnabled());
	}
	
	// ContactUs Link Verification
	@Test(priority=9)
	public void ContactUsLinkVerification() {
		WebElement ContactUS = driver.findElement(By.linkText("CONTACT US"));
		Assert.assertTrue(ContactUS.isEnabled());
	}
	
	// Facebook Link Verification
	@Test(priority=10)
	public void FacebookLinkVerification() {
		WebElement Facebook = driver.findElement(By.linkText("FACEBOOK"));
		Assert.assertTrue(Facebook.isEnabled());
	}
	
	// QuitTobbacco Link Verification
	@Test(priority=11)
	public void QuitTobbaccoLinkVerification() {
		WebElement QuitTobbacco = driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div[1]/div/div/div/div[1]/div[1]/div/div/a/h2"));
		Assert.assertTrue(QuitTobbacco.isEnabled());
	}
	
	// Healthy Aging Link Verification
	@Test(priority=12)
	public void HealthyAgingLinkVerification() {
		WebElement HealthyAging = driver.findElement(By.linkText("HEALTHY AGING PROGRAMS"));
		Assert.assertTrue(HealthyAging.isEnabled());
	}
	
	// Health Insurance Link Verification
	@Test(priority=13)
	public void HealthInsuranceLinkVerification() {
		WebElement HealthInsurance = driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div[1]/div/div/div/div[1]/div[3]/div/div/a/h2"));
		Assert.assertTrue(HealthInsurance.isEnabled());
	}
	
	// AhecScholars Link Verification
	@Test(priority=14)
	public void AhecScholarsLinkVerification() {
		WebElement AhecScholars = driver.findElement(By.linkText("AHEC SCHOLARS"));
		Assert.assertTrue(AhecScholars.isEnabled());
	}
	
	// Test the functionality of the search bar and the links to various health programs and services.
	 
	// Search Bar Funtionality
	@Test(priority=15)
	public void SearchBarFuntionality() {
		WebElement Search = driver.findElement(By.className("s"));
		Search.sendKeys("Health Programs");
		WebElement SearchButton = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[2]/input"));
		Assert.assertTrue(SearchButton.isEnabled());
		SearchButton.click();
		driver.navigate().back();
		Search.clear();
	}
	
	// links to various health programs which are opening one by one & verifying 
	// Health Programs Functionality1
	@Test(priority=16)
	public void HealthProgramsFunctionality1() {
		WebElement Search =driver.findElement(By.className("s"));
		Search.sendKeys("Tobacco");
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[2]/input")).click();
		String value=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/div/div/div/h1")).getText();
		Boolean contains=value.contains("Tobacco");
		Assert.assertTrue(contains);
		driver.navigate().back();
		Search.clear();
	}
	
	// Health Programs Functionality2
	@Test(priority=17)
	public void HealthProgramsFunctionality2() {
		WebElement Search =driver.findElement(By.className("s"));
		Search.sendKeys("AHEC SCHOLARS");
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[2]/input")).click();
		String value=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/div/div/div/h1")).getText();
		Boolean contains=value.contains("AHEC SCHOLARS");
		Assert.assertTrue(contains);
		driver.navigate().back();
		Search.clear();		
	}
	
	// Health Programs Functionality3
	@Test(priority=18)
	public void HealthProgramsFunctionality3() {
		WebElement Search =driver.findElement(By.className("s"));
		Search.sendKeys("Healthy Aging");
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[2]/input")).click();
		String value=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/div/div/div/h1")).getText();
		Boolean contains=value.contains("Healthy Aging");
		Assert.assertTrue(contains);
		driver.navigate().back();
		Search.clear();		
	}
	
	// Health Programs Functionality4
	@Test(priority=19)
	public void HealthProgramsFunctionality4() {
		WebElement Search =driver.findElement(By.className("s"));
		Search.sendKeys("Covering Florida");
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[2]/input")).click();
		String value=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/div/div/div/h1")).getText();
		Boolean contains=value.contains("Covering Florida");
		Assert.assertTrue(contains);
		driver.navigate().back();
		Search.clear();		
	}
	
	// another method (links to various health programs which are opening on loop & verifying on loop)
	// Health Programs Functionality on loop
	@Test(priority=20)
	public void HealthProgramsFunctionality() {
		String[] Arrays = {"Tobacco","AHEC SCHOLARS","Healthy Aging","Covering Florida"};
		for (String array : Arrays) {
			WebElement Search =driver.findElement(By.className("s"));
			Search.sendKeys(array);
			driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[2]/input")).click();
			String value=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/div/div/div/h1")).getText();
			Boolean contains=value.contains(array);
			Assert.assertTrue(contains);
			driver.navigate().back();
			Search.clear();		
		}
	}
	
	// links to various services which are opening on loop & verifying on loop
	// Services Functionality on loop
	@Test(priority=21)
	public void ServicesFunctionality() {
		String[] Arrays = {"Community Based Student Education and Training", "Continuing Education Services"};
		for (String array : Arrays) {
			WebElement Search =driver.findElement(By.className("s"));
			Search.sendKeys(array);
			driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[2]/input")).click();
			String value=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/div/div/div/h1")).getText();
			Boolean contains=value.contains(array);
			Assert.assertTrue(contains);
			driver.navigate().back();
			Search.clear();		
		}		
	}	
	
	// links to various About's which are opening on loop & verifying on loop	
	// About Functionality on loop
	@Test(priority=22)
	public void AboutFunctionality() {
		String[] Arrays = {"Board of Directors", "Staff", "Partners", "Work With Us", "History of AHEC"};
		for (String array : Arrays) {
			WebElement Search =driver.findElement(By.className("s"));
			Search.sendKeys(array);
			driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[2]/input")).click();
			String value=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/div/div/div/h1")).getText();
			Boolean contains=value.contains(array);
			Assert.assertTrue(contains);
			driver.navigate().back();
			Search.clear();		
		}		
	}	
	
	// Automate the navigation to different programs and ensure the correct display of content and related resources. 
	// HealthPrograms_TobaccoContent_Verification
	@Test(priority=23)
	public void HealthPrograms_TobaccoContent_Verification() {
		WebElement hoverElement = driver.findElement(By.xpath("//*[@id=\"menu-item-264\"]/a/span[1]"));
		Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        driver.findElement(By.id("menu-item-344")).click();
        String ExpectedText = "QUIT TOBACCO";
        String TextSource = driver.getPageSource();
        Assert.assertTrue(TextSource.contains(ExpectedText), "The expected text was not found on the page.");
        driver.navigate().back();
	}
	
	// HealthPrograms_AHECSCHOLARS_Verification
	@Test(priority=24)
	public void HealthPrograms_AHECSCHOLARS_Verification() {
		WebElement hoverElement = driver.findElement(By.xpath("//*[@id=\"menu-item-264\"]/a/span[1]"));
		Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        driver.findElement(By.id("menu-item-280")).click();
        String ExpectedText = "The Scholars Program is nationally recognized and only 150 students in the state of Florida are able to join this elite program.";
        String TextSource = driver.getPageSource();
        Assert.assertTrue(TextSource.contains(ExpectedText), "The expected text was not found on the page.");
        driver.navigate().back();
	}
	
	// HealthPrograms_HealthyAging_Verification
	@Test(priority=25)
	public void HealthPrograms_HealthyAging_Verification() {
		WebElement hoverElement = driver.findElement(By.xpath("//*[@id=\"menu-item-264\"]/a/span[1]"));
		Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        driver.findElement(By.id("menu-item-534")).click();
        String ExpectedText = "West Florida Area Health Education Center";
        String TextSource = driver.getPageSource();
        Assert.assertTrue(TextSource.contains(ExpectedText), "The expected text was not found on the page.");
        driver.navigate().back();
	}
	
	// HealthPrograms_CoveringFlorida_Verification
	@Test(priority=26)
	public void HealthPrograms_CoveringFlorida_Verification() {
		WebElement hoverElement = driver.findElement(By.xpath("//*[@id=\"menu-item-264\"]/a/span[1]"));
		Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        driver.findElement(By.id("menu-item-1572")).click();
        String ExpectedText = "Covering Florida Program Navigators are trained and able to provide free and unbiased help to consumers";
        String TextSource = driver.getPageSource();
        Assert.assertTrue(TextSource.contains(ExpectedText), "The expected text was not found on the page.");
        driver.navigate().back();
	}
	
	// Automate the navigation to different Services and ensure the correct display of content and related resources. 
    // Services_CommunityBased_Verification
	@Test(priority=27)
	public void Services_CommunityBased_Verification() {
		WebElement hoverElement = driver.findElement(By.xpath("//*[@id=\"menu-item-331\"]/a/span[1]"));
		Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        driver.findElement(By.id("menu-item-440")).click();
        String ExpectedText = "Community-based clinical training";
        String TextSource = driver.getPageSource();
        Assert.assertTrue(TextSource.contains(ExpectedText), "The expected text was not found on the page.");
        driver.navigate().back();
	}
	
	//Services_ContinuingEducationServices_Verification
	@Test(priority=28)
	public void Services_ContinuingEducationServices_Verification() {
		WebElement hoverElement = driver.findElement(By.xpath("//*[@id=\"menu-item-331\"]/a/span[1]"));
		Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        driver.findElement(By.id("menu-item-330")).click();
        String ExpectedText = "Continuing Education Services";
        String TextSource = driver.getPageSource();
        Assert.assertTrue(TextSource.contains(ExpectedText), "The expected text was not found on the page.");
        driver.navigate().back();
	}
	
	// User Registration
	@Test(priority=29)
	public void UserRegistration() {
		WebElement hoverElement = driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]/a/span[1]"));
		Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        driver.findElement(By.className("fusion-menu-login-box-register")).click();
        driver.findElement(By.name("username")).sendKeys("siddanisaisanthosh");
        driver.findElement(By.name("email")).sendKeys("siddanisanthosh@gmail.com");
        driver.findElement(By.name("password")).sendKeys("12345678@santhosh");
        driver.findElement(By.name("register")).click();
        driver.navigate().back();
	}
	
	// User Login
	@Test(priority=30)
	public void UserLogin() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]/a/span[1]")).click();		
        driver.findElement(By.id("username")).sendKeys("siddanisanthosh@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345678@santhosh");
        driver.findElement(By.id("rememberme")).click();
        driver.findElement(By.name("login")).click();        
        driver.navigate().back();
        driver.navigate().back();
	}
	
	//Registering for Health Aging program
	@Test(priority=31)
	public void HealthAgingRegister() throws InterruptedException, IOException {
		WebElement program=driver.findElement(By.id("menu-item-264"));
    	Actions a=new Actions(driver);
    	a.moveToElement(program).perform();
    	driver.findElement(By.id("menu-item-534")).click();
    	Thread.sleep(7000);
    	driver.findElement(By.xpath("//*[@id=\"cog-input-auto-0\"]")).sendKeys("santhosh");
    	driver.findElement(By.id("cog-input-auto-1")).sendKeys("siddani");
    	driver.findElement(By.id("cog-1")).sendKeys("9876543210");
    	driver.findElement(By.xpath("//*[@id=\"cog-2\"]")).sendKeys("abc@gmail.com");
    	driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[1]/div[1]/div[1]/div/label[2]")).click();
    	driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[1]/div[1]/div[1]/div/label[5]")).click();
    	driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[2]/div[1]/div[1]/div/label[2]")).click();
    	driver.findElement(By.id("cog-7")).sendKeys("I am a good tester");
    	driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[8]/div/div[1]/label/span[1]")).click();
    	driver.findElement(By.className("cog-button__text")).click();
    	String message = driver.findElement(By.xpath("/html/body/div[8]/div/main/div/section/div/div/div[1]/div/div[1]/div/form/div/div/div[1]/div[1]/div/div[1]")).getText();
    	Assert.assertNotNull(message);
    	// Highlight and screenshot
    	Thread.sleep(5000);
    	JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].style.backgroundColor='yellow'",driver.findElement(By.className("entry-title")));
		TakesScreenshot tk=(TakesScreenshot) driver;
		File sourceFile=tk.getScreenshotAs(OutputType.FILE);
		File destFile=new File("C:\\Users\\HP\\Desktop\\ProjectScreenshot/img2.jpg");
		FileUtils.copyFile(sourceFile,destFile);
    	driver.navigate().back();
	}
	
	// using Exception and Highlighting and Taking Screenshot
	@Test(priority=32)
	public void tobaccoVerification() throws IOException {
		  WebElement tobacco=driver.findElement(By.id("menu-item-264"));
		  Actions a=new Actions(driver);
		  a.moveToElement(tobacco).perform();
		  driver.findElement(By.id("menu-item-344")).click();
		  String heading=driver.findElement(By.className("entry-title")).getText();
		  System.out.println(heading);
		  boolean result=heading.equalsIgnoreCase("Tobacco");
		  if(result==true)
		  {
			  System.out.println("Tobacco page content dispalyed correctly");
		  }
		  else {
			  System.out.println("Tobacco page  not dispalyed correctly");
		  }
		  JavascriptExecutor jse=(JavascriptExecutor)driver;
		  jse.executeScript("arguments[0].style.backgroundColor='yellow'",driver.findElement(By.className("entry-title")));
		  TakesScreenshot tk=(TakesScreenshot) driver;
		  File sourceFile=tk.getScreenshotAs(OutputType.FILE);
		  File destFile=new File("C:\\Users\\HP\\Desktop\\ProjectScreenshot/img1.jpg");
		  FileUtils.copyFile(sourceFile,destFile);
	      driver.navigate().back();
	}
	
	// Closing the Browser
	@AfterClass
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();		
	}
}