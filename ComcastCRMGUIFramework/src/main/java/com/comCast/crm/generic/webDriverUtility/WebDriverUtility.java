package com.comCast.crm.generic.webDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Pratyusha
 */

public class WebDriverUtility {
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}


	public void implicityWaitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void ExplacitlyWaitForPageLoadBasedOnVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void ExplacitlyWaitForPageLoadBasedOnVisibility(WebDriver driver, List<WebElement> element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void ExplacitlyWaitForPageLoadBasedOnElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void ExplacitlyWaitForPageLoadBasedOnAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void ExplacitlyWaitForPageLoadBasedOnUrl(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlToBe(url));
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void switchToAlertAndFetchText(WebDriver driver, WebElement element) {
		driver.switchTo().alert();
		element.getText();
	}

	public void switchToAlertAndAddText(WebDriver driver, WebElement element, String data) {
		driver.switchTo().alert();
		element.sendKeys(data);
	}

	public void switchToWindowOnUrl(WebDriver driver, String partialUrl) {

		Set<String> allId = driver.getWindowHandles();
		Iterator<String> itr = allId.iterator();

		while (itr.hasNext()) {

			String windowId = itr.next();
			driver.switchTo().window(windowId);

			String actualUrl = driver.getCurrentUrl();
			if (actualUrl.contains(partialUrl)) {
				break;
			}
		}
	}

	public void switchToWindowOnTitle(WebDriver driver, String partialTitle) {
		String parentId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> itr = allId.iterator();

		while (itr.hasNext()) {

			String windowId = itr.next();
			driver.switchTo().window(windowId);

			String actualTitle = driver.getTitle();
			if (actualTitle.contains(partialTitle)) {
				break;
			}
		}
	}

	/**
	 * Utility methods for switching to Frames
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}

	public void switchToFrameParent(WebDriver driver) {
		driver.switchTo().parentFrame();

	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);

	}

	/**
	 *  Utility methods for DropDown Select class
	 * @param element
	 * @param visibleText
	 */
	 
	public void select(WebElement element, String visibleText) {
		Select sc = new Select(element);
		sc.selectByVisibleText(visibleText);
	}

	public void select(WebElement element, int index) {
		Select sc = new Select(element);
		sc.selectByIndex(index);
	}

	public void selectOnValue(WebElement element, String value) {
		Select sc = new Select(element);
		sc.selectByValue(value);
	}
	/**
	 * Utility Methods for Mouse Action Actions class
	 * @param driver
	 * @param element
	 */
	 

	public void mouseMoveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void mouseClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();

	}

	public void mouseDoubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	public void mouseContextClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void mouseDragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}

	public void mouseDragAndDropBy(WebDriver driver, WebElement element, int xOffSet, int yOffSet) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(element, xOffSet, yOffSet).perform();

	}

	public void mouseRelease(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.release(element).perform();
	}

	public void mousePause(WebDriver driver, Duration time) {
		Actions act = new Actions(driver);
		act.pause(time).perform();
	}

	public void mouseClickAndHold(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element);

	}

	public void mouseMoveByOffSet(WebDriver driver, int xOffSet, int yOffset) {
		Actions act = new Actions(driver);
		act.moveByOffset(xOffSet, xOffSet);
	}
	/**
	 * utility methods for screenshot
	 * @param driver
	 * @throws IOException
	 */
	public void screenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshot/test.png"));
	}

}
