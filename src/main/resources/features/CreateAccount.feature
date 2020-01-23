@CreateAccount

Feature: Go to litecart.stqa.ru site and create new account

  Scenario: Create Account in litecart.stqa.ru
    Given go to create account page "http://litecart.stqa.ru/ru/create_account"
    When enter "674300" to Tax ID
    And enter "Julia" to First Name
    And enter "Ivanova" Last Name
    And enter "ul. Karla Marksa 1-65" Address_1
    And enter "453213" Postcode
    And enter "Yekaterinburg" City
    And select "Russian Federation" Country
    And enter "julia_00_rus@mail.ru" Email
    And enter "+74964512009" Phone
    And enter "YekaterinburgRUS" Desired Password
    And confirm "YekaterinburgRUS" Password
    And click on Create Account button
    Then should go to edit profile page "http://litecart.stqa.ru/ru/edit_account"
    And check Tax ID "674300"
    And check First Name "Julia"
    And check Last Name "Ivanova"
    And check Address_1 "ul. Karla Marksa 1-65"
    And check Postcode "453213"
    And check City "Yekaterinburg"
    And check Country "Russian Federation"
    And check Email "julia_00_rus@mail.ru"
    And check Phone "+74964512009"