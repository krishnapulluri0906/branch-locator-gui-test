package info.steps;

import info.pageObjects.HomePage;
import info.reusables.reusable;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HomePageSteps extends ScenarioSteps {

	HomePage objHomePage;
	reusable objResuable = new reusable();
	public final static String Framework_specifications_property_path = "testproperties/";
	public final static String Application_url_property_file = "globalSettings.properties";

	@Step
	public void launchURL() {
		String appurl = objResuable.readProperty(Application_url_property_file, "url");
		getDriver().get(appurl);
		getDriver().manage().window().maximize();
	}

	@Step
	public void clickAndEnterPostCode(String PostCodeValue) {
		objHomePage.clickOnBranchFinderLink();
		objHomePage.enterTextInPostCode(PostCodeValue);

	}

	@Step
	public void navigateToViewBranchLink() {
		objHomePage.clickOnViewBranchLink();

	}

	@Step
	public void txtPhoneNumber() {
		objHomePage.txtPhoneNumberValue();

	}

}
