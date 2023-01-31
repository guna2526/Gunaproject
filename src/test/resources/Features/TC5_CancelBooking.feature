@CancelBooking
Feature: Verifying Adactin Cancel Booking Details

  Scenario Outline: Verifying Adactin Cancel Booking Details By Entering All Fields
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
    And User should cancel order id
    Then User should verify after cancel booking with success message "The booking has been cancelled."

    Examples: 
      | userName | password       | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom | firstName | lastName | address |
      | guna2526 | bablunaaas@007 | London   | Hotel Sunshine | Deluxe   |         2 | 15/12/2022  | 20/12/2022   |             4 |                2 | Selva     | Vignesh  | Chennai |

  Scenario Outline: Verifying Adactin Cancel Booking Details By Using Existing Order Id
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello guna2526!"
    And User should cancel booking by using existing order id "<orderId>"
    Then User should verify after cancel booking with success message "The booking has been cancelled."

    Examples: 
      | userName | password       | orderId    |
      | guna2526 | bablunaaas@007 | 2093J8OOT4 |
