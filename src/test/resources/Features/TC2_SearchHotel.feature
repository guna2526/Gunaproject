@SearchHotel
Feature: Verifying Adactin Search Hotel Details

  Scenario Outline: Verifying Adactin Search Hotel Details By Entering All Fields
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello guna2526!"
    And User should search hotel "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrensPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName | password      | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom |
      | guna2526 | bablunaas@007 | London   | Hotel Sunshine | Deluxe   |         2 | 15/12/2022  | 20/12/2022   |             4 |                2 |

  Scenario Outline: Verifying Adactin Search Hotel Details By Entering Only Mandatory Fields
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello guna2526!"
    And User should search only mandatory fields "<location>","<noOfRooms>","<checkInDate>","<checkOutDate>" and "<adultsPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName | password      | location | noOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | guna2526 | bablunaas@007 | London   |         2 | 15/12/2022  | 20/12/2022   |             4 |

  Scenario Outline: Verifying Adactin Search Hotel Details By Selecting a Hotel
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello guna2526!"
    And User should search hotel "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrensPerRoom>"
    Then User should verify after search hotel with invalid date error message "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName | password      | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom |
      | guna2526 | bablunaas@007 | London   | Hotel Sunshine | Deluxe   |         2 | 15/12/2023  | 20/12/2022   |             4 |                2 |

  Scenario Outline: Verifying Adactin Search Hotel Details By Without Entering Any Fields
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello guna2526!"
    And User should search hotel without enter any fields
    Then User should verify after search hotel error message "Please Select a Location"

    Examples: 
      | userName | password      |
      | guna2526 | bablunaas@007 |
