@Regression
Feature: Login Test
  As user I want to login into nop commerce website

  @Smoke
  Scenario: Verify user should navigate to register page successfully
    Given I am on homepage
    When I click on register link
    Then I should navigate to register page successfully

  @Sanity
  Scenario Outline: Verify that firstname lastname email password and confirm password fields are mandatory
    Given I am on homepage
    When I click on register link
    And I click on register button
    Then I should see the error message "<errorMessage>" for fieldName "<fieldName>"
    Examples:
      | fieldName       | errorMessage           |
      | FirstName       | First name is required.|
      | LastName        | Last name is required.  |
      | Email           | Email is required.      |
      | Password        | Password is required.   |
      | ConfirmPassword | Password is required.    |

  Scenario Outline: Verify that user should create account successfully
    Given I am on homepage
    When I click on register link
    And   I select gender "<gender>"
    And   I enter firstname "<firstName>"
    And   I enter lastname "<lastName>"
    And   I select date of birth  "<day>""<month>""<year>"
    And   I enter random email "<email>"
    And   I enter password "<password>"
    And   I enter confirm password "<confirmPassword>"
    And   I click on register button
    Then  I should see registration confirmation message
    Examples:
      | gender       | firstName   |lastName|day|month   |year  |email              |password |confirmPassword|
      | Female       | Red         |Rose    |22 |February|1980  |redrose@example.com|abcd1234 |abcd1234       |