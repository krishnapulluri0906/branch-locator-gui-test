package info.stepDefinition;

import info.reusables.TestDataHandler;
import info.steps.HomePageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BranchLocaterStepDefinition {

	
	@Steps
	HomePageSteps homePageSteps;
	

	@Given("I want to launch lloyds banking application")
	public void i_want_to_launch_lloyds_banking_application() {
		homePageSteps.launchURL();
		
	}

	@When("I want to search the lloyds banking branch with postcode {string}")
	public void i_want_to_search_the_lloyds_banking_branch_with_postcode(String data_id) {
		String postCodeValue = TestDataHandler.getData(data_id, "PostCodeIDColumn");
		homePageSteps.clickAndEnterPostCode(postCodeValue);
		
	}

	@Then("I want to filter the first nearest branch")
	public void i_want_to_filter_the_first_nearest_branch() {
		homePageSteps.navigateToViewBranchLink();
		
		
	}

	@Then("I want to print phone number in bdd test resport")
	public void i_want_to_print_phone_number_in_bdd_test_resport() {
		homePageSteps.txtPhoneNumber();
		
	}

}
