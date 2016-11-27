# Fyber
Fyber automation test

Here is my solution of the challenge proposed.

To solve the problem, I've implemented a solution based on Cucumber JVM, Selenium, Java and Spring as a Maven project. I have used Assertj (is fluent assertion library for Java) for the assertions.
To do this, I've designed a basic a Page Object Model (POM), where every page in the web platform is a different class. Genger component has been designed as a component (can be in different pages). By this way, We're encapsulating the interaction with the driver, so the user only need to code as usual with any OOP language. So for example, to click in a Login button in a home page, we only need to do something like "homePage.clickOnLoginButton()", where homePage is an instance of the class HomePage and the click method contains the functionality related to the driver. By this way, we abstract the driver login with the business logic.
I've created an abstract class where all the driver funtionality is managed and provide method to interact with the driver, so every page class extends from this one.

The feature file which contains the tests is called "sortTest.feature" and can be located under "test/features". Here, there are two scenarios, I made them with different approaches, the first one for the Top Page, is done as Scenario, and the second one as Scenario outline.

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

The first one is faster than the second one due to the browser is open only once. The second one is easy to add new examples, but every example opens a browser, so make it a bit slower, but give us scalability.

To execute the test, in a command terminal, execute "mvn clean test" and the test will be executed.

