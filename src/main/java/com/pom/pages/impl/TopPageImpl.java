package com.pom.pages.impl;

import com.model.Movie;
import com.pom.SORT_ENUM;
import com.pom.abstracts.AbstractImdbPage;
import com.pom.pages.interfaces.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javi on 26/11/2016.
 */
@Component
@Lazy
public class TopPageImpl extends AbstractImdbPage implements CommonPage {

    private final static By MAIN_LIST_COMPONENT = By.cssSelector("table[data-caller-name='chart-top250movie']");

    private final static By MOVIE_LIST = By.cssSelector("tbody[class='lister-list']");

    private final static By TITLE_TEXT = By.cssSelector("td[class='titleColumn'] a");

    private final static By RATING_TEXT = By.cssSelector("td[class='ratingColumn imdbRating'] strong");

    private final static By SORTING_SELECTOR = By.cssSelector("select[name='sort']");

    private List<Movie> topList = new ArrayList<>();

    @Override
    public List<Movie> getListOfMovies() {
        List<WebElement> elementList = find(MAIN_LIST_COMPONENT).findElement(MOVIE_LIST).findElements(By.tagName("tr"));
        for (WebElement element : elementList) {
            String title = element.findElement(TITLE_TEXT).getText();
            Float rating = Float.valueOf(element.findElement(RATING_TEXT).getText().replace(",","."));
            Movie movie = new Movie(title,rating);
            this.topList.add(movie);
        }
        return topList;
    }

    @Override
    public void sortBy(SORT_ENUM.SORT_BY sort_by) {
        clickOn(SORTING_SELECTOR);
        Select dropdown = new Select(find(SORTING_SELECTOR));
        dropdown.selectByVisibleText(sort_by.getName());
    }

    @Override
    public List<String> getSortingTypes() {
        List<WebElement> elementList = find(SORTING_SELECTOR).findElements(By.tagName("option"));
        List<String> result = new ArrayList<>();
        for (WebElement element:elementList) {
            result.add(element.getText());
        }
        return result;
    }

    @Override
    public Integer getMovieListSize() {
        return find(MAIN_LIST_COMPONENT).findElement(MOVIE_LIST).findElements(By.tagName("tr")).size();
    }

    @Override
    public void load() {
        load("http://www.imdb.com/chart/top");
    }
}
