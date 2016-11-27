package com.pom.pages.impl;

import com.model.Movie;
import com.pom.SORT_ENUM;
import com.pom.abstracts.AbstractImdbPage;
import com.pom.pages.interfaces.CommonPage;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javi on 26/11/2016.
 */
@Component
public class GenrerPageImpl extends AbstractImdbPage implements CommonPage {

    private static final By MOVIE_LIST_COMPONENT = By.cssSelector(".lister-list");

    private static final By MOVIE_ELEMENT = By.cssSelector(".lister-item.mode-advanced");

    private static final By MOVIE_TITLE = By.cssSelector(".lister-item-header a");

    private static final By MOVIE_RATING = By.cssSelector(".ratings-bar strong");

    private static final By POPULARITY_SORT_LINK = By.cssSelector(".moviemeter");

    private static final By ALPHABETIC_SORT_LINK = By.cssSelector(".alpha");

    private static final By USER_RATING_SORT_LINK = By.cssSelector(".user_rating");

    private static final By NUMBER_OF_VOTES_SORT_LINK = By.cssSelector(".num_votes");

    private static final By US_BOX_SORT_LINK = By.cssSelector(".boxoffice_gross_us");

    private static final By RUNTIME_SORT_LINK = By.cssSelector(".runtime");

    private static final By YEAR_SORT_LINK = By.cssSelector(".year");

    private static final By RELEASE_DATE_SORT_LINK = By.cssSelector(".release_date");

    private static final By SORT_LINKS_SECTION = By.className(".sorting");

    private List<Movie> listOfMovies = new ArrayList<>();

    @Override
    public List<Movie> getListOfMovies() {
        List<WebElement> elementList = find(MOVIE_LIST_COMPONENT).findElements(MOVIE_ELEMENT);
        for (WebElement element : elementList) {
            String title = element.findElement(MOVIE_TITLE).getText();
            Float rating = Float.valueOf(element.findElement(MOVIE_RATING).getText().replace(",","."));
            Movie movie = new Movie(title,rating);
            this.listOfMovies.add(movie);
        }
        return listOfMovies;
    }

    @Override
    public Integer getMovieListSize() {
        return find(MOVIE_LIST_COMPONENT).findElements(MOVIE_ELEMENT).size();
    }

    @Override
    public void sortBy(SORT_ENUM.SORT_BY sort_by) {
        switch(sort_by){
            case ALPHABETICAL:
                clickOn(ALPHABETIC_SORT_LINK);
                break;
            case POPULARITY:
                clickOn(POPULARITY_SORT_LINK);
                break;
            case NUMBER_OF_VOTES:
                clickOn(NUMBER_OF_VOTES_SORT_LINK);
                break;
            case US_BOX_OFFICE:
                clickOn(US_BOX_SORT_LINK);
                break;
            case RUNTIME:
                clickOn(RUNTIME_SORT_LINK);
                break;
            case IMDB_RATING:
                clickOn(USER_RATING_SORT_LINK);
            case YEAR:
                clickOn(YEAR_SORT_LINK);
                break;
            case RELEASE_DATE:
                clickOn(RELEASE_DATE_SORT_LINK);
                break;

            default:
                throw new NotImplementedException(String.format("Sort type '%s' is not implemented",sort_by.getName()));
        }

    }

    @Override
    public List<String> getSortingTypes() {
        List<String> sortingTypes = new ArrayList<>();
        List<WebElement> elementList = find(SORT_LINKS_SECTION).findElements(By.tagName("a"));
        for (WebElement element:elementList) {
            sortingTypes.add(element.getText());
        }
        return sortingTypes;
    }

    @Override
    public void load() {
        load("http://www.imdb.com/chart/top");
    }
}
