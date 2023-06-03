Feature: Login functionlity

  @smoke
  Scenario: Home page login ok
    Given I visit login page
    When I enter " taib.maaoui@gmail.com" in the user name field and "sJ4rL7om" in the passwrd field
    And I click in login button
    Then I should be in profile page

  @smoke
  Scenario Outline: Home page login Nok
    Given I visit login page
    When I enter "<email>" in the user name field and "<password>" in the passwrd field
    And I click in login button
    Then Error message is shown "<message>"

    Examples: 
      | email                 | password        | message                             |
      | email                 | sJ4rL7ok        | Address email or password incorrect |
      | test.test@gmail.com   | sJ4rL7om        | Email is required                   |
      | taib.maaoui@gmail.com | pw2dvo55fdsdfqs | Password is required                |
      | test.test@gmail.com   | ml4rL7ok        | Address email or password incorrect |
      | test.test             | sJ4rL7om        | Must be a valid email address       |

  @smoke
  Scenario: User can recover password
    Given I visit login page
    When I click on the Forgot password button
    Then I redirected to the password recovery page
    And I enter email address "user@sofia-technologies.com"
    And I click on the submit button
    Then An email is sent with an 8 character password

  @smoke
  Scenario: User can not recover password with invalid email
    Given I visit login page
    When I click on the Forgot password button
    Then I redirected to the password recovery page
    And I enter email address "user@example.com"
    And I click on the submit button
    Then Error message is shown "Must be a valid email address"

  @smoke
  Scenario: User can not recover password with no email
    Given I visit login page
    When I click on the Forgot password button
    Then I redirected to the password recovery page
    And I enter email address ""
    And I click on the submit button
    Then Error message is shown "Email is required"
