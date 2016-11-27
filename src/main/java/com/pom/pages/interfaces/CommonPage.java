package com.pom.pages.interfaces;

import com.model.Movie;
import com.pom.SORT_ENUM;

import java.util.List;

/**
 * Created by Javi on 26/11/2016.
 */
public interface CommonPage {

    /**
     * Return the list of movies in the page
     * @return the list of movies
     */
    List<Movie> getListOfMovies();

    /**
     * Return the list of movies size
     * @return the size
     */
    Integer getMovieListSize();


    /**
     * Returns the visible text for the sorting types
     * @return a list of String
     */
    List<String> getSortingTypes();

    /**
     * Sort the movies by the specified type
     * @param sort_by
     */
    void sortBy(SORT_ENUM.SORT_BY sort_by);

    /**
     * Load the page
     */
    void load();
}
