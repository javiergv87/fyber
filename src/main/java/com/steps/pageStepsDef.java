package com.steps;

import com.config.CucumberConfiguration;
import com.pom.SORT_ENUM;
import com.pom.abstracts.AbstractImdbPage;
import com.pom.components.GenrerMenuComponent;
import com.pom.pages.impl.GenrerPageImpl;
import com.pom.pages.impl.TopPageImpl;
import com.pom.pages.interfaces.CommonPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by Javi on 26/11/2016.
 */
@ContextConfiguration(classes = {CucumberConfiguration.class})
public class pageStepsDef {

    @Autowired
    @Lazy
    TopPageImpl topPage;

    @Autowired
    @Lazy
    GenrerPageImpl genrerPage;

    @Autowired
    @Lazy
    GenrerMenuComponent genrerMenu;

    @Given("^user goes to IMDb top page$")
    public void userGoesToPage() throws Throwable {
        topPage.load();
    }

    @After
    public static void after() {
        AbstractImdbPage.closeBrowser();
    }


    @When("^user selects sort by '(Ranking|IMDb Rating|Release Date|Number of Ratings|Your Rating)' in Top page$")
    public void userSelectsSortBySortType(String type) throws Throwable {
        switch (type) {
            case "Ranking":
                topPage.sortBy(SORT_ENUM.SORT_BY.RANKING);
                break;
            case "IMDb Rating":
                topPage.sortBy(SORT_ENUM.SORT_BY.IMDB_RATING);
                break;
            case "Release Date":
                topPage.sortBy(SORT_ENUM.SORT_BY.RELEASE_DATE);
                break;
            case "Number of Ratings":
                topPage.sortBy(SORT_ENUM.SORT_BY.NUMBER_OF_RATINGS);
                break;
            case "Your Rating":
                topPage.sortBy(SORT_ENUM.SORT_BY.YOUR_RATING);
                break;
            default:
                throw new NotImplementedException(String.format("Type '%s' not implemented yet",type));
        }
    }

    @When("^user selects sort by '(Alphabetical|Popularity|Number of Votes|US Box Office|Runtime|IMDb Rating|Year|Release Date)' in Genrer page$")
    public void userSortsBySortType(String type) throws Throwable {
        switch (type) {
            case "Alphabetical":
                genrerPage.sortBy(SORT_ENUM.SORT_BY.ALPHABETICAL);
                break;
            case "Popularity":
                genrerPage.sortBy(SORT_ENUM.SORT_BY.POPULARITY);
                break;
            case "Number of Votes":
                genrerPage.sortBy(SORT_ENUM.SORT_BY.NUMBER_OF_VOTES);
                break;
            case "US Box Office":
                genrerPage.sortBy(SORT_ENUM.SORT_BY.US_BOX_OFFICE);
                break;
            case "Runtime":
                genrerPage.sortBy(SORT_ENUM.SORT_BY.RUNTIME);
                break;
            case "IMDb Rating":
                genrerPage.sortBy(SORT_ENUM.SORT_BY.IMDB_RATING);
                break;
            case "Year":
                genrerPage.sortBy(SORT_ENUM.SORT_BY.YEAR);
                break;
            case "Release Date":
                genrerPage.sortBy(SORT_ENUM.SORT_BY.RELEASE_DATE);
                break;
            default:
                throw new NotImplementedException(String.format("Type '%s' not implemented yet",type));
        }
    }


    @Then("^(Top|Genrer) page shows at least one movie$")
    public void topPageShowsAtLeastOneMovie(final String page) throws Throwable {
        if("Top".equalsIgnoreCase(page))
            assertThat(topPage.getMovieListSize()).as("list size").isGreaterThan(0);
        else
            assertThat(genrerPage.getMovieListSize()).as("list size").isGreaterThan(0);
    }

    @Given("^user goes to '(.*)' genrer page$")
    public void userGoesToWesternGenrerPage(final String genrer) throws Throwable {
        genrerMenu.clickOnGenrer(genrer);
    }
}
