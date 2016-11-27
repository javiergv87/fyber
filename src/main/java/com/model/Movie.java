package com.model;

/**
 * Created by Javi on 26/11/2016.
 */
public class Movie {

    private String title;

    private Float rating;

    public Movie(final String title, final Float rating) {
        this.title=title;
        this.rating=rating;
    }

    /**
     * Return the title of the movie
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the movie
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the rating of the movie
     * @return the title
     */
    public Float getRating() {
        return rating;
    }

    /**
     * Set the rating of the movie
     * @param rating
     */
    public void setRating(Float rating) {
        this.rating = rating;
    }
}
