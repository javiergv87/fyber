Feature: Check result list in top movies

  Scenario: Check result list has at least one movie in top page
    Given user goes to IMDb top page
    When user selects sort by 'Ranking' in Top page
    Then Top page shows at least one movie
    When user selects sort by 'IMDb Rating' in Top page
    Then Top page shows at least one movie
    When user selects sort by 'Release Date' in Top page
    Then Top page shows at least one movie
    When user selects sort by 'Number of Ratings' in Top page
    Then Top page shows at least one movie
    When user selects sort by 'Your Rating' in Top page
    Then Top page shows at least one movie


  Scenario Outline: Check result list has at least one movie in genrer page
    Given user goes to IMDb top page
    When user goes to 'Western' genrer page
    And user selects sort by '<sortBy>' in Genrer page
    Then Genrer page shows at least one movie

    Examples:
    |sortBy|
    |Alphabetical|
    |Popularity|
    |Number of Votes|
    |US Box Office|
    |Runtime|
    |IMDb Rating|
    |Year|
    |Release Date|


