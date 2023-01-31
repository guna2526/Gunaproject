@BookHotel
Feature: Verifying Adactin Book Hotel Details

  Scenario Outline: Verifying Adactin Book Hotel Details By Entering All Fields
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello guna2526!"
    And User should search hotel "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrensPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should select the hotel and click continue
    Then User should verify after select hotel with success message "Book A Hotel"
    And User should book hotel "<firstName>","<lastName>" and "<address>"
      | creditCardNO     | creditCardType   | expiryMonth | expiryYear | cvvNumber |
      | 7894561230123456 | American Express | December    |       2022 |      1124 |
      | 4561230789123456 | VISA             | May         |       2022 |      1012 |
      | 7896543210789456 | Master Card      | June        |       2022 |      3369 |
      | 7531598520789963 | VISA             | December    |       2022 |      4951 |
    Then User should verify after book hotel with success message "Booking Confirmation"

    Examples: 
      | userName | password      | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom | firstName | lastName | address |
      | guna2526 | bablunaas@007 | London   | Hotel Sunshine | Deluxe   |         2 | 15/12/2022  | 20/12/2022   |             4 |                2 | Selva     | Vignesh  | Chennai |

  Scenario Outline: Verifying Adactin Book Hotel Details Without Entering Any Fields
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello guna2526!"
    And User should search hotel "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrensPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should select the hotel and click continue
    Then User should verify after select hotel with success message "Book A Hotel"
    And User should click book now by without entering any fields
    Then User should verify after book hotel with error message "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName | password      | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom |
      | guna2526 | bablunaas@007 | London   | Hotel Sunshine | Deluxe   |         2 | 15/12/2022  | 20/12/2022   |             4 |                2 |
