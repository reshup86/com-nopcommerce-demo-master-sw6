package com.nopcommerce.demo.cucumber.steps;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    @Given("^I am on homepage$")
    public void iAmOnHomepage() {
    }

    @When("^I click on login link$")
    public void iClickOnLoginLink() {
        new HomePage().clickOnLoginLink();
    }

    @Then("^I should navigate to login page successfully$")
    public void iShouldNavigateToLoginPageSuccessfully() {
        new LoginPage().getWelcomeText();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = new LoginPage().getWelcomeText();
        Assert.assertEquals("Login is not displayed", expectedMessage,actualMessage);
    }

    @And("^I entered email \"([^\"]*)\"$")
    public void iEnteredEmail(String email)  {
        new LoginPage().enterEmailId(email);
    }

    @And("^I enter password \"([^\"]*)\"$")
    public void iEnterPassword(String password)  {
        new LoginPage().enterPassword(password);
    }

    @And("^I click on login button$")
    public void iClickOnLoginButton() {
        new LoginPage().clickOnLoginButton();
    }

    @Then("^I should see the error message \"([^\"]*)\"$")
    public void iShouldSeeTheErrorMessage(String errorMessage)  {
        Assert.assertEquals("Invalid data",errorMessage,new LoginPage().getErrorMessage());
    }


    @Then("^I should see logout link is display$")
    public void iShouldSeeLogoutLinkIsDisplay() {
        Assert.assertTrue("Logout link is not displayed",new HomePage().isLogOutLinkDisplay());
    }


    @Then("^I should see logIn link is display$")
    public void iShouldSeeLogInLinkIsDisplay() {
        Assert.assertEquals("Login link is not displayed",true, new HomePage().isLogInLinkDisplay());
    }
}
