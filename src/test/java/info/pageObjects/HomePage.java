package info.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.reusables.customEnsure;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;



public class HomePage extends PageObject {
	protected static final Logger LOG = LoggerFactory.getLogger(HomePage.class);


	@FindBy(xpath = "(//span[text()='Branch Finder'])[1]")
	protected WebElementFacade lnkBranchFinder;

	@FindBy(xpath = "//input[@name='qp']")
	protected WebElementFacade txtEnterPostCode;
	
	@FindBy(xpath = "(//a[@class='Teaser-ctaLink'])[1]")
	protected WebElementFacade lnkFirstBranch;
	
	
	@FindBy(xpath = "//button[@id='accept']")
	protected WebElementFacade btnAccept;
	
	
	@FindBy(id = "phone-main")
	protected WebElementFacade txtPhoneNumber;
		

	public void clickOnBranchFinderLink() {
		lnkBranchFinder.click();
	}
	
	public void enterTextInPostCode(String postCode) {
		txtEnterPostCode.sendKeys(postCode);
		if(btnAccept.isVisible()) {
			btnAccept.click();
		}
		txtEnterPostCode.sendKeys(Keys.ENTER);
	}
	
	public void clickOnViewBranchLink() {
		lnkFirstBranch.click();
		
	}
	
	public void txtPhoneNumberValue() {		
		WebElement element = getDriver().findElement(By.id("phone-main"));   
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();",element);
		String phoneNumber = txtPhoneNumber.getText();
		customEnsure.customLogWithoutScreenShot("Phone Number for postcode is ====" + phoneNumber,"pass");
		LOG.info("Phone Number for postcode is ====" + phoneNumber);

	}
	
	
	

}
