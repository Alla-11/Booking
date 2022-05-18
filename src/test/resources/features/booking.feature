Feature: Search on booking.com

  @Smoke
  Scenario: Search by city criteria
    Given User is looking for hotel in 'London' city
    When User does search
    Then Hotel 'Juzz Holiday Lets' sould be on the first page


  Scenario: Compare rating with the hotel
    Given User is looking for rating for hotel in 'London' city
    When User does search
    Then Hotel 'Juzz Holiday Lets' has a rating of '9,9'


  @Critical
  Scenario Outline: Search by different cities criteria
    Given User is looking for hotel in '<City>' city
    When User does search
    Then Hotel '<Hotel>' sould be on the first page

    Examples:
      | City       | Hotel                                         |
      | London     | Juzz Holiday Lets                             |
      | Washington | The St Gregory Hotel Dupont Circle Georgetown |
      | Madrid     | Apartamentos Gran Via centro plaza callao     |