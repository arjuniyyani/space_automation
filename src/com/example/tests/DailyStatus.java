package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestStatus {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver","/home/vishnu/eclipse/geckodriver");
	driver = new FirefoxDriver();
    baseUrl = "https://accounts.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(baseUrl + "/ServiceLogin?service=ah&passive=true&continue=https%3A%2F%2Fappengine.google.com%2F_ah%2Fconflogin%3Fcontinue%3Dhttp%3A%2F%2Fqburst-space-staging.appspot.com%2F&ltmpl=gm&shdf=ChkLEgZhaG5hbWUaDXNwYWNlIHN0YWdpbmcMEgJhaCIUUcNlw-aKbYKQB2YXWE8TiZtK65goATIURw4BhkrJn5DDgtBD5287MefqeXg#identifier");
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("invoicingqbacc@gmail.com");
    driver.findElement(By.id("next")).click();
    driver.findElement(By.id("Passwd")).clear();
    driver.findElement(By.id("Passwd")).sendKeys("qburst1234");
    driver.findElement(By.id("signIn")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //driver.findElement(By.id("approve_button")).click();
  }

  @Test
  public void testStatus() throws Exception {
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    //driver.findElement(By.xpath("//aside[@id='left-panel']/nav/ul/li[7]/a/i")).click();
    ////aside[@id='left-panel']/nav/ul/li[7]/a/i
    //driver.findElement(By.cssSelector("li.open > ul > li > a.ng-binding")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    new Select(driver.findElement(By.id("postedFor"))).selectByVisibleText("16/01/2017");
    driver.findElement(By.id("message")).clear();
    for(int i = 1; i <= 56;i++){
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   driver.findElement(By.id("project")).sendKeys("infosys");
    new Select(driver.findElement(By.id("timeSpent"))).selectByVisibleText("02");
    driver.findElement(By.id("message")).sendKeys("Test Message for testing daily status");
    driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
    driver.findElement(By.id("saveDailyStatusButton")).click();
    driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
    //driver.findElement(By.cssSelector("i.fa.fa-sign-out")).click();
    //driver.findElement(By.id("bot2-Msg1")).click();
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    //driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
