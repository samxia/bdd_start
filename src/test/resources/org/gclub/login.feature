@login
Feature:  log in to GClub
  @login_with_error_name
  Scenario Outline: ：On login page, input the wrong username and password
    Given I am on the login page
    And  I input a user name "<username>" and input a password "<password>"
    When I click the login button
    Then should be told the username or password are incorrect
    And stay on the login page

    Examples:
      |username|password|
      |abc       |apwd    |
      |bcd       |bpwd    |

    @login_with_right_user @smoke
  Scenario Outline: ：On login page, input the right username and password
    Given I am on the login page
    And  I input a user name "<username>" and input a password "<password>"
    When I click the login button
    Then should go to the user‘s home page

    Examples:
      |username    |password|
      |testaccount |123456  |