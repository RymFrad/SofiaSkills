Feature: Login functionlity

  Scenario: Home page login ok
    Given I visit login page
    When I enter " taib.maaoui@gmail.com" in the user name field and "sJ4rL7om" in the passwrd field
    And I click in login button
    Then I should be in profile page

  Scenario: Home page login Nok
    Given I visit login page
    When I enter "email" in the user name field and "sJ4rL7ok" in the passwrd field
    And I click in login button
    Then Error message is shown "Address email or password incorrect"
 