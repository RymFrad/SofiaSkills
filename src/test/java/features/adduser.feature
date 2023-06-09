Feature: Add User Functionality
@smoke
Scenario: Add User Successfully
Given I am on the login page
When I log in as an administrator with valid email "taib.maaoui@gmail.com" and a valid password "sJ4rL7om"
And I click the login button
Then I should be redirected to the profile page
And I click on the User Configuration option
And I select the Add User option
And I enter "First" in the First Name field "Last" in the Last Name field and "testsofapp@yopmail.com" in the Email Address field
And I select a Role from the Role list
And I select a Company from the Company list
And I select a Department from the Department list
And I select a Function from the Function list
And I click on the Submit button
Then a message should be displayed saying User added successfully.

@smoke

Scenario: Import User file Successfully
Given I am on the login page
When I log in as an administrator with valid email "taib.maaoui@gmail.com" and a valid password "sJ4rL7om"
And I click the login button
Then I should be redirected to the profile page
And I click on the User Configuration option
And I select the Import file option
Then I choose an excel file and i click on open button 
Then A confirmation window should be open with a message Do you want to upload this file  
And I click Yes button
Then a message should be displayed saying file is uploaded successfully.