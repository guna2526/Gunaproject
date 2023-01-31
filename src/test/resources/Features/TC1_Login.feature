@Login
Feature: Verifying Adactin Hotel login details

  Scenario Outline: Verifying Adactin Hotel Login Valid
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello guna2526!"

    Examples: 
      | userName | password      |
      | guna2526 | bablunaas@007 |

  Scenario Outline: Verifying Adactin Hotel Login using Enter
    Given User is on the adactin page
    When User should perform login "<userName>","<password>" with Enter Key
    Then User should verify after login success message "Hello guna2526!"

    Examples: 
      | userName | password      |
      | guna2526 | bablunaas@007 |

  Scenario Outline: Verifying Adactin Hotel Login Invalid credentials
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login with invalid credential error message contains "Invalid Login details or Your Password might have expired. Click here to reset your password"

    Examples: 
      | userName | password |
      | guna     | Selva123 |
