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
    
 Scenario: Invalid email
    Given I visit login page
    When I enter "test.test@gmail.com" in the user name field and "sJ4rL7om" in the passwrd field
    And I click in login button
    Then Error message is shown "Email is required"

  Scenario: Invalid password
    Given I visit login page
    When I enter "taib.maaoui@gmail.com" in the user name field and "pw2dvo55fdsdfqs" in the passwrd field
    And I click in login button
    Then Error message is shown "Password is required"

  Scenario: Incorrect password
    Given I visit login page
    When I enter "taib.maaoui@gmail.com" in the user name field and "ml4rL7ok" in the passwrd field
    And I click in login button
    Then Error message is shown "Address email or password incorrect"

  Scenario: Inorrect email
    Given I visit login page
    When I enter "test.test" in the user name field and "sJ4rL7om" in the passwrd field
    And I click in login button
    Then Error message is shown "Must be a valid email address"

    Scenario: User can recover password
    Given I visit login page
    When I click on the Forgot password button
    Then I redirected to the password recovery page
    And I enter email address "user@sofia-technologies.com"
    And I click on the submit button
    Then An email is sent with an 8 character password

  Scenario: User can not recover password with invalid email
    Given I visit login page
    When I click on the Forgot password button
    Then I redirected to the password recovery page
    And I enter email address "user@example.com"
    And I click on the submit button
    Then Error message is shown "Must be a valid email address"

  Scenario: User can not recover password with no email
    Given I visit login page
    When I click on the Forgot password button
    Then I redirected to the password recovery page
    And I enter email address ""
    And I click on the submit button
    Then Error message is shown "Email is required"