Feature: Login Functionality

  Background: Given I am on the login page

  Scenario: Successful login with valid credentials When I enter username "tomsmith" and password "SuperSecretPassword!" And I click the login button Then I should see a success message

  Scenario: Failed login with invalid credentials When I enter username "invalidUser" and password "wrongPassword" And I click the login button Then I should see an error message containing "Your username is invalid!"

  Scenario: Failed login with empty fields When I enter username "" and password "" And I click the login button Then I should see an error message containing "Your username is invalid!"

  Scenario: Failed login with excessively long username When I enter a very long username and password "SuperSecretPassword!" And I click the login button Then I should see an error message containing "Your username is invalid!"

  Scenario: Failed login with valid username and empty password When I enter username "tomsmith" and password "" And I click the login button Then I should see an error message containing "Your password is invalid!"