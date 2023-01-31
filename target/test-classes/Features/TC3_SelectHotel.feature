@SelectHotel
Feature: Verifying Adactin Select Hotel Details

  Scenario Outline: Verifying Adactin Select Hotel Details By Selecting a Hotel
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello guna2526!"
    And User should search hotel "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrensPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should select the hotel and click continue
    Then User should verify after select hotel with success message "Book A Hotel"

    Examples: 
      | userName | password      | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom |
      | guna2526 | bablunaas@007 | London   | Hotel Sunshine | Deluxe   |         2 | 15/12/2022  | 20/12/2022   |             4 |                2 |

  Scenario Outline: Verifying Adactin Select Hotel Details By Without Select Any Hotel
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello guna2526!"
    And User should search hotel "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrensPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should click continue without select any hotel
    Then User should verify after select hotel with error message "Please Select a Hotel"

    Examples: 
      | userName | password      | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom |
      | guna2526 | bablunaas@007 | London   | Hotel Sunshine | Deluxe   |         2 | 15/12/2022  | 20/12/2022   |             4 |                2 |
