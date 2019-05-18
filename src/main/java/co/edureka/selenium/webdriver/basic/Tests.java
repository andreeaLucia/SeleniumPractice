package co.edureka.selenium.webdriver.basic;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


public class Tests {
	WebDriver driver;
	JavaScriptExecutor jse;
	@Test
	public void testButtonProgramari() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.bigfitness.ro/m/");
			boolean existenceProgramari = driver.findElement(By.xpath("/html/body/center/a[10]/img")).isDisplayed();
			if(existenceProgramari == true) {
				System.out.println("Programari button exists – Passed");
			}
			else {
				System.out.println("Programari button does not exists – Failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLinkProgramari() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.bigfitness.ro");
			WebElement buttonProgramari = driver.findElement(By.cssSelector("<a href=\"http://programari.bigfitness.ro\" style=\"font-family:'Open Sans';font-size:14px;font-weight:800;color:#685e58;text-decoration:none;\">PROGRAMARI</a>"));
			String expectedLink = "http://www.programari.bigfitness.ro";
			buttonProgramari.click();
			String url = driver.getCurrentUrl();
			Assert.assertEquals(url, expectedLink);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testButtonMaiMulte() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.bigfitness.ro");
			boolean existenceBut = driver.findElement(By.cssSelector("body > center > table:nth-child(14) > tbody > tr > td > table:nth-child(4) > tbody > tr > td > font")).isDisplayed();
			if (existenceBut) {
				WebElement butMaiMulte = driver.findElement(By.cssSelector("body > center > table:nth-child(14) > tbody > tr > td > table:nth-child(4) > tbody > tr > td > font"));
				String expectedLink = "http://www.bigfitness.ro/anunturi.php";
				butMaiMulte.click();
				String url = driver.getCurrentUrl();
				Assert.assertEquals(url, expectedLink);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testLogin() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.reddit.com/");
			WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[1]/header/div/div[2]/div[2]/div[1]/a[1]"));
			loginButton.click();
			driver.navigate().to("https://www.reddit.com/login/");
			WebElement userName = driver.findElement(By.cssSelector("#loginUsername"));
			userName.click();
			userName.sendKeys("andreeaLucia");
			WebElement password = driver.findElement(By.cssSelector("#loginPassword"));
			password.click();
			password.sendKeys("1234567");
			WebElement signIn = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/fieldset[5]/button"));
			signIn.click();
			assertNotEquals("Login cu succes!","https://www.reddit.com/","https://www.reddit.com/login/");	

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testDropDownRomania() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.reddit.com/");
			WebElement dropDownRomania = driver.findElement(By.xpath("//*[@id=\"CountrySort--CountrySortPicker\"]/span"));
			dropDownRomania.click();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test 
	public void testUsabilityOfNightMoodRadioButton() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium\\chromedriver.exe");
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
			driver.get("https://www.reddit.com/");
			String actualCss = driver.findElement(By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[2]/div/div/div")).getCssValue("background-color").toString();
			WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"USER_DROPDOWN_ID\"]"));
			dropDown.click();
			WebElement nightMode = driver.findElement(By.xpath("/html/body/div[4]/button[1]/div"));
			nightMode.click();
			String expectedCss = driver.findElement(By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[2]/div/div/div")).getCssValue("background-color").toString();
			assertEquals(expectedCss, actualCss);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test 
	public void testSearchBox() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.get("https://www.ultimateqa.com/?s");
			String titlePagBeforeSearching = driver.getTitle();
			WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"s\"]"));
			searchBox.click();
			searchBox.sendKeys("selenium webdriver");
			WebElement buttonSearch = driver.findElement(By.xpath("//*[@id=\"searchsubmit\"]"));
			buttonSearch.click();
			String titlePageAfterSearching = driver.getTitle();
			assertNotEquals("Button usability",titlePageAfterSearching,titlePagBeforeSearching);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test 
	public void testingRadioButtons() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.ultimateqa.com/simple-html-elements-for-automation/");

			WebElement radioButton1 = driver.findElement(By.xpath("//*[@id=\"et-boc\"]/div/div[3]/div/div[1]/div[7]/div/div/div/form/input[1]"));
			WebElement radioButton2 = driver.findElement(By.xpath("//*[@id=\"et-boc\"]/div/div[3]/div/div[1]/div[7]/div/div/div/form/input[2]"));
			WebElement radioButton3 = driver.findElement(By.xpath("//*[@id=\"et-boc\"]/div/div[3]/div/div[1]/div[7]/div/div/div/form/input[3]"));
			radioButton1.click();
			radioButton2.click();
			radioButton3.click();
			//driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test 
	public void testingCheckBoxingForBike() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.ultimateqa.com/simple-html-elements-for-automation/");
			
			WebElement checkBox1 = driver.findElement(By.xpath("//*[@id=\"et-boc\"]/div/div[3]/div/div[1]/div[8]/div/div/div/form/input[1]"));
			checkBox1.click();
			if(checkBox1.isSelected()) {
				System.out.println("Checkbox is toggled on");
			}
			else {
				System.out.println("Checkbox is toggled off");
			}
			checkBox1.click();
			if(!checkBox1.isSelected()) {
				System.out.println("Checkbox is now toggled off!!");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test 
	public void testingCheckBoxingForCar() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.ultimateqa.com/simple-html-elements-for-automation/");
			WebElement checkBox2 = driver.findElement(By.xpath("//*[@id=\"et-boc\"]/div/div[3]/div/div[1]/div[8]/div/div/div/form/input[1]"));
			checkBox2.click();
			if(checkBox2.isSelected()) {
				System.out.println("Checkbox is toggled on");
			}
			else {
				System.out.println("Checkbox is toggled off");
			}
			checkBox2.click();
			if(!checkBox2.isSelected()) {
				System.out.println("Checkbox is now toggled off!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
